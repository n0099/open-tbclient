package com.baidu.titan.sdk.pm;

import com.baidu.titan.sdk.common.TitanConstant;
import com.baidu.titan.sdk.internal.util.Closes;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class PatchClassInfo {
    public HashSet<String> instantClassNames;
    public HashSet<String> lazyClassNames;

    public static PatchClassInfo createFromJson(String str) {
        try {
            PatchClassInfo patchClassInfo = new PatchClassInfo();
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(TitanConstant.KEY_LAZY_INIT_CLASS);
            JSONArray jSONArray2 = jSONObject.getJSONArray(TitanConstant.KEY_INSTANT_INIT_CLASS);
            patchClassInfo.lazyClassNames = new HashSet<>();
            patchClassInfo.instantClassNames = new HashSet<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                patchClassInfo.lazyClassNames.add(jSONArray.getString(i));
            }
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                patchClassInfo.instantClassNames.add(jSONArray2.getString(i2));
            }
            return patchClassInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PatchClassInfo createFromPatch(File file) {
        ZipFile zipFile;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(new ZipEntry(TitanConstant.PATCH_CLASS_INFO_PATH))));
                try {
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read > 0) {
                            charArrayWriter.write(cArr, 0, read);
                        } else {
                            PatchClassInfo createFromJson = createFromJson(charArrayWriter.toString());
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
}
