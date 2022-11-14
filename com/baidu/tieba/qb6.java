package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.gd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class qb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public Context c;
    public gd6 d;
    public d e;
    public nd6 f;
    public boolean g;
    public gd6.d h;
    public View.OnClickListener i;
    public PopupWindow.OnDismissListener j;

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public class a implements gd6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb6 a;

        public a(qb6 qb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb6Var;
        }

        @Override // com.baidu.tieba.gd6.d
        public void onItemClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.b = i;
            StatisticItem statisticItem = new StatisticItem("c13369");
            int i2 = 1;
            if (i == 1) {
                i2 = 2;
            }
            TiebaStatic.log(statisticItem.param("obj_type", i2));
            this.a.r();
            if (this.a.e != null) {
                this.a.e.a(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb6 a;

        public b(qb6 qb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f.r()) {
                return;
            }
            if (view2 == this.a.a) {
                if (this.a.d == null) {
                    this.a.d = new gd6(this.a.c);
                    this.a.d.setOnDismissListener(this.a.j);
                    this.a.d.l(this.a.h);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new jb6(this.a.c.getString(R.string.obfuscated_res_0x7f0f0a09), 2));
                arrayList.add(new jb6(this.a.c.getString(R.string.obfuscated_res_0x7f0f1528), 1));
                this.a.d.k(arrayList, this.a.b);
                this.a.d.n(this.a.a);
            }
            this.a.g = true;
            qb6 qb6Var = this.a;
            qb6Var.s(qb6Var.g);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qb6 a;

        public c(qb6 qb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qb6Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.g = false;
            qb6 qb6Var = this.a;
            qb6Var.s(qb6Var.g);
        }
    }

    public qb6(Context context, int i, int i2, nd6 nd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), nd6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new a(this);
        this.i = new b(this);
        this.j = new c(this);
        this.c = context;
        this.b = i;
        this.f = nd6Var;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (n()) {
                SkinManager.setViewTextColor(this.a, R.color.CAM_X0105, i);
                if (this.a != null) {
                    s(this.g);
                }
            }
            gd6 gd6Var = this.d;
            if (gd6Var != null && this.g) {
                gd6Var.j();
            }
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || !n()) {
            return;
        }
        this.b = i;
        r();
    }

    public void u(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.e = dVar;
        }
    }

    public void v(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView) == null) {
            this.a = textView;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.b;
            if (i == 2 || i == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public void p() {
        gd6 gd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (gd6Var = this.d) != null) {
            gd6Var.i();
        }
    }

    public void r() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && n() && (textView = this.a) != null) {
            int i = this.b;
            if (i != 1) {
                if (i == 2) {
                    textView.setText(R.string.obfuscated_res_0x7f0f0a09);
                }
            } else {
                textView.setText(R.string.obfuscated_res_0x7f0f1528);
            }
            this.a.setOnClickListener(this.i);
            s(this.g);
        }
    }

    public final void s(boolean z) {
        int i;
        db6 db6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                i = R.drawable.obfuscated_res_0x7f08096d;
            } else {
                i = R.drawable.icon_pure_unfold12_svg;
            }
            nd6 nd6Var = this.f;
            if (nd6Var != null) {
                db6Var = nd6Var.n();
            } else {
                db6Var = null;
            }
            if (db6Var != null && db6Var.a) {
                nd6 nd6Var2 = this.f;
                if (nd6Var2 != null && nd6Var2.t()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                    this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                    return;
                }
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
                this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0107);
            this.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.getInstance().getPureDrawable(i, R.color.CAM_X0108, null), (Drawable) null);
        }
    }
}
