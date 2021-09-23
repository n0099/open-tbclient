package com.baidu.wallet.base.widget.pulltorefresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
/* loaded from: classes8.dex */
public class FooterLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f60884a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60885b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f60886c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f60887d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterLoadingLayout(Context context) {
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
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            this.f60884a = (ProgressBar) findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"));
            this.f60885b = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_loadmore_text"));
            setState(LoadingLayout.State.RESET);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, attributeSet)) == null) ? LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_base_load_more"), (ViewGroup) null) : (View) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ResUtils.dimen(getContext(), "wallet_base_footer_height") : invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onNoMoreData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f60885b.setVisibility(0);
            if (TextUtils.isEmpty(this.f60887d)) {
                this.f60885b.setText(ResUtils.getString(getContext(), "wallet_base_no_more"));
            } else {
                this.f60885b.setText(this.f60887d);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f60884a.setVisibility(0);
            this.f60885b.setVisibility(0);
            if (TextUtils.isEmpty(this.f60886c)) {
                this.f60885b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
            } else {
                this.f60885b.setText(this.f60886c);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TextUtils.isEmpty(this.f60886c)) {
                this.f60885b.setText(ResUtils.string(getContext(), "wallet_base_refresh_loading"));
            } else {
                this.f60885b.setText(this.f60886c);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, state, state2) == null) {
            this.f60884a.setVisibility(8);
            this.f60885b.setVisibility(4);
            super.onStateChanged(state, state2);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, charSequence) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setNoMoreDataLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f60887d = charSequence;
        TextView textView = this.f60885b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f60886c = charSequence;
        TextView textView = this.f60885b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void showTopDivider(boolean z) {
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_progress_footer"))) == null) {
            return;
        }
        findViewById.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterLoadingLayout(Context context, AttributeSet attributeSet) {
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
        a(context);
    }
}
