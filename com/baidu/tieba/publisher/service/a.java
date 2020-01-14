package com.baidu.tieba.publisher.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.e;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountRequestListener;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.IAddressManageCallback;
import com.baidu.searchbox.account.ICheckBdussAlertStatusCallback;
import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.IGetTplStokenCallback;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.IVerifyUserFaceIDListener;
import com.baidu.searchbox.account.IWebModifyPwdCallback;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.params.LogoutParams;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.publisher.a.d;
import com.baidu.tieba.publisher.a.o;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a implements BoxAccountManager {
    private static boolean jAT = false;
    private static String mUid = "";
    private static String mBduss = "";
    private static String mZid = "";

    public a() {
        initData(com.baidu.tieba.publisher.b.a.czH());
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void login(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void login(Context context, LoginParams loginParams) {
    }

    public void n(Context context, boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                String bduss = currentAccountInfo.getBDUSS();
                String id = currentAccountInfo.getID();
                String gz = FH.gz(TbadkCoreApplication.getInst());
                o.jAS.putBoolean("mloginState", true);
                o.jAS.putString("mUid", id);
                o.jAS.putString("mBduss", bduss);
                o.jAS.putString("mZid", gz);
                o.jAS.apply();
                d.au(mBduss);
                com.baidu.tieba.publisher.a.b.setZid(mZid);
                jAT = true;
                return;
            }
            logout(context);
            if (z) {
                bc.checkUpIsLogin(context);
                return;
            }
            return;
        }
        logout(context);
        if (z) {
            bc.checkUpIsLogin(context);
        }
    }

    public void initData(Context context) {
        e.a(BoxAccountManager.SERVICE_REFERENCE, new b());
        o.sp = context.getSharedPreferences("account", 0);
        o.jAS = o.sp.edit();
        mUid = o.sp.getString("mUid", "");
        mBduss = o.sp.getString("mBduss", "");
        mZid = o.sp.getString("mZid", "");
        d.au(mBduss);
        com.baidu.tieba.publisher.a.b.setZid(mZid);
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void combineLogin(Context context, LoginParams loginParams, int i, ILoginResultListener iLoginResultListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void bindPhone(Context context, LoginParams loginParams, ILoginResultListener iLoginResultListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void logout(LogoutParams logoutParams) {
    }

    public void logout(Context context) {
        jAT = false;
        o.jAS.putBoolean("mloginState", false);
        o.jAS.apply();
        d.czx();
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void release() {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public boolean isLogin() {
        jAT = o.sp.getBoolean("mloginState", false);
        return jAT;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public boolean isLogin(int i) {
        return jAT;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public boolean isGuestLogin() {
        return false;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public String getSession(String str, String str2) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public String getSession(String str) {
        if (TextUtils.equals(str, BoxAccountManager.SESSION_UID)) {
            return mUid;
        }
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public BoxAccount getBoxAccount(int i, IGetBoxAccountListener iGetBoxAccountListener) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public BoxAccount getBoxAccount() {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void modifyUserInfo(long j, BoxAccount boxAccount, IAccountRequestListener iAccountRequestListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void modifyUserInfo(JSONObject jSONObject, IAccountRequestListener iAccountRequestListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void checkBdussAndAlert(Activity activity, boolean z, String str, ILoginResultListener iLoginResultListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void checkBdussAndAlert(Activity activity, boolean z, String str, ICheckBdussAlertStatusCallback iCheckBdussAlertStatusCallback) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void addLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void removeLoginStatusChangedListener(IAccountStatusChangedListener iAccountStatusChangedListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public List<String> getAuthorizedDomains(Context context) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public List<String> getAuthorizedDomainsForPtoken(Context context) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public String buildBDUSSCookie(String str, String str2) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public String buildPtokenCookie(String str, String str2) {
        return null;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void loginStatusCheck(UserAccountActionItem userAccountActionItem) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public boolean isWxAppInstalledAndSupported() {
        return true;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void getTplStoken(IGetTplStokenCallback iGetTplStokenCallback, String str, List<String> list) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void setThirdLoginSwitch(int i) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void startAccountNickNameActivity(Activity activity, String str, String str2, int i) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void showNickNameGuideDialog(Activity activity, String str) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public boolean isShow(int i) {
        return false;
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void verifyUserFaceId(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void loadAccountRealName(Context context, String str, IVerifyUserFaceIDListener iVerifyUserFaceIDListener) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void loadModifyPwd(IWebModifyPwdCallback iWebModifyPwdCallback) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void loadAddressManage(Context context, String str) {
    }

    @Override // com.baidu.searchbox.account.BoxAccountManager
    public void selectAddress(Context context, boolean z, String str, IAddressManageCallback iAddressManageCallback) {
    }
}
