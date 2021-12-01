package com.baidu.wallet.base.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class CustomerServiceMenu extends BdMenu implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHARGE_RECORD = 100003;
    public static final int CHARGE_SERVICE = 100004;
    public static final int TRANSFER_RECORD = 100001;
    public static final int TRANSFER_SERVICE = 100002;
    public static final int WITHDRAW_RECORD = 100005;
    public static final int WITHDRAW_SERVICE = 100006;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerServiceMenu(View view, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 == 100001) {
            add(TRANSFER_RECORD, ResUtils.string(this.mContext, "wallet_transfer_record"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        } else if (i2 == 100003) {
            add(CHARGE_RECORD, ResUtils.string(this.mContext, "bd_wallet_balance_charge_records"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        } else if (i2 == 100005) {
            add(WITHDRAW_RECORD, ResUtils.string(this.mContext, "bd_wallet_balance_withdraw_records"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        }
        setDismissOnClick(true);
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, list) == null) {
            ((ContextMenuView) view).layoutMenu(list);
        }
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public View getMenuView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? new ContextMenuView(context) : (View) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, popupWindow) == null) {
            popupWindow.showAsDropDown(this.mViewToAttach);
        }
    }
}
