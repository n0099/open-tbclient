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
/* loaded from: classes13.dex */
public class DangerousPermissionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";
    public static final String a = "dangerous_permission_utils";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, DangerousPermission> f50996b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f50997c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f50998d;

    /* renamed from: e  reason: collision with root package name */
    public int f50999e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51000f;

    /* renamed from: g  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f51001g;

    /* renamed from: h  reason: collision with root package name */
    public DangerousPermissionDialog f51002h;

    /* loaded from: classes13.dex */
    public static class DangerousPermission {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String a = "dp_";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public Context f51007b;

        /* renamed from: c  reason: collision with root package name */
        public String f51008c;

        /* renamed from: d  reason: collision with root package name */
        public String f51009d;

        /* renamed from: e  reason: collision with root package name */
        public String f51010e;

        /* renamed from: f  reason: collision with root package name */
        public String f51011f;

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
            this.f51007b = DxmApplicationContextImpl.getApplicationContext(context);
            this.f51008c = str;
            this.f51009d = str2;
            this.f51010e = str3;
            this.f51011f = str4;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Context context = this.f51007b;
                return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.a, a + this.f51008c, Boolean.FALSE)).booleanValue();
            }
            return invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Context context = this.f51007b;
                SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.a, a + this.f51008c, Boolean.TRUE);
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return TextUtils.isEmpty(this.f51011f) ? ResUtils.getString(this.f51007b, this.f51010e) : this.f51011f;
            }
            return (String) invokeV.objValue;
        }

        public String d() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    str = new JSONObject(this.f51009d).optString("positive");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f51007b, "wallet_base_permission_positive") : str;
            }
            return (String) invokeV.objValue;
        }

        public String e() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                try {
                    str = new JSONObject(this.f51009d).optString("negative");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f51007b, "wallet_base_permission_negative") : str;
            }
            return (String) invokeV.objValue;
        }

        public String getPermission() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51008c : (String) invokeV.objValue;
        }

        public String getTitle() {
            String str;
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                try {
                    str = new JSONObject(this.f51009d).optString("title");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = "";
                }
                return TextUtils.isEmpty(str) ? ResUtils.getString(this.f51007b, "wallet_base_permission_title") : str;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes13.dex */
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

    /* loaded from: classes13.dex */
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
                                return c2 != 4 ? "" : this.f50996b.get(PermissionRequest.RESOURCE_AUDIO_CAPTURE).c();
                            }
                            return this.f50996b.get(s.f55293i).c();
                        }
                        return this.f50996b.get(PermissionRequest.RESOURCE_VIDEO_CAPTURE).c();
                    }
                    return this.f50996b.get(s.f55291g).c();
                }
                return this.f50996b.get("android.permission.READ_CONTACTS").c();
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
            this.f50997c = new WeakReference<>(activity);
            this.f50998d = strArr;
            this.f50999e = -1;
            this.f51000f = true;
            this.f51001g = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f51002h;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f51002h = null;
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
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) && this.f50996b == null && context != null) {
            HashMap hashMap = new HashMap();
            this.f50996b = hashMap;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.f50996b.put(s.f55291g, new DangerousPermission(context, s.f55291g, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.f50996b.put(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.f50996b.put(PermissionRequest.RESOURCE_AUDIO_CAPTURE, new DangerousPermission(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.f50996b.put("android.permission.WRITE_EXTERNAL_STORAGE", new DangerousPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.f50996b.put(s.f55293i, new DangerousPermission(context, s.f55293i, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
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
            int i2 = this.f50999e + 1;
            this.f50999e = i2;
            String[] strArr = this.f50998d;
            if (i2 >= strArr.length) {
                a(true);
                return;
            }
            DangerousPermission dangerousPermission = this.f50996b.get(strArr[i2]);
            if (dangerousPermission == null) {
                a();
                return;
            }
            Activity activity = this.f50997c.get();
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
                public final /* synthetic */ DangerousPermissionDialog f51003b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f51004c;

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
                    this.f51004c = this;
                    this.a = dangerousPermission;
                    this.f51003b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f51004c.f51000f = false;
                        if (this.f51004c.f51001g != null) {
                            this.f51004c.f51001g.requestResult(this.a.getPermission(), Boolean.FALSE);
                        }
                        this.f51003b.dismiss();
                        this.f51004c.a();
                    }
                }
            });
            dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), new View.OnClickListener(this, dangerousPermission, dangerousPermissionDialog) { // from class: com.baidu.wallet.core.utils.DangerousPermissionUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DangerousPermission a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionDialog f51005b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ DangerousPermissionUtils f51006c;

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
                    this.f51006c = this;
                    this.a = dangerousPermission;
                    this.f51005b = dangerousPermissionDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f51006c.f51001g != null) {
                            this.f51006c.f51001g.requestResult(this.a.getPermission(), Boolean.TRUE);
                        }
                        this.f51005b.dismiss();
                        this.f51006c.a();
                    }
                }
            });
            this.f51002h = dangerousPermissionDialog;
            dangerousPermissionDialog.show();
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f51001g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
            }
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, this, z) == null) {
            BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f51001g;
            if (iRequestPermissionCallBack != null) {
                iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f51000f));
            }
            this.f51002h = null;
            this.f51001g = null;
        }
    }
}
