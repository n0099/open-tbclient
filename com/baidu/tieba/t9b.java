package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class t9b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public LinearLayout c;
    public TextView d;
    public View e;
    public TextView f;
    public String g;
    public List<b> h;
    public e i;
    public c j;
    public boolean k;

    /* loaded from: classes8.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(int i, View view2);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public t9b b;
        public View c;
        public TextView d;
        public View e;
        public String f;
        public int g;
        public d h;
        public boolean i;
        public boolean j;
        public final View.OnClickListener k;

        /* loaded from: classes8.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    if (this.a.h != null) {
                        this.a.h.onClick();
                    }
                    if (this.a.b != null && this.a.b.d() != null) {
                        this.a.b.d().a(this.a.a, view2);
                    }
                }
            }
        }

        public b(String str, t9b t9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, t9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = 17;
            this.i = true;
            this.k = new a(this);
            this.f = str;
            this.b = t9bVar;
            this.a = hashCode();
            f();
            e();
        }

        public void h(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
                this.h = dVar;
                e();
            }
        }

        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (View) invokeV.objValue;
        }

        public final void e() {
            TextView textView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (textView = this.d) != null) {
                textView.setOnClickListener(this.k);
            }
        }

        public final void f() {
            t9b t9bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (t9bVar = this.b) != null && t9bVar.c() != null) {
                View inflate = LayoutInflater.from(this.b.c()).inflate(R.layout.bottom_up_list_dialog_item, this.b.e(), false);
                this.c = inflate;
                TextView textView = (TextView) inflate.findViewById(R.id.item_view);
                this.d = textView;
                textView.setText(this.f);
                this.d.setGravity(this.g);
                View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f090958);
                this.e = findViewById;
                if (this.i) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                g();
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                TextView textView = this.d;
                if (textView != null) {
                    if (this.j) {
                        SkinManager.setBackgroundResource(textView, R.drawable.bg_bottom_up_corner_dialog);
                    } else {
                        textView.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0211));
                    }
                }
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t9b a;

        public a(t9b t9bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t9bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t9bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.onClick();
            }
        }
    }

    public t9b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context == null) {
            return;
        }
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
        this.b = inflate;
        this.c = (LinearLayout) inflate.findViewById(R.id.content_view);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092685);
        this.e = this.b.findViewById(R.id.title_divide_line);
        this.h = new ArrayList();
        this.f = (TextView) this.b.findViewById(R.id.dialog_bottom_cancel_button);
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!StringUtils.isNull(this.g)) {
                this.d.setText(this.g);
                this.e.setVisibility(0);
            } else {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
            }
            if (this.j != null) {
                this.f.setOnClickListener(new a(this));
            }
            f();
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (e) invokeV.objValue;
    }

    public ViewGroup e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public void f() {
        b bVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.d, R.drawable.bg_title_corner_dialog_item);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0108);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.f, R.drawable.bg_bottom_up_list_dialog_item);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
            List<b> list = this.h;
            if (list != null) {
                for (b bVar2 : list) {
                    bVar2.g();
                }
            }
            if (this.k) {
                if (!StringUtils.isNull(this.g) && (textView = this.d) != null && (textView.getBackground() instanceof GradientDrawable)) {
                    float dimension = c().getResources().getDimension(R.dimen.tbds32);
                    ((GradientDrawable) this.d.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
                    return;
                }
                List<b> list2 = this.h;
                if (list2 != null && ListUtils.getCount(list2) > 0 && (bVar = this.h.get(0)) != null && !bVar.j) {
                    bVar.j = true;
                    bVar.g();
                }
            }
        }
    }

    public void g(List<b> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, list) != null) || list == null) {
            return;
        }
        this.h = list;
        this.c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            b bVar = list.get(i);
            if (bVar != null) {
                this.c.addView(bVar.d());
            }
        }
    }
}
