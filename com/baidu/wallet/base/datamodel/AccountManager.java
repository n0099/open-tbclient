package com.baidu.wallet.base.datamodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class AccountManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_PREFERENCE_ACCOUNT = "account";
    public static final String PREFERENCES_NAME_PRE = "o2o_service.preferences";
    public static final String TAG = "AccountManager";
    public static AccountManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public final SharedPreferences mPreferences;
    public String mbfbToken;

    /* loaded from: classes11.dex */
    public class User implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountManager this$0;
        public String tokenValue;
        public int userType;

        public User(AccountManager accountManager, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountManager, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = accountManager;
            this.userType = i2;
            this.tokenValue = str;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("user_type", this.userType);
                    jSONObject.put("token_value", this.tokenValue);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    public AccountManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = DxmApplicationContextImpl.getApplicationContext(context);
        this.mPreferences = context.getSharedPreferences("account", 0);
    }

    private void delScanCodeSP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            String passUid = WalletLoginHelper.getInstance().getPassUid();
            this.mContext.getPackageName();
            if (TextUtils.isEmpty(passUid) || !TextUtils.isDigitsOnly(passUid)) {
                String str = getFileNamePrefix() + "o2o_service.preferences";
                try {
                    SharedPreferencesUtils.clear(this.mContext, str);
                    File file = new File(this.mContext.getFilesDir().getParent() + "/shared_prefs/" + str + ActivityChooserModel.HISTORY_FILE_EXTENSION);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static synchronized AccountManager getInstance(Context context) {
        InterceptResult invokeL;
        AccountManager accountManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (AccountManager.class) {
                if (sInstance == null) {
                    sInstance = new AccountManager(DxmApplicationContextImpl.getApplicationContext(context));
                }
                accountManager = sInstance;
            }
            return accountManager;
        }
        return (AccountManager) invokeL.objValue;
    }

    public String getBfbToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = this.mbfbToken;
            if (str == null) {
                LogUtil.d("AccountManager", "mtoken 为NULL mPreferences=" + this.mPreferences);
                return this.mPreferences.getString("token", null);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getFileNamePrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String localEncrypt1 = SafePay.getInstance().localEncrypt1(WalletLoginHelper.getInstance().getPassUid());
            if (TextUtils.isEmpty(localEncrypt1)) {
                return "";
            }
            LogUtil.i("AccountManager", "PREFERENCES_NAME_PRE: uid " + localEncrypt1);
            return Md5Utils.toMD5(localEncrypt1);
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> getLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? WalletLoginHelper.getInstance().getLoginData() : (Map) invokeV.objValue;
    }

    public int getLoginType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? WalletLoginHelper.getInstance().getLoginType() : invokeV.intValue;
    }

    public String getOpenBduss() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? WalletLoginHelper.getInstance().getOpenLoginToken() : (String) invokeV.objValue;
    }

    public void logout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            delScanCodeSP();
            if (LocalRouter.getInstance(this.mContext).isRequestAvailable(new RouterRequest().provider("hce").action("cleanData"))) {
                LocalRouter.getInstance(DxmApplicationContextImpl.getApplicationContext(this.mContext)).route(this.mContext, new RouterRequest().provider("hce").action("cleanData"), new RouterCallback(this) { // from class: com.baidu.wallet.base.datamodel.AccountManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AccountManager a;

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

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "hce");
                            hashMap2.put("action", "cleanData");
                            DXMSdkSAUtils.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
            }
        }
    }

    public void setBfbToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            LogUtil.d("AccountManager", "setBfbToken=" + str);
            this.mbfbToken = str;
            SharedPreferences.Editor edit = this.mPreferences.edit();
            edit.putString("token", str);
            edit.apply();
        }
    }
}
