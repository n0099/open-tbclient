package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.baidu.tieba.wallet.pay.ShareUtils;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import d.b.c.e.i.a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LightAppListenerImpl implements ILightAppListener {
    public String TAG = getClass().getSimpleName();

    @Override // com.baidu.wallet.api.ILightAppListener
    public boolean callShare(Activity activity, Map<String, String> map, ILightappInvokerCallback iLightappInvokerCallback) {
        if (activity == null || map == null) {
            return false;
        }
        String str = map.get(ILightAppListener.KEY_SHARE_TITLE);
        String str2 = map.get(ILightAppListener.KEY_SHARE_CONTENT);
        String str3 = map.get(ILightAppListener.KEY_SHARE_LINK);
        String str4 = map.get(ILightAppListener.KEY_SHARE_IMAGE);
        String str5 = map.get(ILightAppListener.KEY_SHARE_MEDIATYPE);
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        ShareUtils.share(activity, str5, str, str2, str3, str4);
        return true;
    }

    @Override // com.baidu.wallet.api.ILightAppListener
    public boolean getCurrentLocation(final ILocationCallback iLocationCallback) {
        if (iLocationCallback == null) {
            return false;
        }
        a.l().i(true, new a.c() { // from class: com.baidu.tieba.wallet.LightAppListenerImpl.1
            @Override // d.b.c.e.i.a.c
            public void onLocationGeted(int i, String str, Address address) {
                if (i != 0) {
                    if (i == 1 || i == 2 || i == 3) {
                        iLocationCallback.onReceiveLocation(null);
                    } else if (i != 4 && i != 5) {
                        iLocationCallback.onReceiveLocation(null);
                    } else {
                        iLocationCallback.onReceiveLocation(null);
                    }
                } else if (address != null) {
                    LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                    lightAppLocationModel.result = 0;
                    LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                    lightAppLocationModel.coords = coords;
                    coords.latitude = address.getLatitude();
                    lightAppLocationModel.coords.longitude = address.getLongitude();
                    if (address.getExtras() != null) {
                        lightAppLocationModel.coords.accuracy = address.getExtras().getFloat("radius");
                    }
                    iLocationCallback.onReceiveLocation(lightAppLocationModel);
                }
            }
        });
        return true;
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        HashSet hashSet = new HashSet();
        hashSet.add("toast");
        return hashSet;
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method_name");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                jSONObject.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ("toast".equals(string)) {
                iLightappInvokerCallback.onResult(0, "1");
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
