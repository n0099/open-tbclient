package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class imb extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<ulb> b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911f4);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911af);
        }
    }

    public imb(Context context, List<ulb> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return this.b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
            ulb ulbVar = this.b.get(i);
            if (view2 == null) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05a7, viewGroup, false);
                a aVar = new a(inflate);
                aVar.a.setText(ulbVar.f());
                aVar.b.setText(ulbVar.h());
                inflate.setTag(aVar);
                return inflate;
            }
            a aVar2 = (a) view2.getTag();
            aVar2.a.setText(ulbVar.f());
            aVar2.b.setText(ulbVar.h());
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
