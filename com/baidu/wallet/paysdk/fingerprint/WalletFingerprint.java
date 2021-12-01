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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.nopassauth.OtpTokenUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.SecurityUtils;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.paysdk.storage.PayPreferenceManager;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.security.KeyStoreException;
/* loaded from: classes12.dex */
public class WalletFingerprint implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static int SUPPORT_API_LEVEL = 23;
    public static WalletFingerprint a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public IFingerprintPay f53483b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.wallet.paysdk.fingerprint.b.a f53484c;

    /* renamed from: d  reason: collision with root package name */
    public Context f53485d;

    /* renamed from: e  reason: collision with root package name */
    public PhoneSupportStatus f53486e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
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
        this.f53486e = PhoneSupportStatus.UNSUPPORT;
        this.f53485d = context.getApplicationContext();
    }

    @TargetApi(23)
    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f53485d, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= SUPPORT_API_LEVEL) {
                FingerprintManager fingerprintManager = (FingerprintManager) this.f53485d.getSystemService(FingerprintManager.class);
                try {
                    a a2 = a.a(this.f53485d);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (a == null) {
                synchronized (WalletFingerprint.class) {
                    if (a == null) {
                        a = new WalletFingerprint(context);
                    }
                }
            }
            return a;
        }
        return (WalletFingerprint) invokeL.objValue;
    }

    public static String getKeyStoreAlise(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String ppKey = PayPreferenceManager.getPpKey(context.getApplicationContext());
            return a.f53488b + "_" + ppKey + "_" + BeanConstants.CHANNEL_ID;
        }
        return (String) invokeL.objValue;
    }

    public static String getKeyStoreNewAlise(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            String newPpKey = PayPreferenceManager.getNewPpKey(context.getApplicationContext());
            return a.f53488b + "_" + newPpKey + "_" + BeanConstants.CHANNEL_ID;
        }
        return (String) invokeL.objValue;
    }

    @TargetApi(23)
    public void cancleListening() {
        com.baidu.wallet.paysdk.fingerprint.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.f53484c) == null) {
            return;
        }
        aVar.a();
        this.f53484c.d();
        this.f53484c = null;
    }

    public void clearOTPToken() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPreferencesUtils.setParam(this.f53485d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getPpKey(this.f53485d), "");
            SharedPreferencesUtils.setParam(this.f53485d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f53485d), "");
        }
    }

    public void close(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f53483b = fingerprintPay;
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
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_TOKEN_ENTER);
            if (TextUtils.isEmpty(str)) {
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_TOKENINFO_IS_NULL);
                return null;
            }
            String safeSavedDataByUnionId = OtpTokenUtils.getSafeSavedDataByUnionId(str, this.f53485d);
            String str2 = "generateDynamickey tokeninfo=" + safeSavedDataByUnionId;
            String[] split = safeSavedDataByUnionId.split("\\|");
            if (split.length == 9) {
                int i2 = 6;
                int i3 = 1;
                try {
                    i2 = Integer.valueOf(split[5].substring(split[5].length() - 1, split[5].length())).intValue();
                    i3 = Integer.valueOf(split[7]).intValue();
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_KEYLEN_TIMESTEP);
                } catch (Exception e2) {
                    StatisticManager.onEventEndWithValue(StatServiceEvent.EVENT_FP_GET_DECRYPT_TOKEN_EXCEPTION, e2.toString());
                }
                String str3 = "generateDynamicKey() key.length=" + i2 + "&& timeStep=" + i3;
                return OtpTokenUtils.getEncryptTOtpCode(this.f53485d, i3, safeSavedDataByUnionId.split("\\|")[3], i2);
            }
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_DECRYPT_TOKEN_FAIL);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public IFingerprintPay getFingerprintPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            a();
            if (this.f53486e == PhoneSupportStatus.SUPPORT_SYS) {
                return new SysFingerprintPay();
            }
            return null;
        }
        return (IFingerprintPay) invokeV.objValue;
    }

    public void getOTPToken(FingerprintGetOtpTokenCallback fingerprintGetOtpTokenCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fingerprintGetOtpTokenCallback) == null) || fingerprintGetOtpTokenCallback == null || this.f53485d == null) {
            return;
        }
        WalletLoginHelper.getInstance().setOpenBdussErrorCodeShowFlag(false);
        WalletLoginHelper.getInstance().verifyPassLogin(new LoginBackListenerProxy(this.f53485d, new ILoginBackListener(this, fingerprintGetOtpTokenCallback) { // from class: com.baidu.wallet.paysdk.fingerprint.WalletFingerprint.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FingerprintGetOtpTokenCallback a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ WalletFingerprint f53487b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, fingerprintGetOtpTokenCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f53487b = this;
                this.a = fingerprintGetOtpTokenCallback;
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onFail(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.a.getOtpToken("");
                }
            }

            @Override // com.baidu.wallet.api.ILoginBackListener
            public void onSuccess(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    String newPpKey = PayPreferenceManager.getNewPpKey(this.f53487b.f53485d);
                    this.a.getOtpToken((String) SharedPreferencesUtils.getParam(this.f53487b.f53485d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, newPpKey, ""));
                }
            }
        }));
    }

    public String getSN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_ENTER);
            String[] split = new String(Base64.decode((String) SharedPreferencesUtils.getParam(this.f53485d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f53485d), ""), 0)).split("\\|");
            if (split.length == 3) {
                String localDecrypt1 = SecurePay.getInstance().localDecrypt1(split[2]);
                if (TextUtils.isEmpty(localDecrypt1)) {
                    StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_IS_NULL);
                    return localDecrypt1;
                }
                StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_SUCCESS);
                return localDecrypt1;
            }
            StatisticManager.onEvent(StatServiceEvent.EVENT_FP_GET_SN_FAIL);
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasEnrollFingerprint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f53485d, "android.permission.USE_FINGERPRINT") && isDevicesSupport()) {
                return a(this.f53485d);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hasOTPToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? !TextUtils.isEmpty((String) SharedPreferencesUtils.getParam(this.f53485d, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, PayPreferenceManager.getNewPpKey(this.f53485d), "")) : invokeV.booleanValue;
    }

    public boolean isDevicesSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (PermissionManager.checkCallingPermission(this.f53485d, "android.permission.USE_FINGERPRINT")) {
                a();
                return this.f53486e != PhoneSupportStatus.UNSUPPORT;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void open(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f53483b = fingerprintPay;
            if (fingerprintPay == null) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.OPEN, 2, "");
            } else {
                fingerprintPay.open(activity, fingerprintCallback, true);
            }
        }
    }

    @TargetApi(23)
    public void startListening(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f53483b = getFingerprintPay(FpType.SYSTEM_FINGERPRINT);
            try {
                this.f53484c = new com.baidu.wallet.paysdk.fingerprint.b.a(this.f53485d);
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
            }
            com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.f53484c;
            if (aVar != null && this.f53483b != null) {
                aVar.a(bVar);
                this.f53484c.a(2);
                return;
            }
            bVar.a(-1, "");
        }
    }

    public void verify(Activity activity, FpType fpType, FingerprintCallback fingerprintCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, activity, fpType, fingerprintCallback) == null) {
            IFingerprintPay fingerprintPay = getFingerprintPay(fpType);
            this.f53483b = fingerprintPay;
            if (fingerprintPay == null) {
                fingerprintCallback.onAuthorizeResult(IFingerprintPay.Action.VERIFY, 2, "");
            } else {
                fingerprintPay.verify(activity, fingerprintCallback);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (SecurityUtils.isRoot()) {
                this.f53486e = PhoneSupportStatus.UNSUPPORT;
            } else if (b()) {
                this.f53486e = PhoneSupportStatus.SUPPORT_SYS;
            } else {
                this.f53486e = PhoneSupportStatus.UNSUPPORT;
            }
        }
    }

    public IFingerprintPay getFingerprintPay(FpType fpType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fpType)) == null) {
            a();
            PhoneSupportStatus phoneSupportStatus = this.f53486e;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) ? PermissionManager.checkCallingPermission(context, "android.permission.USE_FINGERPRINT") && Build.VERSION.SDK_INT >= 23 && (fingerprintManager = (FingerprintManager) context.getSystemService(FingerprintManager.class)) != null && fingerprintManager.hasEnrolledFingerprints() : invokeL.booleanValue;
    }
}
