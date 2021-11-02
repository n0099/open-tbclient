package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
/* loaded from: classes10.dex */
public class CertificateMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60441a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60442b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f60443c;

    /* renamed from: d  reason: collision with root package name */
    public a f60444d;

    /* renamed from: e  reason: collision with root package name */
    public b f60445e;

    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CertificateMenuView f60447a;

        /* renamed from: b  reason: collision with root package name */
        public GetCardInfoResponse.CertificateTypeInfo[] f60448b;

        public a(CertificateMenuView certificateMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {certificateMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60447a = certificateMenuView;
        }

        public void a(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, certificateTypeInfoArr) == null) {
                this.f60448b = certificateTypeInfoArr;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr = this.f60448b;
                if (certificateTypeInfoArr != null) {
                    return certificateTypeInfoArr.length;
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                return null;
            }
            return invokeI.objValue;
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
            CertificateMenuItemView certificateMenuItemView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    certificateMenuItemView = new CertificateMenuItemView(this.f60447a.getContext());
                } else {
                    certificateMenuItemView = (CertificateMenuItemView) view;
                }
                certificateMenuItemView.updateItem(this.f60448b[i2]);
                return certificateMenuItemView;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-713780763, "Lcom/baidu/wallet/paysdk/ui/widget/CertificateMenuView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-713780763, "Lcom/baidu/wallet/paysdk/ui/widget/CertificateMenuView;");
                return;
            }
        }
        f60441a = CertificateMenuView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public CertificateMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f60442b = false;
        a();
    }

    public String getBackgroundResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "wallet_base_certifcate_dialog" : (String) invokeV.objValue;
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
            return null;
        }
        return (String) invokeII.objValue;
    }

    public String getMenuItemViewLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "dxm_wallet_base_menu_item_view" : (String) invokeV.objValue;
    }

    public int getSeparatorColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return -1710619;
        }
        return invokeV.intValue;
    }

    public void layoutMenu(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, certificateTypeInfoArr) == null) {
            a aVar = this.f60444d;
            if (aVar != null) {
                aVar.a(certificateTypeInfoArr);
                this.f60444d.notifyDataSetChanged();
                return;
            }
            a aVar2 = new a(this);
            this.f60444d = aVar2;
            aVar2.a(certificateTypeInfoArr);
            this.f60443c.setAdapter((ListAdapter) this.f60444d);
        }
    }

    @Override // com.dxmpay.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdMenuItem) == null) {
        }
    }

    @Override // com.dxmpay.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f60442b = false;
        }
    }

    public void setCertificertSelectListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f60445e = bVar;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
            this.f60443c = new ListView(getContext());
            int dip2px = DisplayUtils.dip2px(getContext(), 115.0f);
            this.f60443c.setDivider(new ColorDrawable(getSeparatorColor()));
            this.f60443c.setDividerHeight(1);
            this.f60443c.setSelector(new ColorDrawable(0));
            this.f60443c.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.CertificateMenuView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CertificateMenuView f60446a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60446a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) && view != null && (view instanceof CertificateMenuItemView)) {
                        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = ((CertificateMenuItemView) view).getCertificateTypeInfo();
                        if (this.f60446a.f60445e != null) {
                            this.f60446a.f60445e.a(certificateTypeInfo);
                        }
                    }
                }
            });
            addView(this.f60443c, new LinearLayout.LayoutParams(dip2px, -2));
            setFocusableInTouchMode(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f60442b = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60442b = false;
        a();
    }
}
