package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class roa extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bpa> a;
    public bpa b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;

        public a(roa roaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {roaVar};
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

    public roa() {
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
        this.a = new ArrayList();
    }

    public List<bpa> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.size();
        }
        return invokeV.intValue;
    }

    public void b(bpa bpaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bpaVar) == null) {
            if (bpaVar == null) {
                List<bpa> list = this.a;
                if (list != null) {
                    this.b = list.get(0);
                }
            } else {
                this.b = bpaVar;
            }
            notifyDataSetChanged();
        }
    }

    public void c(List<bpa> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && list != null) {
            this.a = list;
            if (list.size() > 0) {
                this.b = this.a.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0 && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f09122c && (view2.getTag() instanceof bpa)) {
            this.b = (bpa) view2.getTag();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view3;
        a aVar;
        bpa bpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d05bd, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f09122c);
                aVar.a = tbImageView;
                tbImageView.setIsRound(true);
                aVar.a.setDrawerType(1);
                aVar.a.setDefaultBgResource(R.color.transparent);
                aVar.a.setBorderWidth(BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
                aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.a.setConrers(15);
                TextView textView = (TextView) view3.findViewById(R.id.tv_name);
                aVar.b = textView;
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
                aVar.b = (TextView) view3.findViewById(R.id.tv_name);
                view3.setTag(aVar);
            } else {
                view3 = view2;
                aVar = (a) view2.getTag();
            }
            if (i >= 0 && i < this.a.size()) {
                bpa bpaVar2 = this.a.get(i);
                if (bpaVar2 != null) {
                    aVar.a.setTag(bpaVar2);
                    aVar.a.setOnClickListener(this);
                    aVar.a.startLoad(String.valueOf(bpaVar2.b), 24, false);
                    aVar.b.setText(bpaVar2.a);
                }
                if (!TextUtils.isEmpty(bpaVar2.a) && (bpaVar = this.b) != null && TextUtils.equals(bpaVar2.a, bpaVar.a)) {
                    aVar.a.setDrawBorder(true);
                } else {
                    aVar.a.setDrawBorder(false);
                }
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }
}
