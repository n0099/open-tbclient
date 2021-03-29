package com.baidu.wallet.api;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.passport.LoginImpl;
import com.baidu.wallet.passport.PassLoginUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;

    /* renamed from: c  reason: collision with root package name */
    public static WalletLoginHelper f23481c;

    /* renamed from: a  reason: collision with root package name */
    public WalletApiExtListener.LoginstatuSyncListener f23482a;

    /* renamed from: b  reason: collision with root package name */
    public final String f23483b;

    /* renamed from: d  reason: collision with root package name */
    public IWalletLoginListener f23484d;

    /* renamed from: e  reason: collision with root package name */
    public Context f23485e;

    /* renamed from: f  reason: collision with root package name */
    public IWalletListener f23486f;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final WalletLoginHelper f23490a = new WalletLoginHelper();
    }

    public static final WalletLoginHelper getInstance() {
        return a.f23490a;
    }

    public void clearOpenBduss() {
        logout(false);
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i, int i2, String str, Class<?>[] clsArr) {
        objArr[i2] = a(i);
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak() { // from class: com.baidu.wallet.api.WalletLoginHelper.1
            @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
            public void onFailure(int i3, String str2) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i3 + " , " + str2);
            }
        }, clsArr);
    }

    public int getBdussState() {
        return SapiAccountManager.getInstance().getAccountService().getBdussState();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public Map<String, String> getLoginData(String str) {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(str);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    @Deprecated
    public String getLoginStoken(String str) {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(str);
        }
        return iWalletLoginListener.getLoginStoken(str);
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getLoginToken() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginToken();
        }
        return iWalletLoginListener.getLoginToken();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public int getLoginType() {
        return 0;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
        } else {
            iWalletLoginListener.getOpenBduss(z, iLoginBackListener);
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public String getOpenLoginToken() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginOpenToken();
        }
        return iWalletLoginListener.getOpenLoginToken();
    }

    public String getPassUid() {
        Map<String, String> loginData = getLoginData();
        if (loginData != null) {
            return loginData.get("pass_uid");
        }
        return null;
    }

    public String getPassUserName() {
        Map<String, String> loginData = getLoginData();
        if (loginData != null) {
            return loginData.get("pass_user_name");
        }
        return null;
    }

    public WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener() {
        return this.f23482a;
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getTpl() {
        return BeanConstants.CHANNEL_ID_WALLET_APP.equals(BeanConstants.CHANNEL_ID) ? "baiduwalletapp" : "bdwalletsdk";
    }

    public String getUnionId() {
        try {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_union_id");
            }
            return null;
        } catch (Exception e2) {
            LogUtil.d("Sensor", e2.getMessage());
            return null;
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void handlerWalletError(int i) {
        DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_HANDLERWALLETERROR);
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_HANDLERWALLETERROR);
        onHandleWalletError(i);
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.handlerWalletError(i);
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        this.f23486f = iWalletListener;
        this.f23484d = new LoginImpl(context);
        PassLoginUtil.getInstance().init();
        this.f23485e = context.getApplicationContext();
    }

    public boolean isInnerPassLogin() {
        return false;
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isLogin() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().isLogin();
        }
        return iWalletLoginListener.isLogin();
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public boolean isPassLogin() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().isPassLogin();
        }
        return iWalletLoginListener.isPassLogin();
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public void login(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onSuccess(0, "");
            }
        } else if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f23484d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
            }
        } else {
            IWalletListener iWalletListener = this.f23486f;
            if (iWalletListener != null) {
                iWalletListener.login(iLoginBackListener);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        }
    }

    public void logout() {
        PassLoginUtil.getInstance().logout();
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onHandleWalletError(int i) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f23482a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onHandleWalletError(i);
        }
    }

    @Override // com.baidu.wallet.api.IWalletLoginListener
    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.onLoginChanaged(context, map);
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f23482a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onWebViewLogout(context);
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        clearOpenBduss();
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f23484d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f23486f;
        if (iWalletListener == null) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        } else if (iWalletListener instanceof IWalletListener2) {
            ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
        } else {
            iWalletListener.login(iLoginBackListener);
        }
    }

    public void setIntervalDuration(long j) {
        PassLoginUtil.getInstance().setIntervalDuration(j);
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        this.f23482a = loginstatuSyncListener;
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
    }

    @Override // com.baidu.wallet.api.IWalletHostListener
    public boolean startPage(String str) {
        if (this.f23485e == null) {
            return false;
        }
        DXMSdkSAUtils.onEvent(StatServiceEvent.EVENT_API_STARTPAGE);
        PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_API_STARTPAGE);
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f23484d;
            if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                BaiduWalletDelegate.getInstance().openH5Module(this.f23485e, str, true);
            }
        } else {
            IWalletListener iWalletListener = this.f23486f;
            if (iWalletListener != null) {
                if (!iWalletListener.startPage(str)) {
                    BaiduWalletDelegate.getInstance().openH5Module(this.f23485e, str, true);
                }
            } else {
                LogUtil.d(this.f23483b, "mWalletListener is null");
                Context context = this.f23485e;
                GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_load_fail"));
            }
        }
        return true;
    }

    public void syncH5LoginStatus(Context context) {
        int bdussState = SapiAccountManager.getInstance().getAccountService().getBdussState();
        String str = this.f23483b;
        LogUtil.d(str, "syncH5login bdussState = " + bdussState);
        if (bdussState == 2 || bdussState == 4) {
            syncLoginStatus(context, "", new WalletApiExtListener.SyncLoginStatusCb() { // from class: com.baidu.wallet.api.WalletLoginHelper.3
                @Override // com.baidu.wallet.api.WalletApiExtListener.SyncLoginStatusCb
                public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
                    String str2 = WalletLoginHelper.this.f23483b;
                    LogUtil.d(str2, "syncH5logoin onResult code = " + syncResult);
                    DXMSdkSAUtils.onEventWithValues(StatServiceEvent.SYNC_H5_LOGINSTATE_RESULT, Arrays.asList(String.valueOf(syncResult.getVal())));
                    PayStatisticsUtil.onEventWithValue(StatServiceEvent.SYNC_H5_LOGINSTATE_RESULT, String.valueOf(syncResult.getVal()));
                    if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                        WalletLoginHelper.getInstance().getOpenBduss(false, null);
                    }
                }
            });
        } else if (bdussState == 3) {
            String str2 = this.f23483b;
            LogUtil.d(str2, "syncH5login = " + bdussState + " ; invoke logout");
            DXMSdkSAUtils.onEvent(StatServiceEvent.INVOKE_PASS_LOGOUT);
            PayStatisticsUtil.onEvent(StatServiceEvent.INVOKE_PASS_LOGOUT);
            onWebViewLogout(context);
            logout();
            AccountManager.getInstance(context).logout();
        }
    }

    @Override // com.baidu.wallet.api.WalletApiExtListener.LoginstatuSyncListener
    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f23482a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
        }
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(true, iLoginBackListener);
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "");
        }
    }

    public WalletLoginHelper() {
        this.f23483b = WalletLoginHelper.class.getSimpleName();
    }

    private PASSMethodCallTransfer.ParamsWap a(int i) {
        PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
        paramsWap.param = "";
        HashMap hashMap = new HashMap();
        paramsWap.attributes = hashMap;
        if (i == 26) {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
        } else if (i == 27) {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
        } else {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
        }
        return paramsWap;
    }

    public void logout(boolean z) {
        PassLoginUtil.getInstance().logout(z);
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public Map<String, String> getLoginData() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(getTpl());
    }

    @Override // com.baidu.wallet.api.IWalletStoken
    public String getLoginStoken() {
        IWalletLoginListener iWalletLoginListener = this.f23484d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(getTpl());
        }
        return iWalletLoginListener.getLoginStoken(getTpl());
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i, int i2, int i3, String str, Class<?>[] clsArr) {
        if (i == 28) {
            objArr[i2] = a(26);
            objArr[i3] = a(27);
        }
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak() { // from class: com.baidu.wallet.api.WalletLoginHelper.2
            @Override // com.baidu.sapi2.openbduss.PASSMethodCallTransfer.DynamicCallbak
            public void onFailure(int i4, String str2) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i4 + " , " + str2);
            }
        }, clsArr);
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(z, iLoginBackListener);
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "未登录");
        }
    }

    @Override // com.baidu.wallet.api.IWalletHostListener2
    public void login(ILoginBackListener iLoginBackListener, String str) {
        clearOpenBduss();
        if (isPassLogin()) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onSuccess(0, "");
            }
        } else if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f23484d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
            }
        } else {
            IWalletListener iWalletListener = this.f23486f;
            if (iWalletListener == null) {
                if (iLoginBackListener != null) {
                    iLoginBackListener.onFail(-1, "");
                }
            } else if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f23484d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f23486f;
        if (iWalletListener == null) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        } else if (iWalletListener instanceof IWalletListener2) {
            ((IWalletListener2) iWalletListener).login(iLoginBackListener);
        } else {
            iWalletListener.login(iLoginBackListener);
        }
    }
}
