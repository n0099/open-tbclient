package com.baidu.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.paysdk.SDKInitBeanCallBack;
import com.baidu.wallet.paysdk.beans.NewSdkInitBean;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class BdWalletUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f63319a = "__Baidu_Wallet_SDK_FP";

    /* renamed from: b  reason: collision with root package name */
    public static final String f63320b = "device_fp";

    /* renamed from: c  reason: collision with root package name */
    public static final String f63321c = "__Baidu_Wallet_SDK_KEFU";

    /* renamed from: d  reason: collision with root package name */
    public static final String f63322d = "kefu_phone_num";
    public transient /* synthetic */ FieldHolder $fh;

    public BdWalletUtils() {
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

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static void addFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            activity.getWindow().addFlags(8192);
        }
    }

    public static String[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                int length = signatureArr.length;
                String[] strArr = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    strArr[i2] = Md5Utils.md5Hex(signatureArr[i2].toByteArray());
                }
                return strArr;
            } catch (PackageManager.NameNotFoundException unused) {
                return new String[0];
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static void clearFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, activity) == null) {
            activity.getWindow().clearFlags(8192);
        }
    }

    public static void dealCashDesk(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, session) == null) || session == null) {
            return;
        }
        NetworkBean.SessionCache.getInstance().put(null, session);
    }

    public static String getDeviceFP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, f63319a, f63320b, "");
            return !TextUtils.isEmpty(str) ? SafePay.getInstance().localDecrypt1(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getFPFileLastModified(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            File file = new File(context.getFilesDir().getParent() + "/shared_prefs/" + f63319a + ActivityChooserModel.HISTORY_FILE_EXTENSION);
            if (file.exists()) {
                return "" + (file.lastModified() / 1000);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void getInitForPoll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            SdkInitBean sdkInitBean = new SdkInitBean(DxmApplicationContextImpl.getApplicationContext(context));
            sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            sdkInitBean.execBean();
        }
    }

    public static String getKefuPhoneNum(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context == null) {
                return "";
            }
            String str = (String) SharedPreferencesUtils.getParam(context, f63321c, f63322d, "");
            return TextUtils.isEmpty(str) ? ResUtils.getString(context, "wallet_base_help_phone_no_dial") : str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0069 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v11, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isCertifiedApp(@NonNull Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            String str = a(context) ? ".dxm.debug.license" : ".dxm.license";
            int i2 = 0;
            try {
                String packageName = context.getPackageName();
                LogUtil.d("financial", "签名文件名：" + packageName + str);
                AssetManager assets = context.getAssets();
                byte[] a2 = a(assets.open(packageName + str), true);
                String[] b2 = b(context);
                z = 0;
                while (i2 < b2.length && (z = VerSig.verify(a2, b2[i2].concat(packageName).getBytes(), "SHA-1")) == 0) {
                    try {
                        i2++;
                        z = z;
                    } catch (IOException unused) {
                        i2 = z ? 1 : 0;
                        z = i2;
                        LogUtil.d("financial", "验签结果：" + z);
                        return z;
                    }
                }
            } catch (IOException unused2) {
            }
            LogUtil.d("financial", "验签结果：" + z);
            return z;
        }
        return invokeL.booleanValue;
    }

    public static void loadDeviceFP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            SdkInitBean sdkInitBean = new SdkInitBean(DxmApplicationContextImpl.getApplicationContext(context));
            sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            sdkInitBean.execBean();
            NewSdkInitBean newSdkInitBean = new NewSdkInitBean(DxmApplicationContextImpl.getApplicationContext(context));
            newSdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
            newSdkInitBean.execBean();
        }
    }

    public static void setDeviceFP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) || str == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f63319a, f63320b, SafePay.getInstance().localEncrypt1(str));
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) || str == null || context == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f63321c, f63322d, str);
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, str3, onClickListener, onClickListener2}) == null) {
            PromptDialog promptDialog = new PromptDialog(context);
            promptDialog.setMessage(str);
            promptDialog.setNegativeBtn(str2, new View.OnClickListener(onClickListener, promptDialog) { // from class: com.baidu.wallet.utils.BdWalletUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f63323a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f63324b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onClickListener, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63323a = onClickListener;
                    this.f63324b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f63323a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f63324b.dismiss();
                    }
                }
            });
            promptDialog.setPositiveBtn(str3, new View.OnClickListener(onClickListener2, promptDialog) { // from class: com.baidu.wallet.utils.BdWalletUtils.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View.OnClickListener f63325a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f63326b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {onClickListener2, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f63325a = onClickListener2;
                    this.f63326b = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        View.OnClickListener onClickListener3 = this.f63325a;
                        if (onClickListener3 != null) {
                            onClickListener3.onClick(view);
                        }
                        this.f63326b.dismiss();
                    }
                }
            });
            promptDialog.show();
        }
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, inputStream, z)) == null) {
            if (inputStream != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        if (z) {
                            inputStream.close();
                        }
                        byteArrayOutputStream.close();
                    }
                }
                return byteArrayOutputStream.toByteArray();
            }
            throw new IOException("The input stream is null!");
        }
        return (byte[]) invokeLZ.objValue;
    }
}
