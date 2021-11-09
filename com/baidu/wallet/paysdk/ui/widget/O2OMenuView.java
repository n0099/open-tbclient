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
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
/* loaded from: classes10.dex */
public class O2OMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f60460a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60461b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f60462c;

    /* renamed from: d  reason: collision with root package name */
    public a f60463d;

    /* renamed from: e  reason: collision with root package name */
    public OnO2OMenuItemSelectListener f60464e;

    /* loaded from: classes10.dex */
    public interface OnO2OMenuItemSelectListener {
        void onMenuItemClick(String str);
    }

    /* loaded from: classes10.dex */
    public class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ O2OMenuView f60466a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f60467b;

        public a(O2OMenuView o2OMenuView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o2OMenuView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60466a = o2OMenuView;
        }

        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) {
                this.f60467b = strArr;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String[] strArr = this.f60467b;
                if (strArr != null) {
                    return strArr.length;
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
            O2OMenuItemView o2OMenuItemView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    o2OMenuItemView = new O2OMenuItemView(this.f60466a.getContext());
                } else {
                    o2OMenuItemView = (O2OMenuItemView) view;
                }
                o2OMenuItemView.updateItem(this.f60467b[i2]);
                return o2OMenuItemView;
            }
            return (View) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1832842512, "Lcom/baidu/wallet/paysdk/ui/widget/O2OMenuView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1832842512, "Lcom/baidu/wallet/paysdk/ui/widget/O2OMenuView;");
                return;
            }
        }
        f60460a = O2OMenuView.class.getSimpleName();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public O2OMenuView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f60461b = false;
        a();
    }

    public String getBackgroundResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "wallet_base_o2o_bg_pay_more" : (String) invokeV.objValue;
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

    public void layoutMenu(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            a aVar = this.f60463d;
            if (aVar != null) {
                aVar.a(strArr);
                this.f60463d.notifyDataSetChanged();
                return;
            }
            a aVar2 = new a(this);
            this.f60463d = aVar2;
            aVar2.a(strArr);
            this.f60462c.setAdapter((ListAdapter) this.f60463d);
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
            this.f60461b = false;
        }
    }

    public void setMenuSelectListener(OnO2OMenuItemSelectListener onO2OMenuItemSelectListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onO2OMenuItemSelectListener) == null) {
            this.f60464e = onO2OMenuItemSelectListener;
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
            this.f60462c = new ListView(getContext());
            int dip2px = DisplayUtils.dip2px(getContext(), 115.0f);
            this.f60462c.setDivider(new ColorDrawable(getSeparatorColor()));
            this.f60462c.setDividerHeight(1);
            this.f60462c.setSelector(new ColorDrawable(0));
            this.f60462c.setOnItemClickListener(new AdapterView.OnItemClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.O2OMenuView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ O2OMenuView f60465a;

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
                    this.f60465a = this;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) && view != null && (view instanceof O2OMenuItemView)) {
                        String string = ((O2OMenuItemView) view).getString();
                        if (this.f60465a.f60464e != null) {
                            this.f60465a.f60464e.onMenuItemClick(string);
                        }
                    }
                }
            });
            addView(this.f60462c, new LinearLayout.LayoutParams(dip2px, -2));
            setFocusableInTouchMode(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O2OMenuView(Context context, AttributeSet attributeSet) {
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
        this.f60461b = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O2OMenuView(Context context) {
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
        this.f60461b = false;
        a();
    }
}
