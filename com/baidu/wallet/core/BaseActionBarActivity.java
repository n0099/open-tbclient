package com.baidu.wallet.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes10.dex */
public abstract class BaseActionBarActivity extends BeanActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdActionBar mBdActionBar;
    public FrameLayout mContentLayout;
    public View mContentView;
    public IErrorViewDelegate mErrorViewDelegate;

    /* loaded from: classes10.dex */
    public class ErrorViewDelegate implements IErrorViewDelegate {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WalletBaseEmptyView f58858a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseActionBarActivity f58859b;

        public ErrorViewDelegate(BaseActionBarActivity baseActionBarActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseActionBarActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58859b = baseActionBarActivity;
            WalletBaseEmptyView walletBaseEmptyView = new WalletBaseEmptyView(baseActionBarActivity.getActivity());
            this.f58858a = walletBaseEmptyView;
            walletBaseEmptyView.setVisibility(8);
            baseActionBarActivity.mContentLayout.addView(this.f58858a);
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showContentView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58859b.mContentView.setVisibility(0);
                this.f58858a.setVisibility(8);
            }
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emptyBtnClickListener) == null) {
                this.f58858a.setVisibility(0);
                this.f58859b.mContentView.setVisibility(8);
                this.f58858a.showTip1_Tip2_NextBtn(ResUtils.drawable(this.f58859b.mAct, "wallet_base_no_net"), ResUtils.getString(this.f58859b.mAct, "wallet_base_no_network"), ResUtils.getString(this.f58859b.mAct, "wallet_base_no_network_reason"), ResUtils.getString(this.f58859b.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
            }
        }

        @Override // com.baidu.wallet.core.BaseActionBarActivity.IErrorViewDelegate
        public void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, emptyBtnClickListener) == null) {
                this.f58858a.setVisibility(0);
                this.f58859b.mContentView.setVisibility(8);
                this.f58858a.showTip1_NextBtn(ResUtils.drawable(this.f58859b.mAct, "wallet_base_no_net"), ResUtils.getString(this.f58859b.mAct, "wallet_base_no_network"), ResUtils.getString(this.f58859b.getActivity(), "bd_wallet_reload"), emptyBtnClickListener);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface IErrorViewDelegate {
        void showContentView();

        void showLocalNetError(WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);

        void showServerNetError(String str, WalletBaseEmptyView.EmptyBtnClickListener emptyBtnClickListener);
    }

    public BaseActionBarActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private IErrorViewDelegate createErrorViewDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new ErrorViewDelegate(this) : (IErrorViewDelegate) invokeV.objValue;
    }

    public void closeLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
        }
    }

    public <T> T findViewByIdExt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? (T) findViewById(i2) : (T) invokeI.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public BdActionBar getBdActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBdActionBar : (BdActionBar) invokeV.objValue;
    }

    public FrameLayout getContentLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContentLayout : (FrameLayout) invokeV.objValue;
    }

    public IErrorViewDelegate getErrorViewDelegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mErrorViewDelegate : (IErrorViewDelegate) invokeV.objValue;
    }

    public abstract void init(View view);

    public void initBdActionBar() {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdActionBar = this.mBdActionBar) == null) {
            return;
        }
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.core.BaseActionBarActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BaseActionBarActivity f58851a;

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
                this.f58851a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f58851a.getActivity());
                    this.f58851a.onBackPressed();
                }
            }
        });
    }

    public boolean isStrEmpty(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) ? TextUtils.isEmpty(charSequence) : invokeL.booleanValue;
    }

    public abstract int onBindLayoutId();

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, com.baidu.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(DxmApplicationContextImpl.getApplicationContext(this), "wallet_base_title_activity"));
            this.mBdActionBar = (BdActionBar) findViewByIdExt(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "bdactionbar"));
            this.mContentLayout = (FrameLayout) findViewByIdExt(ResUtils.id(DxmApplicationContextImpl.getApplicationContext(this), "content_frame_layout"));
            View inflate = LayoutInflater.from(this).inflate(onBindLayoutId(), (ViewGroup) null);
            this.mContentView = inflate;
            this.mContentLayout.addView(inflate);
            initBdActionBar();
            init(this.mContentLayout);
            this.mErrorViewDelegate = createErrorViewDelegate();
        }
    }

    public void showLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
        }
    }

    public void showThemeDialog(CharSequence charSequence, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, charSequence, onClickListener, onClickListener2) == null) {
            PromptDialog promptDialog = new PromptDialog(this.mAct);
            promptDialog.setMessage(charSequence);
            promptDialog.setNegativeBtn(ResUtils.string(this.mAct, "ebpay_know"), new View.OnClickListener(this, onClickListener, promptDialog) { // from class: com.baidu.wallet.core.BaseActionBarActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f58852a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f58853b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaseActionBarActivity f58854c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onClickListener, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58854c = this;
                    this.f58852a = onClickListener;
                    this.f58853b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f58852a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f58853b.dismiss();
                    }
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "wallet_varify_quick"), new View.OnClickListener(this, onClickListener2, promptDialog) { // from class: com.baidu.wallet.core.BaseActionBarActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f58855a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f58856b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BaseActionBarActivity f58857c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onClickListener2, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58857c = this;
                    this.f58855a = onClickListener2;
                    this.f58856b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f58855a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f58856b.dismiss();
                    }
                }
            });
            promptDialog.show();
        }
    }
}
