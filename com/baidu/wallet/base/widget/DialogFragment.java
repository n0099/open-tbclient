package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.widget.dialog.listener.DelegateOnCancleListener;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
/* loaded from: classes11.dex */
public class DialogFragment extends BaseFragment implements IBeanResponseCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIALOG_NO_NETWORK = 3851;
    public static final int DIALOG_PROMPT = 3843;
    public static final int DIALOG_WAIT_S0 = 0;
    public static final int DIALOG_WAIT_S1 = -1;
    public static final int DIALOG_WAIT_S2 = -2;
    public static final String TAG = "DialogFragment";
    public transient /* synthetic */ FieldHolder $fh;
    public String mDialogMsg;

    public DialogFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDialogMsg = "";
    }

    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
            if (i3 == 5003) {
                BaseActivity baseActivity = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity, ResUtils.getString(baseActivity, "wallet_base_please_login"));
                AccountManager.getInstance(((BaseFragment) this).mAct).logout();
                WalletLoginHelper.getInstance().logout(false);
            } else if (i3 == -2) {
                BaseActivity baseActivity2 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity2, ResUtils.getString(baseActivity2, "fp_get_data_fail"));
            } else if (i3 == -3) {
                BaseActivity baseActivity3 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity3, ResUtils.getString(baseActivity3, "fp_get_data_fail"));
            } else if (i3 == -4) {
                BaseActivity baseActivity4 = ((BaseFragment) this).mAct;
                GlobalUtils.toast(baseActivity4, ResUtils.getString(baseActivity4, "fp_get_data_fail"));
            } else if (i3 == -8) {
                WalletGlobalUtils.safeShowDialog(((BaseFragment) this).mAct, 3851, "");
            } else {
                this.mDialogMsg = str;
                if (TextUtils.isEmpty(str)) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "fp_get_data_fail");
                }
                GlobalUtils.toast(getActivity(), this.mDialogMsg);
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, obj, str) == null) {
        }
    }

    public void initActionBar(View view, String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, view, str) == null) || (bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(((BaseFragment) this).mAct, "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(((BaseFragment) this).mAct, str));
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogFragment a;

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
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    GlobalUtils.hideKeyboard(((BaseFragment) this.a).mAct.getActivity());
                    this.a.finish();
                }
            }
        });
    }

    public void initHomeActionBar(View view, String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, view, str) == null) || (bdActionBar = (BdActionBar) view.findViewById(ResUtils.id(((BaseFragment) this).mAct, "bdactionbar"))) == null) {
            return;
        }
        bdActionBar.setTitle(ResUtils.string(((BaseFragment) this).mAct, str));
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogFragment a;

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
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    GlobalUtils.hideKeyboard(((BaseFragment) this.a).mAct.getActivity());
                    this.a.finish();
                }
            }
        });
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, str) == null) {
            LogUtil.i("BeanActivity", "onBeanExecFailure. bean id = " + i2 + ", err code = " + i3 + ", err msg = " + str);
            BaseActivity baseActivity = ((BaseFragment) this).mAct;
            if (baseActivity == null) {
                return;
            }
            baseActivity.runOnUiThread(new Runnable(this, i2, i3, str) { // from class: com.baidu.wallet.base.widget.DialogFragment.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f52051b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f52052c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ DialogFragment f52053d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52053d = this;
                    this.a = i2;
                    this.f52051b = i3;
                    this.f52052c = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((BaseFragment) this.f52053d).mAct == null) {
                        return;
                    }
                    this.f52053d.handleFailure(this.a, this.f52051b, this.f52052c);
                }
            });
        }
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            handleFailure(i2, i3, str);
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        BaseActivity baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, obj, str) == null) || (baseActivity = ((BaseFragment) this).mAct) == null) {
            return;
        }
        baseActivity.runOnUiThread(new Runnable(this, i2, obj, str) { // from class: com.baidu.wallet.base.widget.DialogFragment.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f52048b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f52049c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ DialogFragment f52050d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), obj, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52050d = this;
                this.a = i2;
                this.f52048b = obj;
                this.f52049c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((BaseFragment) this.f52050d).mAct == null) {
                    return;
                }
                this.f52050d.handleResponse(this.a, this.f52048b, this.f52049c);
            }
        });
    }

    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            LogUtil.d("DialogFragment", "onCreateDalog. id = " + i2);
            if (i2 != -2 && i2 != -1 && i2 != 0) {
                return new PromptDialog(((BaseFragment) this).mAct);
            }
            return new LoadingDialog(((BaseFragment) this).mAct);
        }
        return (Dialog) invokeI.objValue;
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, event) == null) && event != null && event.mEventKey.equals("ev_bean_execut_err_content")) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, dialog) == null) {
            LogUtil.d("DialogFragment", "onPrepareDialog. id = " + i2);
            if (i2 == -2) {
                LoadingDialog loadingDialog = (LoadingDialog) dialog;
                loadingDialog.setCancelable(true);
                loadingDialog.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DialogFragment a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            this.a.cancleRequest();
                        }
                    }
                }, loadingDialog));
            } else if (i2 == -1) {
                LoadingDialog loadingDialog2 = (LoadingDialog) dialog;
                loadingDialog2.setCancelable(true);
                loadingDialog2.setOnCancelListener(new DelegateOnCancleListener(new DialogInterface.OnCancelListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DialogFragment a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || ((BaseFragment) this.a).mAct == null) {
                            return;
                        }
                        ((BaseFragment) this.a).mAct.onBackPressed();
                    }
                }, loadingDialog2));
            } else if (i2 == 0) {
                ((LoadingDialog) dialog).setCancelable(false);
            } else if (i2 != 3851) {
            } else {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(getString(ResUtils.string(((BaseFragment) this).mAct, "ebpay_no_network")));
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setNegativeBtn(ResUtils.string(((BaseFragment) this).mAct, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DialogFragment a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(((BaseFragment) this.a).mAct, 3851);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(((BaseFragment) this).mAct, "ebpay_setting"), new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.DialogFragment.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DialogFragment a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(((BaseFragment) this.a).mAct, 3851);
                            try {
                                this.a.startActivityForResult(new Intent("android.settings.SETTINGS"), 0);
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    public void postEvent(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, obj) == null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(eventBus, str, obj));
        }
    }
}
