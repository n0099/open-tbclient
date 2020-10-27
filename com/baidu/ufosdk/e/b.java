package com.baidu.ufosdk.e;

import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.f.c;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f3708a;

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fa A[Catch: Exception -> 0x0147, TryCatch #10 {Exception -> 0x0147, blocks: (B:20:0x00f5, B:22:0x00fa, B:24:0x00ff, B:26:0x0104), top: B:81:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ff A[Catch: Exception -> 0x0147, TryCatch #10 {Exception -> 0x0147, blocks: (B:20:0x00f5, B:22:0x00fa, B:24:0x00ff, B:26:0x0104), top: B:81:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0104 A[Catch: Exception -> 0x0147, TRY_LEAVE, TryCatch #10 {Exception -> 0x0147, blocks: (B:20:0x00f5, B:22:0x00fa, B:24:0x00ff, B:26:0x0104), top: B:81:0x00f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0157 A[Catch: Exception -> 0x0165, TryCatch #12 {Exception -> 0x0165, blocks: (B:46:0x0152, B:48:0x0157, B:50:0x015c, B:52:0x0161), top: B:83:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c A[Catch: Exception -> 0x0165, TryCatch #12 {Exception -> 0x0165, blocks: (B:46:0x0152, B:48:0x0157, B:50:0x015c, B:52:0x0161), top: B:83:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0161 A[Catch: Exception -> 0x0165, TRY_LEAVE, TryCatch #12 {Exception -> 0x0165, blocks: (B:46:0x0152, B:48:0x0157, B:50:0x015c, B:52:0x0161), top: B:83:0x0152 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        InputStreamReader inputStreamReader;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        r2 = null;
        inputStreamReader2 = null;
        BufferedReader bufferedReader3 = null;
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
                if (f3708a == null) {
                    f3708a = "UfoSDK/2.9.10 (" + e.a() + " " + e.b() + ")";
                }
                httpURLConnection2.setRequestProperty("User-Agent", f3708a);
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
                        InputStreamReader inputStreamReader3 = new InputStreamReader(httpURLConnection2.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader3);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine).append("\n");
                                } catch (Exception e) {
                                    bufferedReader3 = bufferedReader;
                                    dataOutputStream2 = dataOutputStream;
                                    inputStreamReader = inputStreamReader3;
                                    httpURLConnection = httpURLConnection2;
                                    e = e;
                                    try {
                                        c.a("httpURLConnSender exp!", e);
                                        String stringBuffer2 = stringBuffer.toString();
                                        if (dataOutputStream2 != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        if (bufferedReader3 != null) {
                                        }
                                        if (inputStreamReader == null) {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        dataOutputStream = dataOutputStream2;
                                        bufferedReader = bufferedReader3;
                                        inputStreamReader2 = inputStreamReader;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader2 != null) {
                                            inputStreamReader2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    inputStreamReader2 = inputStreamReader3;
                                    httpURLConnection = httpURLConnection2;
                                    th = th2;
                                    if (dataOutputStream != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            c.a("httpURLConnSender response: " + stringBuffer.toString());
                            inputStreamReader3.close();
                            bufferedReader.close();
                            inputStreamReader2 = inputStreamReader3;
                            bufferedReader2 = bufferedReader;
                        } catch (Exception e3) {
                            dataOutputStream2 = dataOutputStream;
                            httpURLConnection = httpURLConnection2;
                            e = e3;
                            inputStreamReader = inputStreamReader3;
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            inputStreamReader2 = inputStreamReader3;
                            httpURLConnection = httpURLConnection2;
                            th = th3;
                        }
                    } else {
                        bufferedReader2 = null;
                    }
                    try {
                        httpURLConnection2.disconnect();
                        String stringBuffer3 = stringBuffer.toString();
                        try {
                            dataOutputStream.close();
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return stringBuffer3;
                    } catch (Exception e5) {
                        dataOutputStream2 = dataOutputStream;
                        InputStreamReader inputStreamReader4 = inputStreamReader2;
                        bufferedReader3 = bufferedReader2;
                        httpURLConnection = httpURLConnection2;
                        e = e5;
                        inputStreamReader = inputStreamReader4;
                        c.a("httpURLConnSender exp!", e);
                        String stringBuffer22 = stringBuffer.toString();
                        if (dataOutputStream2 != null) {
                            try {
                                dataOutputStream2.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return stringBuffer22;
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        if (inputStreamReader == null) {
                            inputStreamReader.close();
                            return stringBuffer22;
                        }
                        return stringBuffer22;
                    } catch (Throwable th4) {
                        bufferedReader = bufferedReader2;
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (dataOutputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream2 = dataOutputStream;
                    e = e7;
                    inputStreamReader = null;
                } catch (Throwable th5) {
                    bufferedReader = null;
                    httpURLConnection = httpURLConnection2;
                    th = th5;
                }
            } catch (Exception e8) {
                httpURLConnection = httpURLConnection2;
                dataOutputStream2 = null;
                e = e8;
                inputStreamReader = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                httpURLConnection = httpURLConnection2;
                dataOutputStream = null;
                th = th6;
            }
        } catch (Exception e9) {
            e = e9;
            inputStreamReader = null;
            httpURLConnection = null;
            dataOutputStream2 = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedReader = null;
            httpURLConnection = null;
            dataOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        ?? r0;
        HttpURLConnection httpURLConnection3 = null;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
            httpURLConnection = null;
        } catch (Throwable th) {
            th = th;
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
            if (httpURLConnection2.getResponseCode() == 200) {
                c.a("^^ httpURLConnGet success! ^^");
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                r0 = 1;
            } else {
                c.a("^^ httpURLConnGet false! ^^");
                httpURLConnection2.disconnect();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                r0 = 0;
            }
            return r0;
        } catch (Exception e4) {
            httpURLConnection = r0;
            e = e4;
            try {
                e.printStackTrace();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection3 = httpURLConnection;
                if (httpURLConnection3 != null) {
                    try {
                        httpURLConnection3.disconnect();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            httpURLConnection3 = r0;
            th = th3;
            if (httpURLConnection3 != null) {
            }
            throw th;
        }
    }
}
