package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.t43;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class u42 extends v42 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean K0;
    public static String L0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter G0;
    public final List<pa3> H0;
    public FrameLayout I0;
    public boolean J0;

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;

        public a(u42 u42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;

        public b(u42 u42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.J0 = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa3 a;
        public final /* synthetic */ u42 b;

        public c(u42 u42Var, pa3 pa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var, pa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u42Var;
            this.a = pa3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.k3().f0().z(u42.L0, true);
                this.b.o3(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ik3<Map<String, pa3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;

        public d(u42 u42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(Map<String, pa3> map) {
            FragmentActivity m;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) && (m = this.a.m()) != null && !m.isFinishing() && !m.isDestroyed()) {
                x43.b(this.a.I0);
                if (map == null) {
                    return;
                }
                for (Map.Entry<String, pa3> entry : map.entrySet()) {
                    pa3 value = entry.getValue();
                    if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.d && value.b() && "2".equals(value.e) && !"snsapi_base".equals(value.b)) {
                        this.a.H0.add(value);
                    }
                }
                this.a.q3();
                this.a.G0.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u42 a;

        public e(u42 u42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public pa3 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (pa3) this.a.H0.get(i);
            }
            return (pa3) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return getItem(i).hashCode();
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.H0.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null || !(view2.getTag() instanceof g)) {
                    view2 = View.inflate(this.a.s(), R.layout.obfuscated_res_0x7f0d00d7, null);
                    g gVar = new g(this.a);
                    gVar.b = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f0906f6);
                    gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a7);
                    view2.setTag(gVar);
                }
                g gVar2 = (g) view2.getTag();
                pa3 item = getItem(i);
                if (TextUtils.isEmpty(item.g)) {
                    str = item.f;
                } else {
                    str = item.g;
                }
                TextView textView = gVar2.a;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                textView.setText(str);
                gVar2.b.setChecked(item.a());
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ik3<sa3<ua3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pa3 a;
        public final /* synthetic */ u42 b;

        public f(u42 u42Var, pa3 pa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var, pa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u42Var;
            this.a = pa3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(sa3<ua3.e> sa3Var) {
            FragmentActivity m;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) != null) || (m = this.b.m()) == null) {
                return;
            }
            x43.b(this.b.I0);
            if (sa3Var == null || !sa3Var.c()) {
                h53.f(m, R.string.obfuscated_res_0x7f0f01f2).G();
            } else {
                this.b.p3(this.a, sa3Var.a.b);
            }
            this.b.J0 = false;
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public CheckBox b;
        public final /* synthetic */ u42 c;

        public g(u42 u42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u42Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160950, "Lcom/baidu/tieba/u42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160950, "Lcom/baidu/tieba/u42;");
                return;
            }
        }
        K0 = am1.a;
        L0 = "pref_close_scope_alert_showed";
    }

    public u42() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.H0 = new ArrayList();
        this.J0 = false;
    }

    public static u42 m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new u42();
        }
        return (u42) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c0 = null;
            super.F0();
        }
    }

    public final BaseAdapter j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new e(this);
        }
        return (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public p53 k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return cr2.V().F();
        }
        return (p53) invokeV.objValue;
    }

    public final void l3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            x43.g(m(), this.I0);
            this.H0.clear();
            this.G0.notifyDataSetChanged();
            nx2.h(new d(this));
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onPause()");
            }
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            O2(1);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onResume()");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void Q0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, bundle) == null) {
            super.Q0(view2, bundle);
            l3();
        }
    }

    public final void p3(pa3 pa3Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, pa3Var, z) == null) {
            if (z) {
                i = 1;
            } else {
                i = -1;
            }
            pa3Var.j = i;
            this.G0.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            c2(view2);
            A2(-1);
            J2(-16777216);
            C2(S(R.string.obfuscated_res_0x7f0f04a4));
            E2(true);
            Q2(false);
        }
    }

    public final void o3(pa3 pa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pa3Var) == null) {
            i3(pa3Var, !pa3Var.a());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, activity) == null) {
            super.v0(activity);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.y0(bundle);
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00d6, viewGroup, false);
            b2(inflate);
            this.I0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0907bc);
            this.G0 = j3();
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f09018e);
            listView.setAdapter((ListAdapter) this.G0);
            listView.setOnItemClickListener(this);
            if (a2()) {
                inflate = d2(inflate);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.C0();
            p53 k3 = k3();
            if (k3 != null) {
                k3.f0().v();
            }
            if (K0) {
                Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
            }
        }
    }

    public final void i3(pa3 pa3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, pa3Var, z) == null) {
            p53 k3 = k3();
            if (k3 == null) {
                this.J0 = false;
                return;
            }
            x43.g(m(), this.I0);
            k3.f0().d(m(), pa3Var.b, false, z, true, new f(this, pa3Var));
        }
    }

    public final void n3(pa3 pa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pa3Var) == null) {
            t43.a aVar = new t43.a(m());
            aVar.U(R.string.obfuscated_res_0x7f0f01f5);
            aVar.v(R.string.obfuscated_res_0x7f0f01f4);
            aVar.n(new xk3());
            aVar.O(R.string.obfuscated_res_0x7f0f01f3, new c(this, pa3Var));
            aVar.B(R.string.obfuscated_res_0x7f0f0141, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.J0) {
            return;
        }
        pa3 pa3Var = this.H0.get(i);
        this.J0 = true;
        if (pa3Var.a() && !k3().f0().m(L0, false)) {
            n3(pa3Var);
            return;
        }
        na3.k("onItemClick : " + pa3Var, Boolean.FALSE);
        o3(pa3Var);
    }

    public final void q3() {
        View i0;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (i0 = i0()) == null) {
            return;
        }
        boolean isEmpty = this.H0.isEmpty();
        TextView textView = (TextView) i0.findViewById(R.id.obfuscated_res_0x7f0925a4);
        int i2 = 8;
        if (isEmpty) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        if (!isEmpty) {
            textView.setText(Y(R.string.obfuscated_res_0x7f0f01f6, k3().a0()));
        }
        View findViewById = i0.findViewById(R.id.obfuscated_res_0x7f09102b);
        if (findViewById != null) {
            if (isEmpty) {
                i2 = 0;
            }
            findViewById.setVisibility(i2);
        }
        TextView textView2 = (TextView) i0.findViewById(R.id.obfuscated_res_0x7f090a0a);
        if (isEmpty) {
            textView2.setText(Y(R.string.obfuscated_res_0x7f0f01f1, k3().a0()));
        }
    }
}
