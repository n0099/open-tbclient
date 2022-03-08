package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
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
import com.dxmpay.apollon.utils.ResUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class O2OBankCardInfoAdapter extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SELECTEDORENABLEFLAG = "1";
    public static final String SHOW_BIND_CARD_BTN_FLAG = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public List<O2OBankInfo> a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f50586b;

    /* renamed from: c  reason: collision with root package name */
    public Context f50587c;

    /* renamed from: d  reason: collision with root package name */
    public int f50588d;

    /* renamed from: com.baidu.wallet.paysdk.datamodel.O2OBankCardInfoAdapter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f50589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ O2OBankCardInfoAdapter f50590c;

        public a(O2OBankCardInfoAdapter o2OBankCardInfoAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o2OBankCardInfoAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50590c = o2OBankCardInfoAdapter;
        }

        public /* synthetic */ a(O2OBankCardInfoAdapter o2OBankCardInfoAdapter, AnonymousClass1 anonymousClass1) {
            this(o2OBankCardInfoAdapter);
        }
    }

    public O2OBankCardInfoAdapter(Context context, List<O2OBankInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f50588d = 0;
        this.f50587c = context;
        this.f50586b = (LayoutInflater) context.getSystemService("layout_inflater");
        if (list != null) {
            this.a.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = this.f50586b.inflate(ResUtils.layout(this.f50587c, "wallet_base_bankinfo_item"), (ViewGroup) null);
                aVar = new a(this, null);
                aVar.a = (TextView) view.findViewById(ResUtils.id(this.f50587c, "bd_wallet_bank_info"));
                aVar.f50589b = (ImageView) view.findViewById(ResUtils.id(this.f50587c, "bd_Wallet_bank_sel_imge"));
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            O2OBankInfo item = getItem(i2);
            if (item == null) {
                return view;
            }
            if (i2 == 0) {
                view.setBackgroundResource(ResUtils.drawable(this.f50587c, "wallet_base_corners_top"));
            } else {
                view.setBackgroundResource(ResUtils.drawable(this.f50587c, "wallet_base_history_item_selector"));
            }
            if ("1".equalsIgnoreCase(item.enabled)) {
                aVar.a.setEnabled(true);
                aVar.a.setText(item.display_name);
                aVar.a.setTextColor(ResUtils.getColor(this.f50587c, "bd_wallet_text_gray_color"));
            } else {
                aVar.a.setEnabled(false);
                aVar.a.setText(item.display_name);
                aVar.a.setTextColor(ResUtils.getColor(this.f50587c, "dxm_wallet_pwdpay_light_gray"));
            }
            if (i2 + 1 == this.f50588d) {
                aVar.f50589b.setImageDrawable(ResUtils.getDrawable(this.f50587c, "wallet_base_payset_checked"));
            } else {
                aVar.f50589b.setImageDrawable(ResUtils.getDrawable(this.f50587c, "wallet_base_payset_unchecked"));
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public void setData(List<O2OBankInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void setSelIndex(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.f50588d = i2;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public O2OBankInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.a.size()) {
                return null;
            }
            return this.a.get(i2);
        }
        return (O2OBankInfo) invokeI.objValue;
    }
}
