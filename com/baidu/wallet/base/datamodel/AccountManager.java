package com.baidu.wallet.base.datamodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.beans.BeanConstants;
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
/* loaded from: classes5.dex */
public final class AccountManager implements NoProguard {
    public static final String FILE_PREFERENCE_ACCOUNT = "account";
    public static final String PREFERENCES_NAME_PRE = "o2o_service.preferences";
    public static final String TAG = "AccountManager";
    public static AccountManager sInstance;
    public Context mContext;
    public final SharedPreferences mPreferences;
    public String mbfbToken;

    /* loaded from: classes5.dex */
    public class User implements Serializable {
        public static final long serialVersionUID = 1;
        public String tokenValue;
        public int userType;

        public User(int i2, String str) {
            this.userType = i2;
            this.tokenValue = str;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("user_type", this.userType);
                jSONObject.put(BeanConstants.KEY_TOEKN_VALUE, this.tokenValue);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    public AccountManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mPreferences = context.getSharedPreferences("account", 0);
    }

    private void delScanCodeSP() {
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        this.mContext.getPackageName();
        if (TextUtils.isEmpty(passUid) || !TextUtils.isDigitsOnly(passUid)) {
            String str = getFileNamePrefix() + PREFERENCES_NAME_PRE;
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

    public static synchronized AccountManager getInstance(Context context) {
        AccountManager accountManager;
        synchronized (AccountManager.class) {
            if (sInstance == null) {
                sInstance = new AccountManager(context.getApplicationContext());
            }
            accountManager = sInstance;
        }
        return accountManager;
    }

    public String getBduss() {
        return WalletLoginHelper.getInstance().getLoginToken();
    }

    public String getBfbToken() {
        String str = this.mbfbToken;
        if (str == null) {
            LogUtil.d(TAG, "mtoken 为NULL mPreferences=" + this.mPreferences);
            return this.mPreferences.getString("token", null);
        }
        return str;
    }

    public String getFileNamePrefix() {
        String localEncrypt1 = SafePay.getInstance().localEncrypt1(WalletLoginHelper.getInstance().getPassUid());
        if (TextUtils.isEmpty(localEncrypt1)) {
            return "";
        }
        LogUtil.i(TAG, "PREFERENCES_NAME_PRE: uid " + localEncrypt1);
        return Md5Utils.toMD5(localEncrypt1);
    }

    public Map<String, String> getLoginData() {
        return WalletLoginHelper.getInstance().getLoginData();
    }

    public int getLoginType() {
        return WalletLoginHelper.getInstance().getLoginType();
    }

    public String getOpenBduss() {
        return WalletLoginHelper.getInstance().getOpenLoginToken();
    }

    public void logout() {
        delScanCodeSP();
        if (LocalRouter.getInstance(this.mContext).isRequestAvailable(new RouterRequest().provider("hce").action("cleanData"))) {
            LocalRouter.getInstance(this.mContext.getApplicationContext()).route(this.mContext, new RouterRequest().provider("hce").action("cleanData"), new RouterCallback() { // from class: com.baidu.wallet.base.datamodel.AccountManager.1
                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "hce");
                        hashMap2.put("action", "cleanData");
                        DXMSdkSAUtils.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                        PayStatisticsUtil.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                    }
                }
            });
        }
    }

    public void setBfbToken(String str) {
        LogUtil.d(TAG, "setBfbToken=" + str);
        this.mbfbToken = str;
        SharedPreferences.Editor edit = this.mPreferences.edit();
        edit.putString("token", str);
        edit.apply();
    }
}
