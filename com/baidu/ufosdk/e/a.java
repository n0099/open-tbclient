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
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.b.e;
import com.baidu.ufosdk.f.c;
import com.baidu.ufosdk.f.i;
import com.baidu.ufosdk.f.j;
import com.baidu.ufosdk.f.k;
import com.baidu.ufosdk.f.p;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public final class a {
    public static void a(int i, int i2, Handler handler) {
        c.d("postUrl is https://ufosdk.baidu.com/?m=Index&a=getProductType");
        c.d("getTitleAndHint (*^o^*) success!! product_type = " + i);
        c.d("getTitleAndHint (*^o^*) success!! appid = " + UfoSDK.appid);
        c.d("getTitleAndHint (*^o^*) success!! extend_feedback_channel = " + i2);
        HashMap hashMap = new HashMap();
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("sdkvn", "2.9.10");
        if (i != 0) {
            hashMap.put("product_type", Integer.valueOf(i));
        }
        if (i2 != -1) {
            hashMap.put("extend_feedback_channel", Integer.valueOf(i2));
        }
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getProductType", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (TextUtils.isEmpty(a)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(k.b(a));
            c.c("response is " + jSONObject.toString());
            if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                c.d("getTitleAndHint   (*^o^*) success!! \n" + jSONObject.toString());
                JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                JSONObject jSONObject2 = jSONArray.length() == 1 ? (JSONObject) jSONArray.get(0) : null;
                if (jSONObject2 == null || jSONObject2.length() <= 0) {
                    return;
                }
                handler.obtainMessage(18, jSONObject2).sendToTarget();
            }
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
        }
    }

    public static void a(Context context, int i, int i2, int i3, int i4, boolean z) {
        String b = d.b(context);
        boolean contains = b.contains(RomUtils.UNKNOWN);
        boolean contains2 = b.contains("NONE");
        if (contains || contains2) {
            SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
            String b2 = i.b(System.currentTimeMillis());
            UfoSDK.startStr = b2 + "-enable";
            edit.putString("lastStart", b2 + "-enable");
            return;
        }
        com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(context);
        String format = String.format("https://ufosdk.baidu.com/?m=hide&a=behavior&editFeedbackView=%d&editFeedbackWord=%d&editFeedbackPicture=%d&myFeedback=%d&appid=%s&editFeedbackViewUV=%d&editFeedbackViewFromRobotUV=%d&editFeedbackViewFromFaqUV=%d&robotUv=%d", Integer.valueOf(dVar.a()), Integer.valueOf(dVar.b()), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.d()), UfoSDK.appid, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        c.c("--FeedbackChatSender:1517--getURL is : " + format);
        try {
            if (b.a(format)) {
                SharedPreferences.Editor edit2 = context.getSharedPreferences("UfoSharePreference", 0).edit();
                edit2.putInt("editFeedbackViewUV", 0);
                edit2.putInt("editFeedbackViewFromRobotUV", 0);
                edit2.putInt("editFeedbackViewFromFaqUV", 0);
                edit2.putInt("robotUv", 0);
                String b3 = i.b(System.currentTimeMillis());
                if (z) {
                    UfoSDK.startStr = b3 + "-enable";
                    edit2.putString("lastStart", b3 + "-enable");
                } else {
                    UfoSDK.startStr = b3 + "-disable";
                    edit2.putString("lastStart", b3 + "-disable");
                }
                edit2.commit();
            } else {
                SharedPreferences.Editor edit3 = context.getSharedPreferences("UfoSharePreference", 0).edit();
                edit3.putInt("editFeedbackViewUV", 0);
                edit3.putInt("editFeedbackViewFromRobotUV", 0);
                edit3.putInt("editFeedbackViewFromFaqUV", 0);
                edit3.putInt("robotUv", 0);
                String b4 = i.b(System.currentTimeMillis());
                if (z) {
                    UfoSDK.startStr = b4 + "-enable";
                    edit3.putString("lastStart", b4 + "-enable");
                } else {
                    UfoSDK.startStr = b4 + "-disable";
                    edit3.putString("lastStart", b4 + "-disable");
                }
                edit3.commit();
            }
            dVar.c(0);
            dVar.a(0);
            dVar.b(0);
            dVar.d(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Handler handler) {
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
        hashMap.put(Constants.PHONE_BRAND, Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("osvc", String.valueOf(j.a()));
        hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
        hashMap.put("sdkvn", "2.9.10");
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getProductType", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(k.b(a));
                c.c("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    JSONArray jSONArray = (JSONArray) jSONObject.get("data");
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        handler.obtainMessage(10).sendToTarget();
                    } else {
                        handler.obtainMessage(9, jSONArray).sendToTarget();
                    }
                }
            }
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
        }
    }

    public static boolean a(Context context) {
        long j;
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
        hashMap.put(Constants.PHONE_BRAND, Build.MANUFACTURER);
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
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        hashMap.put("screensize", (i == 0 && i2 == 0) ? null : String.valueOf(i) + "*" + String.valueOf(i2));
        hashMap.put("sdkvn", "2.9.10");
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=postclientinfo", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(k.b(a));
                c.a("getAPIKey response is " + jSONObject.toString());
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    String string = jSONObject.getString("clientid");
                    String string2 = jSONObject.getString("appid");
                    String string3 = jSONObject.getString("devid");
                    String string4 = jSONObject.getString(com.baidu.android.imsdk.internal.Constants.KEY_PRODUCT_LINE);
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
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:49|50|51|(2:53|(6:58|59|60|61|(1:63)|(1:68)(1:67))(1:57))|72|(1:55)|58|59|60|61|(0)|(1:65)|68) */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02a4, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02a5, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0265 A[Catch: all -> 0x0297, Exception -> 0x02a4, TRY_LEAVE, TryCatch #1 {all -> 0x0297, Exception -> 0x0225, blocks: (B:11:0x0072, B:13:0x0093, B:15:0x00be, B:17:0x00d4, B:18:0x00f4, B:20:0x00fa, B:22:0x011c, B:23:0x0127, B:25:0x0134, B:27:0x014b, B:29:0x0151, B:31:0x0169, B:32:0x017a, B:34:0x0199, B:35:0x01aa, B:37:0x01b6, B:38:0x01ca, B:85:0x0320, B:88:0x033a, B:91:0x034c, B:43:0x01ff, B:45:0x0208, B:47:0x0213, B:49:0x0219, B:59:0x0250, B:61:0x025c, B:63:0x0265, B:65:0x026e, B:67:0x0274, B:74:0x02a9, B:73:0x02a5, B:57:0x024b, B:75:0x02c7, B:77:0x02d4, B:79:0x02e1, B:80:0x02ea, B:81:0x0308, B:82:0x0312, B:92:0x035a, B:93:0x036b, B:95:0x037b, B:98:0x039a, B:100:0x03b2, B:52:0x0226), top: B:104:0x0072 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2) {
        JSONArray jSONArray;
        String str3;
        c.b("postUrl is https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        if (str2 == null || str2.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", str2);
        }
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("output_style", 1);
        if (str != null) {
            hashMap.put("msgid", str);
        } else {
            hashMap.put("msgid", "newMessage");
        }
        hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (TextUtils.isEmpty(a)) {
                c.b("getFeedbackChatBack -> response is empty!");
                context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            } else {
                String b = k.b(a);
                c.c("-----------getFeedbackChatBack---------response is " + b);
                JSONObject jSONObject = new JSONObject(b);
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent = new Intent("com.baidu.ufosdk.getchat");
                    if (jSONObject.getInt("msgnum") > 0) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("msg");
                        c.a("getFeedbackChatBack --> msgArray : \n" + jSONArray2.toString());
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= jSONArray2.length()) {
                                break;
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("id", str);
                            hashMap2.put("toggle", "no");
                            String string = jSONArray2.getJSONObject(i2).has("extra") ? jSONArray2.getJSONObject(i2).getString("extra") : null;
                            if (jSONArray2.getJSONObject(i2).has("id")) {
                                hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i2).getInt("id")));
                            }
                            if (string == null || string.length() == 0) {
                                if (!jSONArray2.getJSONObject(i2).has("evaluation")) {
                                    hashMap2.put("toggle", "no");
                                } else if (jSONArray2.getJSONObject(i2).getInt("evaluation") == 0) {
                                    hashMap2.put("toggle", "no");
                                } else {
                                    hashMap2.put("toggle", "yes");
                                }
                                hashMap2.put("flagRobot", 0);
                                hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                            } else {
                                JSONObject jSONObject2 = new JSONObject(string);
                                int i3 = jSONObject2.getInt("flagRobot");
                                hashMap2.put("flagRobot", Integer.valueOf(i3));
                                if (i3 == 0) {
                                    hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                } else {
                                    try {
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    if (jSONObject2.has("robot")) {
                                        jSONArray = (JSONArray) jSONObject2.get("robot");
                                        if (jSONArray != null || jSONArray.length() == 0) {
                                            hashMap2.put("flagRobot", 0);
                                            str3 = null;
                                            if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                                str3 = jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE);
                                            }
                                            if (str3 != null || str3.length() <= 0) {
                                                hashMap2.put("flagRobot", 0);
                                                hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                            } else {
                                                hashMap2.put("toggle", "yes");
                                                hashMap2.put("flagRobot", 0);
                                                hashMap2.put("content", jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE));
                                            }
                                        } else {
                                            hashMap2.put("content", jSONArray.toString());
                                        }
                                    }
                                    jSONArray = null;
                                    if (jSONArray != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    str3 = null;
                                    if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                    }
                                    if (str3 != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    hashMap2.put("content", jSONArray2.getJSONObject(i2).getString("content"));
                                }
                            }
                            hashMap2.put("time", jSONArray2.getJSONObject(i2).getString("time"));
                            int intValue2 = jSONArray2.getJSONObject(i2).has("evaluation") ? ((Integer) jSONArray2.getJSONObject(i2).get("evaluation")).intValue() : 0;
                            hashMap2.put("evaluation", Integer.valueOf(intValue2));
                            if (intValue2 == 0) {
                                hashMap2.put(UgcUBCUtils.UGC_TYPE_ASK, 0);
                                hashMap2.put("toggle", "no");
                            } else if (intValue2 == 10) {
                                hashMap2.put(UgcUBCUtils.UGC_TYPE_ASK, 1);
                                hashMap2.put("toggle", "yes");
                            } else if (intValue2 <= 9) {
                                hashMap2.put(UgcUBCUtils.UGC_TYPE_ASK, 9);
                            } else if (intValue2 >= 11) {
                                hashMap2.put(UgcUBCUtils.UGC_TYPE_ASK, 11);
                            }
                            arrayList.add(hashMap2);
                            c.b("^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString());
                            i = i2 + 1;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("msgList", arrayList);
                        intent.putExtras(bundle);
                        context.sendBroadcast(intent);
                    }
                    if (((Integer) jSONObject.get(IMTrack.DbBuilder.ACTION_UPDATE)).intValue() == 1) {
                        com.baidu.ufosdk.b.ah = ((Integer) jSONObject.get("interval")).intValue();
                    }
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                    return true;
                } else if (intValue != 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Exception e2) {
            c.a("sendRecord fail.", e2);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        } finally {
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
        }
        return false;
    }

    public static boolean a(String str, int i) {
        String a;
        c.c("FeedbackChatSender --> sendSolvedResult:https://ufosdk.baidu.com/?m=Index&a=recordEvaluation");
        HashMap hashMap = new HashMap();
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("id", str);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("evaluation", Integer.valueOf(i));
        try {
            a = b.a("https://ufosdk.baidu.com/?m=Index&a=recordEvaluation", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
        } finally {
            c.d("finally");
        }
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        String b = k.b(a);
        c.c("^^ sendSolvedResult response is: \n" + b);
        if (((Integer) new JSONObject(b).get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
            c.d("finally");
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=getHistory");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("output_style", 1);
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getHistory", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (TextUtils.isEmpty(a)) {
                c.b("getHistoryChat -> response is empty!");
                context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            } else {
                String b = k.b(a);
                c.a("decode response is " + b);
                JSONObject jSONObject = new JSONObject(b);
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    c.c(" ############################ errNo == 0");
                    Intent intent = new Intent("com.baidu.ufosdk.gethistorylist");
                    if (jSONObject.getInt("msgnum") > 0) {
                        UfoSDK.neverFeedback = false;
                        SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        edit.putBoolean("UfoNeverFeedback", false);
                        edit.commit();
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray("msg");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            c.c("#################### " + i + " msgArray.getJSONObject(i)--> " + jSONArray.getJSONObject(i).toString());
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("id", jSONArray.getJSONObject(i).getString("id"));
                            hashMap2.put("content", jSONArray.getJSONObject(i).getString("content"));
                            hashMap2.put("time", jSONArray.getJSONObject(i).getString("time"));
                            hashMap2.put("newmsg", jSONArray.getJSONObject(i).getString("newmsg"));
                            hashMap2.put("replied", jSONArray.getJSONObject(i).getString("replied"));
                            hashMap2.put("lastmsg", jSONArray.getJSONObject(i).getString("lastmsg"));
                            arrayList.add(hashMap2);
                        }
                        intent.putExtra("msgList", arrayList);
                        context.sendBroadcast(intent);
                    } else {
                        UfoSDK.neverFeedback = true;
                        SharedPreferences.Editor edit2 = context.getSharedPreferences("UfoSharePreference", 0).edit();
                        edit2.putBoolean("UfoNeverFeedback", true);
                        edit2.commit();
                        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("msgList", arrayList2);
                        intent.putExtras(bundle);
                        context.sendBroadcast(intent);
                    }
                    return true;
                } else if (intValue != 0) {
                    c.b(" ################### errNo != 0");
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        } finally {
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:31|32|(2:34|(7:39|40|41|(2:43|(1:48)(1:47))|49|(1:45)|48)(1:38))|53|(1:36)|39|40|41|(0)|49|(0)|48) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0255, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0256, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0216 A[Catch: all -> 0x0248, Exception -> 0x0255, TRY_LEAVE, TryCatch #1 {all -> 0x0248, Exception -> 0x01d7, blocks: (B:8:0x0072, B:10:0x0093, B:12:0x00be, B:14:0x00d4, B:15:0x00f3, B:17:0x00f9, B:19:0x011a, B:20:0x0125, B:22:0x0132, B:24:0x0149, B:26:0x014f, B:28:0x0167, B:29:0x0178, B:32:0x01b2, B:34:0x01bb, B:36:0x01c6, B:38:0x01cc, B:48:0x0202, B:49:0x020d, B:51:0x0216, B:53:0x021f, B:55:0x0225, B:63:0x025b, B:61:0x0256, B:46:0x01fd, B:64:0x0279, B:65:0x02a0, B:66:0x02b1, B:68:0x02c0, B:71:0x02df, B:41:0x01d8), top: B:76:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x021f A[Catch: Exception -> 0x01d7, all -> 0x0248, Merged into TryCatch #1 {all -> 0x0248, Exception -> 0x01d7, blocks: (B:8:0x0072, B:10:0x0093, B:12:0x00be, B:14:0x00d4, B:15:0x00f3, B:17:0x00f9, B:19:0x011a, B:20:0x0125, B:22:0x0132, B:24:0x0149, B:26:0x014f, B:28:0x0167, B:29:0x0178, B:32:0x01b2, B:34:0x01bb, B:36:0x01c6, B:38:0x01cc, B:48:0x0202, B:49:0x020d, B:51:0x0216, B:53:0x021f, B:55:0x0225, B:63:0x025b, B:61:0x0256, B:46:0x01fd, B:64:0x0279, B:65:0x02a0, B:66:0x02b1, B:68:0x02c0, B:71:0x02df, B:41:0x01d8), top: B:76:0x0072 }, TRY_ENTER] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2) {
        JSONArray jSONArray;
        String str3;
        c.b("postUrl is https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        if (str2 == null || str2.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", str2);
        }
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("msgid", str);
        hashMap.put("output_style", 1);
        hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                String b = k.b(a);
                c.c("---------getFeedbackChat-----------response is " + b);
                JSONObject jSONObject = new JSONObject(b);
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent = new Intent("com.baidu.ufosdk.getchat");
                    if (jSONObject.getInt("msgnum") > 0) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("msg");
                        c.a("getFeedbackChat --> msgArray : \n" + jSONArray2.toString());
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("id", str);
                            hashMap2.put("toggle", "no");
                            String string = jSONArray2.getJSONObject(i).has("extra") ? jSONArray2.getJSONObject(i).getString("extra") : null;
                            if (jSONArray2.getJSONObject(i).has("id")) {
                                hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i).getInt("id")));
                            }
                            if (string == null || string.length() == 0) {
                                hashMap2.put("toggle", "no");
                                hashMap2.put("flagRobot", 0);
                                hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                            } else {
                                JSONObject jSONObject2 = new JSONObject(string);
                                int i2 = jSONObject2.getInt("flagRobot");
                                hashMap2.put("flagRobot", Integer.valueOf(i2));
                                if (i2 == 0) {
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                } else {
                                    try {
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    if (jSONObject2.has("robot")) {
                                        jSONArray = (JSONArray) jSONObject2.get("robot");
                                        if (jSONArray != null || jSONArray.length() == 0) {
                                            hashMap2.put("flagRobot", 0);
                                            if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                                str3 = jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE);
                                                if (str3 != null || str3.length() <= 0) {
                                                    hashMap2.put("flagRobot", 0);
                                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                } else {
                                                    hashMap2.put("toggle", "yes");
                                                    hashMap2.put("flagRobot", 0);
                                                    hashMap2.put("content", jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE));
                                                }
                                            }
                                            str3 = null;
                                            if (str3 != null) {
                                            }
                                            hashMap2.put("flagRobot", 0);
                                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                        } else {
                                            hashMap2.put("content", jSONArray.toString());
                                        }
                                    }
                                    jSONArray = null;
                                    if (jSONArray != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                    }
                                    str3 = null;
                                    if (str3 != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                }
                            }
                            hashMap2.put("time", jSONArray2.getJSONObject(i).getString("time"));
                            arrayList.add(hashMap2);
                            c.c("^^^^^^^^getFeedbackChat^^^^^^^^^" + arrayList.toString());
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("msgList", arrayList);
                        intent.putExtras(bundle);
                        context.sendBroadcast(intent);
                    }
                    if (((Integer) jSONObject.get(IMTrack.DbBuilder.ACTION_UPDATE)).intValue() == 1) {
                        com.baidu.ufosdk.b.ah = ((Integer) jSONObject.get("interval")).intValue();
                    }
                    return true;
                } else if (intValue != 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Exception e2) {
            c.a("sendRecord fail.", e2);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        } finally {
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
        }
        return false;
    }

    public static String c(Context context) {
        c.c("postUrl is https://ufosdk.baidu.com/?m=Index&a=newmsgnotice");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("output_style", 1);
        hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ai));
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                String b = k.b(a);
                c.a("response is " + b);
                JSONObject jSONObject = new JSONObject(b);
                c.a("response is " + jSONObject.toString());
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    if (((Integer) jSONObject.get("newmsg")).intValue() > 0) {
                        context.sendBroadcast(new Intent("com.baidu.ufosdk.getnewhistoryflag"));
                    }
                    if (((Integer) jSONObject.get(IMTrack.DbBuilder.ACTION_UPDATE)).intValue() == 1) {
                        com.baidu.ufosdk.b.ai = ((Integer) jSONObject.get("interval")).intValue();
                    }
                    return String.valueOf(jSONObject.get("newmsg"));
                }
            }
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(5:34|35|(2:37|38)(1:69)|39|40)|(2:42|(7:51|52|53|(2:55|(1:60)(1:59))|61|(1:57)|60)(2:46|(1:50)))|65|(1:44)|51|52|53|(0)|61|(0)|60) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02c0, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x02c1, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c8 A[Catch: Exception -> 0x0241, all -> 0x02b3, Merged into TryCatch #2 {all -> 0x02b3, Exception -> 0x0241, blocks: (B:3:0x0091, B:5:0x00b2, B:7:0x00f0, B:9:0x0106, B:10:0x0125, B:12:0x012b, B:14:0x014c, B:15:0x0161, B:17:0x016e, B:19:0x017b, B:21:0x0181, B:23:0x0199, B:24:0x01aa, B:26:0x01c8, B:28:0x01d5, B:31:0x01e2, B:32:0x01eb, B:34:0x01f3, B:36:0x01fc, B:38:0x0206, B:40:0x020f, B:42:0x0218, B:44:0x021e, B:46:0x0233, B:48:0x0239, B:59:0x026d, B:60:0x0278, B:62:0x0281, B:64:0x028a, B:66:0x0290, B:74:0x02c6, B:72:0x02c1, B:57:0x0268, B:75:0x02ed, B:76:0x0314, B:79:0x0335, B:51:0x0242), top: B:89:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0218 A[Catch: Exception -> 0x0241, all -> 0x02b3, Merged into TryCatch #2 {all -> 0x02b3, Exception -> 0x0241, blocks: (B:3:0x0091, B:5:0x00b2, B:7:0x00f0, B:9:0x0106, B:10:0x0125, B:12:0x012b, B:14:0x014c, B:15:0x0161, B:17:0x016e, B:19:0x017b, B:21:0x0181, B:23:0x0199, B:24:0x01aa, B:26:0x01c8, B:28:0x01d5, B:31:0x01e2, B:32:0x01eb, B:34:0x01f3, B:36:0x01fc, B:38:0x0206, B:40:0x020f, B:42:0x0218, B:44:0x021e, B:46:0x0233, B:48:0x0239, B:59:0x026d, B:60:0x0278, B:62:0x0281, B:64:0x028a, B:66:0x0290, B:74:0x02c6, B:72:0x02c1, B:57:0x0268, B:75:0x02ed, B:76:0x0314, B:79:0x0335, B:51:0x0242), top: B:89:0x0091 }, TRY_ENTER] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0281 A[Catch: all -> 0x02b3, Exception -> 0x02c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x02c0, blocks: (B:60:0x0278, B:62:0x0281), top: B:85:0x0278 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x028a A[Catch: Exception -> 0x0241, all -> 0x02b3, Merged into TryCatch #2 {all -> 0x02b3, Exception -> 0x0241, blocks: (B:3:0x0091, B:5:0x00b2, B:7:0x00f0, B:9:0x0106, B:10:0x0125, B:12:0x012b, B:14:0x014c, B:15:0x0161, B:17:0x016e, B:19:0x017b, B:21:0x0181, B:23:0x0199, B:24:0x01aa, B:26:0x01c8, B:28:0x01d5, B:31:0x01e2, B:32:0x01eb, B:34:0x01f3, B:36:0x01fc, B:38:0x0206, B:40:0x020f, B:42:0x0218, B:44:0x021e, B:46:0x0233, B:48:0x0239, B:59:0x026d, B:60:0x0278, B:62:0x0281, B:64:0x028a, B:66:0x0290, B:74:0x02c6, B:72:0x02c1, B:57:0x0268, B:75:0x02ed, B:76:0x0314, B:79:0x0335, B:51:0x0242), top: B:89:0x0091 }, TRY_ENTER] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, String str, String str2) {
        JSONArray jSONArray;
        String str3;
        String str4;
        HashMap hashMap = new HashMap();
        hashMap.put("appid", str2);
        hashMap.put("appvn", e.b());
        hashMap.put("baiducuid", com.baidu.ufosdk.b.c);
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("extra", com.baidu.ufosdk.b.f);
        hashMap.put("id", str);
        hashMap.put("interval", String.valueOf(com.baidu.ufosdk.b.ah));
        hashMap.put("model", Build.MODEL);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put("output_style", 1);
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getmsgbyclient", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                String b = k.b(a);
                c.a("response is " + b);
                JSONObject jSONObject = new JSONObject(b);
                c.c("response is -- >  " + b);
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Intent intent = new Intent("com.baidu.ufosdk.getchat");
                    if (jSONObject.getInt("msgnum") > 0) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("msg");
                        c.a("getFeedbackAnswer2 --> msgArray : \n" + jSONArray2.toString());
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("id", str);
                            hashMap2.put("toggle", "no");
                            if (jSONArray2.getJSONObject(i).has("id")) {
                                hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i).getInt("id")));
                            }
                            String string = jSONArray2.getJSONObject(i).has("extra") ? jSONArray2.getJSONObject(i).getString("extra") : null;
                            if (string == null || string.length() == 0) {
                                hashMap2.put("toggle", "no");
                                hashMap2.put("flagRobot", 0);
                                hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                            } else {
                                JSONObject jSONObject2 = new JSONObject(string);
                                int i2 = jSONObject2.getInt("flagRobot");
                                hashMap2.put("flagRobot", Integer.valueOf(i2));
                                if (i2 == 0) {
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                } else {
                                    try {
                                        jSONArray = jSONObject2.has("robot") ? (JSONArray) jSONObject2.get("robot") : null;
                                        try {
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                            str3 = null;
                                            if (jSONArray != null) {
                                            }
                                            hashMap2.put("flagRobot", 0);
                                            if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                            }
                                            str4 = null;
                                            if (str4 != null) {
                                            }
                                            hashMap2.put("flagRobot", 0);
                                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                            hashMap2.put("toggle", "yes");
                                            hashMap2.put("time", jSONArray2.getJSONObject(i).getString("time"));
                                            if (jSONArray2.getJSONObject(i).has("evaluation")) {
                                            }
                                            arrayList.add(hashMap2);
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        jSONArray = null;
                                    }
                                    if (jSONObject2.has(AlaStaticKeys.ALA_STATIC_VALUE_TIP)) {
                                        str3 = jSONObject2.getString(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
                                        if (jSONArray != null || jSONArray.length() == 0) {
                                            hashMap2.put("flagRobot", 0);
                                            if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                                str4 = jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE);
                                                if (str4 != null || str4.length() <= 0) {
                                                    hashMap2.put("flagRobot", 0);
                                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                                    hashMap2.put("toggle", "yes");
                                                } else {
                                                    hashMap2.put("toggle", "yes");
                                                    hashMap2.put("flagRobot", 0);
                                                    hashMap2.put("content", jSONObject2.getString(UgcUBCUtils.QUESTION_REPLY_PAGE));
                                                }
                                            }
                                            str4 = null;
                                            if (str4 != null) {
                                            }
                                            hashMap2.put("flagRobot", 0);
                                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                            hashMap2.put("toggle", "yes");
                                        } else {
                                            hashMap2.put("content", jSONArray.toString());
                                            hashMap2.put("toggle", "no");
                                            if (str3 != null && str3.length() > 0) {
                                                hashMap2.put(AlaStaticKeys.ALA_STATIC_VALUE_TIP, str3);
                                            }
                                        }
                                    }
                                    str3 = null;
                                    if (jSONArray != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    if (jSONObject2.has(UgcUBCUtils.QUESTION_REPLY_PAGE)) {
                                    }
                                    str4 = null;
                                    if (str4 != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                    hashMap2.put("toggle", "yes");
                                }
                            }
                            hashMap2.put("time", jSONArray2.getJSONObject(i).getString("time"));
                            if (jSONArray2.getJSONObject(i).has("evaluation")) {
                                int i3 = jSONArray2.getJSONObject(i).getInt("evaluation");
                                if (i3 == 0) {
                                    hashMap2.put("toggle", "no");
                                }
                                if (i3 == 10) {
                                    hashMap2.put("toggle", "yes");
                                }
                            }
                            arrayList.add(hashMap2);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("msgList", arrayList);
                        intent.putExtras(bundle);
                        context.sendBroadcast(intent);
                    }
                    return true;
                } else if (intValue != 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Exception e3) {
            c.a("sendRecord fail.", e3);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        } finally {
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
        }
        return false;
    }

    public static String d(Context context, String str, String str2) {
        c.c("-.-postUrl is https://ufosdk.baidu.com/?m=Index&a=getallmsgbyclientid");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        if (str2 == null || str2.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", str2);
        }
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("id", str);
        hashMap.put("os", "android");
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("output_style", 1);
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=getallmsgbyclientid", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                JSONObject jSONObject = new JSONObject(k.b(a));
                c.a("response is " + jSONObject.toString());
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0 && jSONObject.getInt("msgnum") > 0) {
                    return jSONObject.getJSONArray("msg").toString();
                }
                if (intValue != 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
                }
            }
        } catch (Exception e) {
            c.a("sendRecord fail.", e);
            Looper.prepare();
            context.sendBroadcast(new Intent("com.baidu.ufosdk.reload"));
            Looper.loop();
        }
        return null;
    }

    public static boolean e(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        if (str2 == null || str2.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", str2);
        }
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("id", str);
        try {
            String a = b.a("https://ufosdk.baidu.com/?m=Index&a=delmsgbyid", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a)) {
                if (((Integer) new JSONObject(k.b(a)).get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    context.sendBroadcast(new Intent("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag"));
                    return true;
                }
                context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
                Looper.prepare();
                Toast.makeText(context, "删除失败，请稍后重试。", 1).show();
                Looper.loop();
            }
        } catch (Exception e) {
            context.sendBroadcast(new Intent("com.baidu.ufosdk.deletemsg_dialogdismiss"));
            c.a("sendRecord fail.", e);
            Looper.prepare();
            Toast.makeText(context, "删除失败，请稍后重试。", 1).show();
            Looper.loop();
        }
        return false;
    }
}
