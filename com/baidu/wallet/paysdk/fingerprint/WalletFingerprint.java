package com.baidu.wallet.paysdk.fingerprint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.nopassauth.OtpTokenUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.SecurityUtils;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import java.security.KeyStoreException;
/* loaded from: classes5.dex */
public class WalletFingerprint implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static int SUPPORT_API_LEVEL = 23;

    /* renamed from: a  reason: collision with root package name */
    public static WalletFingerprint f26096a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public IFingerprintPay f26097b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.a.a f26098c;

    /* renamed from: d  reason: collision with root package name */
    public Context f26099d;

    /* renamed from: e  reason: collision with root package name */
    public PhoneSupportStatus f26100e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class FpType {
        public static final /* synthetic */ FpType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FpType FIDO_FINGERPRINT;
        public static final FpType SYSTEM_FINGERPRINT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601748418, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint$FpType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1601748418, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint$FpType;");
                    return;
                }
            }
            SYSTEM_FINGERPRINT = new FpType("SYSTEM_FINGERPRINT", 0);
            FpType fpType = new FpType("FIDO_FINGERPRINT", 1);
            FIDO_FINGERPRINT = fpType;
            $VALUES = new FpType[]{SYSTEM_FINGERPRINT, fpType};
        }

        public FpType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FpType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FpType) Enum.valueOf(FpType.class, str) : (FpType) invokeL.objValue;
        }

        public static FpType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FpType[]) $VALUES.clone() : (FpType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class PhoneSupportStatus {
        public static final /* synthetic */ PhoneSupportStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PhoneSupportStatus SUPPORT_SYS;
        public static final PhoneSupportStatus UNSUPPORT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303912687, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint$PhoneSupportStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(303912687, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint$PhoneSupportStatus;");
                    return;
                }
            }
            UNSUPPORT = new PhoneSupportStatus("UNSUPPORT", 0);
            PhoneSupportStatus phoneSupportStatus = new PhoneSupportStatus("SUPPORT_SYS", 1);
            SUPPORT_SYS = phoneSupportStatus;
            $VALUES = new PhoneSupportStatus[]{UNSUPPORT, phoneSupportStatus};
        }

        public PhoneSupportStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PhoneSupportStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PhoneSupportStatus) Enum.valueOf(PhoneSupportStatus.class, str) : (PhoneSupportStatus) invokeL.objValue;
        }

        public static PhoneSupportStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PhoneSupportStatus[]) $VALUES.clone() : (PhoneSupportStatus[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(656564528, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(656564528, "Lcom/baidu/wallet/paysdk/fingerprint/WalletFingerprint;");
        }
    }

    public WalletFingerprint(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f26100e = PhoneSupportStatus.UNSUPPORT;
        this.f26099d = context.getApplicationContext();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (SecurityUtils.isRoot()) {
                this.f26100e = PhoneSupportStatus.UNSUPPORT;
            } else if (b()) {
                LogUtil.d("WalletFingerprint", "Only support system!");
                this.f26100e = PhoneSupportStatus.SUPPORT_SYS;
            } else {
                LogUtil.d("WalletFingerprint", "None support!");
                this.f26100e = PhoneSupportStatus.UNSUPPORT;
            }
        }
    }

    @TargetApi(23)
    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f26099d, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= SUPPORT_API_LEVEL) {
                FingerprintManager fingerprintManager = (FingerprintManager) this.f26099d.getSystemService(FingerprintManager.class);
                try {
                    a a2 = a.a(this.f26099d);
                    return a2 != null && a2.a() && fingerprintManager != null && fingerprintManager.isHardwareDetected();
                } catch (KeyStoreException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static WalletFingerprint getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (f26096a == null) {
                synchronized (WalletFingerprint.class) {
                    if (f26096a == null) {
                        f26096a = new WalletFingerprint(context);
                    }
                }
            }
            return f26096a;
        }
        return (WalletFingerprint) invokeL.objValue;
    }

    public static String getKeyStoreAlise(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String ppKey = PayPreferenceManager.getPpKey(context.getApplicationContext());
            return a.f26101b + "_" + ppKey + "_" + BeanConstants.CHANNEL_ID;
        }
        return (String) invokeL.objValue;
    }

    public static String getKeyStoreNewAlise(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String newPpKey = PayPreferenceManager.getNewPpKey(context.getApplicationContext());
            return a.f26101b + "_" + newPpKey + "_" + BeanConstants.CHANNEL_ID;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(23)
    public void cancleListening() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogUtil.d("WalletFingerprint", "WalletFingerprint.cancleListening");
            com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f26098c;
            if (aVar != null) {
                aVar.a();
                this.f26098c.d();
                this.f26098c = null;
            }
        }
    }

    public void clearOTPToken() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogUtil.d("WalletFingerprint", "clearOTPToken");
            SharedPreferencesUtils.setParam(this.f26099d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getPpKey(this.f26099d), "");
            SharedPreferencesUtils.setParam(this.f26099d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f26099d), "");
        }
    }

    public void close(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f26097b = fingerprintPay;
            if (fingerprintPay == null) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.CLOSE, 2, "");
            } else {
                fingerprintPay.close(activity, fingerprintCallback);
            }
        }
    }

    public String generateOTPKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String safeSavedDataByUnionId = OtpTokenUtils.getSafeSavedDataByUnionId(str, this.f26099d);
            LogUtil.d("WalletFingerprint", "generateDynamickey tokeninfo=" + safeSavedDataByUnionId);
            String[] split = safeSavedDataByUnionId.split("\\|");
            if (split.length == 9) {
                int i2 = 6;
                int i3 = 1;
                try {
                    i2 = Integer.valueOf(split[5].substring(split[5].length() - 1, split[5].length())).intValue();
                    i3 = Integer.valueOf(split[7]).intValue();
                } catch (Exception unused) {
                }
                LogUtil.d("WalletFingerprint", "generateDynamicKey() key.length=" + i2 + "&& timeStep=" + i3);
                return OtpTokenUtils.getEncryptTOtpCode(this.f26099d, i3, safeSavedDataByUnionId.split("\\|")[3], i2);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public IFingerprintPay getFingerprintPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a();
            if (this.f26100e == PhoneSupportStatus.SUPPORT_SYS) {
                return new SysFingerprintPay();
            }
            return null;
        }
        return (IFingerprintPay) invokeV.objValue;
    }

    public String getSN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String[] split = new String(Base64.decode((String) SharedPreferencesUtils.getParam(this.f26099d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f26099d), ""), 0)).split("\\|");
            if (split.length == 3) {
                return SafePay.getInstance().localDecrypt1(split[2]);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasEnrollFingerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f26099d, "android.permission.USE_FINGERPRINT") && isDevicesSupport()) {
                return a(this.f26099d);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasOTPToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? !TextUtils.isEmpty((String) SharedPreferencesUtils.getParam(this.f26099d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f26099d), "")) : invokeV.booleanValue;
    }

    public boolean isDevicesSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f26099d, "android.permission.USE_FINGERPRINT")) {
                a();
                return this.f26100e != PhoneSupportStatus.UNSUPPORT;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void open(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f26097b = fingerprintPay;
            if (fingerprintPay == null) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, "");
            } else {
                fingerprintPay.open(activity, fingerprintCallback);
            }
        }
    }

    @TargetApi(23)
    public void startListening(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f26097b = getFingerprintPay(FpType.SYSTEM_FINGERPRINT);
            try {
                this.f26098c = new com.baidu.wallet.paysdk.fingerprint.a.a(this.f26099d);
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
            }
            com.baidu.wallet.paysdk.fingerprint.a.a aVar = this.f26098c;
            if (aVar != null && this.f26097b != null) {
                aVar.a(bVar);
                this.f26098c.a(2);
                return;
            }
            bVar.a(-1, "");
        }
    }

    public void verify(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f26097b = fingerprintPay;
            if (fingerprintPay == null) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, "");
            } else {
                fingerprintPay.verify(activity, fingerprintCallback);
            }
        }
    }

    public IFingerprintPay getFingerprintPay(FpType fpType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fpType)) == null) {
            a();
            PhoneSupportStatus phoneSupportStatus = this.f26100e;
            if (phoneSupportStatus != PhoneSupportStatus.UNSUPPORT && fpType == FpType.SYSTEM_FINGERPRINT && phoneSupportStatus == PhoneSupportStatus.SUPPORT_SYS) {
                return new SysFingerprintPay();
            }
            return null;
        }
        return (IFingerprintPay) invokeL.objValue;
    }

    @TargetApi(23)
    private boolean a(Context context) {
        InterceptResult invokeL;
        FingerprintManager fingerprintManager;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) ? PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= 23 && (fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class)) != null && fingerprintManager.hasEnrolledFingerprints() : invokeL.booleanValue;
    }
}
