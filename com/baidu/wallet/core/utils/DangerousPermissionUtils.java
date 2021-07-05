package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DangerousPermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";

    /* renamed from: a  reason: collision with root package name */
    public static final String f24611a = "dangerous_permission_utils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DangerousPermission> f24612b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f24613c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f24614d;

    /* renamed from: e  reason: collision with root package name */
    public int f24615e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24616f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f24617g;

    /* renamed from: h  reason: collision with root package name */
    public DangerousPermissionDialog f24618h;

    /* loaded from: classes6.dex */
    public static class DangerousPermission {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final String f24625a = "dp_";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Context f24626b;

        /* renamed from: c  reason: collision with root package name */
        public String f24627c;

        /* renamed from: d  reason: collision with root package name */
        public String f24628d;

        /* renamed from: e  reason: collision with root package name */
        public String f24629e;

        /* renamed from: f  reason: collision with root package name */
        public String f24630f;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24626b = context.getApplicationContext();
            this.f24627c = str;
            this.f24628d = str2;
            this.f24629e = str3;
            this.f24630f = str4;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Context context = this.f24626b;
                return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.f24611a, f24625a + this.f24627c, Boolean.FALSE)).booleanValue();
            }
            return invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Context context = this.f24626b;
                SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.f24611a, f24625a + this.f24627c, Boolean.TRUE);
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TextUtils.isEmpty(this.f24630f) ? ResUtils.getString(this.f24626b, this.f24629e) : this.f24630f;
            }
            return (String) invokeV.objValue;
        }

        public String d() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    str = new JSONObject(this.f24628d).optString("positive");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24626b, "wallet_base_permission_positive") : str;
            }
            return (String) invokeV.objValue;
        }

        public String e() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    str = new JSONObject(this.f24628d).optString("negative");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24626b, "wallet_base_permission_negative") : str;
            }
            return (String) invokeV.objValue;
        }

        public String getPermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f24627c : (String) invokeV.objValue;
        }

        public String getTitle() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    str = new JSONObject(this.f24628d).optString("title");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f24626b, "wallet_base_permission_title") : str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class DangerousPermissionDialog extends PromptDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DangerousPermissionDialog(Context context) {
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

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    super.dismiss();
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.app.Dialog
        public void show() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    super.show();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static DangerousPermissionUtils f24631a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-563473600, "Lcom/baidu/wallet/core/utils/DangerousPermissionUtils$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-563473600, "Lcom/baidu/wallet/core/utils/DangerousPermissionUtils$a;");
                    return;
                }
            }
            f24631a = new DangerousPermissionUtils();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public static DangerousPermissionUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.f24631a : (DangerousPermissionUtils) invokeV.objValue;
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, activity, strArr, iRequestPermissionCallBack) == null) {
            a(activity);
            if (!a(str) || activity == null) {
                if (iRequestPermissionCallBack != null) {
                    iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
                    return;
                }
                return;
            }
            this.f24613c = new WeakReference<>(activity);
            this.f24614d = strArr;
            this.f24615e = -1;
            this.f24616f = true;
            this.f24617g = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f24618h;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f24618h = null;
            }
            a();
        }
    }

    public DangerousPermissionUtils() {
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

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, context) == null) && this.f24612b == null && context != null) {
            HashMap hashMap = new HashMap();
            this.f24612b = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.f24612b.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.f24612b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.f24612b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.f24612b.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new DangerousPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.f24612b.put("android.permission.READ_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.READ_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            if (DPU_SOURCE_LANGBRIDGE.equals(str)) {
                return "1".equals(SdkInitResponse.getInstance().langbridge_permission_dialog);
            }
            if ("1".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return true;
            }
            if ("0".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return false;
            }
            return BeanConstants.CHANNEL_ID_WALLET_APP.equals(BeanConstants.CHANNEL_ID) || "walletapppro".equals(BeanConstants.CHANNEL_ID) || "bdyouqianhuapro".equals(BeanConstants.CHANNEL_ID) || "bdlicai".equals(BeanConstants.CHANNEL_ID);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i2 = this.f24615e + 1;
            this.f24615e = i2;
            String[] strArr = this.f24614d;
            if (i2 >= strArr.length) {
                a(true);
                return;
            }
            DangerousPermission dangerousPermission = this.f24612b.get(strArr[i2]);
            if (dangerousPermission == null) {
                a();
                return;
            }
            Activity activity = this.f24613c.get();
            if (activity == null) {
                a(false);
                return;
            }
            DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
            dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
            dangerousPermissionDialog.setMessage(dangerousPermission.c());
            dangerousPermissionDialog.setNegativeBtn(dangerousPermission.e(), new View.OnClickListener(this, dangerousPermission, dangerousPermissionDialog) { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DangerousPermission f24619a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionDialog f24620b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f24621c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dangerousPermission, dangerousPermissionDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24621c = this;
                    this.f24619a = dangerousPermission;
                    this.f24620b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f24621c.f24616f = false;
                        if (this.f24621c.f24617g != null) {
                            this.f24621c.f24617g.requestResult(this.f24619a.getPermission(), Boolean.FALSE);
                        }
                        this.f24620b.dismiss();
                        this.f24621c.a();
                    }
                }
            });
            dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), new View.OnClickListener(this, dangerousPermission, dangerousPermissionDialog) { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DangerousPermission f24622a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionDialog f24623b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f24624c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dangerousPermission, dangerousPermissionDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24624c = this;
                    this.f24622a = dangerousPermission;
                    this.f24623b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f24624c.f24617g != null) {
                            this.f24624c.f24617g.requestResult(this.f24622a.getPermission(), Boolean.TRUE);
                        }
                        this.f24623b.dismiss();
                        this.f24624c.a();
                    }
                }
            });
            this.f24618h = dangerousPermissionDialog;
            dangerousPermissionDialog.show();
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f24617g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f24617g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f24616f));
            }
            this.f24618h = null;
            this.f24617g = null;
        }
    }
}
