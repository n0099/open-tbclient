package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jmb extends BaseAdapter {
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.bytedance.tools.ui.view.b a;

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
            this.a = (com.bytedance.tools.ui.view.b) view2;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;

        public b(View view2) {
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
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092708);
        }
    }

    public jmb(Context context, List<ulb> list) {
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.b.get(i).a();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            ulb ulbVar = this.b.get(i);
            if (view2 == null) {
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        com.bytedance.tools.ui.view.b bVar = new com.bytedance.tools.ui.view.b(this.a, ulbVar.f(), ulbVar, ulbVar.j());
                        bVar.setTag(new a(bVar));
                        return bVar;
                    }
                    return view2;
                }
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d05a8, viewGroup, false);
                b bVar2 = new b(inflate);
                bVar2.a.setText(ulbVar.f());
                if ("1".equals(ulbVar.h())) {
                    bVar2.b.setImageResource(R.drawable.obfuscated_res_0x7f080e3f);
                } else {
                    bVar2.b.setImageResource(R.drawable.obfuscated_res_0x7f080e40);
                }
                inflate.setTag(bVar2);
                return inflate;
            } else if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((a) view2.getTag()).a.f(ulbVar.f(), ulbVar, ulbVar.j());
                    return view2;
                }
                return view2;
            } else {
                b bVar3 = (b) view2.getTag();
                if ("1".equals(ulbVar.h())) {
                    bVar3.b.setImageDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e3f));
                    return view2;
                }
                bVar3.b.setImageDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e40));
                return view2;
            }
        }
        return (View) invokeILL.objValue;
    }
}
