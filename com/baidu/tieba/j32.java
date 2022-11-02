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
import com.baidu.tieba.i33;
import com.baidu.tieba.j93;
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
/* loaded from: classes4.dex */
public class j32 extends k32 implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean J0;
    public static String K0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseAdapter F0;
    public final List<e93> G0;
    public FrameLayout H0;
    public boolean I0;

    @Override // com.baidu.tieba.k32
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k32, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.k32
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public a(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.I0 = false;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public b(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.I0 = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e93 a;
        public final /* synthetic */ j32 b;

        public c(j32 j32Var, e93 e93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, e93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = e93Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.b.d3().e0().z(j32.K0, true);
                this.b.h3(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements xi3<Map<String, e93>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public d(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(Map<String, e93> map) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) && (activity = this.a.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                m33.b(this.a.H0);
                if (map == null) {
                    return;
                }
                for (Map.Entry<String, e93> entry : map.entrySet()) {
                    e93 value = entry.getValue();
                    if (!TextUtils.isEmpty(entry.getKey()) && value != null && !value.d && value.b() && "2".equals(value.e) && !"snsapi_base".equals(value.b)) {
                        this.a.G0.add(value);
                    }
                }
                this.a.j3();
                this.a.F0.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j32 a;

        public e(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public e93 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                return (e93) this.a.G0.get(i);
            }
            return (e93) invokeI.objValue;
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
                return this.a.G0.size();
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
                    view2 = View.inflate(this.a.getContext(), R.layout.obfuscated_res_0x7f0d00d2, null);
                    g gVar = new g(this.a);
                    gVar.b = (CheckBox) view2.findViewById(R.id.obfuscated_res_0x7f090627);
                    gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092256);
                    view2.setTag(gVar);
                }
                g gVar2 = (g) view2.getTag();
                e93 item = getItem(i);
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

    /* loaded from: classes4.dex */
    public class f implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e93 a;
        public final /* synthetic */ j32 b;

        public f(j32 j32Var, e93 e93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var, e93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j32Var;
            this.a = e93Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            FragmentActivity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) != null) || (activity = this.b.getActivity()) == null) {
                return;
            }
            m33.b(this.b.H0);
            if (h93Var == null || !h93Var.c()) {
                w33.f(activity, R.string.obfuscated_res_0x7f0f01c3).G();
            } else {
                this.b.i3(this.a, h93Var.a.b);
            }
            this.b.I0 = false;
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public CheckBox b;
        public final /* synthetic */ j32 c;

        public g(j32 j32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j32Var;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832288, "Lcom/baidu/tieba/j32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832288, "Lcom/baidu/tieba/j32;");
                return;
            }
        }
        J0 = ok1.a;
        K0 = "pref_close_scope_alert_showed";
    }

    public j32() {
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
        this.G0 = new ArrayList();
        this.I0 = false;
    }

    public static j32 f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new j32();
        }
        return (j32) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c0 = null;
            super.B0();
        }
    }

    public final BaseAdapter c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new e(this);
        }
        return (BaseAdapter) invokeV.objValue;
    }

    @Nullable
    public e43 d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return rp2.U().D();
        }
        return (e43) invokeV.objValue;
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            m33.g(getActivity(), this.H0);
            this.G0.clear();
            this.F0.notifyDataSetChanged();
            cw2.h(new d(this));
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onPause()");
            }
        }
    }

    @Override // com.baidu.tieba.k32, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            H2(1);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onResume()");
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            e3();
        }
    }

    public final void i3(e93 e93Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, e93Var, z) == null) {
            if (z) {
                i = 1;
            } else {
                i = -1;
            }
            e93Var.j = i;
            this.F0.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.k32
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            V1(view2);
            t2(-1);
            C2(-16777216);
            v2(G(R.string.obfuscated_res_0x7f0f0425));
            x2(true);
            J2(false);
        }
    }

    public final void h3(e93 e93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, e93Var) == null) {
            b3(e93Var, !e93Var.a());
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            super.r0(activity);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onAttach() obj: " + this);
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.u0(bundle);
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onCreate() obj: " + this);
            }
        }
    }

    public final void b3(e93 e93Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, e93Var, z) == null) {
            e43 d3 = d3();
            if (d3 == null) {
                this.I0 = false;
                return;
            }
            m33.g(getActivity(), this.H0);
            d3.e0().d(getActivity(), e93Var.b, false, z, true, new f(this, e93Var));
        }
    }

    public final void g3(e93 e93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, e93Var) == null) {
            i33.a aVar = new i33.a(getActivity());
            aVar.U(R.string.obfuscated_res_0x7f0f01c6);
            aVar.v(R.string.obfuscated_res_0x7f0f01c5);
            aVar.n(new mj3());
            aVar.O(R.string.obfuscated_res_0x7f0f01c4, new c(this, e93Var));
            aVar.B(R.string.obfuscated_res_0x7f0f0112, new b(this));
            aVar.m(true);
            aVar.K(new a(this));
            aVar.X();
        }
    }

    public final void j3() {
        View V;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (V = V()) == null) {
            return;
        }
        boolean isEmpty = this.G0.isEmpty();
        TextView textView = (TextView) V.findViewById(R.id.obfuscated_res_0x7f092253);
        int i2 = 8;
        if (isEmpty) {
            i = 8;
        } else {
            i = 0;
        }
        textView.setVisibility(i);
        if (!isEmpty) {
            textView.setText(H(R.string.obfuscated_res_0x7f0f01c7, d3().Z()));
        }
        View findViewById = V.findViewById(R.id.obfuscated_res_0x7f090e5a);
        if (findViewById != null) {
            if (isEmpty) {
                i2 = 0;
            }
            findViewById.setVisibility(i2);
        }
        TextView textView2 = (TextView) V.findViewById(R.id.obfuscated_res_0x7f0908f8);
        if (isEmpty) {
            textView2.setText(H(R.string.obfuscated_res_0x7f0f01c2, d3().Z()));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.I0) {
            return;
        }
        e93 e93Var = this.G0.get(i);
        this.I0 = true;
        if (e93Var.a() && !d3().e0().m(K0, false)) {
            g3(e93Var);
            return;
        }
        c93.k("onItemClick : " + e93Var, Boolean.FALSE);
        h3(e93Var);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00d1, viewGroup, false);
            U1(inflate);
            this.H0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0906ea);
            this.F0 = c3();
            ListView listView = (ListView) inflate.findViewById(R.id.obfuscated_res_0x7f090188);
            listView.setAdapter((ListAdapter) this.F0);
            listView.setOnItemClickListener(this);
            if (T1()) {
                inflate = W1(inflate);
            }
            return D1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.y0();
            e43 d3 = d3();
            if (d3 != null) {
                d3.e0().v();
            }
            if (J0) {
                Log.d("SwanAppAuthoritySettingFragment", "onDestroy() obj: " + this);
            }
        }
    }
}
