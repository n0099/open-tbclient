package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ac {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static volatile ac oNO;
    private boolean oNN = com.baidu.pyramid.runtime.multiprocess.a.ahD();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ac ejo() {
        if (oNO == null) {
            synchronized (e.class) {
                if (oNO == null) {
                    oNO = new ac();
                }
            }
        }
        return oNO;
    }

    private ac() {
    }

    public void h(String str, int i, int i2, int i3) {
        if (this.oNN && !TextUtils.isEmpty(str)) {
            if (i != 0 || i2 != 0 || i3 != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                    if (i != 0) {
                        jSONObject.put("flowExpired", i);
                    }
                    if (i2 != 0) {
                        jSONObject.put("eventExpired", i2);
                    }
                    if (i3 != 0) {
                        jSONObject.put("flowInterrupt", i3);
                    }
                    e("logDiscard", "timeExpired", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void w(String str, int i, String str2) {
        if (this.oNN && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                jSONObject.put("dbOverNum", i);
                jSONObject.put("tableName", str2);
                e("logDiscard", "database", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void cg(String str, int i) {
        if (this.oNN && !TextUtils.isEmpty(str) && i != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                jSONObject.put("fileNum", i);
                e("logDiscard", "fileNum", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void XB(String str) {
        if (this.oNN && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.EXTRA_CONFIG_LIMIT, str);
                e("logDiscard", "realLog", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void gW(String str, String str2) {
        if (this.oNN) {
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("msg", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("exception", str2);
                    }
                    e("sendFail", "requestError", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Ow(int i) {
        if (this.oNN) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(BaseJsonData.TAG_ERRNO, i);
                e("sendFail", "backend", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void XC(String str) {
        if (this.oNN && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                e("sendFail", "bodyError", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void XD(String str) {
        if (this.oNN && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception", str);
                e("sqlError", null, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void e(String str, String str2, JSONObject jSONObject) {
        af afVar = (af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE);
        if (DEBUG) {
            String str3 = "";
            if (jSONObject != null) {
                str3 = jSONObject.toString();
            }
            Log.d("UBCQualityStatics", "Quality event: type=" + str + ", value=" + str2 + ",ext=" + str3);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("value", str2);
            }
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            afVar.onEvent("1876", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
