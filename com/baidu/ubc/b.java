package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b {
    private static final boolean DEBUG = AppConfig.isDebug();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar, boolean z) {
        a(nVar, bl(nVar.getFileName(), z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [135=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0113 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0115 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00af */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(n nVar, File file) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", nVar.getTime());
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.getContent())) {
                jSONObject.put("content", nVar.getContent());
            } else if (nVar.bge() != null) {
                jSONObject.put("content", nVar.bge().toString());
            }
            if (!TextUtils.isEmpty(nVar.bgd())) {
                jSONObject.put("abtest", nVar.bgd());
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.bfZ()) {
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
            }
            jSONObject.put("idtype", g.eiL().zv(nVar.getId()));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCFileData", e.getMessage());
            }
        }
        if (DEBUG) {
            Log.d("UBCFileData", "saveEvent:" + jSONObject.toString());
        }
        ?? r1 = 2;
        byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
        try {
            try {
                r1 = new FileOutputStream(file, true);
                try {
                    r1.write(encode);
                    r1.write("\n".getBytes());
                    r1.flush();
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            r1 = 0;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            if (r1 != 0) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "filequality");
        if (file2.length() > g.eiL().eiM()) {
            if (file2.delete()) {
                file2 = new File(file, "filequality");
            } else {
                return;
            }
        }
        a(nVar, file2);
    }

    private File bl(String str, boolean z) {
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
        ac.ejd().XU(Log.getStackTraceString(exc));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [254=4] */
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
    public boolean a(aj ajVar, boolean z) {
        BufferedReader bufferedReader;
        boolean a2 = z ? false : a(ajVar);
        File bl = bl("", z);
        ?? exists = bl.exists();
        if (exists != 0) {
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(bl));
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
                                ajVar.zG("1");
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
                            ajVar.df(jSONObject);
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
                    ajVar.r(j, j2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [394=4] */
    private boolean a(aj ajVar) {
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
                                ajVar.zG("1");
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
                            ajVar.df(jSONObject);
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
                ajVar.r(j, j2);
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
    public void io(boolean z) {
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
