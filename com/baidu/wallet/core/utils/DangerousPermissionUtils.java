package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
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
import com.kuaishou.weapon.un.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public class DangerousPermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";
    public static final String a = "dangerous_permission_utils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DangerousPermission> f52411b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f52412c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f52413d;

    /* renamed from: e  reason: collision with root package name */
    public int f52414e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52415f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f52416g;

    /* renamed from: h  reason: collision with root package name */
    public DangerousPermissionDialog f52417h;

    /* loaded from: classes11.dex */
    public static class DangerousPermission {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String a = "dp_";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Context f52422b;

        /* renamed from: c  reason: collision with root package name */
        public String f52423c;

        /* renamed from: d  reason: collision with root package name */
        public String f52424d;

        /* renamed from: e  reason: collision with root package name */
        public String f52425e;

        /* renamed from: f  reason: collision with root package name */
        public String f52426f;

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
            this.f52422b = DxmApplicationContextImpl.getApplicationContext(context);
            this.f52423c = str;
            this.f52424d = str2;
            this.f52425e = str3;
            this.f52426f = str4;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Context context = this.f52422b;
                return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.a, a + this.f52423c, Boolean.FALSE)).booleanValue();
            }
            return invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Context context = this.f52422b;
                SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.a, a + this.f52423c, Boolean.TRUE);
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TextUtils.isEmpty(this.f52426f) ? ResUtils.getString(this.f52422b, this.f52425e) : this.f52426f;
            }
            return (String) invokeV.objValue;
        }

        public String d() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    str = new JSONObject(this.f52424d).optString("positive");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f52422b, "wallet_base_permission_positive") : str;
            }
            return (String) invokeV.objValue;
        }

        public String e() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    str = new JSONObject(this.f52424d).optString("negative");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f52422b, "wallet_base_permission_negative") : str;
            }
            return (String) invokeV.objValue;
        }

        public String getPermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52423c : (String) invokeV.objValue;
        }

        public String getTitle() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    str = new JSONObject(this.f52424d).optString("title");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f52422b, "wallet_base_permission_title") : str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static DangerousPermissionUtils a;
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
            a = new DangerousPermissionUtils();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.a : (DangerousPermissionUtils) invokeV.objValue;
    }

    public String getPermissionDialogDescription(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            a(context);
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String lowerCase = str.toLowerCase();
            char c2 = 65535;
            try {
                switch (lowerCase.hashCode()) {
                    case -1884274053:
                        if (lowerCase.equals("storage")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1367751899:
                        if (lowerCase.equals("camera")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -567451565:
                        if (lowerCase.equals("contacts")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 93166550:
                        if (lowerCase.equals(MediaStreamTrack.AUDIO_TRACK_KIND)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1901043637:
                        if (lowerCase.equals("location")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                return c2 != 4 ? "" : this.f52411b.get(PermissionRequest.RESOURCE_AUDIO_CAPTURE).c();
                            }
                            return this.f52411b.get(s.f56844i).c();
                        }
                        return this.f52411b.get(PermissionRequest.RESOURCE_VIDEO_CAPTURE).c();
                    }
                    return this.f52411b.get(s.f56842g).c();
                }
                return this.f52411b.get("android.permission.READ_CONTACTS").c();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, activity, strArr, iRequestPermissionCallBack) == null) {
            a(activity);
            if (!a(str) || activity == null) {
                if (iRequestPermissionCallBack != null) {
                    iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
                    return;
                }
                return;
            }
            this.f52412c = new WeakReference<>(activity);
            this.f52413d = strArr;
            this.f52414e = -1;
            this.f52415f = true;
            this.f52416g = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f52417h;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f52417h = null;
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && this.f52411b == null && context != null) {
            HashMap hashMap = new HashMap();
            this.f52411b = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.f52411b.put(s.f56842g, new DangerousPermission(context, s.f56842g, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.f52411b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.f52411b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.f52411b.put("android.permission.WRITE_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.f52411b.put(s.f56844i, new DangerousPermission(context, s.f56844i, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) {
            if ("wallet_langbridge".equals(str)) {
                return "1".equals(SdkInitResponse.getInstance().langbridge_permission_dialog);
            }
            if ("1".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return true;
            }
            if ("0".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
                return false;
            }
            return "walletapp".equals(BeanConstants.CHANNEL_ID) || com.dxmpay.wallet.core.beans.BeanConstants.CHANNEL_ID_WALLET_APP_PRO.equals(BeanConstants.CHANNEL_ID) || "bdyouqianhuapro".equals(BeanConstants.CHANNEL_ID) || "bdlicai".equals(BeanConstants.CHANNEL_ID);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i2 = this.f52414e + 1;
            this.f52414e = i2;
            String[] strArr = this.f52413d;
            if (i2 >= strArr.length) {
                a(true);
                return;
            }
            DangerousPermission dangerousPermission = this.f52411b.get(strArr[i2]);
            if (dangerousPermission == null) {
                a();
                return;
            }
            Activity activity = this.f52412c.get();
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
                public final /* synthetic */ DangerousPermission a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionDialog f52418b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f52419c;

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
                    this.f52419c = this;
                    this.a = dangerousPermission;
                    this.f52418b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f52419c.f52415f = false;
                        if (this.f52419c.f52416g != null) {
                            this.f52419c.f52416g.requestResult(this.a.getPermission(), Boolean.FALSE);
                        }
                        this.f52418b.dismiss();
                        this.f52419c.a();
                    }
                }
            });
            dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), new View.OnClickListener(this, dangerousPermission, dangerousPermissionDialog) { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DangerousPermission a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionDialog f52420b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f52421c;

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
                    this.f52421c = this;
                    this.a = dangerousPermission;
                    this.f52420b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f52421c.f52416g != null) {
                            this.f52421c.f52416g.requestResult(this.a.getPermission(), Boolean.TRUE);
                        }
                        this.f52420b.dismiss();
                        this.f52421c.a();
                    }
                }
            });
            this.f52417h = dangerousPermissionDialog;
            dangerousPermissionDialog.show();
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f52416g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f52416g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f52415f));
            }
            this.f52417h = null;
            this.f52416g = null;
        }
    }
}
