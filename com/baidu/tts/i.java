package com.baidu.tts;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.google.zxing.client.result.ResultParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i extends m1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public int c;
    public String d;
    public Context e;
    public String f;

    @Override // com.baidu.tts.m1
    public void a(int i, Map map, String str, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), map, str, bArr, th}) == null) {
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -2;
        this.e = b1.d().b();
    }

    public final JSONObject a(byte[] bArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            try {
                str = new String(bArr, StandardCharsets.UTF_8.name());
                if (str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
                    str = str.substring(1);
                }
            } catch (UnsupportedEncodingException e) {
                LoggerProxy.e("JsonResponseHandler", "Encoding response into string failed" + e.toString());
                str = null;
            }
            if (str == null) {
                return null;
            }
            return new JSONObject(str.trim());
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tts.m1
    public void a(int i, Map map, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), map, str, bArr}) == null) {
            try {
                JSONObject a = a(bArr);
                if (a != null) {
                    a(i, map, a);
                } else {
                    a(i, map, new JSONException("Unexpected response type JsonResponseHandler"), (JSONObject) null);
                }
            } catch (JSONException e) {
                a(i, map, e, (JSONObject) null);
                e.printStackTrace();
            }
        }
    }

    public void a(int i, Map<String, List<String>> map, Throwable th, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), map, th, jSONObject}) == null) {
            LoggerProxy.d("GetLicenseHandler", "getLicense statusCode: " + i);
        }
    }

    public void a(int i, Map<String, List<String>> map, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i, map, jSONObject) == null) {
            n0 n0Var = n0.B;
            int optInt = jSONObject.optInt("err_no");
            this.c = optInt;
            LoggerProxy.d("GetLicenseHandler", " onSuccess statusCode: " + i + " errNo: " + optInt);
            n0 n0Var2 = n0.C;
            String optString = jSONObject.optString(PmsConstant.Statistic.STATISTIC_ERRMSG);
            long optLong = jSONObject.optLong("expires");
            long optLong2 = jSONObject.optLong("time");
            String a = w0.a("AndroidTTS", this.b);
            w0.a(this.e, a, "getLicense_expires", optLong);
            SharedPreferences.Editor edit = this.e.getSharedPreferences(a, 0).edit();
            edit.putInt("getLicense_err_no", optInt);
            edit.commit();
            if (!TextUtils.isEmpty(this.f)) {
                Context context = this.e;
                String str = this.f;
                SharedPreferences.Editor edit2 = context.getSharedPreferences(a, 0).edit();
                edit2.putString("SN", str);
                edit2.commit();
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - optLong2;
            if (j < 60000 && j > 0) {
                w0.a(this.e, a, "getLicense_time", optLong2);
            } else {
                w0.a(this.e, a, "getLicense_time", currentTimeMillis);
            }
            String replaceAll = jSONObject.optString("license").replaceAll("license_begin|license_end", "");
            if (optInt == 0 && !replaceAll.isEmpty()) {
                File file = new File(this.d);
                if (file.exists()) {
                    File file2 = new File(this.d + "_new");
                    boolean a2 = a(this.d + "_new", replaceAll);
                    LoggerProxy.d("GetLicenseHandler", "isSave=" + a2);
                    boolean delete = file.delete();
                    LoggerProxy.d("GetLicenseHandler", "isDelete=" + delete);
                    boolean renameTo = file2.renameTo(file);
                    LoggerProxy.d("GetLicenseHandler", "isRename=" + renameTo);
                } else {
                    boolean a3 = a(this.d, replaceAll);
                    LoggerProxy.d("GetLicenseHandler", "isSave=" + a3);
                }
                SharedPreferences.Editor edit3 = this.e.getSharedPreferences(a, 0).edit();
                edit3.putBoolean("isRegister", true);
                edit3.commit();
            }
            LoggerProxy.d("GetLicenseHandler", "getLicense statusCode: " + i + " err_msg: " + optString + " err_no: " + optInt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(str);
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            try {
                fileOutputStream.write(str2.getBytes(StandardCharsets.UTF_8));
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return true;
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                try {
                    LoggerProxy.d("GetLicenseHandler", "download license success, write file failed");
                    this.c = -1010;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                th = th;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
