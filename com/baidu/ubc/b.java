package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.config.AppConfig;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class b {
    private static final boolean DEBUG = AppConfig.isDebug();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(n nVar, boolean z) {
        FileOutputStream fileOutputStream;
        File bc = bc(nVar.getFileName(), z);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", nVar.getTime());
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.getContent())) {
                jSONObject.put("content", nVar.getContent());
            } else if (nVar.aZn() != null) {
                jSONObject.put("content", nVar.aZn().toString());
            }
            if (!TextUtils.isEmpty(nVar.aZm())) {
                jSONObject.put("abtest", nVar.aZm());
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aZi()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", g.dTF().ym(nVar.getId()));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCFileData", e.getMessage());
            }
        }
        if (DEBUG) {
            Log.d("UBCFileData", "saveEvent:" + jSONObject.toString());
        }
        byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
        try {
            fileOutputStream = new FileOutputStream(bc, true);
            try {
                try {
                    fileOutputStream.write(encode);
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.flush();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    private File bc(String str, boolean z) {
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!TextUtils.isEmpty(str)) {
            File file2 = new File(file, "proc");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            return new File(file2, str);
        }
        return new File(file, z ? "filereal" : "filedata");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Exception exc) {
        File bc = bc("", false);
        if (bc != null) {
            if (bc.length() >= 1048576) {
                bc.delete();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception", Log.getStackTraceString(exc));
                a(new n(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject, 0), false);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [233=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x00c0 */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(ah ahVar, boolean z) {
        BufferedReader bufferedReader;
        boolean a2 = z ? false : a(ahVar);
        File bc = bc("", z);
        ?? exists = bc.exists();
        if (exists != 0) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(bc));
                    long j = Long.MAX_VALUE;
                    long j2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                ahVar.yx("1");
                            }
                            long j3 = jSONObject.getLong("timestamp");
                            if (j3 > 0) {
                                if (j3 < j) {
                                    j = j3;
                                }
                                if (j3 > j2) {
                                    j2 = j3;
                                }
                            }
                            ahVar.da(jSONObject);
                            a2 = true;
                        } catch (Exception e) {
                            e = e;
                            if (DEBUG) {
                                Log.d("UBCFileData", "getExceptionList read fail:", e);
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e2) {
                                    if (DEBUG) {
                                        Log.d("UBCFileData", "getExceptionList close fail:", e2);
                                    }
                                }
                            }
                            return a2;
                        }
                    }
                    ahVar.q(j, j2);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e3) {
                            if (DEBUG) {
                                Log.d("UBCFileData", "getExceptionList close fail:", e3);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (exists != 0) {
                        try {
                            exists.close();
                        } catch (Exception e4) {
                            if (DEBUG) {
                                Log.d("UBCFileData", "getExceptionList close fail:", e4);
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                exists = 0;
                if (exists != 0) {
                }
                throw th;
            }
        }
        return a2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [301=4] */
    private boolean a(ah ahVar) {
        File[] listFiles;
        BufferedReader bufferedReader;
        File file = new File(this.mContext.getFilesDir() + File.separator + "ubcdir", "proc");
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                int i = 0;
                long j = Long.MAX_VALUE;
                long j2 = 0;
                do {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                ahVar.yx("1");
                            }
                            long j3 = jSONObject.getLong("timestamp");
                            if (j3 > 0) {
                                if (j3 < j) {
                                    j = j3;
                                }
                                if (j3 > j2) {
                                    j2 = j3;
                                }
                            }
                            if (DEBUG) {
                                Log.d("UBCFileData", jSONObject.toString());
                            }
                            ahVar.da(jSONObject);
                            i++;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } while (i < 10);
                ahVar.q(j, j2);
                if (DEBUG) {
                    Log.d("UBCFileData", "line num " + i + " delete file ");
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hA(boolean z) {
        File[] listFiles;
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (file.exists()) {
            File file2 = new File(file, z ? "filereal" : "filedata");
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(file, "proc");
            if (file3.exists() && file3.isDirectory() && (listFiles = file3.listFiles()) != null && listFiles.length != 0) {
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }
}
