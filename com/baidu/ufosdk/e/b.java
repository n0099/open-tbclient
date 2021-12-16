package com.baidu.ufosdk.e;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.f.c;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes13.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x015c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014a A[Catch: Exception -> 0x0146, TryCatch #9 {Exception -> 0x0146, blocks: (B:58:0x0142, B:62:0x014a, B:64:0x014f, B:66:0x0154), top: B:90:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014f A[Catch: Exception -> 0x0146, TryCatch #9 {Exception -> 0x0146, blocks: (B:58:0x0142, B:62:0x014a, B:64:0x014f, B:66:0x0154), top: B:90:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0154 A[Catch: Exception -> 0x0146, TRY_LEAVE, TryCatch #9 {Exception -> 0x0146, blocks: (B:58:0x0142, B:62:0x014a, B:64:0x014f, B:66:0x0154), top: B:90:0x0142 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0167 A[Catch: Exception -> 0x0163, TryCatch #11 {Exception -> 0x0163, blocks: (B:72:0x015f, B:76:0x0167, B:78:0x016c, B:80:0x0171), top: B:94:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016c A[Catch: Exception -> 0x0163, TryCatch #11 {Exception -> 0x0163, blocks: (B:72:0x015f, B:76:0x0167, B:78:0x016c, B:80:0x0171), top: B:94:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0171 A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #11 {Exception -> 0x0163, blocks: (B:72:0x015f, B:76:0x0167, B:78:0x016c, B:80:0x0171), top: B:94:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader2;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65536, null, str, str2)) != null) {
            return (String) invokeLL.objValue;
        }
        StringBuffer stringBuffer = new StringBuffer();
        DataOutputStream dataOutputStream2 = null;
        r2 = null;
        r2 = null;
        BufferedReader bufferedReader2 = null;
        dataOutputStream2 = null;
        try {
            c.b("params is " + str2);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                if (a == null) {
                    a = "UfoSDK/2.9.10 (" + e.a() + " " + e.b() + SmallTailInfo.EMOTION_SUFFIX;
                }
                httpURLConnection.setRequestProperty("User-Agent", a);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                httpURLConnection.setRequestProperty("contentType", "utf-8");
                DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream3.writeBytes(str2);
                    dataOutputStream3.flush();
                    dataOutputStream3.close();
                    c.b("responseCode is " + httpURLConnection.getResponseCode());
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader2);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuffer.append(readLine);
                                    stringBuffer.append(StringUtils.LF);
                                } catch (Exception e2) {
                                    dataOutputStream = dataOutputStream3;
                                    inputStreamReader = inputStreamReader2;
                                    e = e2;
                                    dataOutputStream2 = dataOutputStream;
                                    bufferedReader = bufferedReader;
                                    try {
                                        c.a("httpURLConnSender exp!", e);
                                        String stringBuffer2 = stringBuffer.toString();
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                return stringBuffer2;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        return stringBuffer2;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        if (bufferedReader != 0) {
                                            bufferedReader.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataOutputStream2 = dataOutputStream3;
                                    inputStreamReader = inputStreamReader2;
                                    th = th;
                                    if (dataOutputStream2 != null) {
                                    }
                                    if (httpURLConnection != null) {
                                    }
                                    if (bufferedReader != 0) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    throw th;
                                }
                            }
                            c.a("httpURLConnSender response: " + stringBuffer.toString());
                            inputStreamReader2.close();
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (Exception e5) {
                            dataOutputStream = dataOutputStream3;
                            inputStreamReader = inputStreamReader2;
                            e = e5;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                        }
                    } else {
                        inputStreamReader2 = null;
                    }
                    httpURLConnection.disconnect();
                    String stringBuffer3 = stringBuffer.toString();
                    try {
                        dataOutputStream3.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    return stringBuffer3;
                } catch (Exception e7) {
                    e = e7;
                    bufferedReader = 0;
                    dataOutputStream2 = dataOutputStream3;
                    inputStreamReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = 0;
                    dataOutputStream2 = dataOutputStream3;
                    inputStreamReader = null;
                }
            } catch (Exception e8) {
                e = e8;
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                c.a("httpURLConnSender exp!", e);
                String stringBuffer22 = stringBuffer.toString();
                if (dataOutputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                if (bufferedReader != 0) {
                }
                if (inputStreamReader != null) {
                }
                return stringBuffer22;
            } catch (Throwable th5) {
                th = th5;
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                if (dataOutputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                if (bufferedReader != 0) {
                }
                if (inputStreamReader != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            httpURLConnection = null;
            inputStreamReader = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            inputStreamReader = null;
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
                httpURLConnection.setRequestProperty("contentType", "utf-8");
                if (httpURLConnection.getResponseCode() == 200) {
                    c.a("^^ httpURLConnGet success! ^^");
                    httpURLConnection.disconnect();
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                }
                c.a("^^ httpURLConnGet false! ^^");
                httpURLConnection.disconnect();
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            } catch (Exception e5) {
                e = e5;
                httpURLConnection2 = httpURLConnection;
                e.printStackTrace();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }
}
