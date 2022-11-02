package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.yt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class zt6 implements ut6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public yt6.e b;
    public Context c;
    public List<rk6> d;
    public yt6 e;
    public final BaseAdapter f;
    public AdapterView.OnItemClickListener g;

    @Override // com.baidu.tieba.ut6
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt6 a;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        public a(zt6 zt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public rk6 getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.d == null) {
                    return null;
                }
                return (rk6) this.a.d.get(i);
            }
            return (rk6) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.d == null) {
                    return 0;
                }
                return this.a.d.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0859, (ViewGroup) null);
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275)));
                    yt6.f fVar = new yt6.f();
                    fVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092067);
                    fVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f092064);
                    fVar.c = view2.findViewById(R.id.obfuscated_res_0x7f092066);
                    fVar.d = view2.findViewById(R.id.obfuscated_res_0x7f092065);
                    view2.setTag(fVar);
                }
                SkinManager.setBackgroundResource(view2, R.color.CAM_X0201);
                yt6.f fVar2 = (yt6.f) view2.getTag();
                rk6 item = getItem(i);
                if (item == null) {
                    return view2;
                }
                fVar2.a.setText(item.a);
                if (item.c) {
                    SkinManager.setViewTextColor(fVar2.a, R.color.CAM_X0302, 1);
                    SkinManager.setImageResource(fVar2.b, R.drawable.chx_tips_list_ok);
                    fVar2.b.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(fVar2.a, R.color.CAM_X0108, 1);
                    fVar2.b.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    fVar2.d.setVisibility(0);
                    fVar2.c.setVisibility(8);
                    SkinManager.setBackgroundColor(fVar2.d, R.color.CAM_X0204);
                } else {
                    fVar2.c.setVisibility(0);
                    fVar2.d.setVisibility(8);
                    SkinManager.setBackgroundColor(fVar2.c, R.color.CAM_X0204);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt6 a;

        public b(zt6 zt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.e != null) {
                    this.a.e.c();
                }
                if (this.a.f != null && this.a.b != null) {
                    for (rk6 rk6Var : this.a.d) {
                        if (rk6Var != null) {
                            rk6Var.c = false;
                        }
                    }
                    rk6 rk6Var2 = (rk6) this.a.f.getItem(i);
                    if (rk6Var2 != null) {
                        rk6Var2.c = true;
                        this.a.b.a(rk6Var2.b);
                    }
                }
            }
        }
    }

    public zt6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.g = new b(this);
    }

    @Override // com.baidu.tieba.ut6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ut6
    public void setData(List<rk6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.d = list;
            this.f.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ut6
    public void a(Context context, yt6 yt6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, yt6Var) == null) && context != null && yt6Var != null) {
            this.c = context;
            this.e = yt6Var;
            this.b = yt6Var.d();
            g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdListView bdListView = new BdListView(this.c);
            this.a = bdListView;
            bdListView.setAlwaysDrawnWithCacheEnabled(false);
            this.a.setDivider(null);
            this.a.setDividerHeight(0);
            this.a.setSelector(17170445);
            this.a.setCacheColorHint(this.c.getResources().getColor(17170445));
            this.a.setOnItemClickListener(this.g);
            this.a.setAdapter((ListAdapter) this.f);
        }
    }
}
