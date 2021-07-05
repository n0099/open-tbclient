package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BdMenu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public GetCardInfoResponse.CertificateTypeInfo[] f26850a;

    /* renamed from: b  reason: collision with root package name */
    public CertificateMenuView.b f26851b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, certificateTypeInfoArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26850a = certificateTypeInfoArr;
        setDismissOnClick(true);
    }

    public void a(CertificateMenuView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f26851b = bVar;
        }
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, list) == null) {
            CertificateMenuView certificateMenuView = (CertificateMenuView) view;
            certificateMenuView.setCertificertSelectListener(this.f26851b);
            certificateMenuView.layoutMenu(this.f26850a);
        }
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public View getMenuView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new CertificateMenuView(context) : (View) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, popupWindow) == null) {
            popupWindow.showAsDropDown(this.mViewToAttach);
        }
    }
}
