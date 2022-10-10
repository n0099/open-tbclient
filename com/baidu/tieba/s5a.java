package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
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
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.ArrayList;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes5.dex */
public class s5a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<p4a> c;
    public PayUIKitConfig d;

    /* loaded from: classes5.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public ImageView c;
        public TextView d;

        public a(s5a s5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s5aVar};
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

    public s5a(Context context, PayUIKitConfig payUIKitConfig, List<p4a> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, payUIKitConfig, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = context;
        this.c = list;
        this.d = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public p4a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.c.get(i) : (p4a) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a9, viewGroup, false);
                aVar = new a(this);
                aVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092653);
                aVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f05);
                aVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b7c);
                aVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092419);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            p4a item = getItem(i);
            aVar.a.setText(item.a());
            PayType payType = item.a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ed0);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ecf);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ecb);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ecc);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ece);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ecd);
            } else if (PayType.DXM_PAY_H5.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080ecb);
            }
            aVar.a.setTextColor(this.a.getResources().getColor(R.color.obfuscated_res_0x7f0608e6));
            if (this.b == i) {
                aVar.c.setBackgroundResource(k5a.a.b(this.d) ? R.drawable.obfuscated_res_0x7f080ed8 : R.drawable.obfuscated_res_0x7f080ed9);
            } else {
                aVar.c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080eda);
            }
            if (TextUtils.isEmpty(item.c)) {
                aVar.d.setVisibility(8);
            } else {
                aVar.d.setVisibility(0);
                aVar.d.setText(item.c);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
