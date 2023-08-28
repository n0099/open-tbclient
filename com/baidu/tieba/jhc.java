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
/* loaded from: classes6.dex */
public class jhc extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<tfc> c;
    public PayUIKitConfig d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public ImageView c;
        public TextView d;

        public a(jhc jhcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jhcVar};
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

    public jhc(Context context, PayUIKitConfig payUIKitConfig, List<tfc> list) {
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
    public tfc getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return this.c.get(i);
        }
        return (tfc) invokeI.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.pay_ui_item_pay_way_choose, viewGroup, false);
                aVar = new a(this);
                aVar.a = (TextView) view2.findViewById(R.id.way_tv_title);
                aVar.c = (ImageView) view2.findViewById(R.id.img_select);
                aVar.b = (ImageView) view2.findViewById(R.id.recharge_way_bg);
                aVar.d = (TextView) view2.findViewById(R.id.tv_tips);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            tfc item = getItem(i);
            aVar.a.setText(item.a());
            PayType payType = item.a;
            if (PayType.ALI_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_zhifubao_icon);
            } else if (PayType.WECHAT_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_weixin_icon);
            } else if (PayType.DXM_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_dxm_icon);
            } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_dxmkj_icon);
            } else if (PayType.UNION_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_unionpay_icon);
            } else if (PayType.QQ_PAY.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_qqpay_icon);
            } else if (PayType.DXM_PAY_H5.equals(payType)) {
                aVar.b.setBackgroundResource(R.drawable.pay_ui_pay_channel_dxm_icon);
            }
            aVar.a.setTextColor(this.a.getResources().getColor(R.color.pay_ui_font_color_6));
            if (this.b == i) {
                if (vgc.a.b(this.d)) {
                    i2 = R.drawable.pay_ui_pay_way_item_select;
                } else {
                    i2 = R.drawable.pay_ui_pay_way_item_select_y;
                }
                aVar.c.setBackgroundResource(i2);
            } else {
                aVar.c.setBackgroundResource(R.drawable.pay_ui_pay_way_item_unselect);
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
