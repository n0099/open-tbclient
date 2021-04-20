package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.util.Arrays;
import java.util.Set;
/* loaded from: classes5.dex */
public class LightAppWrapper implements NoProguard, ILightappInvoker {
    public static final String LIGHT_APP_METHOD_IMPL_BY_APP = "method_implemented_by_app";

    /* renamed from: a  reason: collision with root package name */
    public ILightAppListener f24494a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LightAppWrapper f24495a = new LightAppWrapper();
    }

    public static LightAppWrapper getInstance() {
        return a.f24495a;
    }

    public boolean callShare(Activity activity, LightAppShareModel lightAppShareModel, ILightappInvokerCallback iLightappInvokerCallback) {
        if (activity == null) {
            return false;
        }
        ILightAppListener iLightAppListener = this.f24494a;
        if (iLightAppListener != null) {
            boolean callShare = iLightAppListener.callShare(activity, lightAppShareModel.toMap(), iLightappInvokerCallback);
            if (callShare) {
                DXMSdkSAUtils.onEventWithValues(LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList("#callShare"));
                PayStatisticsUtil.onEventWithValue("#callShare", LIGHT_APP_METHOD_IMPL_BY_APP);
                return callShare;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", lightAppShareModel.content + " - " + lightAppShareModel.linkUrl);
            intent.putExtra("android.intent.extra.SUBJECT", lightAppShareModel.title);
            intent.setType("text/*");
            activity.startActivity(Intent.createChooser(intent, ResUtils.getString(activity, "wallet_lightapp_share")));
        } else {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.TEXT", lightAppShareModel.content + " - " + lightAppShareModel.linkUrl);
            intent2.putExtra("android.intent.extra.SUBJECT", lightAppShareModel.title);
            intent2.setType("text/*");
            activity.startActivity(Intent.createChooser(intent2, ResUtils.getString(activity, "wallet_lightapp_share")));
        }
        if (iLightappInvokerCallback != null) {
            iLightappInvokerCallback.onResult(0, "");
        }
        return false;
    }

    public boolean getCurrentLocation(ILocationCallback iLocationCallback) {
        ILightAppListener iLightAppListener = this.f24494a;
        if (iLightAppListener == null || !iLightAppListener.getCurrentLocation(iLocationCallback)) {
            return false;
        }
        DXMSdkSAUtils.onEventWithValues(LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS));
        PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS, LIGHT_APP_METHOD_IMPL_BY_APP);
        return true;
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        ILightAppListener iLightAppListener = this.f24494a;
        if (iLightAppListener != null) {
            return iLightAppListener.getMethodList();
        }
        return null;
    }

    public void initLightApp(ILightAppListener iLightAppListener) {
        this.f24494a = iLightAppListener;
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        ILightAppListener iLightAppListener = this.f24494a;
        if (iLightAppListener != null) {
            iLightAppListener.lightappInvoke(context, str, iLightappInvokerCallback);
        }
    }

    public LightAppWrapper() {
    }
}
