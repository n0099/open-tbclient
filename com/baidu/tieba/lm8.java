package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class lm8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public final List<nm8> b;
    public LayoutInflater c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TextView b;
        public View c;
        public View d;

        public b(lm8 lm8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }

        public /* synthetic */ b(lm8 lm8Var, a aVar) {
            this(lm8Var);
        }
    }

    public lm8(TbPageContext tbPageContext) {
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
        this.b = new ArrayList();
        this.c = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public final void a(b bVar, View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, bVar, view2, i) == null) && bVar != null && bVar.a != i) {
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(bVar.d, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.b, R.color.CAM_X0105, 1);
            bVar.a = i;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.clear();
            notifyDataSetChanged();
        }
    }

    public List<nm8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public nm8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.b.get(i);
        }
        return (nm8) invokeI.objValue;
    }

    public void e(String str, List<nm8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) {
            this.a = str;
            this.b.clear();
            if (list != null) {
                this.b.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            nm8 item = getItem(i);
            if (item == null) {
                return view2;
            }
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            } else {
                view2 = this.c.inflate(R.layout.obfuscated_res_0x7f0d042c, (ViewGroup) null);
                bVar = new b(this, null);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091993);
                bVar.c = view2.findViewById(R.id.divider_line_top);
                bVar.d = view2.findViewById(R.id.divider_line_bottom);
                view2.setTag(bVar);
            }
            View view3 = bVar.c;
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view3.setVisibility(i2);
            bVar.b.setText(StringHelper.highLightText(rt5.a(StringHelper.cutStringWithEllipsisNew(item.b(), 18)), this.a, R.color.CAM_X0302));
            a(bVar, view2, TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
