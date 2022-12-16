package com.baidu.titan.sdk.pm;

import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.internal.util.Closes;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PatchMetaInfo {
    public static final String KEY_BOOT_LOAD_SYNC_POLICY = "bootLoadSyncPolicy";
    public static final String KEY_LOAD_POLICY = "loadPolicy";
    public static final String KEY_PATCH_STATUS = "status";
    public static final String KEY_TARGET_ID = "targetId";
    public static final String KEY_VERSION_INFO = "versionInfo";
    public int status;
    public String targetId;
    public VersionInfo versionInfo;
    public int loadPolicy = 0;
    public int bootLoadSyncPolicy = 0;

    /* loaded from: classes7.dex */
    public static class VersionInfo {
        public static final String KEY_HOST_VERSIONCODE = "hostVersionCode";
        public static final String KEY_HOST_VERSIONNAME = "hostVersionName";
        public static final String KEY_PATCH_VERSIONCODE = "patchVersionCode";
        public static final String KEY_PATCH_VERSIONNAME = "patchVersionName";
        public int hostVersionCode;
        public String hostVersionName;
        public int patchVersionCode;
        public String patchVersionName;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("patchVersionCode", this.patchVersionCode);
                jSONObject.put("patchVersionName", this.patchVersionName);
                jSONObject.put("hostVersionName", this.hostVersionName);
                jSONObject.put("hostVersionCode", this.hostVersionCode);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }

        public String toJsonString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("patchVersionCode", this.patchVersionCode);
                jSONObject.put("patchVersionName", this.patchVersionName);
                jSONObject.put("hostVersionName", this.hostVersionName);
                jSONObject.put("hostVersionCode", this.hostVersionCode);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject.toString();
            }
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetId", this.targetId);
            jSONObject.put("status", this.status);
            jSONObject.put("loadPolicy", this.loadPolicy);
            if (this.versionInfo != null) {
                jSONObject.put("versionInfo", this.versionInfo.toJson());
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static PatchMetaInfo createFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PatchMetaInfo patchMetaInfo = new PatchMetaInfo();
            patchMetaInfo.targetId = jSONObject.getString("targetId");
            patchMetaInfo.status = jSONObject.getInt("status");
            patchMetaInfo.loadPolicy = jSONObject.optInt("loadPolicy", 0);
            patchMetaInfo.bootLoadSyncPolicy = jSONObject.optInt("bootLoadSyncPolicy", 0);
            JSONObject jSONObject2 = jSONObject.getJSONObject("versionInfo");
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.hostVersionName = jSONObject2.optString("hostVersionName");
            versionInfo.hostVersionCode = jSONObject2.getInt("hostVersionCode");
            versionInfo.patchVersionName = jSONObject2.optString("patchVersionName");
            versionInfo.patchVersionCode = jSONObject2.getInt("patchVersionCode");
            patchMetaInfo.versionInfo = versionInfo;
            return patchMetaInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    public static PatchMetaInfo createFromPatch(File file) {
        ZipFile zipFile;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(new ZipEntry(TitanConstant.PATCH_INFO_PATH))));
                try {
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read > 0) {
                            charArrayWriter.write(cArr, 0, read);
                        } else {
                            PatchMetaInfo createFromJson = createFromJson(charArrayWriter.toString());
                            Closes.closeQuiet((Reader) bufferedReader);
                            Closes.closeQuiet(zipFile);
                            return createFromJson;
                        }
                    }
                } catch (Exception unused) {
                    Closes.closeQuiet((Reader) bufferedReader);
                    Closes.closeQuiet(zipFile);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    Closes.closeQuiet((Reader) bufferedReader2);
                    Closes.closeQuiet(zipFile);
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            zipFile = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetId", this.targetId);
            jSONObject.put("status", this.status);
            jSONObject.put("loadPolicy", this.loadPolicy);
            if (this.versionInfo != null) {
                jSONObject.put("versionInfo", this.versionInfo.toJsonString());
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject.toString();
        }
    }
}
