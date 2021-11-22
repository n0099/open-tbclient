package com.baidu.ufosdk.e;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.f.c;
import com.baidu.ufosdk.f.i;
import com.baidu.ufosdk.f.j;
import com.baidu.ufosdk.f.k;
import com.baidu.ufosdk.f.p;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, int i3, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65536, null, i2, i3, handler) == null) {
            c.d("postUrl is https://ufosdk.baidu.com/?m=Index&a=getProductType");
            c.d("getTitleAndHint (*^o^*) success!! product_type = " + i2);
            c.d("getTitleAndHint (*^o^*) success!! appid = " + UfoSDK.appid);
            c.d("getTitleAndHint (*^o^*) success!! extend_feedback_channel = " + i3);
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("sdkvn", "2.9.10");
            if (i2 != 0) {
                hashMap.put("product_type", Integer.valueOf(i2));
            }
            if (i3 != -1) {
                hashMap.put("extend_feedback_channel", Integer.valueOf(i3));
            }
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=getProductType", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(k.b(a3));
                c.c("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    c.d("getTitleAndHint   (*^o^*) success!! \n" + jSONObject.toString());
                    JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                    JSONObject jSONObject2 = jSONArray.length() == 1 ? (JSONObject) jSONArray.get(0) : null;
                    if (jSONObject2 == null || jSONObject2.length() <= 0) {
                        return;
                    }
                    handler.obtainMessage(18, jSONObject2).sendToTarget();
                }
            } catch (Exception e2) {
                c.a("sendRecord fail.", e2);
            }
        }
    }

    public static void a(Context context, int i2, int i3, int i4, int i5, boolean z) {
        SharedPreferences.Editor edit;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            String b2 = d.b(context);
            boolean contains = b2.contains(RomUtils.UNKNOWN);
            boolean contains2 = b2.contains("NONE");
            if (contains || contains2) {
                SharedPreferences.Editor edit2 = context.getSharedPreferences("UfoSharePreference", 0).edit();
                String b3 = i.b(System.currentTimeMillis());
                UfoSDK.startStr = b3 + "-enable";
                edit2.putString("lastStart", b3 + "-enable");
                return;
            }
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(context);
            String format = String.format("https://ufosdk.baidu.com/?m=hide&a=behavior&editFeedbackView=%d&editFeedbackWord=%d&editFeedbackPicture=%d&myFeedback=%d&appid=%s&editFeedbackViewUV=%d&editFeedbackViewFromRobotUV=%d&editFeedbackViewFromFaqUV=%d&robotUv=%d", Integer.valueOf(dVar.a()), Integer.valueOf(dVar.b()), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.d()), UfoSDK.appid, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            StringBuilder sb = new StringBuilder("--FeedbackChatSender:1517--getURL is : ");
            sb.append(format);
            c.c(sb.toString());
            try {
                if (b.a(format)) {
                    edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putInt("editFeedbackViewUV", 0);
                    edit.putInt("editFeedbackViewFromRobotUV", 0);
                    edit.putInt("editFeedbackViewFromFaqUV", 0);
                    edit.putInt("robotUv", 0);
                    String b4 = i.b(System.currentTimeMillis());
                    if (z) {
                        UfoSDK.startStr = b4 + "-enable";
                        str2 = b4 + "-enable";
                    } else {
                        UfoSDK.startStr = b4 + "-disable";
                        str2 = b4 + "-disable";
                    }
                    edit.putString("lastStart", str2);
                } else {
                    edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putInt("editFeedbackViewUV", 0);
                    edit.putInt("editFeedbackViewFromRobotUV", 0);
                    edit.putInt("editFeedbackViewFromFaqUV", 0);
                    edit.putInt("robotUv", 0);
                    String b5 = i.b(System.currentTimeMillis());
                    if (z) {
                        UfoSDK.startStr = b5 + "-enable";
                        str = b5 + "-enable";
                    } else {
                        UfoSDK.startStr = b5 + "-disable";
                        str = b5 + "-disable";
                    }
                    edit.putString("lastStart", str);
                }
                edit.commit();
                dVar.c(0);
                dVar.a(0);
                dVar.b(0);
                dVar.d(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, handler) == null) {
            c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=getProductType");
            String uuid = UUID.randomUUID().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("os", "android");
            hashMap.put("clientid", UfoSDK.clientid);
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("pkgname", e.a());
            hashMap.put("cuid", uuid);
            hashMap.put("appvn", e.b());
            hashMap.put("brand", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            hashMap.put("osvn", Build.VERSION.RELEASE);
            hashMap.put("osvc", String.valueOf(j.a()));
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            hashMap.put("sdkvn", "2.9.10");
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=getProductType", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(k.b(a3));
                c.c("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        handler.obtainMessage(10).sendToTarget();
                    } else {
                        handler.obtainMessage(9, jSONArray).sendToTarget();
                    }
                }
            } catch (Exception e2) {
                c.a("sendRecord fail.", e2);
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=postclientinfo");
            String uuid = UUID.randomUUID().toString();
            HashMap hashMap = new HashMap();
            hashMap.put("os", "android");
            hashMap.put("clientid", UfoSDK.clientid);
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("pkgname", e.a());
            hashMap.put("cuid", uuid);
            hashMap.put("appvn", e.b());
            hashMap.put("brand", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            hashMap.put("osvn", Build.VERSION.RELEASE);
            hashMap.put("osvc", String.valueOf(j.a()));
            if (p.a("android.permission.MOUNT_UNMOUNT_FILESYSTEMS")) {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                j = statFs.getBlockCount() * statFs.getBlockSize();
            } else {
                j = -1;
            }
            hashMap.put("totalspace", String.valueOf(j));
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i2 == 0 && i3 == 0) {
                str = null;
            } else {
                str = String.valueOf(i2) + ProxyConfig.MATCH_ALL_SCHEMES + String.valueOf(i3);
            }
            hashMap.put("screensize", str);
            hashMap.put("sdkvn", "2.9.10");
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=postclientinfo", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject(k.b(a3));
                    c.a("getAPIKey response is " + jSONObject.toString());
                    if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                        String string = jSONObject.getString("clientid");
                        String string2 = jSONObject.getString("appid");
                        String string3 = jSONObject.getString("devid");
                        String string4 = jSONObject.getString(Constants.KEY_PRODUCT_LINE);
                        SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        UfoSDK.clientid = string;
                        UfoSDK.appid = string2;
                        UfoSDK.devid = string3;
                        UfoSDK.productid = string4;
                        edit.putString("UfoClientId", string);
                        edit.putString("UfoAppId", string2);
                        edit.putString("UfoDevId", string3);
                        edit.putString("UfoProductId", string4);
                        edit.commit();
                        context.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
                        return true;
                    }
                }
            } catch (Exception e2) {
                c.a("sendRecord fail.", e2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:137:0x0328 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x0340 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:152:0x0367 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:173:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:180:0x00f0 */
    /* JADX WARN: Can't wrap try/catch for region: R(11:88|89|(2:91|(5:96|97|98|(2:100|101)|(1:106)(1:105))(1:95))|110|(1:93)|96|97|98|(0)|(1:103)|106) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b9, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b1 A[Catch: Exception -> 0x01b8, all -> 0x02bb, TRY_LEAVE, TryCatch #6 {Exception -> 0x01b8, blocks: (B:61:0x01ab, B:63:0x01b1), top: B:167:0x01ab }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Intent intent;
        String a2;
        Intent intent2;
        String str3;
        String str4;
        String str5;
        JSONObject jSONObject;
        String str6;
        String str7;
        Intent intent3;
        String string;
        int i2;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) != null) {
            return invokeLLL.booleanValue;
        }
        String str8 = context;
        Context context2 = str;
        String str9 = str2;
        String str10 = "time";
        String str11 = "extra";
        String str12 = "id";
        c.b("postUrl is https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        if (str9 == null || str2.length() <= 0) {
            str9 = UfoSDK.appid;
        }
        hashMap.put("appid", str9);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("output_style", 1);
        if (context2 != null) {
            hashMap.put("msgid", context2);
        } else {
            hashMap.put("msgid", "newMessage");
        }
        String str13 = "interval";
        hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
        String a3 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
        try {
            try {
                try {
                    a2 = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(a3, "UTF-8"));
                    try {
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    context2 = str8;
                    str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                }
            } catch (Exception e3) {
                e = e3;
                context2 = str8;
                str10 = "com.baidu.ufosdk.reload";
                str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
            if (!TextUtils.isEmpty(a2)) {
                String b2 = k.b(a2);
                c.c("-----------getFeedbackChatBack---------response is " + b2);
                JSONObject jSONObject2 = new JSONObject(b2);
                int intValue = ((Integer) jSONObject2.get("errno")).intValue();
                if (intValue != 0) {
                    context2 = str8;
                    str4 = "com.baidu.ufosdk.reload";
                    str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    str3 = str8;
                    if (intValue != 0) {
                        try {
                            str10 = str4;
                            intent2 = new Intent(str10);
                            str8 = str8;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    }
                    intent = new Intent(str3);
                    context2.sendBroadcast(intent);
                    return false;
                }
                try {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent4 = new Intent("com.baidu.ufosdk.getchat");
                    if (jSONObject2.getInt("msgnum") > 0) {
                        str4 = "com.baidu.ufosdk.reload";
                        try {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("msg");
                            str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            try {
                                c.a("getFeedbackChatBack --> msgArray : \n" + jSONArray2.toString());
                                int i3 = 0;
                                str8 = str8;
                                while (i3 < jSONArray2.length()) {
                                    String str14 = str13;
                                    try {
                                        try {
                                            HashMap hashMap2 = new HashMap();
                                            hashMap2.put(str12, context2);
                                            hashMap2.put("toggle", "no");
                                            String str15 = null;
                                            String string2 = jSONArray2.getJSONObject(i3).has(str11) ? jSONArray2.getJSONObject(i3).getString(str11) : null;
                                            if (jSONArray2.getJSONObject(i3).has(str12)) {
                                                str7 = str11;
                                                hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i3).getInt(str12)));
                                            } else {
                                                str7 = str11;
                                            }
                                            String str16 = str12;
                                            JSONObject jSONObject3 = jSONObject2;
                                            if (string2 == null || string2.length() == 0) {
                                                intent3 = intent4;
                                                if (!jSONArray2.getJSONObject(i3).has("evaluation") || jSONArray2.getJSONObject(i3).getInt("evaluation") == 0) {
                                                    hashMap2.put("toggle", "no");
                                                } else {
                                                    hashMap2.put("toggle", "yes");
                                                }
                                                hashMap2.put("flagRobot", 0);
                                                string = jSONArray2.getJSONObject(i3).getString("content");
                                            } else {
                                                JSONObject jSONObject4 = new JSONObject(string2);
                                                int i4 = jSONObject4.getInt("flagRobot");
                                                intent3 = intent4;
                                                hashMap2.put("flagRobot", Integer.valueOf(i4));
                                                if (i4 == 0) {
                                                    string = jSONArray2.getJSONObject(i3).getString("content");
                                                } else {
                                                    try {
                                                    } catch (Exception e5) {
                                                        e5.printStackTrace();
                                                    }
                                                    if (jSONObject4.has("robot")) {
                                                        jSONArray = (JSONArray) jSONObject4.get("robot");
                                                        if (jSONArray != null || jSONArray.length() == 0) {
                                                            hashMap2.put("flagRobot", 0);
                                                            if (jSONObject4.has("answer")) {
                                                                str15 = jSONObject4.getString("answer");
                                                            }
                                                            if (str15 != null || str15.length() <= 0) {
                                                                hashMap2.put("flagRobot", 0);
                                                                string = jSONArray2.getJSONObject(i3).getString("content");
                                                            } else {
                                                                hashMap2.put("toggle", "yes");
                                                                hashMap2.put("flagRobot", 0);
                                                                string = jSONObject4.getString("answer");
                                                            }
                                                        } else {
                                                            string = jSONArray.toString();
                                                        }
                                                    }
                                                    jSONArray = null;
                                                    if (jSONArray != null) {
                                                    }
                                                    hashMap2.put("flagRobot", 0);
                                                    if (jSONObject4.has("answer")) {
                                                    }
                                                    if (str15 != null) {
                                                    }
                                                    hashMap2.put("flagRobot", 0);
                                                    string = jSONArray2.getJSONObject(i3).getString("content");
                                                }
                                            }
                                            hashMap2.put("content", string);
                                            hashMap2.put("time", jSONArray2.getJSONObject(i3).getString("time"));
                                            int intValue2 = jSONArray2.getJSONObject(i3).has("evaluation") ? ((Integer) jSONArray2.getJSONObject(i3).get("evaluation")).intValue() : 0;
                                            hashMap2.put("evaluation", Integer.valueOf(intValue2));
                                            if (intValue2 == 0) {
                                                hashMap2.put("ask", 0);
                                                hashMap2.put("toggle", "no");
                                            } else if (intValue2 == 10) {
                                                hashMap2.put("ask", 1);
                                                hashMap2.put("toggle", "yes");
                                            } else {
                                                if (intValue2 <= 9) {
                                                    i2 = 9;
                                                } else if (intValue2 >= 11) {
                                                    i2 = 11;
                                                }
                                                hashMap2.put("ask", i2);
                                            }
                                            arrayList.add(hashMap2);
                                            c.b("^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString());
                                            i3++;
                                            str8 = context;
                                            context2 = str;
                                            str13 = str14;
                                            str11 = str7;
                                            str12 = str16;
                                            jSONObject2 = jSONObject3;
                                            intent4 = intent3;
                                        } catch (Exception e6) {
                                            e = e6;
                                            context2 = context;
                                            str10 = str4;
                                            str8 = str5;
                                            c.a("sendRecord fail.", e);
                                            Looper.prepare();
                                            context2.sendBroadcast(new Intent(str10));
                                            Looper.loop();
                                            intent = new Intent(str8);
                                            context2.sendBroadcast(intent);
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        context2 = context;
                                        str8 = str5;
                                        context2.sendBroadcast(new Intent((String) str8));
                                        throw th;
                                    }
                                }
                                jSONObject = jSONObject2;
                                Intent intent5 = intent4;
                                str6 = str13;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("msgList", arrayList);
                                intent5.putExtras(bundle);
                                context2 = context;
                                try {
                                    try {
                                        context2.sendBroadcast(intent5);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str8 = str5;
                                        context2.sendBroadcast(new Intent((String) str8));
                                        throw th;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    str10 = str4;
                                    str8 = str5;
                                    c.a("sendRecord fail.", e);
                                    Looper.prepare();
                                    context2.sendBroadcast(new Intent(str10));
                                    Looper.loop();
                                    intent = new Intent(str8);
                                    context2.sendBroadcast(intent);
                                    return false;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                context2 = str8;
                            } catch (Throwable th4) {
                                th = th4;
                                context2 = str8;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            context2 = str8;
                            str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        }
                    } else {
                        context2 = str8;
                        str4 = "com.baidu.ufosdk.reload";
                        str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        jSONObject = jSONObject2;
                        str6 = "interval";
                    }
                    try {
                        JSONObject jSONObject5 = jSONObject;
                        if (((Integer) jSONObject5.get("update")).intValue() == 1) {
                            com.baidu.ufosdk.b.ah = ((Integer) jSONObject5.get(str6)).intValue();
                        }
                        context2.sendBroadcast(new Intent(str5));
                        return true;
                    } catch (Exception e10) {
                        e = e10;
                        str8 = str5;
                    }
                } catch (Exception e11) {
                    e = e11;
                    context2 = str8;
                    str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    str10 = "com.baidu.ufosdk.reload";
                }
                str10 = str4;
                c.a("sendRecord fail.", e);
                Looper.prepare();
                context2.sendBroadcast(new Intent(str10));
                Looper.loop();
                intent = new Intent(str8);
                context2.sendBroadcast(intent);
                return false;
            }
            context2 = str8;
            str10 = "com.baidu.ufosdk.reload";
            str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            c.b("getFeedbackChatBack -> response is empty!");
            intent2 = new Intent(str10);
            context2.sendBroadcast(intent2);
            str3 = str8;
            intent = new Intent(str3);
            context2.sendBroadcast(intent);
            return false;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, str, i2)) == null) {
            c.c("FeedbackChatSender --> sendSolvedResult:https://ufosdk.baidu.com/?m=Index&a=recordEvaluation");
            HashMap hashMap = new HashMap();
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("id", str);
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("evaluation", Integer.valueOf(i2));
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                try {
                    String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=recordEvaluation", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                    if (!TextUtils.isEmpty(a3)) {
                        String b2 = k.b(a3);
                        c.c("^^ sendSolvedResult response is: \n" + b2);
                        return ((Integer) new JSONObject(b2).get("errno")).intValue() == 0;
                    }
                } catch (Exception e2) {
                    c.a("sendRecord fail.", e2);
                }
                return false;
            } finally {
                c.d("finally");
            }
        }
        return invokeLI.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Intent intent;
        String a2;
        Intent intent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=getHistory");
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", UfoSDK.clientid);
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("uid", com.baidu.ufosdk.b.f57565d);
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f57565d);
            hashMap.put("username", com.baidu.ufosdk.b.f57563b);
            hashMap.put("os", "android");
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("output_style", 1);
            String a3 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                try {
                    a2 = b.a("https://ufosdk.baidu.com/?m=Index&a=getHistory", "sdk_encrypt=" + URLEncoder.encode(a3, "UTF-8"));
                } catch (Exception e2) {
                    c.a("sendRecord fail.", e2);
                    Looper.prepare();
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                    Looper.loop();
                    intent = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                }
                if (!TextUtils.isEmpty(a2)) {
                    String b2 = k.b(a2);
                    c.a("decode response is " + b2);
                    JSONObject jSONObject = new JSONObject(b2);
                    int intValue = ((Integer) jSONObject.get("errno")).intValue();
                    if (intValue != 0) {
                        if (intValue != 0) {
                            c.b(" ################### errNo != 0");
                            intent2 = new Intent("com.baidu.ufosdk.reload");
                        }
                        intent = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                        context.sendBroadcast(intent);
                        return false;
                    }
                    c.c(" ############################ errNo == 0");
                    Intent intent3 = new Intent("com.baidu.ufosdk.gethistorylist");
                    if (jSONObject.getInt("msgnum") > 0) {
                        UfoSDK.neverFeedback = false;
                        SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        edit.putBoolean("UfoNeverFeedback", false);
                        edit.commit();
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray("msg");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            c.c("#################### " + i2 + " msgArray.getJSONObject(i)--> " + jSONArray.getJSONObject(i2).toString());
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("id", jSONArray.getJSONObject(i2).getString("id"));
                            hashMap2.put("content", jSONArray.getJSONObject(i2).getString("content"));
                            hashMap2.put("time", jSONArray.getJSONObject(i2).getString("time"));
                            hashMap2.put("newmsg", jSONArray.getJSONObject(i2).getString("newmsg"));
                            hashMap2.put("replied", jSONArray.getJSONObject(i2).getString("replied"));
                            hashMap2.put("lastmsg", jSONArray.getJSONObject(i2).getString("lastmsg"));
                            arrayList.add(hashMap2);
                        }
                        intent3.putExtra("msgList", arrayList);
                    } else {
                        UfoSDK.neverFeedback = true;
                        SharedPreferences.Editor edit2 = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        edit2.putBoolean("UfoNeverFeedback", true);
                        edit2.commit();
                        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("msgList", arrayList2);
                        intent3.putExtras(bundle);
                    }
                    context.sendBroadcast(intent3);
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                    return true;
                }
                c.b("getHistoryChat -> response is empty!");
                intent2 = new Intent("com.baidu.ufosdk.reload");
                context.sendBroadcast(intent2);
                intent = new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss");
                context.sendBroadcast(intent);
                return false;
            } catch (Throwable th) {
                context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:58|59)|(2:61|(5:66|67|68|(2:70|71)|(1:76)(1:75))(1:65))|80|(1:63)|66|67|68|(0)|(1:73)|76) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01ab, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a3 A[Catch: Exception -> 0x01aa, all -> 0x0275, TRY_LEAVE, TryCatch #3 {all -> 0x0275, blocks: (B:21:0x00e8, B:22:0x00fc, B:24:0x0102, B:26:0x011b, B:28:0x0126, B:30:0x0130, B:35:0x014c, B:37:0x0152, B:39:0x0168, B:40:0x0170, B:66:0x01f2, B:42:0x0175, B:44:0x017b, B:50:0x018a, B:52:0x0190, B:53:0x0195, B:54:0x019d, B:56:0x01a3, B:61:0x01b0, B:63:0x01b6, B:64:0x01c8, B:59:0x01ab, B:47:0x0183, B:65:0x01d9, B:67:0x0223, B:74:0x024a, B:78:0x025d), top: B:119:0x00e8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        String str4;
        Intent intent;
        String str5;
        String str6;
        JSONObject jSONObject;
        String str7;
        JSONArray jSONArray;
        String str8;
        String str9;
        JSONObject jSONObject2;
        String string;
        JSONArray jSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            String str10 = str;
            String str11 = str2;
            String str12 = "extra";
            String str13 = "id";
            c.b("postUrl is https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient");
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", UfoSDK.clientid);
            if (str11 == null || str2.length() <= 0) {
                str11 = UfoSDK.appid;
            }
            hashMap.put("appid", str11);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("os", "android");
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("msgid", str10);
            hashMap.put("output_style", 1);
            String str14 = "interval";
            hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                try {
                    try {
                        String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                        if (TextUtils.isEmpty(a3)) {
                            str4 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        } else {
                            String b2 = k.b(a3);
                            c.c("---------getFeedbackChat-----------response is " + b2);
                            JSONObject jSONObject3 = new JSONObject(b2);
                            int intValue = ((Integer) jSONObject3.get("errno")).intValue();
                            if (intValue == 0) {
                                try {
                                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                                    Intent intent2 = new Intent("com.baidu.ufosdk.getchat");
                                    if (jSONObject3.getInt("msgnum") > 0) {
                                        str5 = "com.baidu.ufosdk.reload";
                                        try {
                                            jSONArray = jSONObject3.getJSONArray("msg");
                                            str6 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                        } catch (Exception e2) {
                                            e = e2;
                                            str4 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                            str3 = str5;
                                            c.a("sendRecord fail.", e);
                                            Looper.prepare();
                                            context.sendBroadcast(new Intent(str3));
                                            Looper.loop();
                                            intent = new Intent(str4);
                                            context.sendBroadcast(intent);
                                            return false;
                                        }
                                        try {
                                            try {
                                                c.a("getFeedbackChat --> msgArray : \n" + jSONArray.toString());
                                                int i2 = 0;
                                                while (i2 < jSONArray.length()) {
                                                    String str15 = str14;
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put(str13, str10);
                                                    hashMap2.put("toggle", "no");
                                                    String str16 = null;
                                                    String string2 = jSONArray.getJSONObject(i2).has(str12) ? jSONArray.getJSONObject(i2).getString(str12) : null;
                                                    if (jSONArray.getJSONObject(i2).has(str13)) {
                                                        str8 = str12;
                                                        hashMap2.put("chatId", Integer.valueOf(jSONArray.getJSONObject(i2).getInt(str13)));
                                                    } else {
                                                        str8 = str12;
                                                    }
                                                    if (string2 == null || string2.length() == 0) {
                                                        str9 = str13;
                                                        jSONObject2 = jSONObject3;
                                                        hashMap2.put("toggle", "no");
                                                        hashMap2.put("flagRobot", 0);
                                                        string = jSONArray.getJSONObject(i2).getString("content");
                                                    } else {
                                                        str9 = str13;
                                                        JSONObject jSONObject4 = new JSONObject(string2);
                                                        int i3 = jSONObject4.getInt("flagRobot");
                                                        jSONObject2 = jSONObject3;
                                                        hashMap2.put("flagRobot", Integer.valueOf(i3));
                                                        if (i3 == 0) {
                                                            string = jSONArray.getJSONObject(i2).getString("content");
                                                        } else {
                                                            try {
                                                            } catch (Exception e3) {
                                                                e3.printStackTrace();
                                                            }
                                                            if (jSONObject4.has("robot")) {
                                                                jSONArray2 = (JSONArray) jSONObject4.get("robot");
                                                                if (jSONArray2 != null || jSONArray2.length() == 0) {
                                                                    hashMap2.put("flagRobot", 0);
                                                                    if (jSONObject4.has("answer")) {
                                                                        str16 = jSONObject4.getString("answer");
                                                                    }
                                                                    if (str16 != null || str16.length() <= 0) {
                                                                        hashMap2.put("flagRobot", 0);
                                                                        string = jSONArray.getJSONObject(i2).getString("content");
                                                                    } else {
                                                                        hashMap2.put("toggle", "yes");
                                                                        hashMap2.put("flagRobot", 0);
                                                                        string = jSONObject4.getString("answer");
                                                                    }
                                                                } else {
                                                                    string = jSONArray2.toString();
                                                                }
                                                            }
                                                            jSONArray2 = null;
                                                            if (jSONArray2 != null) {
                                                            }
                                                            hashMap2.put("flagRobot", 0);
                                                            if (jSONObject4.has("answer")) {
                                                            }
                                                            if (str16 != null) {
                                                            }
                                                            hashMap2.put("flagRobot", 0);
                                                            string = jSONArray.getJSONObject(i2).getString("content");
                                                        }
                                                    }
                                                    hashMap2.put("content", string);
                                                    hashMap2.put("time", jSONArray.getJSONObject(i2).getString("time"));
                                                    arrayList.add(hashMap2);
                                                    c.c("^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString());
                                                    i2++;
                                                    str10 = str;
                                                    str14 = str15;
                                                    str12 = str8;
                                                    str13 = str9;
                                                    jSONObject3 = jSONObject2;
                                                }
                                                jSONObject = jSONObject3;
                                                str7 = str14;
                                                Bundle bundle = new Bundle();
                                                bundle.putParcelableArrayList("msgList", arrayList);
                                                intent2.putExtras(bundle);
                                                context.sendBroadcast(intent2);
                                            } catch (Throwable th) {
                                                th = th;
                                                str10 = str6;
                                                context.sendBroadcast(new Intent(str10));
                                                throw th;
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            str3 = str5;
                                            str4 = str6;
                                            c.a("sendRecord fail.", e);
                                            Looper.prepare();
                                            context.sendBroadcast(new Intent(str3));
                                            Looper.loop();
                                            intent = new Intent(str4);
                                            context.sendBroadcast(intent);
                                            return false;
                                        }
                                    } else {
                                        str5 = "com.baidu.ufosdk.reload";
                                        str6 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                        jSONObject = jSONObject3;
                                        str7 = "interval";
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    str4 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                                    str3 = "com.baidu.ufosdk.reload";
                                }
                                try {
                                    JSONObject jSONObject5 = jSONObject;
                                    if (((Integer) jSONObject5.get("update")).intValue() == 1) {
                                        com.baidu.ufosdk.b.ah = ((Integer) jSONObject5.get(str7)).intValue();
                                    }
                                    context.sendBroadcast(new Intent(str6));
                                    return true;
                                } catch (Exception e6) {
                                    e = e6;
                                    str4 = str6;
                                    str3 = str5;
                                    c.a("sendRecord fail.", e);
                                    Looper.prepare();
                                    context.sendBroadcast(new Intent(str3));
                                    Looper.loop();
                                    intent = new Intent(str4);
                                    context.sendBroadcast(intent);
                                    return false;
                                }
                            }
                            str5 = "com.baidu.ufosdk.reload";
                            str4 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                            if (intValue != 0) {
                                try {
                                    str3 = str5;
                                } catch (Exception e7) {
                                    e = e7;
                                    str3 = str5;
                                    c.a("sendRecord fail.", e);
                                    Looper.prepare();
                                    context.sendBroadcast(new Intent(str3));
                                    Looper.loop();
                                    intent = new Intent(str4);
                                    context.sendBroadcast(intent);
                                    return false;
                                }
                                try {
                                    context.sendBroadcast(new Intent(str3));
                                } catch (Exception e8) {
                                    e = e8;
                                    c.a("sendRecord fail.", e);
                                    Looper.prepare();
                                    context.sendBroadcast(new Intent(str3));
                                    Looper.loop();
                                    intent = new Intent(str4);
                                    context.sendBroadcast(intent);
                                    return false;
                                }
                            }
                        }
                        intent = new Intent(str4);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str10 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                }
            } catch (Exception e9) {
                e = e9;
                str3 = "com.baidu.ufosdk.reload";
                str4 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
            context.sendBroadcast(intent);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=newmsgnotice");
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", UfoSDK.clientid);
            hashMap.put("appid", UfoSDK.appid);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f57565d);
            hashMap.put("uid", com.baidu.ufosdk.b.f57565d);
            hashMap.put("username", com.baidu.ufosdk.b.f57563b);
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("output_style", 1);
            hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ai));
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                String b2 = k.b(a3);
                c.a("response is " + b2);
                JSONObject jSONObject = new JSONObject(b2);
                c.a("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    if (((Integer) jSONObject.get("newmsg")).intValue() > 0) {
                        context.sendBroadcast(new Intent("com.baidu.ufosdk.getnewhistoryflag"));
                    }
                    if (((Integer) jSONObject.get("update")).intValue() == 1) {
                        com.baidu.ufosdk.b.ai = ((Integer) jSONObject.get("interval")).intValue();
                    }
                    return String.valueOf(jSONObject.get("newmsg"));
                }
                return null;
            } catch (Exception e2) {
                c.a("sendRecord fail.", e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:121:0x02f7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:144:0x0110 */
    /* JADX WARN: Can't wrap try/catch for region: R(15:(3:44|45|(2:47|48)(1:79))|(2:49|50)|(5:52|(7:61|62|63|(2:65|(1:70)(1:69))|71|(1:67)|70)(2:56|(1:60))|32|(1:43)(4:34|(1:36)|37|(2:39|40)(1:42))|41)|75|(1:54)|61|62|63|(0)|71|(0)|70|32|(0)(0)|41) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01ec, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ed, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01bd A[Catch: all -> 0x0292, Exception -> 0x0296, TryCatch #2 {Exception -> 0x0296, blocks: (B:16:0x012a, B:18:0x013f, B:19:0x0150, B:21:0x015a, B:26:0x0170, B:28:0x0176, B:30:0x018c, B:31:0x0194, B:70:0x0239, B:72:0x024e, B:74:0x0258, B:77:0x025f, B:78:0x0262, B:49:0x01bd, B:51:0x01c3, B:53:0x01cf, B:55:0x01d5, B:56:0x01d9, B:65:0x01f3, B:67:0x01f9, B:68:0x0209, B:62:0x01ed, B:46:0x01b7, B:69:0x0220, B:79:0x0276), top: B:130:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e7 A[Catch: Exception -> 0x01ec, all -> 0x0292, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ec, blocks: (B:57:0x01e1, B:59:0x01e7), top: B:128:0x01e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f3 A[Catch: all -> 0x0292, Exception -> 0x0296, TryCatch #2 {Exception -> 0x0296, blocks: (B:16:0x012a, B:18:0x013f, B:19:0x0150, B:21:0x015a, B:26:0x0170, B:28:0x0176, B:30:0x018c, B:31:0x0194, B:70:0x0239, B:72:0x024e, B:74:0x0258, B:77:0x025f, B:78:0x0262, B:49:0x01bd, B:51:0x01c3, B:53:0x01cf, B:55:0x01d5, B:56:0x01d9, B:65:0x01f3, B:67:0x01f9, B:68:0x0209, B:62:0x01ed, B:46:0x01b7, B:69:0x0220, B:79:0x0276), top: B:130:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024e A[Catch: all -> 0x0292, Exception -> 0x0296, TryCatch #2 {Exception -> 0x0296, blocks: (B:16:0x012a, B:18:0x013f, B:19:0x0150, B:21:0x015a, B:26:0x0170, B:28:0x0176, B:30:0x018c, B:31:0x0194, B:70:0x0239, B:72:0x024e, B:74:0x0258, B:77:0x025f, B:78:0x0262, B:49:0x01bd, B:51:0x01c3, B:53:0x01cf, B:55:0x01d5, B:56:0x01d9, B:65:0x01f3, B:67:0x01f9, B:68:0x0209, B:62:0x01ed, B:46:0x01b7, B:69:0x0220, B:79:0x0276), top: B:130:0x012a }] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        String str4;
        Intent intent;
        String a2;
        String str5;
        ArrayList<? extends Parcelable> arrayList;
        Intent intent2;
        String string;
        JSONArray jSONArray;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, str, str2)) == null) {
            String str8 = context;
            Context context2 = str;
            HashMap hashMap = new HashMap();
            hashMap.put("appid", str2);
            hashMap.put("appvn", e.b());
            hashMap.put("baiducuid", com.baidu.ufosdk.b.f57564c);
            hashMap.put("clientid", UfoSDK.clientid);
            hashMap.put("devid", UfoSDK.devid);
            String str9 = "extra";
            hashMap.put("extra", com.baidu.ufosdk.b.f57567f);
            String str10 = "id";
            hashMap.put("id", context2);
            hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
            hashMap.put("model", Build.MODEL);
            hashMap.put("os", "android");
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("uid", com.baidu.ufosdk.b.f57565d);
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f57565d);
            hashMap.put("username", com.baidu.ufosdk.b.f57563b);
            hashMap.put("output_style", 1);
            String a3 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                try {
                    a2 = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(a3, "UTF-8"));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
                context2 = str8;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            } catch (Throwable th2) {
                th = th2;
                context2 = str8;
                str8 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            }
            if (!TextUtils.isEmpty(a2)) {
                String b2 = k.b(a2);
                c.a("response is " + b2);
                JSONObject jSONObject = new JSONObject(b2);
                c.c("response is -- >  " + b2);
                int intValue = ((Integer) jSONObject.get("errno")).intValue();
                if (intValue == 0) {
                    ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                    Intent intent3 = new Intent("com.baidu.ufosdk.getchat");
                    if (jSONObject.getInt("msgnum") > 0) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("msg");
                        str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                        try {
                            c.a("getFeedbackAnswer2 --> msgArray : \n" + jSONArray2.toString());
                            int i2 = 0;
                            str8 = str8;
                            while (i2 < jSONArray2.length()) {
                                try {
                                    try {
                                        HashMap hashMap2 = new HashMap();
                                        hashMap2.put(str10, context2);
                                        hashMap2.put("toggle", "no");
                                        if (jSONArray2.getJSONObject(i2).has(str10)) {
                                            hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i2).getInt(str10)));
                                        }
                                        String string2 = jSONArray2.getJSONObject(i2).has(str9) ? jSONArray2.getJSONObject(i2).getString(str9) : null;
                                        String str11 = str10;
                                        String str12 = str9;
                                        if (string2 == null || string2.length() == 0) {
                                            arrayList = arrayList2;
                                            intent2 = intent3;
                                            hashMap2.put("toggle", "no");
                                            hashMap2.put("flagRobot", 0);
                                            string = jSONArray2.getJSONObject(i2).getString("content");
                                        } else {
                                            intent2 = intent3;
                                            JSONObject jSONObject2 = new JSONObject(string2);
                                            int i3 = jSONObject2.getInt("flagRobot");
                                            arrayList = arrayList2;
                                            hashMap2.put("flagRobot", Integer.valueOf(i3));
                                            if (i3 == 0) {
                                                string = jSONArray2.getJSONObject(i2).getString("content");
                                            } else {
                                                try {
                                                    jSONArray = jSONObject2.has("robot") ? (JSONArray) jSONObject2.get("robot") : null;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    jSONArray = null;
                                                }
                                                try {
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    e.printStackTrace();
                                                    str6 = null;
                                                    if (jSONArray != null) {
                                                    }
                                                    hashMap2.put("flagRobot", 0);
                                                    if (jSONObject2.has("answer")) {
                                                    }
                                                    str7 = null;
                                                    if (str7 != null) {
                                                    }
                                                    hashMap2.put("flagRobot", 0);
                                                    hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                    hashMap2.put("toggle", "yes");
                                                    hashMap2.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                                                    if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                                    }
                                                    ArrayList<? extends Parcelable> arrayList3 = arrayList;
                                                    arrayList3.add(hashMap2);
                                                    i2++;
                                                    str8 = context;
                                                    arrayList2 = arrayList3;
                                                    str10 = str11;
                                                    str9 = str12;
                                                    intent3 = intent2;
                                                    context2 = str;
                                                }
                                                if (jSONObject2.has("tip")) {
                                                    str6 = jSONObject2.getString("tip");
                                                    if (jSONArray != null || jSONArray.length() == 0) {
                                                        hashMap2.put("flagRobot", 0);
                                                        if (jSONObject2.has("answer")) {
                                                            str7 = jSONObject2.getString("answer");
                                                            if (str7 != null || str7.length() <= 0) {
                                                                hashMap2.put("flagRobot", 0);
                                                                hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                                hashMap2.put("toggle", "yes");
                                                            } else {
                                                                hashMap2.put("toggle", "yes");
                                                                hashMap2.put("flagRobot", 0);
                                                                string = jSONObject2.getString("answer");
                                                            }
                                                        }
                                                        str7 = null;
                                                        if (str7 != null) {
                                                        }
                                                        hashMap2.put("flagRobot", 0);
                                                        hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                        hashMap2.put("toggle", "yes");
                                                    } else {
                                                        hashMap2.put("content", jSONArray.toString());
                                                        hashMap2.put("toggle", "no");
                                                        if (str6 != null && str6.length() > 0) {
                                                            hashMap2.put("tip", str6);
                                                        }
                                                    }
                                                    hashMap2.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                                                    if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                                        int i4 = jSONArray2.getJSONObject(i2).getInt("evaluation");
                                                        if (i4 == 0) {
                                                            hashMap2.put("toggle", "no");
                                                        }
                                                        if (i4 == 10) {
                                                            hashMap2.put("toggle", "yes");
                                                        }
                                                    }
                                                    ArrayList<? extends Parcelable> arrayList32 = arrayList;
                                                    arrayList32.add(hashMap2);
                                                    i2++;
                                                    str8 = context;
                                                    arrayList2 = arrayList32;
                                                    str10 = str11;
                                                    str9 = str12;
                                                    intent3 = intent2;
                                                    context2 = str;
                                                }
                                                str6 = null;
                                                if (jSONArray != null) {
                                                }
                                                hashMap2.put("flagRobot", 0);
                                                if (jSONObject2.has("answer")) {
                                                }
                                                str7 = null;
                                                if (str7 != null) {
                                                }
                                                hashMap2.put("flagRobot", 0);
                                                hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                                hashMap2.put("toggle", "yes");
                                                hashMap2.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                                                if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                                }
                                                ArrayList<? extends Parcelable> arrayList322 = arrayList;
                                                arrayList322.add(hashMap2);
                                                i2++;
                                                str8 = context;
                                                arrayList2 = arrayList322;
                                                str10 = str11;
                                                str9 = str12;
                                                intent3 = intent2;
                                                context2 = str;
                                            }
                                        }
                                        hashMap2.put("content", string);
                                        hashMap2.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                                        if (jSONArray2.getJSONObject(i2).has("evaluation")) {
                                        }
                                        ArrayList<? extends Parcelable> arrayList3222 = arrayList;
                                        arrayList3222.add(hashMap2);
                                        i2++;
                                        str8 = context;
                                        arrayList2 = arrayList3222;
                                        str10 = str11;
                                        str9 = str12;
                                        intent3 = intent2;
                                        context2 = str;
                                    } catch (Exception e5) {
                                        e = e5;
                                        context2 = context;
                                        str4 = "com.baidu.ufosdk.reload";
                                        str3 = str5;
                                        c.a("sendRecord fail.", e);
                                        Looper.prepare();
                                        context2.sendBroadcast(new Intent(str4));
                                        Looper.loop();
                                        intent = new Intent(str3);
                                        context2.sendBroadcast(intent);
                                        return false;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    context2 = context;
                                    str8 = str5;
                                    context2.sendBroadcast(new Intent(str8));
                                    throw th;
                                }
                            }
                            Intent intent4 = intent3;
                            Bundle bundle = new Bundle();
                            bundle.putParcelableArrayList("msgList", arrayList2);
                            intent4.putExtras(bundle);
                            context2 = context;
                            try {
                                context2.sendBroadcast(intent4);
                            } catch (Exception e6) {
                                e = e6;
                                str4 = "com.baidu.ufosdk.reload";
                                str3 = str5;
                                c.a("sendRecord fail.", e);
                                Looper.prepare();
                                context2.sendBroadcast(new Intent(str4));
                                Looper.loop();
                                intent = new Intent(str3);
                                context2.sendBroadcast(intent);
                                return false;
                            } catch (Throwable th4) {
                                th = th4;
                                str8 = str5;
                                context2.sendBroadcast(new Intent(str8));
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            context2 = str8;
                        } catch (Throwable th5) {
                            th = th5;
                            context2 = str8;
                        }
                    } else {
                        context2 = str8;
                        str5 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                    }
                    context2.sendBroadcast(new Intent(str5));
                    return true;
                }
                context2 = str8;
                str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
                if (intValue != 0) {
                    try {
                        str4 = "com.baidu.ufosdk.reload";
                        try {
                            context2.sendBroadcast(new Intent(str4));
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        str4 = "com.baidu.ufosdk.reload";
                        c.a("sendRecord fail.", e);
                        Looper.prepare();
                        context2.sendBroadcast(new Intent(str4));
                        Looper.loop();
                        intent = new Intent(str3);
                        context2.sendBroadcast(intent);
                        return false;
                    }
                }
                c.a("sendRecord fail.", e);
                Looper.prepare();
                context2.sendBroadcast(new Intent(str4));
                Looper.loop();
                intent = new Intent(str3);
                context2.sendBroadcast(intent);
                return false;
            }
            context2 = str8;
            str3 = "com.baidu.ufosdk.deletemsg_dialogdismiss";
            intent = new Intent(str3);
            context2.sendBroadcast(intent);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static String d(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, str2)) == null) {
            c.c("-.-postUrl is https://ufosdk.baidu.com/?m=Index&a=getallmsgbyclientid");
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", UfoSDK.clientid);
            if (str2 == null || str2.length() <= 0) {
                str2 = UfoSDK.appid;
            }
            hashMap.put("appid", str2);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("id", str);
            hashMap.put("os", "android");
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("output_style", 1);
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=getallmsgbyclientid", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(k.b(a3));
                c.a("response is " + jSONObject.toString());
                int intValue = ((Integer) jSONObject.get("errno")).intValue();
                if (intValue != 0 || jSONObject.getInt("msgnum") <= 0) {
                    if (intValue != 0) {
                        context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                        return null;
                    }
                    return null;
                }
                return jSONObject.getJSONArray("msg").toString();
            } catch (Exception e2) {
                c.a("sendRecord fail.", e2);
                Looper.prepare();
                context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                Looper.loop();
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean e(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", UfoSDK.clientid);
            if (str2 == null || str2.length() <= 0) {
                str2 = UfoSDK.appid;
            }
            hashMap.put("appid", str2);
            hashMap.put("devid", UfoSDK.devid);
            hashMap.put("uid", com.baidu.ufosdk.b.f57565d);
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f57565d);
            hashMap.put("username", com.baidu.ufosdk.b.f57563b);
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("id", str);
            String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = b.a("https://ufosdk.baidu.com/?m=Index&a=delmsgbyid", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return false;
                }
                if (((Integer) new JSONObject(k.b(a3)).get("errno")).intValue() == 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
                    return true;
                }
                context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                Looper.prepare();
                Toast.makeText(context, "删除失败，请稍后重试。", 1).show();
                Looper.loop();
                return false;
            } catch (Exception e2) {
                context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                c.a("sendRecord fail.", e2);
                Looper.prepare();
                Toast.makeText(context, "删除失败，请稍后重试。", 1).show();
                Looper.loop();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
