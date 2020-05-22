package com.baidu.ubc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class b {
    private static final boolean DEBUG = AppConfig.isDebug();
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0160 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0162 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00ea */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(n nVar, boolean z) {
        File file;
        File file2 = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (TextUtils.isEmpty(nVar.getFileName())) {
            file = new File(file2, z ? "filereal" : "filedata");
        } else {
            File file3 = new File(file2, "proc");
            if (!file3.exists()) {
                file3.mkdirs();
            }
            file = new File(file3, nVar.getFileName());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.getId());
            jSONObject.put("timestamp", nVar.getTime());
            jSONObject.put("type", "0");
            if (!TextUtils.isEmpty(nVar.getContent())) {
                jSONObject.put("content", nVar.getContent());
            } else if (nVar.aIv() != null) {
                jSONObject.put("content", nVar.aIv().toString());
            }
            if (!TextUtils.isEmpty(nVar.aIu())) {
                jSONObject.put("abtest", nVar.aIu());
            }
            if (!TextUtils.isEmpty(nVar.getCategory())) {
                jSONObject.put("c", nVar.getCategory());
            }
            if (nVar.aIq()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put("idtype", g.drP().tK(nVar.getId()));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("UBCFileData", e.getMessage());
            }
        }
        if (DEBUG) {
            Log.d("UBCFileData", "saveEvent:" + jSONObject.toString());
        }
        ?? bytes = jSONObject.toString().getBytes();
        byte[] encode = Base64.encode(bytes, 2);
        try {
            try {
                bytes = new FileOutputStream(file, true);
                try {
                    bytes.write(encode);
                    bytes.write("\n".getBytes());
                    bytes.flush();
                    if (bytes != 0) {
                        try {
                            bytes.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bytes != 0) {
                        try {
                            bytes.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (bytes != 0) {
                    try {
                        bytes.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bytes = 0;
        } catch (Throwable th2) {
            th = th2;
            bytes = 0;
            if (bytes != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [188=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(ah ahVar, boolean z) {
        BufferedReader bufferedReader;
        File file = new File(this.mContext.getFilesDir(), "ubcdir");
        if (!file.exists()) {
            file.mkdir();
        }
        boolean a = z ? false : a(ahVar);
        File file2 = new File(file, z ? "filereal" : "filedata");
        if (file2.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                long j = Long.MAX_VALUE;
                long j2 = 0;
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                            if (jSONObject.has("abtest")) {
                                ahVar.tV("1");
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
                            ahVar.cx(jSONObject);
                            a = true;
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
                            return a;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                if (DEBUG) {
                                    Log.d("UBCFileData", "getExceptionList close fail:", e3);
                                }
                            }
                        }
                        throw th;
                    }
                }
                ahVar.s(j, j2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e4) {
                        if (DEBUG) {
                            Log.d("UBCFileData", "getExceptionList close fail:", e4);
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                throw th;
            }
        }
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=4] */
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
                                ahVar.tV("1");
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
                            ahVar.cx(jSONObject);
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
                ahVar.s(j, j2);
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
    public void gl(boolean z) {
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
