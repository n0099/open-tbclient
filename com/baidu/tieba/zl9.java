package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class zl9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gm9 a;
    public int b;
    public a c;
    public Context d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public TextView b;

        public a(zl9 zl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public zl9(Context context) {
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
        this.b = 0;
        this.d = context;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = i;
            notifyDataSetChanged();
        }
    }

    public void e(gm9 gm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gm9Var) == null) {
            this.a = gm9Var;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        ArrayList<gm9> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            gm9 gm9Var = this.a;
            if (gm9Var != null && (arrayList = gm9Var.e) != null) {
                return arrayList.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    public final View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.d).inflate(R.layout.obfuscated_res_0x7f0d02d4, (ViewGroup) null);
            a aVar = new a(this);
            this.c = aVar;
            aVar.a = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09168d);
            this.c.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091694);
            inflate.setTag(this.c);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final void b(a aVar, gm9 gm9Var, View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, gm9Var, view2, i) == null) && aVar != null && gm9Var != null) {
            aVar.b.setText("");
            if (i == 0) {
                TextView textView = aVar.b;
                textView.setText(this.d.getString(R.string.obfuscated_res_0x7f0f0270) + gm9Var.b);
            } else {
                aVar.b.setText(gm9Var.b);
            }
            if (i != this.b) {
                aVar.a.setVisibility(4);
                SkinManager.setViewTextColor(aVar.b, R.color.common_color_10200, 1);
                return;
            }
            aVar.a.setVisibility(0);
            SkinManager.setViewTextColor(aVar.b, R.color.common_color_10013, 1);
        }
    }

    public gm9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (gm9) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<gm9> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            gm9 gm9Var = this.a;
            if (gm9Var != null && (arrayList = gm9Var.e) != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = a();
            }
            gm9 gm9Var = this.a;
            if (gm9Var == null) {
                return view2;
            }
            gm9 gm9Var2 = gm9Var.e.get(i);
            a aVar = (a) view2.getTag();
            this.c = aVar;
            if (gm9Var2 != null) {
                b(aVar, gm9Var2, view2, i);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
