package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y40 extends o40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // com.baidu.tieba.q40
    public String a(String str, String str2, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        OutputStream outputStream;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, map, jSONObject)) != null) {
            return (String) invokeLLLL.objValue;
        }
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("urlStr should not be null");
        }
        ?? r1 = 0;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(str2);
                if (map != null && map.size() > 0) {
                    for (String str3 : map.keySet()) {
                        httpURLConnection.setRequestProperty(str3, map.get(str3));
                    }
                    httpURLConnection.setRequestProperty("Content-type", "application/json");
                }
                outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(jSONObject.toString().getBytes("utf-8"));
                    outputStream2.flush();
                    if (httpURLConnection.getResponseCode() != 200) {
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                    String str4 = "";
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str4 = str4 + readLine;
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            r1 = httpURLConnection;
                            outputStream = outputStream2;
                            th = th;
                            if (r1 != 0) {
                                r1.disconnect();
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return str4;
                } catch (UnsupportedEncodingException unused2) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return null;
                } catch (MalformedURLException unused3) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    return null;
                } catch (ProtocolException unused4) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    return null;
                } catch (IOException unused5) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    r1 = httpURLConnection;
                    outputStream = outputStream2;
                    th = th2;
                    bufferedReader = null;
                }
            } catch (UnsupportedEncodingException unused6) {
                outputStream2 = null;
            } catch (MalformedURLException unused7) {
                outputStream2 = null;
            } catch (ProtocolException unused8) {
                outputStream2 = null;
            } catch (IOException unused9) {
                outputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                r1 = httpURLConnection;
                outputStream = null;
            }
        } catch (UnsupportedEncodingException unused10) {
            httpURLConnection = null;
            outputStream2 = null;
        } catch (MalformedURLException unused11) {
            httpURLConnection = null;
            outputStream2 = null;
        } catch (ProtocolException unused12) {
            httpURLConnection = null;
            outputStream2 = null;
        } catch (IOException unused13) {
            httpURLConnection = null;
            outputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            bufferedReader = null;
        }
    }
}
