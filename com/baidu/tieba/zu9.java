package com.baidu.tieba;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.wu9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class zu9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public final List<wu9.a> b;
    public int c;
    public String d;
    public String e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu9.a a;
        public final /* synthetic */ zu9 b;

        public a(zu9 zu9Var, wu9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zu9Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zu9Var;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.a == null) {
                return;
            }
            this.b.h(this.a);
            if (this.a.g == 1) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(this.b.a.getPageActivity()).createSubPbActivityConfig(this.a.f + "", this.a.a + "", "search_post", true);
                createSubPbActivityConfig.setKeyPageStartFrom(8);
                this.b.a.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(this.b.a.getPageActivity()).createNormalCfg(this.a.f + "", this.a.a + "", "search_post");
            createNormalCfg.setStartFrom(8);
            createNormalCfg.setSortType(0);
            this.b.a.sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948372587, "Lcom/baidu/tieba/zu9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948372587, "Lcom/baidu/tieba/zu9;");
                return;
            }
        }
        TbadkCoreApplication.getInst().getListItemRule().c();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<wu9.a> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public zu9(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = tbPageContext;
        this.b = new ArrayList();
    }

    public final void g(wu9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c15357");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", aVar.f);
            if (aVar.g == 1 || aVar.h == 1) {
                statisticItem.param("pid", aVar.a);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void c(List<wu9.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b.clear();
            this.b.addAll(list);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = str;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            List<wu9.a> list = this.b;
            if (list == null || list.isEmpty() || i < 0 || i >= this.b.size()) {
                return null;
            }
            return this.b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0811, (ViewGroup) null);
                b bVar = new b(null);
                bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258d);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907d8);
                bVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091459);
                bVar.d = (TextView) view2.findViewById(R.id.user_name);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09252f);
                view2.setTag(bVar);
            }
            b bVar2 = (b) view2.getTag();
            wu9.a aVar = this.b.get(i);
            if (aVar == null) {
                return view2;
            }
            bVar2.a.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.b, "#e53917")));
            bVar2.b.setText(Html.fromHtml(StringHelper.getHighLightString(aVar.d, "#e53917")));
            bVar2.d.setText(aVar.i);
            bVar2.e.setText(StringHelper.getFormatTime(aVar.c));
            bVar2.c.setVisibility(0);
            if (aVar.g == 1) {
                bVar2.c.setText(R.string.obfuscated_res_0x7f0f0753);
            } else if (aVar.h == 1) {
                bVar2.c.setText(R.string.obfuscated_res_0x7f0f122c);
            } else {
                bVar2.c.setVisibility(8);
            }
            view2.setOnClickListener(new a(this, aVar));
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            ks5.a(this.a, view2);
            i(aVar);
            g(aVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(wu9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c12405").param("fname", aVar.e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i = this.c;
            if (i > 0) {
                param.param("tab_id", i);
            }
            if (aVar != null) {
                if (aVar.g != 1 && aVar.h != 1) {
                    param.param("tid", aVar.f);
                } else {
                    param.param("pid", aVar.a);
                }
                param.param("fid", this.e);
                param.param("query", this.d);
            }
            TiebaStatic.log(param);
        }
    }

    public final void i(wu9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            StatisticItem param = new StatisticItem("c14171").param("fname", aVar.e).param("uid", TbadkCoreApplication.getCurrentAccount());
            int i = this.c;
            if (i > 0) {
                param.param("tab_id", i);
            }
            if (aVar != null) {
                if (aVar.g != 1 && aVar.h != 1) {
                    param.param("tid", aVar.f);
                } else {
                    param.param("pid", aVar.a);
                }
                param.param("fid", this.e);
                param.param("query", this.d);
            }
            TiebaStatic.log(param);
        }
    }
}
