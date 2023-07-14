package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagItemInfo;
import java.util.List;
import tv.athena.revenue.payui.model.ImageLoaderSupplier;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes7.dex */
public class mbc extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<GiftBagItemInfo> b;
    public PayUIKitConfig c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        public a(mbc mbcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mbcVar};
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

    public mbc(Context context, List<GiftBagItemInfo> list, PayUIKitConfig payUIKitConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, payUIKitConfig};
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
        this.c = payUIKitConfig;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftBagItemInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<GiftBagItemInfo> list = this.b;
            if (list != null && !list.isEmpty() && i >= 0 && i < this.b.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (GiftBagItemInfo) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.a, zac.a.a(this.c));
                if (getCount() <= 2) {
                    i2 = R.layout.pay_ui_item_pay_gift_bag_big;
                } else {
                    i2 = R.layout.pay_ui_item_pay_gift_bag_small;
                }
                view2 = LayoutInflater.from(contextThemeWrapper).inflate(i2, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TextView) view2.findViewById(R.id.tv_gift_name);
                aVar.c = (ImageView) view2.findViewById(R.id.img_gift);
                aVar.b = (TextView) view2.findViewById(R.id.tv_num);
                aVar.d = (TextView) view2.findViewById(R.id.tv_type);
                view2.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
            }
            GiftBagItemInfo item = getItem(i);
            if (TextUtils.isEmpty(item.name)) {
                aVar.a.setVisibility(4);
            } else {
                aVar.a.setVisibility(0);
                aVar.a.setText(item.name);
            }
            if (!TextUtils.isEmpty(item.countDisplay) && !StringUtil.NULL_STRING.equals(item.countDisplay)) {
                aVar.b.setVisibility(0);
                aVar.b.setText(item.countDisplay);
            } else {
                aVar.b.setVisibility(4);
            }
            if (!TextUtils.isEmpty(item.typeName) && !StringUtil.NULL_STRING.equals(item.typeName)) {
                aVar.d.setVisibility(0);
                aVar.d.setText(item.typeName);
            } else {
                aVar.d.setVisibility(4);
            }
            PayUIKitConfig payUIKitConfig = this.c;
            if (payUIKitConfig != null && payUIKitConfig.imageLoaderSupplier != null) {
                this.c.imageLoaderSupplier.onLoad(this.a, aVar.c, new ImageLoaderSupplier.ImageParam(item.imgUrl, -1, -1));
            } else {
                RLog.error("PayGiftListAdapter", "getView error mPayUIKitConfig null", new Object[0]);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
