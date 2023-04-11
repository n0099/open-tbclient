package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.location.selectpoi.SearchLocationActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class kg8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hg8 a;
    public SearchLocationActivity b;
    public boolean c;
    public NoDataView d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public b(kg8 kg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(kg8 kg8Var, a aVar) {
            this(kg8Var);
        }
    }

    public kg8(SearchLocationActivity searchLocationActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {searchLocationActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.b = searchLocationActivity;
    }

    public b b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            b bVar = new b(this, null);
            bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915a6);
            bVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0915a7);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public void d(hg8 hg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hg8Var) == null) {
            this.a = hg8Var;
        }
    }

    public View a(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            NoDataView a2 = NoDataViewFactory.a(this.b.getPageContext().getPageActivity(), viewGroup, NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14a8), null);
            this.d = a2;
            a2.f(this.b.getPageContext(), skinType);
            this.d.setVisibility(0);
            return this.d;
        }
        return (View) invokeL.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            hg8 hg8Var = this.a;
            if (hg8Var != null && hg8Var.a() != null && !this.a.a().isEmpty()) {
                this.c = true;
                return this.a.a().size();
            }
            this.c = false;
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            hg8 hg8Var = this.a;
            if (hg8Var != null && hg8Var.a() != null && !this.a.a().isEmpty()) {
                return this.a.a().get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (!this.c) {
                return a(viewGroup);
            }
            b bVar = null;
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            }
            if (bVar == null) {
                view2 = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05a8, viewGroup, false);
                bVar = b(view2);
                view2.setTag(bVar);
            }
            bVar.a.setText(this.a.a().get(i).a());
            SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.a, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundResource(view2, R.drawable.home_recommend_item_bg);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
