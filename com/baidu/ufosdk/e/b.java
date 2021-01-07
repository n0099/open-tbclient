package com.baidu.ufosdk.e;

import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.f.c;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f5657a;

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f5 A[Catch: Exception -> 0x0140, TryCatch #6 {Exception -> 0x0140, blocks: (B:20:0x00f0, B:22:0x00f5, B:24:0x00fa, B:26:0x00ff), top: B:76:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00fa A[Catch: Exception -> 0x0140, TryCatch #6 {Exception -> 0x0140, blocks: (B:20:0x00f0, B:22:0x00f5, B:24:0x00fa, B:26:0x00ff), top: B:76:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ff A[Catch: Exception -> 0x0140, TRY_LEAVE, TryCatch #6 {Exception -> 0x0140, blocks: (B:20:0x00f0, B:22:0x00f5, B:24:0x00fa, B:26:0x00ff), top: B:76:0x00f0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0152 A[Catch: Exception -> 0x0160, TryCatch #5 {Exception -> 0x0160, blocks: (B:45:0x014d, B:47:0x0152, B:49:0x0157, B:51:0x015c), top: B:74:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0157 A[Catch: Exception -> 0x0160, TryCatch #5 {Exception -> 0x0160, blocks: (B:45:0x014d, B:47:0x0152, B:49:0x0157, B:51:0x015c), top: B:74:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015c A[Catch: Exception -> 0x0160, TRY_LEAVE, TryCatch #5 {Exception -> 0x0160, blocks: (B:45:0x014d, B:47:0x0152, B:49:0x0157, B:51:0x015c), top: B:74:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        Exception e;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            c.b("params is " + str2);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setInstanceFollowRedirects(true);
                if (f5657a == null) {
                    f5657a = "UfoSDK/2.9.10 (" + e.a() + " " + e.b() + ")";
                }
                httpURLConnection2.setRequestProperty("User-Agent", f5657a);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setChunkedStreamingMode(0);
                httpURLConnection2.setRequestProperty("Accept-Charset", "utf-8");
                httpURLConnection2.setRequestProperty(CameraActivityConfig.KEY_CONTENT_TYPE, "utf-8");
                dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream.writeBytes(str2);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    c.b("responseCode is " + httpURLConnection2.getResponseCode());
                    if (httpURLConnection2.getResponseCode() == 200) {
                        inputStreamReader = new InputStreamReader(httpURLConnection2.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine).append("\n");
                                } catch (Exception e2) {
                                    e = e2;
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        c.a("httpURLConnSender exp!", e);
                                        String stringBuffer2 = stringBuffer.toString();
                                        if (dataOutputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader == null) {
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection = httpURLConnection2;
                                    if (dataOutputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    throw th;
                                }
                            }
                            c.a("httpURLConnSender response: " + stringBuffer.toString());
                            inputStreamReader.close();
                            bufferedReader.close();
                        } catch (Exception e4) {
                            e = e4;
                            bufferedReader = null;
                            httpURLConnection = httpURLConnection2;
                            c.a("httpURLConnSender exp!", e);
                            String stringBuffer22 = stringBuffer.toString();
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    return stringBuffer22;
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader == null) {
                                inputStreamReader.close();
                                return stringBuffer22;
                            }
                            return stringBuffer22;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = null;
                            httpURLConnection = httpURLConnection2;
                            if (dataOutputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            throw th;
                        }
                    } else {
                        inputStreamReader = null;
                        bufferedReader = null;
                    }
                    httpURLConnection2.disconnect();
                    String stringBuffer3 = stringBuffer.toString();
                    try {
                        dataOutputStream.close();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    return stringBuffer3;
                } catch (Exception e7) {
                    e = e7;
                    inputStreamReader = null;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (Exception e8) {
                e = e8;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0003 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    public static boolean a(String str) {
        Exception e;
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        ?? r0;
        int i = null;
        HttpURLConnection httpURLConnection3 = null;
        try {
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = i;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            httpURLConnection2.setRequestMethod("GET");
            httpURLConnection2.setDoInput(true);
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setUseCaches(false);
            httpURLConnection2.setInstanceFollowRedirects(true);
            httpURLConnection2.setConnectTimeout(5000);
            httpURLConnection2.setReadTimeout(5000);
            httpURLConnection2.setRequestProperty("Accept-Charset", "utf-8");
            httpURLConnection2.setRequestProperty(CameraActivityConfig.KEY_CONTENT_TYPE, "utf-8");
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode == 200) {
                ?? r3 = "^^ httpURLConnGet success! ^^";
                c.a("^^ httpURLConnGet success! ^^");
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                r0 = 1;
                i = r3;
            } else {
                c.a("^^ httpURLConnGet false! ^^");
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                r0 = 0;
                i = responseCode;
            }
            return r0;
        } catch (Exception e5) {
            e = e5;
            httpURLConnection3 = r0;
            e.printStackTrace();
            if (httpURLConnection3 != null) {
                try {
                    httpURLConnection3.disconnect();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = r0;
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }
}
