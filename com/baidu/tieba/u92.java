package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.spswitch.emotion.Emoticons;
import com.baidu.tieba.ph3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.channels.FileChannel;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165755, "Lcom/baidu/tieba/u92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165755, "Lcom/baidu/tieba/u92;");
                return;
            }
        }
        a = rr1.a;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return ou2.o().N();
        }
        return invokeV.booleanValue;
    }

    public static void a(File file, File file2) throws IOException {
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, file, file2) == null) {
            FileChannel fileChannel2 = 0;
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    fileChannel2.transferFrom(channel, 0L, channel.size());
                    lr4.d(channel);
                    lr4.d(fileChannel2);
                } catch (Throwable th) {
                    th = th;
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel3;
                    lr4.d(fileChannel2);
                    lr4.d(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        }
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            c(str, str2, str3, false);
        }
    }

    public static void c(String str, String str2, String str3, boolean z) {
        FileInputStream fileInputStream;
        BufferedWriter bufferedWriter;
        File file;
        File file2;
        File file3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            BufferedReader bufferedReader = null;
            try {
                file = new File(str);
                String absolutePath = file.getParentFile().getAbsolutePath();
                String name = file.getName();
                file2 = new File(absolutePath + File.separator + name + ".tmp");
                file3 = new File(absolutePath + File.separator + name + ".bak");
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
                bufferedWriter = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
                bufferedWriter = null;
            }
            if (z) {
                if (file3.exists()) {
                    file3.renameTo(file);
                }
                lr4.d(null);
                lr4.d(null);
                lr4.d(null);
                return;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2));
                try {
                    if (file3.exists()) {
                        a(file3, file);
                    } else {
                        a(file, file3);
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                    boolean z2 = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.contains(str2)) {
                                bufferedWriter.write(str3 + "\n");
                                z2 = true;
                            }
                            bufferedWriter.write(readLine + "\n");
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            Exception exc = e;
                            fileInputStream = fileInputStream2;
                            e = exc;
                            try {
                                e.printStackTrace();
                                lr4.d(bufferedReader);
                                lr4.d(fileInputStream);
                                lr4.d(bufferedWriter);
                            } catch (Throwable th2) {
                                th = th2;
                                lr4.d(bufferedReader);
                                lr4.d(fileInputStream);
                                lr4.d(bufferedWriter);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            Throwable th4 = th;
                            fileInputStream = fileInputStream2;
                            th = th4;
                            lr4.d(bufferedReader);
                            lr4.d(fileInputStream);
                            lr4.d(bufferedWriter);
                            throw th;
                        }
                    }
                    bufferedWriter.flush();
                    if (z2) {
                        file2.renameTo(file);
                    } else {
                        file2.delete();
                    }
                    lr4.d(bufferedReader2);
                    lr4.d(fileInputStream2);
                } catch (Exception e3) {
                    e = e3;
                    bufferedWriter = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = null;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedWriter = null;
            } catch (Throwable th6) {
                th = th6;
                bufferedWriter = null;
            }
            lr4.d(bufferedWriter);
        }
    }

    public static void e(@NonNull Context context) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                Class<?> cls = Class.forName("android.content.res.AssetManager");
                Field declaredField = cls.getDeclaredField("mStringBlocks");
                boolean z3 = true;
                declaredField.setAccessible(true);
                Object[] objArr = (Object[]) declaredField.get(context.getAssets());
                if (objArr == null) {
                    jSONObject.put("stringBlocks", StringUtil.NULL_STRING);
                } else {
                    jSONObject.put("stringBlocks size", objArr.length);
                    for (int i = 0; i < objArr.length; i++) {
                        String str = "stringBlocks " + i;
                        StringBuilder sb = new StringBuilder();
                        sb.append(" == null :");
                        if (objArr[i] == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        sb.append(z);
                        jSONObject.put(str, sb.toString());
                    }
                }
                Field declaredField2 = cls.getDeclaredField("sSystem");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(cls);
                Field declaredField3 = cls.getDeclaredField("mStringBlocks");
                declaredField3.setAccessible(true);
                Object[] objArr2 = (Object[]) declaredField3.get(obj);
                if (objArr2 == null) {
                    jSONObject.put("stringBlocksSys", StringUtil.NULL_STRING);
                } else {
                    jSONObject.put("stringBlocksSys size", objArr2.length);
                    for (int i2 = 0; i2 < objArr2.length; i2++) {
                        String str2 = "stringBlocksSys " + i2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" == null :");
                        if (objArr2[i2] == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        sb2.append(z2);
                        jSONObject.put(str2, sb2.toString());
                    }
                }
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.View, Resources.getSystem().getIdentifier("webViewStyle", Emoticons.KEY_ATTR, "android"), 0);
                if (obtainStyledAttributes == null) {
                    jSONObject.put("TypedArray", StringUtil.NULL_STRING);
                } else {
                    jSONObject.put("TypedArray ", obtainStyledAttributes.toString());
                    jSONObject.put("TypedArray mLength", obtainStyledAttributes.length());
                    Field declaredField4 = obtainStyledAttributes.getClass().getDeclaredField("mRecycled");
                    declaredField4.setAccessible(true);
                    jSONObject.put("TypedArray mRecycled", declaredField4.get(obtainStyledAttributes));
                    Field declaredField5 = obtainStyledAttributes.getClass().getDeclaredField("mAssets");
                    declaredField5.setAccessible(true);
                    if (declaredField5.get(obtainStyledAttributes) != context.getAssets()) {
                        z3 = false;
                    }
                    jSONObject.put("TypedArray mAssets", z3);
                    obtainStyledAttributes.recycle();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                if (a) {
                    Log.d("SwanAppCoreUtils", "reportFatalInfo: empty");
                    return;
                }
                return;
            }
            if (a) {
                Log.d("SwanAppCoreUtils", "reportFatalInfo: " + jSONObject2);
            }
            ph3.b bVar = new ph3.b(10006);
            bVar.i(jSONObject2);
            bVar.h(hb3.g0());
            bVar.m();
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put("package", AppRuntime.getApplication().getPackageName());
                jSONObject.put("processName", ProcessUtils.getCurProcessName());
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str2);
                jSONObject.put("errMessage", str3);
                jSONObject.put("isMainThread", bp3.O());
                String jSONObject2 = jSONObject.toString();
                if (a && TextUtils.isEmpty(jSONObject2)) {
                    Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: empty");
                    return;
                }
                if (a) {
                    Log.d("SwanAppCoreUtils", "reportInsertHistoryCrash: " + jSONObject2);
                }
                ph3.b bVar = new ph3.b(10008);
                bVar.i(jSONObject2);
                bVar.h(hb3.g0());
                bVar.m();
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            c(str, null, null, true);
        }
    }
}
