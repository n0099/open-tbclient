package com.baidu.titan.sdk.stat;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LoaderTimeStat {
    public static final String TITAN_APPLY = "titanApply";
    public static final String TITAN_CREATE_LAODER_HEAD = "titanCreateLoaderHead";
    public static final String TITAN_GET_APK_ID = "titanGetApkId";
    public static final String TITAN_GET_DEX_PATH = "titanGetDexPath";
    public static final String TITAN_GET_PATCH_DIR = "titanGetPatchDir";
    public static final String TITAN_LOAD_LOADER = "titanLoadLoader";
    public static final String TITAN_LOCK = "titanLock";
    public static final String TITAN_NEW_CLASSLOADER = "titanNewClassLoader";
    public static final String TITAN_NEW_LOADER = "titanNewLoader";
    public static final String TITAN_READ_HEAD_CONTENT = "titanReadContent";
    public static final String TITAN_VERIFY_SIGNATURE = "titanVerifySignature";
    public static final String TITAN_WAIT_VERIFY = "titanWaitVerify";
    public static LoaderTimeStat sInstance;
    public long apply;
    public long createLoaderHead;
    public long getApkId;
    public long getDexPath;
    public long getPatchDir;
    public long loadLoader;
    public long lock;
    public long newClassLoader;
    public long newLoader;
    public long readHeadContent;
    public long verifySignature;
    public long waitVerify;

    public static synchronized LoaderTimeStat getInstance() {
        LoaderTimeStat loaderTimeStat;
        synchronized (LoaderTimeStat.class) {
            if (sInstance == null) {
                sInstance = new LoaderTimeStat();
            }
            loaderTimeStat = sInstance;
        }
        return loaderTimeStat;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("readHeadContent", this.readHeadContent);
            jSONObject.put("createLoaderHead", this.createLoaderHead);
            jSONObject.put("getApkId", this.getApkId);
            jSONObject.put("getPatchDir", this.getPatchDir);
            jSONObject.put("getDexPath", this.getDexPath);
            jSONObject.put("newClassLoader", this.newClassLoader);
            jSONObject.put("waitVerify", this.waitVerify);
            jSONObject.put("loadLoader", this.loadLoader);
            jSONObject.put("newLoader", this.newLoader);
            jSONObject.put("apply", this.apply);
            jSONObject.put("verifySignature", this.verifySignature);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(TITAN_READ_HEAD_CONTENT, String.valueOf(this.readHeadContent));
        hashMap.put(TITAN_CREATE_LAODER_HEAD, String.valueOf(this.createLoaderHead));
        hashMap.put(TITAN_GET_APK_ID, String.valueOf(this.getApkId));
        hashMap.put(TITAN_GET_PATCH_DIR, String.valueOf(this.getPatchDir));
        hashMap.put(TITAN_LOCK, String.valueOf(this.lock));
        hashMap.put(TITAN_GET_DEX_PATH, String.valueOf(this.getDexPath));
        hashMap.put(TITAN_NEW_CLASSLOADER, String.valueOf(this.newClassLoader));
        hashMap.put(TITAN_WAIT_VERIFY, String.valueOf(this.waitVerify));
        hashMap.put(TITAN_LOAD_LOADER, String.valueOf(this.loadLoader));
        hashMap.put(TITAN_NEW_LOADER, String.valueOf(this.newLoader));
        hashMap.put(TITAN_APPLY, String.valueOf(this.apply));
        hashMap.put(TITAN_VERIFY_SIGNATURE, String.valueOf(this.verifySignature));
        return hashMap;
    }
}
