package com.baidu.ufosdk;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.ar.pose.PoseAR;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.FeedbackConfigurations;
import com.baidu.ufosdk.hybrid.base.WebLoaderActivity;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Display a;
    public static int b;
    public static int c;
    public static IConfigurations d;
    @SuppressLint({"StaticFieldLeak"})
    public static Context e;
    public static Handler f;
    public static long g;
    public static ContentResolver h;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, context, f2)) == null) {
            return (int) (context.getResources().getDisplayMetrics().density * f2);
        }
        return invokeLF.intValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, str2)) == null) {
            return PreferencesUtil.LEFT_MOUNT + str + "] " + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i, i2)) == null) {
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i3 <= i2 && i4 <= i) {
                return 1;
            }
            int min = Math.min(Math.round(i3 / i2), Math.round(i4 / i));
            while ((i4 * i3) / (min * min) > i * i2 * 2) {
                min++;
            }
            return min;
        }
        return invokeLII.intValue;
    }

    public static Intent a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            return a(context, i, "", "", "");
        }
        return (Intent) invokeLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, int i, String str, String str2, String str3) {
        InterceptResult invokeCommon;
        Intent intent;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Integer.valueOf(i), str, str2, str3})) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 5) {
                                if (i != 6) {
                                    intent2 = null;
                                    if (intent2 != null) {
                                        intent2.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                                    }
                                    return intent2;
                                }
                                intent = new Intent(context, ScreenCapEditActivity.class);
                                if (!TextUtils.isEmpty(str3)) {
                                    intent.putExtra("shot", Base64.decode(str3, 0));
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    intent.putExtra("image_path", str2);
                                }
                                intent.putExtra("from_app", true);
                            } else {
                                intent = new Intent(context, FeedbackReportActivity.class);
                                if (!TextUtils.isEmpty(str3)) {
                                    intent.putExtra("shot", Base64.decode(str3, 0));
                                }
                            }
                        } else {
                            intent = new Intent(context, FeedbackListActivity.class);
                        }
                    } else {
                        intent = new Intent(context, FeedbackEditActivity.class);
                        intent.putExtra("fromlist", "no");
                        intent.putExtra("come_from", 2);
                        if (!TextUtils.isEmpty(str3)) {
                            intent.putExtra("shot", Base64.decode(str3, 0));
                        }
                    }
                } else {
                    intent = new Intent(context, FeedbackInputActivity.class);
                    intent.putExtra("currentview", 1);
                }
            } else {
                intent = new Intent(context, WebLoaderActivity.class);
                intent.putExtra("help_center_url", str);
            }
            intent2 = intent;
            if (intent2 != null) {
            }
            return intent2;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return i(context).getString("ufo_sg_ad", "");
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) {
            return i(context).getString("ufo_sg_cd", "");
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) {
            return i(context).getString("ufo_sg_dd", "");
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) {
            return i(context).getString("ufo_sg_pd", "");
        }
        return (String) invokeL.objValue;
    }

    public static SharedPreferences i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) {
            try {
                return context.getSharedPreferences("UfoSharePreference", 0);
            } catch (Exception unused) {
                return d().getSharedPreferences("UfoSharePreference", 0);
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static String a(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, intent, str)) == null) {
            if (intent == null) {
                return null;
            }
            try {
                return intent.getStringExtra(str);
            } catch (Exception unused) {
                intent.replaceExtras((Bundle) null);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str) {
        SecretKeySpec secretKeySpec;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                try {
                    secretKeySpec = new SecretKeySpec(j().getBytes(), "AES");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    secretKeySpec = null;
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(i().getBytes()));
                return new String(cipher.doFinal(Base64.decode(str, 0))).trim();
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            if (b == 0) {
                if (a == null) {
                    a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                }
                Point point = new Point();
                a.getSize(point);
                b = point.x;
                c = point.y;
            }
            int[] iArr = {b, c};
            return iArr[0] + "x" + iArr[1];
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            Random random = new Random();
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < random.nextInt(1) + charArray.length; i++) {
                stringBuffer.append(Integer.toHexString(charArray[i]));
            }
            if (z) {
                return stringBuffer.reverse().toString();
            }
            return stringBuffer.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public static String b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65563, null, str, z)) == null) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bytes);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (z) {
                        hexString = hexString.toUpperCase();
                    }
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                    sb.append("");
                }
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLZ.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String a(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    Object obj = map.get(str);
                    if (obj instanceof String) {
                        jSONObject.put(str, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str, obj);
                    } else if (obj instanceof Long) {
                        jSONObject.put(str, obj);
                    } else if (obj instanceof Float) {
                        jSONObject.put(str, obj);
                    } else {
                        String str2 = "mapRecord2JSON: unexpected key[" + str + "]'s value " + obj;
                    }
                } catch (JSONException unused) {
                    String str3 = "Could not create JSON object for key " + str;
                }
            }
            String str4 = "json is " + jSONObject.toString();
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"TrulyRandom"})
    public static String b(String str) {
        InterceptResult invokeL;
        SecretKeySpec secretKeySpec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            byte[] bArr = null;
            try {
                try {
                    secretKeySpec = new SecretKeySpec(j().getBytes(), "AES");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    secretKeySpec = null;
                }
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                int blockSize = cipher.getBlockSize();
                byte[] bytes = str.getBytes();
                int length = bytes.length;
                if (length % blockSize != 0) {
                    length += blockSize - (length % blockSize);
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
                cipher.init(1, secretKeySpec, new IvParameterSpec(i().getBytes()));
                bArr = cipher.doFinal(bArr2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return new String(Base64.encodeToString(bArr, 0));
        }
        return (String) invokeL.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, null) == null) && d == null) {
            try {
                Context d2 = d();
                if (d2 == null) {
                    d = new FeedbackConfigurations.Builder().build();
                    return;
                }
                IConfigurations appConfigurations = FeedbackManager.getInstance(d2).getAppConfigurations();
                d = appConfigurations;
                if (appConfigurations != null) {
                    return;
                }
                FeedbackConfigurations.Builder builder = new FeedbackConfigurations.Builder();
                builder.setAppIdentifier(c.a(), c.b());
                String string = i(d2).getString("ufo_papo_acc", "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(a(string));
                    builder.setAccount(jSONObject.optString("accountName"), jSONObject.optString("accountUid"));
                }
                d = builder.build();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, int i, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z), str}) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, 102);
            bundle.putInt("feedback_source", i);
            bundle.putInt("submit_status", z ? 1 : 0);
            bundle.putString("feedback_info", str);
            a(context, bundle);
        }
    }

    public static void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, context, j) == null) {
            u1.a(i(context).edit().putLong("Ufolastsendtime", j));
        }
    }

    public static void a(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            try {
                Intent intent = new Intent("com.baidu.ufosdk.ACTION_CALLBACK");
                intent.addCategory(c.a());
                intent.setPackage(c.a());
                intent.putExtras(bundle);
                context.sendBroadcast(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, 101);
            bundle.putInt("ufo_register", !TextUtils.isEmpty(str) ? 1 : 0);
            bundle.putString("ufo_appkey", str);
            a(context, bundle);
        }
    }

    public static void a(File file, boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, file, z) == null) {
            if (file.exists()) {
                if (file.isFile()) {
                    a(file);
                    return;
                } else if (file.isDirectory()) {
                    if (z && (listFiles = file.listFiles()) != null) {
                        for (File file2 : listFiles) {
                            a(file2, true);
                        }
                    }
                    a(file);
                    return;
                } else {
                    return;
                }
            }
            Log.i("FeedbackSDK-V4.1.9.1", b("FileHelper", "Cannot delete " + file.getAbsolutePath() + ", which not found"));
        }
    }

    public static void a(CharSequence charSequence, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, charSequence, i) == null) {
            f.post(new l1(charSequence, i));
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) {
            Log.e("FeedbackSDK-V4.1.9.1", b(str, str2));
        }
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, str2, th) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(" Exception: ");
            StringWriter stringWriter = new StringWriter(1024);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            sb.append(stringWriter.toString());
            Log.e("FeedbackSDK-V4.1.9.1", b(str, sb.toString()));
        }
    }

    public static boolean a(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65554, null, context, str, i, str2)) == null) {
            e0 a2 = e0.a(context);
            String str3 = s1.d;
            String str4 = "FeedbackChatSender --> sendSolvedResult:" + str3;
            HashMap hashMap = new HashMap();
            if (str2 != null && str2.length() > 0) {
                hashMap.put("appid", str2);
            } else {
                hashMap.put("appid", a2.b);
            }
            hashMap.put("id", str);
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("evaluation", Integer.valueOf(i));
            String b2 = b(a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                String a3 = d0.a(str3, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a3)) {
                    String a4 = a(a3);
                    String str5 = "^^ sendSolvedResult response is: \n" + a4;
                    if (((Integer) new JSONObject(a4).get("errno")).intValue() != 0) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:69|70|(2:72|73)(1:104)|74|75|(2:77|(7:86|87|88|(2:90|(1:95)(1:94))|96|(1:92)|95)(2:81|(1:85)))|100|(1:79)|86|87|88|(0)|96|(0)|95) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0201, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0202, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d2 A[Catch: all -> 0x02ae, Exception -> 0x02b2, TryCatch #9 {Exception -> 0x02b2, blocks: (B:14:0x0119, B:15:0x0139, B:17:0x013f, B:20:0x0156, B:21:0x0165, B:23:0x016f, B:28:0x0185, B:30:0x018b, B:32:0x01a1, B:71:0x0252, B:73:0x0267, B:75:0x0271, B:78:0x0278, B:79:0x027b, B:50:0x01d2, B:52:0x01d8, B:54:0x01e4, B:56:0x01ea, B:57:0x01ee, B:66:0x0208, B:68:0x020e, B:69:0x0221, B:63:0x0202, B:47:0x01cc, B:70:0x0238, B:80:0x028d), top: B:134:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fc A[Catch: Exception -> 0x0201, all -> 0x02ae, TRY_LEAVE, TryCatch #10 {all -> 0x02ae, blocks: (B:14:0x0119, B:15:0x0139, B:17:0x013f, B:20:0x0156, B:21:0x0165, B:23:0x016f, B:28:0x0185, B:30:0x018b, B:32:0x01a1, B:71:0x0252, B:73:0x0267, B:75:0x0271, B:78:0x0278, B:79:0x027b, B:34:0x01ae, B:36:0x01b4, B:39:0x01bd, B:41:0x01c3, B:50:0x01d2, B:52:0x01d8, B:54:0x01e4, B:56:0x01ea, B:57:0x01ee, B:58:0x01f6, B:60:0x01fc, B:66:0x0208, B:68:0x020e, B:69:0x0221, B:63:0x0202, B:47:0x01cc, B:70:0x0238, B:80:0x028d), top: B:134:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208 A[Catch: all -> 0x02ae, Exception -> 0x02b2, TryCatch #9 {Exception -> 0x02b2, blocks: (B:14:0x0119, B:15:0x0139, B:17:0x013f, B:20:0x0156, B:21:0x0165, B:23:0x016f, B:28:0x0185, B:30:0x018b, B:32:0x01a1, B:71:0x0252, B:73:0x0267, B:75:0x0271, B:78:0x0278, B:79:0x027b, B:50:0x01d2, B:52:0x01d8, B:54:0x01e4, B:56:0x01ea, B:57:0x01ee, B:66:0x0208, B:68:0x020e, B:69:0x0221, B:63:0x0202, B:47:0x01cc, B:70:0x0238, B:80:0x028d), top: B:134:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0267 A[Catch: all -> 0x02ae, Exception -> 0x02b2, TryCatch #9 {Exception -> 0x02b2, blocks: (B:14:0x0119, B:15:0x0139, B:17:0x013f, B:20:0x0156, B:21:0x0165, B:23:0x016f, B:28:0x0185, B:30:0x018b, B:32:0x01a1, B:71:0x0252, B:73:0x0267, B:75:0x0271, B:78:0x0278, B:79:0x027b, B:50:0x01d2, B:52:0x01d8, B:54:0x01e4, B:56:0x01ea, B:57:0x01ee, B:66:0x0208, B:68:0x020e, B:69:0x0221, B:63:0x0202, B:47:0x01cc, B:70:0x0238, B:80:0x028d), top: B:134:0x0119 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Context context2;
        String str3;
        String str4;
        String a2;
        Intent intent;
        String str5;
        ArrayList<? extends Parcelable> arrayList;
        Intent intent2;
        JSONArray jSONArray;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, str, str2)) == null) {
            String str8 = str;
            e0 a3 = e0.a(context);
            String str9 = s1.c;
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str2);
            hashMap.put("appvn", c.b());
            hashMap.put("clientid", a3.a);
            hashMap.put("devid", a3.c);
            String str10 = "id";
            hashMap.put("id", str8);
            hashMap.put("interval", String.valueOf(a.a));
            hashMap.put("model", "");
            hashMap.put("os", "android");
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("baiducuid", f());
            String str11 = "extra";
            hashMap.put("extra", g());
            hashMap.put("uid", c());
            hashMap.put(DpStatConstants.KEY_USER_ID, c());
            hashMap.put("username", b());
            hashMap.put("output_style", 1);
            String b2 = b(a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                a2 = d0.a(str9, d0.a(hashMap2));
            } catch (Exception unused) {
                context2 = context;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            } catch (Throwable th) {
                th = th;
                context2 = context;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
            if (!TextUtils.isEmpty(a2)) {
                String a4 = a(a2);
                String str12 = "response is " + a4;
                JSONObject jSONObject = new JSONObject(a4);
                StringBuilder sb = new StringBuilder();
                try {
                    try {
                        sb.append("response is -- >  ");
                        sb.append(a4);
                        sb.toString();
                        int intValue = ((Integer) jSONObject.get("errno")).intValue();
                        if (intValue == 0) {
                            try {
                                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                                Intent intent3 = new Intent("com.baidu.ufosdk.getchat");
                                if (jSONObject.getInt("msgnum") > 0) {
                                    JSONArray jSONArray2 = jSONObject.getJSONArray("msg");
                                    StringBuilder sb2 = new StringBuilder();
                                    try {
                                        try {
                                            sb2.append("postUrl:");
                                            sb2.append(str9);
                                            sb2.toString();
                                            String str13 = "getFeedbackAnswer2 --> msgArray : \n" + jSONArray2.toString();
                                            int i = 0;
                                            while (i < jSONArray2.length()) {
                                                HashMap hashMap3 = new HashMap();
                                                hashMap3.put(str10, str8);
                                                hashMap3.put("toggle", "no");
                                                if (jSONArray2.getJSONObject(i).has(str10)) {
                                                    hashMap3.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i).getInt(str10)));
                                                }
                                                if (jSONArray2.getJSONObject(i).has(str11)) {
                                                    str5 = jSONArray2.getJSONObject(i).getString(str11);
                                                } else {
                                                    str5 = null;
                                                }
                                                String str14 = str10;
                                                String str15 = str11;
                                                if (str5 != null && str5.length() != 0) {
                                                    intent2 = intent3;
                                                    JSONObject jSONObject2 = new JSONObject(str5);
                                                    int i2 = jSONObject2.getInt("flagRobot");
                                                    arrayList = arrayList2;
                                                    hashMap3.put("flagRobot", Integer.valueOf(i2));
                                                    if (i2 == 0) {
                                                        hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                    } else {
                                                        try {
                                                            if (jSONObject2.has("robot")) {
                                                                jSONArray = (JSONArray) jSONObject2.get("robot");
                                                            } else {
                                                                jSONArray = null;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            jSONArray = null;
                                                        }
                                                        try {
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            e.printStackTrace();
                                                            str6 = null;
                                                            if (jSONArray == null) {
                                                            }
                                                            hashMap3.put("flagRobot", 0);
                                                            if (jSONObject2.has("answer")) {
                                                            }
                                                            str7 = null;
                                                            if (str7 == null) {
                                                            }
                                                            hashMap3.put("flagRobot", 0);
                                                            hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                            hashMap3.put("toggle", "yes");
                                                            hashMap3.put("time", jSONArray2.getJSONObject(i).getString("time"));
                                                            if (jSONArray2.getJSONObject(i).has("evaluation")) {
                                                            }
                                                            ArrayList<? extends Parcelable> arrayList3 = arrayList;
                                                            arrayList3.add(hashMap3);
                                                            i++;
                                                            arrayList2 = arrayList3;
                                                            str10 = str14;
                                                            str11 = str15;
                                                            intent3 = intent2;
                                                            str8 = str;
                                                        }
                                                        if (jSONObject2.has("tip")) {
                                                            str6 = jSONObject2.getString("tip");
                                                            if (jSONArray == null && jSONArray.length() != 0) {
                                                                hashMap3.put("content", jSONArray.toString());
                                                                hashMap3.put("toggle", "no");
                                                                if (str6 != null && str6.length() > 0) {
                                                                    hashMap3.put("tip", str6);
                                                                }
                                                            } else {
                                                                hashMap3.put("flagRobot", 0);
                                                                if (jSONObject2.has("answer")) {
                                                                    str7 = jSONObject2.getString("answer");
                                                                    if (str7 == null && str7.length() > 0) {
                                                                        hashMap3.put("toggle", "yes");
                                                                        hashMap3.put("flagRobot", 0);
                                                                        hashMap3.put("content", jSONObject2.getString("answer"));
                                                                    } else {
                                                                        hashMap3.put("flagRobot", 0);
                                                                        hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                                        hashMap3.put("toggle", "yes");
                                                                    }
                                                                }
                                                                str7 = null;
                                                                if (str7 == null) {
                                                                }
                                                                hashMap3.put("flagRobot", 0);
                                                                hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                                hashMap3.put("toggle", "yes");
                                                            }
                                                        }
                                                        str6 = null;
                                                        if (jSONArray == null) {
                                                        }
                                                        hashMap3.put("flagRobot", 0);
                                                        if (jSONObject2.has("answer")) {
                                                        }
                                                        str7 = null;
                                                        if (str7 == null) {
                                                        }
                                                        hashMap3.put("flagRobot", 0);
                                                        hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                        hashMap3.put("toggle", "yes");
                                                    }
                                                } else {
                                                    arrayList = arrayList2;
                                                    intent2 = intent3;
                                                    hashMap3.put("toggle", "no");
                                                    hashMap3.put("flagRobot", 0);
                                                    hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                }
                                                hashMap3.put("time", jSONArray2.getJSONObject(i).getString("time"));
                                                if (jSONArray2.getJSONObject(i).has("evaluation")) {
                                                    int i3 = jSONArray2.getJSONObject(i).getInt("evaluation");
                                                    if (i3 == 0) {
                                                        hashMap3.put("toggle", "no");
                                                    }
                                                    if (i3 == 10) {
                                                        hashMap3.put("toggle", "yes");
                                                    }
                                                }
                                                ArrayList<? extends Parcelable> arrayList32 = arrayList;
                                                arrayList32.add(hashMap3);
                                                i++;
                                                arrayList2 = arrayList32;
                                                str10 = str14;
                                                str11 = str15;
                                                intent3 = intent2;
                                                str8 = str;
                                            }
                                            intent = intent3;
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelableArrayList("msgList", arrayList2);
                                            intent.putExtras(bundle);
                                            intent.setPackage(c.a());
                                            context2 = context;
                                        } catch (Exception unused2) {
                                            context2 = context;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        context2 = context;
                                    }
                                    try {
                                        context2.sendBroadcast(intent);
                                    } catch (Exception unused3) {
                                        str4 = "com.baidu.ufosdk.reload";
                                        str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                        Intent intent4 = new Intent(str4);
                                        intent4.setPackage(c.a());
                                        context2.sendBroadcast(intent4);
                                        Intent intent5 = new Intent(str3);
                                        intent5.setPackage(c.a());
                                        context2.sendBroadcast(intent5);
                                        return false;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                        Intent intent6 = new Intent(str3);
                                        intent6.setPackage(c.a());
                                        context2.sendBroadcast(intent6);
                                        throw th;
                                    }
                                } else {
                                    context2 = context;
                                }
                                Intent intent7 = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                                intent7.setPackage(c.a());
                                context2.sendBroadcast(intent7);
                                return true;
                            } catch (Exception unused4) {
                                context2 = context;
                                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            }
                        } else {
                            context2 = context;
                            str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            if (intValue != 0) {
                                try {
                                    try {
                                        str4 = "com.baidu.ufosdk.reload";
                                        try {
                                            Intent intent8 = new Intent(str4);
                                            intent8.setPackage(c.a());
                                            context2.sendBroadcast(intent8);
                                        } catch (Exception unused5) {
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        Intent intent62 = new Intent(str3);
                                        intent62.setPackage(c.a());
                                        context2.sendBroadcast(intent62);
                                        throw th;
                                    }
                                } catch (Exception unused6) {
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        context2 = context;
                    }
                } catch (Exception unused7) {
                    context2 = context;
                }
                str4 = "com.baidu.ufosdk.reload";
                Intent intent42 = new Intent(str4);
                intent42.setPackage(c.a());
                context2.sendBroadcast(intent42);
                Intent intent52 = new Intent(str3);
                intent52.setPackage(c.a());
                context2.sendBroadcast(intent52);
                return false;
            }
            context2 = context;
            str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            Intent intent9 = new Intent(str3);
            intent9.setPackage(c.a());
            context2.sendBroadcast(intent9);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:38|39|(2:41|(5:47|48|49|(1:51)|(2:57|58)(2:55|56))(2:45|46))|62|(1:43)|47|48|49|(0)|(1:53)|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a3, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019d A[Catch: Exception -> 0x01a2, all -> 0x027b, TRY_LEAVE, TryCatch #7 {all -> 0x027b, blocks: (B:19:0x00e3, B:20:0x00f3, B:22:0x00f9, B:24:0x0112, B:26:0x011d, B:29:0x012b, B:34:0x0143, B:36:0x0149, B:38:0x015f, B:64:0x01f1, B:40:0x016c, B:42:0x0172, B:48:0x0181, B:50:0x0187, B:51:0x018f, B:52:0x0197, B:54:0x019d, B:59:0x01a8, B:61:0x01ae, B:62:0x01c3, B:57:0x01a3, B:45:0x017a, B:63:0x01d7, B:65:0x0221, B:69:0x0249, B:73:0x025c), top: B:108:0x00e3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        String str4;
        JSONObject jSONObject;
        String str5;
        String str6;
        String str7;
        String str8;
        JSONObject jSONObject2;
        String str9;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65564, null, context, str, str2)) == null) {
            String str10 = str;
            String str11 = "extra";
            String str12 = "id";
            e0 a2 = e0.a(context);
            String str13 = s1.c;
            String str14 = "postUrl is " + str13;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", a2.a);
            if (str2 != null && str2.length() > 0) {
                hashMap.put("appid", str2);
            } else {
                hashMap.put("appid", a2.b);
            }
            hashMap.put("devid", a2.c);
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("msgid", str10);
            hashMap.put("output_style", 1);
            String str15 = "interval";
            hashMap.put("interval", String.valueOf(a.a));
            String b2 = b(a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                String a3 = d0.a(str13, d0.a(hashMap2));
                if (TextUtils.isEmpty(a3)) {
                    str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                } else {
                    String a4 = a(a3);
                    String str16 = "---------getFeedbackChat-----------response is " + a4;
                    JSONObject jSONObject3 = new JSONObject(a4);
                    int intValue = ((Integer) jSONObject3.get("errno")).intValue();
                    if (intValue != 0) {
                        str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        if (intValue != 0) {
                            try {
                                try {
                                    str4 = "com.baidu.ufosdk.reload";
                                    try {
                                        Intent intent = new Intent(str4);
                                        intent.setPackage(c.a());
                                        context.sendBroadcast(intent);
                                    } catch (Exception unused) {
                                        Intent intent2 = new Intent(str4);
                                        intent2.setPackage(c.a());
                                        context.sendBroadcast(intent2);
                                        Intent intent3 = new Intent(str3);
                                        intent3.setPackage(c.a());
                                        context.sendBroadcast(intent3);
                                        return false;
                                    }
                                } catch (Exception unused2) {
                                    str4 = "com.baidu.ufosdk.reload";
                                    Intent intent22 = new Intent(str4);
                                    intent22.setPackage(c.a());
                                    context.sendBroadcast(intent22);
                                    Intent intent32 = new Intent(str3);
                                    intent32.setPackage(c.a());
                                    context.sendBroadcast(intent32);
                                    return false;
                                }
                            } catch (Throwable th) {
                                th = th;
                                Intent intent4 = new Intent(str3);
                                intent4.setPackage(c.a());
                                context.sendBroadcast(intent4);
                                throw th;
                            }
                        }
                    } else {
                        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                        Intent intent5 = new Intent("com.baidu.ufosdk.getchat");
                        if (jSONObject3.getInt("msgnum") > 0) {
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("msg");
                            StringBuilder sb = new StringBuilder();
                            str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            try {
                                try {
                                    sb.append("getFeedbackChat --> msgArray : \n");
                                    sb.append(jSONArray2.toString());
                                    sb.toString();
                                    int i = 0;
                                    while (i < jSONArray2.length()) {
                                        String str17 = str15;
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put(str12, str10);
                                        hashMap3.put("toggle", "no");
                                        String str18 = null;
                                        if (jSONArray2.getJSONObject(i).has(str11)) {
                                            str7 = jSONArray2.getJSONObject(i).getString(str11);
                                        } else {
                                            str7 = null;
                                        }
                                        if (jSONArray2.getJSONObject(i).has(str12)) {
                                            str8 = str11;
                                            hashMap3.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i).getInt(str12)));
                                        } else {
                                            str8 = str11;
                                        }
                                        if (str7 != null && str7.length() != 0) {
                                            str9 = str12;
                                            JSONObject jSONObject4 = new JSONObject(str7);
                                            int i2 = jSONObject4.getInt("flagRobot");
                                            jSONObject2 = jSONObject3;
                                            hashMap3.put("flagRobot", Integer.valueOf(i2));
                                            if (i2 == 0) {
                                                hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                            } else {
                                                try {
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                                if (jSONObject4.has("robot")) {
                                                    jSONArray = (JSONArray) jSONObject4.get("robot");
                                                    if (jSONArray == null && jSONArray.length() != 0) {
                                                        hashMap3.put("content", jSONArray.toString());
                                                    } else {
                                                        hashMap3.put("flagRobot", 0);
                                                        if (jSONObject4.has("answer")) {
                                                            str18 = jSONObject4.getString("answer");
                                                        }
                                                        if (str18 == null && str18.length() > 0) {
                                                            hashMap3.put("toggle", "yes");
                                                            hashMap3.put("flagRobot", 0);
                                                            hashMap3.put("content", jSONObject4.getString("answer"));
                                                        } else {
                                                            hashMap3.put("flagRobot", 0);
                                                            hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                        }
                                                    }
                                                }
                                                jSONArray = null;
                                                if (jSONArray == null) {
                                                }
                                                hashMap3.put("flagRobot", 0);
                                                if (jSONObject4.has("answer")) {
                                                }
                                                if (str18 == null) {
                                                }
                                                hashMap3.put("flagRobot", 0);
                                                hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                            }
                                        } else {
                                            jSONObject2 = jSONObject3;
                                            str9 = str12;
                                            hashMap3.put("toggle", "no");
                                            hashMap3.put("flagRobot", 0);
                                            hashMap3.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                        }
                                        hashMap3.put("time", jSONArray2.getJSONObject(i).getString("time"));
                                        arrayList.add(hashMap3);
                                        String str19 = "^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString();
                                        i++;
                                        str10 = str;
                                        str15 = str17;
                                        str11 = str8;
                                        str12 = str9;
                                        jSONObject3 = jSONObject2;
                                    }
                                    jSONObject = jSONObject3;
                                    str6 = str15;
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelableArrayList("msgList", arrayList);
                                    intent5.putExtras(bundle);
                                    intent5.setPackage(c.a());
                                    context.sendBroadcast(intent5);
                                } catch (Exception unused3) {
                                    str4 = "com.baidu.ufosdk.reload";
                                    str3 = str5;
                                    Intent intent222 = new Intent(str4);
                                    intent222.setPackage(c.a());
                                    context.sendBroadcast(intent222);
                                    Intent intent322 = new Intent(str3);
                                    intent322.setPackage(c.a());
                                    context.sendBroadcast(intent322);
                                    return false;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                str3 = str5;
                                Intent intent42 = new Intent(str3);
                                intent42.setPackage(c.a());
                                context.sendBroadcast(intent42);
                                throw th;
                            }
                        } else {
                            jSONObject = jSONObject3;
                            str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            str6 = "interval";
                        }
                        try {
                            JSONObject jSONObject5 = jSONObject;
                            if (((Integer) jSONObject5.get(StickerDataChangeType.UPDATE)).intValue() == 1) {
                                a.a = ((Integer) jSONObject5.get(str6)).intValue();
                            }
                            Intent intent6 = new Intent(str5);
                            intent6.setPackage(c.a());
                            context.sendBroadcast(intent6);
                            return true;
                        } catch (Exception unused4) {
                            str3 = str5;
                            str4 = "com.baidu.ufosdk.reload";
                            Intent intent2222 = new Intent(str4);
                            intent2222.setPackage(c.a());
                            context.sendBroadcast(intent2222);
                            Intent intent3222 = new Intent(str3);
                            intent3222.setPackage(c.a());
                            context.sendBroadcast(intent3222);
                            return false;
                        }
                    }
                }
                Intent intent7 = new Intent(str3);
                intent7.setPackage(c.a());
                context.sendBroadcast(intent7);
                return false;
            } catch (Exception unused5) {
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            } catch (Throwable th3) {
                th = th3;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x0368 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:161:0x00eb */
    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:66|67)|(2:69|(5:74|75|76|(1:78)|(1:83)(1:82))(1:73))|87|(1:71)|74|75|76|(0)|(1:80)|83) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b2, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ac A[Catch: Exception -> 0x01b1, all -> 0x02c7, TRY_LEAVE, TryCatch #2 {all -> 0x02c7, blocks: (B:27:0x0103, B:33:0x0125, B:41:0x0153, B:43:0x0159, B:45:0x016d, B:78:0x0218, B:80:0x022d, B:82:0x023e, B:86:0x024a, B:96:0x027c, B:89:0x0259, B:92:0x0269, B:95:0x0275, B:47:0x017a, B:49:0x0180, B:55:0x018f, B:57:0x0195, B:58:0x019e, B:59:0x01a6, B:61:0x01ac, B:66:0x01b7, B:68:0x01bd, B:69:0x01d0, B:64:0x01b2, B:52:0x0188, B:70:0x01e4, B:72:0x01f0, B:74:0x01fa, B:77:0x0205, B:75:0x01fe, B:76:0x0202, B:97:0x02a5), top: B:145:0x0103 }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        String str4;
        JSONObject jSONObject;
        String str5;
        String str6;
        String str7;
        String str8;
        Intent intent;
        int i;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, context, str, str2)) == null) {
            String str9 = context;
            Context context2 = str;
            String str10 = "extra";
            String str11 = "id";
            e0 a2 = e0.a(context);
            String str12 = s1.c;
            String str13 = "postUrl is " + str12;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", a2.a);
            if (str2 != null && str2.length() > 0) {
                hashMap.put("appid", str2);
            } else {
                hashMap.put("appid", a2.b);
            }
            hashMap.put("devid", a2.c);
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("output_style", 1);
            if (context2 != null) {
                hashMap.put("msgid", context2);
            } else {
                hashMap.put("msgid", "newMessage");
            }
            String str14 = "interval";
            hashMap.put("interval", String.valueOf(a.a));
            String b2 = b(a(hashMap));
            try {
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("sdk_encrypt", b2);
                    String a3 = d0.a(str12, d0.a(hashMap2));
                    if (!TextUtils.isEmpty(a3)) {
                        String a4 = a(a3);
                        String str15 = "-----------getFeedbackChatBack---------response is " + a4;
                        JSONObject jSONObject2 = new JSONObject(a4);
                        int intValue = ((Integer) jSONObject2.get("errno")).intValue();
                        if (intValue == 0) {
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                            Intent intent2 = new Intent("com.baidu.ufosdk.getchat");
                            if (jSONObject2.getInt("msgnum") > 0) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("msg");
                                StringBuilder sb = new StringBuilder();
                                str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                try {
                                    sb.append("getFeedbackChatBack --> msgArray : \n");
                                    sb.append(jSONArray2.toString());
                                    sb.toString();
                                    int i2 = 0;
                                    str9 = str9;
                                    while (i2 < jSONArray2.length()) {
                                        String str16 = str14;
                                        try {
                                            try {
                                                HashMap hashMap3 = new HashMap();
                                                hashMap3.put(str11, context2);
                                                hashMap3.put("toggle", "no");
                                                String str17 = null;
                                                if (jSONArray2.getJSONObject(i2).has(str10)) {
                                                    str7 = jSONArray2.getJSONObject(i2).getString(str10);
                                                } else {
                                                    str7 = null;
                                                }
                                                if (jSONArray2.getJSONObject(i2).has(str11)) {
                                                    str8 = str10;
                                                    hashMap3.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i2).getInt(str11)));
                                                } else {
                                                    str8 = str10;
                                                }
                                                String str18 = str11;
                                                JSONObject jSONObject3 = jSONObject2;
                                                if (str7 != null && str7.length() != 0) {
                                                    JSONObject jSONObject4 = new JSONObject(str7);
                                                    int i3 = jSONObject4.getInt("flagRobot");
                                                    intent = intent2;
                                                    hashMap3.put("flagRobot", Integer.valueOf(i3));
                                                    if (i3 == 0) {
                                                        hashMap3.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                    } else {
                                                        try {
                                                        } catch (Exception e2) {
                                                            e2.printStackTrace();
                                                        }
                                                        if (jSONObject4.has("robot")) {
                                                            jSONArray = (JSONArray) jSONObject4.get("robot");
                                                            if (jSONArray == null && jSONArray.length() != 0) {
                                                                hashMap3.put("content", jSONArray.toString());
                                                            } else {
                                                                hashMap3.put("flagRobot", 0);
                                                                if (jSONObject4.has("answer")) {
                                                                    str17 = jSONObject4.getString("answer");
                                                                }
                                                                if (str17 == null && str17.length() > 0) {
                                                                    hashMap3.put("toggle", "yes");
                                                                    hashMap3.put("flagRobot", 0);
                                                                    hashMap3.put("content", jSONObject4.getString("answer"));
                                                                } else {
                                                                    hashMap3.put("flagRobot", 0);
                                                                    hashMap3.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                                }
                                                            }
                                                        }
                                                        jSONArray = null;
                                                        if (jSONArray == null) {
                                                        }
                                                        hashMap3.put("flagRobot", 0);
                                                        if (jSONObject4.has("answer")) {
                                                        }
                                                        if (str17 == null) {
                                                        }
                                                        hashMap3.put("flagRobot", 0);
                                                        hashMap3.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                    }
                                                } else {
                                                    intent = intent2;
                                                    if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                                        if (jSONArray2.getJSONObject(i2).getInt("evaluation") == 0) {
                                                            hashMap3.put("toggle", "no");
                                                        } else {
                                                            hashMap3.put("toggle", "yes");
                                                        }
                                                    } else {
                                                        hashMap3.put("toggle", "no");
                                                    }
                                                    hashMap3.put("flagRobot", 0);
                                                    hashMap3.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                }
                                                hashMap3.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                                                if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                                    i = ((Integer) jSONArray2.getJSONObject(i2).get("evaluation")).intValue();
                                                } else {
                                                    i = 0;
                                                }
                                                hashMap3.put("evaluation", Integer.valueOf(i));
                                                if (i == 0) {
                                                    hashMap3.put("ask", 0);
                                                    hashMap3.put("toggle", "no");
                                                } else if (i == 10) {
                                                    hashMap3.put("ask", 1);
                                                    hashMap3.put("toggle", "yes");
                                                } else if (i <= 9) {
                                                    hashMap3.put("ask", 9);
                                                } else if (i >= 11) {
                                                    hashMap3.put("ask", 11);
                                                }
                                                arrayList.add(hashMap3);
                                                String str19 = "^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString();
                                                i2++;
                                                str9 = context;
                                                context2 = str;
                                                str14 = str16;
                                                str10 = str8;
                                                str11 = str18;
                                                jSONObject2 = jSONObject3;
                                                intent2 = intent;
                                            } catch (Exception unused) {
                                                context2 = context;
                                                str4 = "com.baidu.ufosdk.reload";
                                                str3 = str5;
                                                Intent intent3 = new Intent(str4);
                                                intent3.setPackage(c.a());
                                                context2.sendBroadcast(intent3);
                                                Intent intent4 = new Intent(str3);
                                                intent4.setPackage(c.a());
                                                context2.sendBroadcast(intent4);
                                                return false;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            context2 = context;
                                            str9 = str5;
                                            Intent intent5 = new Intent(str9);
                                            intent5.setPackage(c.a());
                                            context2.sendBroadcast(intent5);
                                            throw th;
                                        }
                                    }
                                    jSONObject = jSONObject2;
                                    str6 = str14;
                                    Intent intent6 = intent2;
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelableArrayList("msgList", arrayList);
                                    intent6.putExtras(bundle);
                                    intent6.setPackage(c.a());
                                    context2 = context;
                                    try {
                                        try {
                                            context2.sendBroadcast(intent6);
                                        } catch (Exception unused2) {
                                            str4 = "com.baidu.ufosdk.reload";
                                            str3 = str5;
                                            Intent intent32 = new Intent(str4);
                                            intent32.setPackage(c.a());
                                            context2.sendBroadcast(intent32);
                                            Intent intent42 = new Intent(str3);
                                            intent42.setPackage(c.a());
                                            context2.sendBroadcast(intent42);
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str9 = str5;
                                        Intent intent52 = new Intent(str9);
                                        intent52.setPackage(c.a());
                                        context2.sendBroadcast(intent52);
                                        throw th;
                                    }
                                } catch (Exception unused3) {
                                    context2 = str9;
                                } catch (Throwable th3) {
                                    th = th3;
                                    context2 = str9;
                                }
                            } else {
                                context2 = str9;
                                jSONObject = jSONObject2;
                                str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                str6 = "interval";
                            }
                            try {
                                JSONObject jSONObject5 = jSONObject;
                                if (((Integer) jSONObject5.get(StickerDataChangeType.UPDATE)).intValue() == 1) {
                                    a.a = ((Integer) jSONObject5.get(str6)).intValue();
                                }
                                Intent intent7 = new Intent(str5);
                                intent7.setPackage(c.a());
                                context2.sendBroadcast(intent7);
                                return true;
                            } catch (Exception unused4) {
                                str3 = str5;
                                str4 = "com.baidu.ufosdk.reload";
                                Intent intent322 = new Intent(str4);
                                intent322.setPackage(c.a());
                                context2.sendBroadcast(intent322);
                                Intent intent422 = new Intent(str3);
                                intent422.setPackage(c.a());
                                context2.sendBroadcast(intent422);
                                return false;
                            }
                        }
                        context2 = str9;
                        str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        if (intValue != 0) {
                            try {
                                str4 = "com.baidu.ufosdk.reload";
                                try {
                                    Intent intent8 = new Intent(str4);
                                    intent8.setPackage(c.a());
                                    context2.sendBroadcast(intent8);
                                } catch (Exception unused5) {
                                    Intent intent3222 = new Intent(str4);
                                    intent3222.setPackage(c.a());
                                    context2.sendBroadcast(intent3222);
                                    Intent intent4222 = new Intent(str3);
                                    intent4222.setPackage(c.a());
                                    context2.sendBroadcast(intent4222);
                                    return false;
                                }
                            } catch (Exception unused6) {
                                str4 = "com.baidu.ufosdk.reload";
                                Intent intent32222 = new Intent(str4);
                                intent32222.setPackage(c.a());
                                context2.sendBroadcast(intent32222);
                                Intent intent42222 = new Intent(str3);
                                intent42222.setPackage(c.a());
                                context2.sendBroadcast(intent42222);
                                return false;
                            }
                        }
                    } else {
                        context2 = str9;
                        str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    }
                    Intent intent9 = new Intent(str3);
                    intent9.setPackage(c.a());
                    context2.sendBroadcast(intent9);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception unused7) {
                context2 = str9;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            } catch (Throwable th5) {
                th = th5;
                context2 = str9;
                str9 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public static boolean a(Intent intent, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65556, null, intent, str, z)) == null) {
            if (intent == null) {
                return z;
            }
            try {
                return intent.getBooleanExtra(str, z);
            } catch (Exception unused) {
                intent.replaceExtras((Bundle) null);
                return z;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, file)) == null) {
            if (file.delete()) {
                return true;
            }
            ContentResolver contentResolver = h;
            ContentValues contentValues = new ContentValues();
            String absolutePath = file.getAbsolutePath();
            contentValues.put("_data", absolutePath);
            try {
                Uri insert = contentResolver.insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValues);
                if (insert == null) {
                    delete = contentResolver.delete(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "_data=?", new String[]{absolutePath});
                } else {
                    delete = contentResolver.delete(insert, null, null);
                }
                if (delete > 0) {
                    return !file.exists();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x009e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x0080 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x009d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x00dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:111:0x00f9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x0116 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x007a */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: byte[] */
    /* JADX DEBUG: Multi-variable search result rejected for r13v10, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r13v14, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r13v3, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r13v7, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[Catch: Exception -> 0x008d, TRY_LEAVE, TryCatch #12 {Exception -> 0x008d, blocks: (B:27:0x0083, B:29:0x0089, B:33:0x0091), top: B:122:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b1 A[Catch: Exception -> 0x00ad, TRY_LEAVE, TryCatch #1 {Exception -> 0x00ad, blocks: (B:41:0x00a3, B:43:0x00a9, B:47:0x00b1), top: B:113:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed A[Catch: Exception -> 0x00e9, TRY_LEAVE, TryCatch #4 {Exception -> 0x00e9, blocks: (B:67:0x00df, B:69:0x00e5, B:73:0x00ed), top: B:117:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010a A[Catch: Exception -> 0x0106, TRY_LEAVE, TryCatch #20 {Exception -> 0x0106, blocks: (B:80:0x00fc, B:82:0x0102, B:86:0x010a), top: B:126:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127 A[Catch: Exception -> 0x0123, TRY_LEAVE, TryCatch #9 {Exception -> 0x0123, blocks: (B:93:0x0119, B:95:0x011f, B:99:0x0127), top: B:120:0x0119 }] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v31, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        ByteArrayOutputStream byteArrayOutputStream;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap decodeByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, bArr, i)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    options.inSampleSize = a(options, 480, 800);
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                    options.inJustDecodeBounds = false;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } catch (Throwable th) {
                    byteArrayOutputStream2 = i;
                    th = th;
                }
            } catch (IllegalArgumentException unused) {
                bArr = null;
            } catch (NullPointerException unused2) {
                bArr = null;
            } catch (Exception unused3) {
                bArr = null;
            } catch (OutOfMemoryError unused4) {
                bArr = 0;
            } catch (RuntimeException unused5) {
                bArr = null;
            } catch (Throwable th2) {
                th = th2;
                bArr = 0;
            }
            try {
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                bArr = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bArr.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        if (!bArr.isRecycled()) {
                            bArr.recycle();
                        }
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return byteArray;
                } catch (IllegalArgumentException unused6) {
                    bitmap4 = bArr;
                    if (bitmap4 != null) {
                        try {
                            if (!bitmap4.isRecycled()) {
                                bitmap4.recycle();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (NullPointerException unused7) {
                    bitmap3 = bArr;
                    if (bitmap3 != null) {
                        try {
                            if (!bitmap3.isRecycled()) {
                                bitmap3.recycle();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (RuntimeException unused8) {
                    bitmap2 = bArr;
                    if (bitmap2 != null) {
                        try {
                            if (!bitmap2.isRecycled()) {
                                bitmap2.recycle();
                            }
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (Exception unused9) {
                    bitmap = bArr;
                    if (bitmap != null) {
                        try {
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                } catch (OutOfMemoryError unused10) {
                    System.gc();
                    if (bArr != 0) {
                        try {
                            if (!bArr.isRecycled()) {
                                bArr.recycle();
                            }
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            return null;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                    }
                    return null;
                }
            } catch (IllegalArgumentException unused11) {
                byteArrayOutputStream = null;
                bitmap4 = bArr;
                if (bitmap4 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (NullPointerException unused12) {
                byteArrayOutputStream = null;
                bitmap3 = bArr;
                if (bitmap3 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (Exception unused13) {
                byteArrayOutputStream = null;
                bitmap = bArr;
                if (bitmap != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (OutOfMemoryError unused14) {
                byteArrayOutputStream = null;
                System.gc();
                if (bArr != 0) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (RuntimeException unused15) {
                byteArrayOutputStream = null;
                bitmap2 = bArr;
                if (bitmap2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bArr != 0) {
                    try {
                        if (!bArr.isRecycled()) {
                            bArr.recycle();
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                }
                throw th;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            a();
            return d.getAccountName();
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            a();
            return d.getAccountUid();
        }
        return (String) invokeV.objValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            a();
            return d.getBackbarType();
        }
        return invokeV.intValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            a();
            return d.getBaiduCuid();
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            a();
            return d.getExtraData();
        }
        return (String) invokeV.objValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            a();
            return d.getFeedbackChannel();
        }
        return (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            a();
            return d.getLoaction();
        }
        return (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            a();
            return d.getRobotWelcome();
        }
        return (String) invokeV.objValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            a();
            return d.getThemeMode();
        }
        return invokeV.intValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - g;
            if (0 < j && j < 500) {
                return true;
            }
            g = currentTimeMillis;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            if (e != null) {
                return e;
            }
            e = (Context) Class.forName("com.baidu.ufosdk.plugin.PluginUtils").getMethod("getApplicationContext", new Class[0]).invoke(null, new Object[0]);
            return e;
        }
        return (Context) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < random.nextInt(1) + 9; i++) {
                sb.append(i);
            }
            sb.append((CharSequence) sb);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, context, str, str2)) == null) {
            e0 a2 = e0.a(context);
            String str3 = s1.e;
            String str4 = "postUrl is " + str3;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", a2.a);
            if (str2 != null && str2.length() > 0) {
                hashMap.put("appid", str2);
            } else {
                hashMap.put("appid", a2.b);
            }
            hashMap.put("devid", a2.c);
            hashMap.put("id", str);
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("output_style", 1);
            String b2 = b(a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                String a3 = d0.a(str3, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject(a(a3));
                    String str5 = "response is " + jSONObject.toString();
                    int intValue = ((Integer) jSONObject.get("errno")).intValue();
                    if (intValue == 0 && jSONObject.getInt("msgnum") > 0) {
                        return jSONObject.getJSONArray("msg").toString();
                    }
                    if (intValue != 0) {
                        Intent intent = new Intent("com.baidu.ufosdk.reload");
                        intent.setPackage(c.a());
                        context.sendBroadcast(intent);
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                Intent intent2 = new Intent("com.baidu.ufosdk.reload");
                intent2.setPackage(c.a());
                context.sendBroadcast(intent2);
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, context)) == null) {
            try {
                z = context.getString(Resources.getSystem().getIdentifier("config_os_brand", EMABTest.TYPE_STRING, "android")).equals("harmony");
            } catch (Exception unused) {
                z = false;
            }
            if (z) {
                return "harmony";
            }
            return "android";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x01d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x00ca */
    /* JADX WARN: Can't wrap try/catch for region: R(3:(3:40|41|(2:50|51)(3:43|(2:45|46)(2:48|49)|47))|37|38) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean f(Context context) {
        String str;
        String a2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            str = 65574;
            InterceptResult invokeL = interceptable.invokeL(65574, null, context);
            if (invokeL != null) {
                return invokeL.booleanValue;
            }
        }
        Context context2 = context;
        String str3 = "lastmsg";
        String str4 = "replied";
        e0 a3 = e0.a(context);
        String str5 = s1.h;
        String str6 = "postUrl is " + str5;
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", a3.a);
        hashMap.put("appid", a3.b);
        hashMap.put("devid", a3.c);
        hashMap.put("uid", c());
        hashMap.put(DpStatConstants.KEY_USER_ID, c());
        hashMap.put("username", b());
        hashMap.put("sdkvn", "4.1.9.1");
        hashMap.put("output_style", 1);
        String b2 = b(a(hashMap));
        try {
            try {
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("sdk_encrypt", b2);
                    a2 = d0.a(str5, d0.a(hashMap2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception unused) {
                str4 = "com.baidu.ufosdk.reload";
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
            if (TextUtils.isEmpty(a2)) {
                str4 = "com.baidu.ufosdk.reload";
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                Intent intent = new Intent("com.baidu.ufosdk.fail");
                intent.setPackage(c.a());
                context2.sendBroadcast(intent);
            } else {
                String a4 = a(a2);
                String str7 = "decode response is " + a4;
                JSONObject jSONObject = new JSONObject(a4);
                int intValue = ((Integer) jSONObject.get("errno")).intValue();
                if (intValue != 0) {
                    str2 = "com.baidu.ufosdk.reload";
                    str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    if (intValue != 0) {
                        try {
                            str4 = str2;
                            Intent intent2 = new Intent(str4);
                            intent2.setPackage(c.a());
                            context2.sendBroadcast(intent2);
                        } catch (Exception unused2) {
                        }
                    }
                    Intent intent3 = new Intent(str3);
                    intent3.setPackage(c.a());
                    context2.sendBroadcast(intent3);
                    return false;
                }
                try {
                    Intent intent4 = new Intent("com.baidu.ufosdk.gethistorylist");
                    try {
                        if (jSONObject.getInt("msgnum") <= 0) {
                            str2 = "com.baidu.ufosdk.reload";
                            String str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            try {
                                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("msgList", arrayList);
                                intent4.putExtras(bundle);
                                intent4.setPackage(c.a());
                                context2.sendBroadcast(intent4);
                                str = str8;
                            } catch (Exception unused3) {
                                str3 = str8;
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            str2 = "com.baidu.ufosdk.reload";
                            try {
                                JSONArray jSONArray = jSONObject.getJSONArray("msg");
                                str = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                int i = 0;
                                while (i < jSONArray.length()) {
                                    try {
                                        String str9 = "#################### " + i + " msgArray.getJSONObject(i)--> " + jSONArray.getJSONObject(i).toString();
                                        if (i >= 500) {
                                            break;
                                        }
                                        HashMap hashMap3 = new HashMap();
                                        hashMap3.put("id", jSONArray.getJSONObject(i).getString("id"));
                                        hashMap3.put("content", jSONArray.getJSONObject(i).getString("content"));
                                        hashMap3.put("time", jSONArray.getJSONObject(i).getString("time"));
                                        hashMap3.put("newmsg", jSONArray.getJSONObject(i).getString("newmsg"));
                                        hashMap3.put("replied", jSONArray.getJSONObject(i).getString("replied"));
                                        hashMap3.put(str3, jSONArray.getJSONObject(i).getString(str3));
                                        String str10 = str3;
                                        hashMap3.put("is_self_service", Integer.valueOf(jSONArray.getJSONObject(i).optInt("is_self_service", 0)));
                                        if (jSONArray.getJSONObject(i).has("appid")) {
                                            hashMap3.put("appid", jSONArray.getJSONObject(i).getString("appid"));
                                        } else {
                                            hashMap3.put("appid", a3.b);
                                        }
                                        arrayList2.add(hashMap3);
                                        i++;
                                        context2 = context;
                                        str3 = str10;
                                    } catch (Exception unused4) {
                                        context2 = context;
                                        str4 = str2;
                                        str3 = str;
                                        Intent intent5 = new Intent(str4);
                                        intent5.setPackage(c.a());
                                        context2.sendBroadcast(intent5);
                                        a("网络连接超时，请检查网络连接。", 1);
                                        Intent intent6 = new Intent(str3);
                                        intent6.setPackage(c.a());
                                        context2.sendBroadcast(intent6);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        context2 = context;
                                        str3 = str;
                                        Intent intent7 = new Intent(str3);
                                        intent7.setPackage(c.a());
                                        context2.sendBroadcast(intent7);
                                        throw th;
                                    }
                                }
                                intent4.putExtra("msgList", arrayList2);
                                intent4.setPackage(c.a());
                                context2 = context;
                                context2.sendBroadcast(intent4);
                                str = str;
                            } catch (Exception unused5) {
                                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            }
                        }
                        Intent intent8 = new Intent((String) str);
                        intent8.setPackage(c.a());
                        context2.sendBroadcast(intent8);
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception unused6) {
                    str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    str4 = "com.baidu.ufosdk.reload";
                }
                str4 = str2;
                Intent intent52 = new Intent(str4);
                intent52.setPackage(c.a());
                context2.sendBroadcast(intent52);
                a("网络连接超时，请检查网络连接。", 1);
                Intent intent62 = new Intent(str3);
                intent62.setPackage(c.a());
                context2.sendBroadcast(intent62);
                return false;
            }
            Intent intent32 = new Intent(str3);
            intent32.setPackage(c.a());
            context2.sendBroadcast(intent32);
            return false;
        } catch (Throwable th4) {
            th = th4;
            str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
        }
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, context)) == null) {
            e0 a2 = e0.a(context);
            String str = s1.i;
            String str2 = "postUrl is " + str;
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", a2.a);
            hashMap.put("appid", a2.b);
            hashMap.put("devid", a2.c);
            hashMap.put("uid", c());
            hashMap.put(DpStatConstants.KEY_USER_ID, c());
            hashMap.put("username", b());
            hashMap.put("sdkvn", "4.1.9.1");
            hashMap.put("output_style", 1);
            hashMap.put("interval", String.valueOf(q1.a));
            String b2 = b(a(hashMap));
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("sdk_encrypt", b2);
                String a3 = d0.a(str, d0.a(hashMap2));
                if (!TextUtils.isEmpty(a3)) {
                    String a4 = a(a3);
                    String str3 = "response is " + a4;
                    JSONObject jSONObject = new JSONObject(a4);
                    r0 = "response is " + jSONObject.toString();
                    if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                        if (((Integer) jSONObject.get(StickerDataChangeType.UPDATE)).intValue() == 1) {
                            q1.a = ((Integer) jSONObject.get("interval")).intValue();
                        }
                        return jSONObject.optString("newmsg");
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a(ExifInterface.LONGITUDE_WEST, false));
            stringBuffer.append(a("9", true));
            stringBuffer.append(random.nextInt(1) + 1);
            stringBuffer.append(a("Y", true));
            stringBuffer.append("abe");
            stringBuffer.append(a("y", true));
            stringBuffer.append("1a88");
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
