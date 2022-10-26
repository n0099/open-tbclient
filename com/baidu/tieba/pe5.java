package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class pe5 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList a;
    public TbPageContext b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TbImageView b;

        public b(pe5 pe5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pe5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(pe5 pe5Var, a aVar) {
            this(pe5Var);
        }
    }

    public pe5(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = -1;
        this.h = 0;
        this.i = 0;
        this.b = tbPageContext;
        this.a = new ArrayList();
        this.d = SkinManager.getColor(R.color.common_color_10043);
        this.e = SkinManager.getColor(R.color.CAM_X0302);
        this.f = fj.f(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070198);
        this.g = fj.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070224);
        this.h = fj.f(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070215);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int i2 = i / 4;
            if (i2 == 0) {
                return 1;
            }
            if (i2 == this.i - 1) {
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.c = i;
        }
    }

    public void c(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            this.a = arrayList;
            if (arrayList != null) {
                if (arrayList.size() % 4 == 0) {
                    this.i = arrayList.size() / 4;
                } else {
                    this.i = (arrayList.size() / 4) + 1;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList != null && i < arrayList.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i == this.c) {
                return 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = this.a;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d077a, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919bc);
                bVar.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919ba);
            } else {
                bVar = (b) view2.getTag();
            }
            if (a(i) == 1) {
                bVar.a.setPadding(0, this.h, 0, 0);
            } else if (a(i) == 2) {
                bVar.a.setPadding(0, 0, 0, this.h);
            } else {
                bVar.a.setPadding(0, 0, 0, 0);
            }
            bVar.b.setDrawerType(0);
            bVar.b.setBorderSurroundContent(true);
            bVar.b.setDrawBorder(true);
            if (itemViewType == 0) {
                bVar.b.setBorderColor(this.d);
                bVar.b.setBorderWidth(this.f);
            } else {
                bVar.b.setBorderColor(this.e);
                bVar.b.setBorderWidth(this.g);
            }
            bVar.b.setDefaultResource(R.drawable.obfuscated_res_0x7f081252);
            bVar.b.L(((qe5) this.a.get(i)).a(), 10, false);
            view2.setTag(bVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
