package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.themeCenter.background.BackgroundItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ys8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<List<DressItemData>> a;
    public TbPageContext<?> b;
    public xs8 c;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public BackgroundItemView b;
        public BackgroundItemView c;
        public BackgroundItemView d;

        public a(ys8 ys8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys8Var};
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

    public ys8(TbPageContext<?> tbPageContext, xs8 xs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, xs8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = xs8Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public List<DressItemData> getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<List<DressItemData>> list = this.a;
            if (list == null || list.size() <= 0 || i < 0 || i >= this.a.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (List) invokeI.objValue;
    }

    public void b(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<List<DressItemData>> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            List<DressItemData> item = getItem(i);
            if (view2 != null) {
                aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0133, viewGroup, false);
                aVar = new a(this);
                aVar.a = view2.findViewById(R.id.obfuscated_res_0x7f0922b8);
                aVar.b = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f09038b);
                aVar.c = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f09038c);
                aVar.d = (BackgroundItemView) view2.findViewById(R.id.obfuscated_res_0x7f09038d);
                view2.setTag(aVar);
            }
            if (item != null) {
                if (i == 0) {
                    aVar.a.setVisibility(0);
                } else {
                    aVar.a.setVisibility(8);
                }
                aVar.b.e(item.get(0));
                aVar.b.setController(this.c);
                if (item.size() > 2) {
                    aVar.c.e(item.get(1));
                    aVar.d.e(item.get(2));
                    aVar.c.setController(this.c);
                    aVar.d.setController(this.c);
                } else if (item.size() > 1) {
                    aVar.c.e(item.get(1));
                    aVar.c.setController(this.c);
                    aVar.d.f();
                } else {
                    aVar.c.f();
                    aVar.d.f();
                }
            }
            this.b.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
