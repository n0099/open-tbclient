package com.baidu.wallet.lightapp.business.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.utils.ImageBase64Utils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24767a = "a";

    /* renamed from: b  reason: collision with root package name */
    public Activity f24768b;

    /* renamed from: c  reason: collision with root package name */
    public LightappBusinessClient f24769c;

    /* renamed from: d  reason: collision with root package name */
    public String f24770d;

    /* renamed from: e  reason: collision with root package name */
    public int f24771e = -1;

    /* renamed from: f  reason: collision with root package name */
    public String f24772f;

    public a(Activity activity, LightappBusinessClient lightappBusinessClient, String str) {
        this.f24768b = activity;
        this.f24769c = lightappBusinessClient;
        this.f24770d = str;
    }

    public void a(Intent intent, final JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(this.f24770d);
            String optString = jSONObject2.optString("fixedWidth");
            if (!TextUtils.isEmpty(optString)) {
                this.f24771e = Integer.parseInt(optString);
                String str = f24767a;
                LogUtil.d(str, "fixedWidth = " + this.f24771e);
            }
            this.f24772f = jSONObject2.optString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            Uri data = intent.getData();
            if (data == null) {
                jSONObject.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                jSONObject.put("des", "内部错误");
                this.f24769c.setAlubmPhotoData(1, jSONObject);
                a("#callNativePhoto Fail", "图片报错");
                return;
            }
            ImageBase64Utils.getInstance().getImageBase64(this.f24768b, data, this.f24771e, new ImageBase64Utils.ImageBase64Listener() { // from class: com.baidu.wallet.lightapp.business.presenter.a.1
                @Override // com.baidu.wallet.utils.ImageBase64Utils.ImageBase64Listener
                public void onBase64Result(String str2) {
                    if (TextUtils.isEmpty(str2)) {
                        try {
                            jSONObject.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                            jSONObject.put("des", "内部错误");
                            a.this.f24769c.setAlubmPhotoData(1, jSONObject);
                            a.this.a("#callNativePhoto Fail", "Base64失败");
                            return;
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("image", str2);
                        jSONObject.put(RouterCallback.KEY_ERROR_CODE, 0);
                        jSONObject.put("des", "ok");
                        jSONObject.put("data", jSONObject3);
                        a.this.f24769c.setAlubmPhotoData(0, jSONObject);
                    } catch (JSONException e3) {
                        try {
                            jSONObject.put(RouterCallback.KEY_ERROR_CODE, LightappConstants.ERRCODE_INNER_ERROR);
                            jSONObject.put("des", "内部错误");
                            a.this.f24769c.setAlubmPhotoData(1, jSONObject);
                            a.this.a("#callNativePhoto Fail", e3.getMessage());
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            });
        } finally {
        }
    }

    public void a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CheckUtils.stripUrlParams(this.f24772f));
        arrayList.add(str2);
        DXMSdkSAUtils.onEventWithValues(str, arrayList);
        PayStatisticsUtil.onEventWithValues(str, arrayList);
    }
}
