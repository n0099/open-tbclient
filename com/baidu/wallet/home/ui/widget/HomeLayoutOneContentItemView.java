package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class HomeLayoutOneContentItemView extends BaseItemView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HomeFinanceContentItemView";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f25196a;

    /* renamed from: b  reason: collision with root package name */
    public NetImageView f25197b;

    /* renamed from: c  reason: collision with root package name */
    public NetImageView f25198c;
    public MaskTextView mDesc_1;
    public MaskTextView mDesc_2;
    public NetImageView mIcon;
    public MaskTextView mTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLayoutOneContentItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeAllViews();
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_layout1_item_layout"), this);
            this.f25196a = findViewById(ResUtils.id(getContext(), "content_layout"));
            this.mIcon = (NetImageView) findViewById(ResUtils.id(getContext(), "home_finance_item_icon"));
            this.mTitle = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_title"));
            this.mDesc_1 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_des_1"));
            this.mDesc_2 = (MaskTextView) findViewById(ResUtils.id(getContext(), "home_finance_item_des_2"));
            this.f25197b = (NetImageView) findViewById(ResUtils.id(getContext(), "red_dot_im"));
            this.f25198c = (NetImageView) findViewById(ResUtils.id(getContext(), "corner_flag_im"));
        }
    }

    public static int getItemHeight(Context context, HomeCfgResponse.DataItem[] dataItemArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, dataItemArr)) == null) {
            int dimension = (int) ResUtils.getDimension(context, "bd_wallet_home_item_finace_two_line_height");
            if (dataItemArr == null || dataItemArr.length <= 0) {
                return dimension;
            }
            for (int i2 = 0; i2 < dataItemArr.length; i2++) {
                if (dataItemArr[i2] != null && !TextUtils.isEmpty(dataItemArr[i2].value1) && !TextUtils.isEmpty(dataItemArr[i2].value2)) {
                    return (int) ResUtils.getDimension(context, "bd_wallet_home_item_finace_three_line_height");
                }
            }
            return dimension;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public boolean handlePoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (isShoudShowPoint()) {
                this.f25197b.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.f25197b.getLayoutParams()).addRule(1, this.mTitle.getId());
                ((RelativeLayout.LayoutParams) this.f25197b.getLayoutParams()).addRule(6, this.mTitle.getId());
                ((RelativeLayout.LayoutParams) this.f25197b.getLayoutParams()).leftMargin = (int) (ResUtils.getDimension(getContext(), "bd_wallet_home_icon_flag_text_right_margin") - ResUtils.getDimension(getContext(), "bd_wallet_home_item_life_margin"));
                this.f25197b.setImageDrawable(ResUtils.getDrawable(getContext(), isShowWhiteDot() ? "wallet_home_white_star" : "wallet_home_red_star"));
                return true;
            }
            this.f25197b.setVisibility(8);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void onEyeMaskChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onEyeMaskChanged();
            MaskTextView maskTextView = this.mTitle;
            if (maskTextView != null) {
                maskTextView.resetMaskText();
            }
            MaskTextView maskTextView2 = this.mDesc_1;
            if (maskTextView2 != null) {
                maskTextView2.resetMaskText();
            }
            MaskTextView maskTextView3 = this.mDesc_2;
            if (maskTextView3 != null) {
                maskTextView3.resetMaskText();
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || getData() == null) {
            return;
        }
        a();
        setTitle(getData().name);
        if (!TextUtils.isEmpty(getData().value1)) {
            setDesc1(getData().value1);
            setDesc1Visibility(0);
        } else {
            setDesc1Visibility(8);
        }
        if (!TextUtils.isEmpty(getData().value2)) {
            setDesc2(getData().value2);
            setDesc2Visibility(0);
        } else {
            setDesc2Visibility(8);
        }
        setIconUrl(getData().logo);
        if (!handlePoint() && hasCornor()) {
            this.f25198c.setVisibility(0);
            NetImageView netImageView = this.f25198c;
            netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + getData().corner_addr);
            return;
        }
        this.f25198c.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemView
    public void setData(HomeCfgResponse.DataItem dataItem, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dataItem, bVar) == null) {
            super.setData(dataItem, bVar);
            a();
            refresh();
        }
    }

    public void setDesc1(String str) {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (maskTextView = this.mDesc_1) == null) {
            return;
        }
        maskTextView.setMaskText(str);
    }

    public void setDesc1Visibility(int i2) {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (maskTextView = this.mDesc_1) == null || maskTextView.getVisibility() == i2) {
            return;
        }
        this.mDesc_1.setVisibility(i2);
    }

    public void setDesc2(String str) {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (maskTextView = this.mDesc_2) == null) {
            return;
        }
        maskTextView.setMaskText(str);
    }

    public void setDesc2Visibility(int i2) {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (maskTextView = this.mDesc_2) == null || maskTextView.getVisibility() == i2) {
            return;
        }
        this.mDesc_2.setVisibility(i2);
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f25196a.getLayoutParams().height = i2;
        }
    }

    public void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.mIcon == null || TextUtils.isEmpty(str)) {
            return;
        }
        NetImageView netImageView = this.mIcon;
        netImageView.setImageUrl(getWalletInterface().getAndroidPrefix() + str);
    }

    public void setTitle(String str) {
        MaskTextView maskTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (maskTextView = this.mTitle) == null) {
            return;
        }
        maskTextView.setMaskText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLayoutOneContentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
