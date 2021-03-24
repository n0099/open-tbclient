package com.baidu.wallet.statistics.impl;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.statistics.BasicStoreToolsWrapper;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.duxiaoman.dxmpay.statistics.StatConfigEntity;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatConfig implements NoProguard, d.d.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    public StatConfigEntity f26809a;

    /* renamed from: b  reason: collision with root package name */
    public Context f26810b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatConfig f26811a = new StatConfig();
    }

    public static StatConfig getInstance(Context context) {
        a.f26811a.setContext(context);
        return a.f26811a;
    }

    @Override // d.d.a.a.b.b
    public int get3GSendingInterval() {
        StatConfigEntity statConfigEntity = this.f26809a;
        if (statConfigEntity == null) {
            return 5;
        }
        return statConfigEntity.mobile_net;
    }

    @Override // d.d.a.a.b.a
    public String getAppVersionCode() {
        return String.valueOf(PhoneUtils.getAppVersionCode(this.f26810b));
    }

    @Override // d.d.a.a.b.a
    public String getAppVersionName() {
        return PhoneUtils.getAppVersionName(this.f26810b);
    }

    @Override // d.d.a.a.b.a
    public String getChannelId() {
        return BeanConstants.CHANNEL_ID;
    }

    @Override // d.d.a.a.b.a
    public String getCommonEvent() {
        return "DXMPaySDK";
    }

    @Override // d.d.a.a.b.a
    public String getDistinctId() {
        if (isLogin() && !TextUtils.isEmpty(WalletLoginHelper.getInstance().getUnionId())) {
            return SafePay.getInstance().encryptProxy(WalletLoginHelper.getInstance().getUnionId());
        }
        return SafePay.getInstance().encryptProxy(com.baidu.wallet.statistics.impl.a.a().b(this.f26810b));
    }

    @Override // d.d.a.a.b.a
    public String getDistinctIdKey() {
        return SafePay.getInstance().getpwProxy();
    }

    @Override // d.d.a.a.b.a
    public String getHeader() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f26810b != null) {
                com.baidu.wallet.statistics.impl.a a2 = com.baidu.wallet.statistics.impl.a.a();
                jSONObject.putOpt("ua", a2.c(this.f26810b));
                jSONObject.putOpt("cu", a2.a(this.f26810b));
                jSONObject.putOpt("op", a2.d(this.f26810b));
                jSONObject.put("cu2", a2.b(this.f26810b));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // d.d.a.a.b.a
    public String getProductName() {
        return "BaiduWallet";
    }

    @Override // d.d.a.a.b.a
    public String getSDKVersion() {
        return BeanConstants.VERSION_NO;
    }

    @Override // d.d.a.a.b.a
    public String getUploadUrl() {
        return DebugConfig.getInstance().getSenorStatisticsHost() + "/sensors_batch/v2";
    }

    @Override // d.d.a.a.b.b
    public int getWifiSendingInterval() {
        StatConfigEntity statConfigEntity = this.f26809a;
        if (statConfigEntity == null) {
            return 3;
        }
        return statConfigEntity.wifi;
    }

    @Override // d.d.a.a.b.b
    public boolean isDisabled() {
        return false;
    }

    @Override // d.d.a.a.b.b
    public boolean isForceToSend(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {PayStatServiceEvent.STD_PAY_SUCCESS, PayStatServiceEvent.STD_PAY_FAILED, PayStatServiceEvent.PERCASHIER_PAY_SUCCESS, PayStatServiceEvent.PERCASHIER_PAY_FAILED, PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, PayStatServiceEvent.INITIVATIVE_BIND_CARD_SUCCESS, PayStatServiceEvent.LBS_PAY_RESULT_ERROR, PayStatServiceEvent.LBS_PAY_RESULT_PAYING, PayStatServiceEvent.LBS_PAY_RESULT_CANCEL, PayStatServiceEvent.LBS_PAY_RESULT_SUCCESS, "endLivenessSDK"};
        try {
            Arrays.sort(strArr);
            return Arrays.binarySearch(strArr, str) >= 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // d.d.a.a.b.b
    public boolean isIgnoreToSend(String str) {
        return false;
    }

    @Override // d.d.a.a.b.a
    public boolean isLogin() {
        return WalletLoginHelper.getInstance().isLogin();
    }

    @Override // d.d.a.a.b.a
    public void loadStrategy() {
        Context context = this.f26810b;
        if (context != null) {
            String statisticsStrategy = BasicStoreToolsWrapper.getStatisticsStrategy(context);
            if (TextUtils.isEmpty(statisticsStrategy)) {
                return;
            }
            try {
                this.f26809a = (StatConfigEntity) JsonUtils.fromJson(new JSONObject(statisticsStrategy).optString("data"), StatConfigEntity.class);
            } catch (Exception e2) {
                LogUtil.errord("Sensor Config", e2.getMessage());
            }
        }
    }

    public void setContext(Context context) {
        if (this.f26810b != null || context == null) {
            return;
        }
        this.f26810b = context.getApplicationContext();
    }

    public StatConfig() {
    }
}
