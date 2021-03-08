package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.mobstat.Config;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class ej extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f3763a;
    private String b;

    public ej(FeedbackInputActivity feedbackInputActivity) {
        this.f3763a = new WeakReference(feedbackInputActivity);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:70|71|(2:73|74)(1:105)|75|76|(2:78|(7:87|88|89|(2:91|(1:96)(1:95))|97|(1:93)|96)(2:82|(1:86)))|101|(1:80)|87|88|89|(0)|97|(0)|96) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0323, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0324, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02af A[Catch: JSONException -> 0x01eb, TRY_ENTER, TryCatch #4 {JSONException -> 0x01eb, blocks: (B:13:0x0076, B:14:0x007c, B:16:0x0082, B:18:0x00a4, B:20:0x00b1, B:21:0x00c2, B:23:0x00ce, B:52:0x01de, B:58:0x01f2, B:60:0x020b, B:61:0x021e, B:63:0x022b, B:66:0x0244, B:24:0x00d9, B:26:0x00e6, B:27:0x00f7, B:29:0x0121, B:31:0x012e, B:67:0x0252, B:69:0x0259, B:71:0x0262, B:73:0x0275, B:41:0x0178, B:108:0x035d, B:83:0x02af, B:85:0x02b5, B:87:0x02dc, B:89:0x02e2, B:94:0x02f1, B:99:0x030e, B:101:0x0314, B:105:0x0329, B:103:0x0324, B:92:0x02ec, B:106:0x033c, B:33:0x0134, B:109:0x0362, B:34:0x0152, B:36:0x015d, B:38:0x0166, B:40:0x016f, B:95:0x02fc, B:97:0x0305), top: B:125:0x0076, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0305 A[Catch: Exception -> 0x0323, TRY_LEAVE, TryCatch #5 {Exception -> 0x0323, blocks: (B:95:0x02fc, B:97:0x0305), top: B:127:0x02fc, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030e A[Catch: JSONException -> 0x01eb, TRY_ENTER, TryCatch #4 {JSONException -> 0x01eb, blocks: (B:13:0x0076, B:14:0x007c, B:16:0x0082, B:18:0x00a4, B:20:0x00b1, B:21:0x00c2, B:23:0x00ce, B:52:0x01de, B:58:0x01f2, B:60:0x020b, B:61:0x021e, B:63:0x022b, B:66:0x0244, B:24:0x00d9, B:26:0x00e6, B:27:0x00f7, B:29:0x0121, B:31:0x012e, B:67:0x0252, B:69:0x0259, B:71:0x0262, B:73:0x0275, B:41:0x0178, B:108:0x035d, B:83:0x02af, B:85:0x02b5, B:87:0x02dc, B:89:0x02e2, B:94:0x02f1, B:99:0x030e, B:101:0x0314, B:105:0x0329, B:103:0x0324, B:92:0x02ec, B:106:0x033c, B:33:0x0134, B:109:0x0362, B:34:0x0152, B:36:0x015d, B:38:0x0166, B:40:0x016f, B:95:0x02fc, B:97:0x0305), top: B:125:0x0076, inners: #2, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(FeedbackInputActivity feedbackInputActivity, Message message) {
        String str;
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        feedbackInputActivity.u = false;
        feedbackInputActivity.h.clear();
        HashMap hashMap = new HashMap();
        hashMap.put("from", 1);
        hashMap.put("content", UfoSDK.firstServerText);
        hashMap.put("contenttype", "0");
        String str5 = (String) message.obj;
        com.baidu.ufosdk.f.c.a("第一条会话：" + str5);
        if (str5.equals("newMessage") || str5.length() == 0) {
            this.b = String.valueOf(System.currentTimeMillis());
            hashMap.put("time", this.b);
        } else {
            String string = feedbackInputActivity.r.getString(Config.TRACE_VISIT_FIRST + feedbackInputActivity.e, "0");
            if (string.equals("0")) {
                try {
                    str4 = (String) new JSONArray(str5).getJSONObject(0).get("time");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                hashMap.put("time", str4);
            }
            str4 = string;
            hashMap.put("time", str4);
        }
        if (!feedbackInputActivity.o) {
            feedbackInputActivity.h.add(hashMap);
        }
        if (feedbackInputActivity.j != null) {
            feedbackInputActivity.j.notifyDataSetChanged();
        }
        try {
            JSONArray jSONArray2 = new JSONArray(str5);
            for (int i = 0; i < jSONArray2.length(); i++) {
                HashMap hashMap2 = new HashMap();
                int intValue = ((Integer) jSONArray2.getJSONObject(i).get("from")).intValue();
                hashMap2.put("from", Integer.valueOf(intValue));
                if (intValue == 1) {
                    int intValue2 = jSONArray2.getJSONObject(i).has("evaluation") ? ((Integer) jSONArray2.getJSONObject(i).get("evaluation")).intValue() : 0;
                    hashMap2.put("evaluation", Integer.valueOf(intValue2));
                    if (intValue2 == 0) {
                        hashMap2.put("ask", 0);
                    } else if (intValue2 == 10) {
                        hashMap2.put("ask", 1);
                    } else if (intValue2 <= 9) {
                        hashMap2.put("ask", 9);
                        if (jSONArray2.getJSONObject(i).has("discontent_reason")) {
                            hashMap2.put("discontent_reason", (String) jSONArray2.getJSONObject(i).get("discontent_reason"));
                        }
                        if (jSONArray2.getJSONObject(i).has("discontent_labels")) {
                            hashMap2.put("discontent_labels", (JSONArray) jSONArray2.getJSONObject(i).get("discontent_labels"));
                        }
                    } else if (intValue2 >= 11) {
                        hashMap2.put("ask", 11);
                    }
                }
                hashMap2.put("chatId", Integer.valueOf(jSONArray2.getJSONObject(i).has("id") ? ((Integer) jSONArray2.getJSONObject(i).get("id")).intValue() : 0));
                String str6 = (String) jSONArray2.getJSONObject(i).get("contenttype");
                hashMap2.put("contenttype", str6);
                String string2 = jSONArray2.getJSONObject(i).has("extra") ? jSONArray2.getJSONObject(i).getString("extra") : null;
                if (string2 == null || string2.length() == 0) {
                    hashMap2.put("content", (String) jSONArray2.getJSONObject(i).get("content"));
                    hashMap2.put("flagRobot", 0);
                } else {
                    JSONObject jSONObject = new JSONObject(string2);
                    if (intValue == 1 && str6.equals("0")) {
                        int i2 = jSONObject.getInt("flagRobot");
                        hashMap2.put("flagRobot", Integer.valueOf(i2));
                        if (i2 == 0) {
                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                        } else {
                            try {
                                jSONArray = jSONObject.has("robot") ? (JSONArray) jSONObject.get("robot") : null;
                                try {
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    str2 = null;
                                    if (jSONArray != null) {
                                    }
                                    hashMap2.put("flagRobot", 0);
                                    if (jSONObject.has("answer")) {
                                    }
                                    str3 = null;
                                    if (str3 != null) {
                                    }
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                    str = (String) hashMap2.get("content");
                                    if (str != null) {
                                        hashMap2.put("contenttype", "1");
                                    }
                                    hashMap2.put("time", (String) jSONArray2.getJSONObject(i).get("time"));
                                    feedbackInputActivity.h.add(hashMap2);
                                }
                            } catch (Exception e3) {
                                e = e3;
                                jSONArray = null;
                            }
                            if (jSONObject.has(AlaStaticKeys.ALA_STATIC_VALUE_TIP)) {
                                str2 = (String) jSONObject.get(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
                                if (jSONArray != null || jSONArray.length() <= 0) {
                                    hashMap2.put("flagRobot", 0);
                                    if (jSONObject.has("answer")) {
                                        str3 = jSONObject.getString("answer");
                                        if (str3 != null || str3.length() <= 0) {
                                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                        } else {
                                            hashMap2.put("content", jSONObject.getString("answer"));
                                        }
                                    }
                                    str3 = null;
                                    if (str3 != null) {
                                    }
                                    hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                                } else {
                                    hashMap2.put("flagRobot", 1);
                                    hashMap2.put("content", jSONArray);
                                    hashMap2.put("contenttype", "-1");
                                    hashMap2.put("subtype", 0);
                                    if (str2 != null && str2.length() > 0) {
                                        hashMap2.put(AlaStaticKeys.ALA_STATIC_VALUE_TIP, str2);
                                    }
                                }
                            }
                            str2 = null;
                            if (jSONArray != null) {
                            }
                            hashMap2.put("flagRobot", 0);
                            if (jSONObject.has("answer")) {
                            }
                            str3 = null;
                            if (str3 != null) {
                            }
                            hashMap2.put("content", jSONArray2.getJSONObject(i).getString("content"));
                        }
                    } else {
                        hashMap2.put("content", (String) jSONArray2.getJSONObject(i).get("content"));
                        hashMap2.put("flagRobot", 0);
                    }
                }
                try {
                    str = (String) hashMap2.get("content");
                    if (str != null && str.contains(".jpg") && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        hashMap2.put("contenttype", "1");
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                hashMap2.put("time", (String) jSONArray2.getJSONObject(i).get("time"));
                feedbackInputActivity.h.add(hashMap2);
            }
            feedbackInputActivity.j.notifyDataSetChanged();
            feedbackInputActivity.d.setVisibility(0);
            feedbackInputActivity.c.setVisibility(0);
            feedbackInputActivity.b.setVisibility(8);
            feedbackInputActivity.k.setVisibility(8);
            feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
            feedbackInputActivity.n = true;
            new Handler().postDelayed(new ek(this, feedbackInputActivity), 1500L);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    private void b(FeedbackInputActivity feedbackInputActivity, Message message) {
        feedbackInputActivity.x++;
        com.baidu.ufosdk.f.c.c("@@@@@@@@: 规定交互轮次：" + feedbackInputActivity.w + " ***当前交互次数" + feedbackInputActivity.x);
        if (feedbackInputActivity.x >= feedbackInputActivity.w && feedbackInputActivity.y) {
            if (!feedbackInputActivity.z) {
                feedbackInputActivity.l.execute(new el(this, feedbackInputActivity));
            }
            com.baidu.ufosdk.f.c.c("handler = 2 tempRobotSwitch = " + feedbackInputActivity.y);
            feedbackInputActivity.y = false;
        }
        if (feedbackInputActivity.H) {
            feedbackInputActivity.f = feedbackInputActivity.e;
        }
        feedbackInputActivity.u = false;
        feedbackInputActivity.d.setVisibility(0);
        ArrayList arrayList = (ArrayList) message.obj;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((String) ((Map) arrayList.get(i)).get("id")).equals(feedbackInputActivity.e)) {
                HashMap hashMap = new HashMap();
                if (((Integer) ((Map) arrayList.get(i)).get("flagRobot")).intValue() == 0) {
                    if (((Map) arrayList.get(i)).containsKey("chatId")) {
                        hashMap.put("chatId", ((Map) arrayList.get(i)).get("chatId"));
                    }
                    hashMap.put("from", 1);
                    hashMap.put("content", (String) ((Map) arrayList.get(i)).get("content"));
                    hashMap.put("time", (String) ((Map) arrayList.get(i)).get("time"));
                    hashMap.put("contenttype", "0");
                    if (!((String) ((Map) arrayList.get(i)).get("toggle")).equals("yes") || feedbackInputActivity.z) {
                        hashMap.put("ask", 0);
                    } else {
                        hashMap.put("ask", 1);
                        feedbackInputActivity.B = false;
                    }
                    String str = (String) hashMap.get("content");
                    if (str != null && str.contains(".jpg") && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        hashMap.put("contenttype", "1");
                    }
                } else {
                    try {
                        JSONArray jSONArray = new JSONArray((String) ((Map) arrayList.get(i)).get("content"));
                        hashMap.put("chatId", ((Map) arrayList.get(i)).get("chatId"));
                        hashMap.put("from", 1);
                        hashMap.put("content", jSONArray);
                        hashMap.put("time", (String) ((Map) arrayList.get(i)).get("time"));
                        hashMap.put("contenttype", "-1");
                        hashMap.put("subtype", 0);
                        hashMap.put(AlaStaticKeys.ALA_STATIC_VALUE_TIP, (String) ((Map) arrayList.get(i)).get(AlaStaticKeys.ALA_STATIC_VALUE_TIP));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!((String) ((Map) arrayList.get(i)).get("toggle")).equals("yes") || feedbackInputActivity.z) {
                        hashMap.put("ask", 0);
                    } else {
                        hashMap.put("ask", 1);
                        feedbackInputActivity.B = false;
                    }
                }
                feedbackInputActivity.h.add(hashMap);
                feedbackInputActivity.j.notifyDataSetChanged();
                feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x038e: IGET  (r2v44 int A[REMOVE]) = (r10v0 android.os.Message) android.os.Message.arg1 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x03a3: IGET  (r2v45 int A[REMOVE]) = (r10v0 android.os.Message) android.os.Message.arg2 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0479: IGET  (r2v21 int A[REMOVE]) = (r10v0 android.os.Message) android.os.Message.arg1 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x048e: IGET  (r2v22 int A[REMOVE]) = (r10v0 android.os.Message) android.os.Message.arg2 int)] */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        FeedbackInputActivity feedbackInputActivity = (FeedbackInputActivity) this.f3763a.get();
        if (feedbackInputActivity == null) {
            return;
        }
        switch (message.what) {
            case 0:
            default:
                return;
            case 1:
                HashMap hashMap = new HashMap();
                hashMap.put("from", 0);
                hashMap.put("content", message.obj);
                hashMap.put("contenttype", "0");
                hashMap.put("time", String.valueOf(System.currentTimeMillis()));
                feedbackInputActivity.h.add(hashMap);
                feedbackInputActivity.j.notifyDataSetChanged();
                feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.E.setEnabled(true);
                feedbackInputActivity.E.setText("");
                return;
            case 2:
                b(feedbackInputActivity, message);
                return;
            case 3:
                feedbackInputActivity.u = false;
                byte[] bArr = (byte[]) message.obj;
                if (bArr != null) {
                    try {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        if (decodeByteArray != null) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("from", 0);
                            hashMap2.put("content", decodeByteArray);
                            hashMap2.put("contenttype", "2");
                            hashMap2.put("time", String.valueOf(System.currentTimeMillis()));
                            feedbackInputActivity.h.add(hashMap2);
                            feedbackInputActivity.j.notifyDataSetChanged();
                            feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError e) {
                        System.gc();
                        return;
                    }
                }
                return;
            case 4:
                feedbackInputActivity.d.setVisibility(8);
                feedbackInputActivity.c.setVisibility(8);
                com.baidu.ufosdk.f.i.a(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.m);
                feedbackInputActivity.b.setVisibility(0);
                feedbackInputActivity.k.setVisibility(8);
                return;
            case 5:
                a(feedbackInputActivity, message);
                return;
            case 6:
                if (feedbackInputActivity.n) {
                    feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                    return;
                }
                return;
            case 7:
                try {
                    String b = com.baidu.ufosdk.f.k.b((String) message.obj);
                    if (!TextUtils.isEmpty(b)) {
                        com.baidu.ufosdk.f.c.a("solved replay response: " + b);
                        if (new JSONObject(b).optInt(BaseJsonData.TAG_ERRNO, -1) == 0) {
                            feedbackInputActivity.u = false;
                            feedbackInputActivity.j.notifyDataSetChanged();
                            feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                            return;
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                feedbackInputActivity.u = false;
                feedbackInputActivity.j.notifyDataSetChanged();
                feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                if (TextUtils.isEmpty(feedbackInputActivity.L)) {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("44"), 0).show();
                    return;
                } else {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.L, 0).show();
                    return;
                }
            case 8:
                if (!feedbackInputActivity.H) {
                    if (message.obj != null) {
                        if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                            Toast.makeText(feedbackInputActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("60"), 0).show();
                        } else {
                            Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.M, 0).show();
                        }
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("from", 1);
                    if (feedbackInputActivity.v) {
                        hashMap3.put("content", UfoSDK.autoReplyText);
                    } else {
                        hashMap3.put("content", UfoSDK.autoReplyText);
                    }
                    hashMap3.put("contenttype", "0");
                    hashMap3.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap3.put("ask", 0);
                    feedbackInputActivity.h.add(hashMap3);
                } else if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("60"), 0).show();
                } else {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.M, 0).show();
                }
                feedbackInputActivity.u = true;
                feedbackInputActivity.j.notifyDataSetChanged();
                feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                return;
            case 9:
                try {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("from", 1);
                    hashMap4.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap4.put("contenttype", "-1");
                    hashMap4.put("subtype", 1);
                    hashMap4.put("content", (JSONArray) message.obj);
                    feedbackInputActivity.h.add(hashMap4);
                    feedbackInputActivity.j.notifyDataSetChanged();
                    feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            case 10:
                com.baidu.ufosdk.f.c.a("产品方向列表为空，直接跳转人工反馈！");
                Intent intent = new Intent();
                intent.setClass(feedbackInputActivity, FeedbackEditActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                intent.putExtra("msgid", feedbackInputActivity.e);
                intent.putExtra("im_content", feedbackInputActivity.A);
                intent.putExtra("come_from", 0);
                feedbackInputActivity.startActivity(intent);
                return;
            case 11:
                feedbackInputActivity.K.f3773a.setVisibility(8);
                feedbackInputActivity.K.c.setBackgroundResource(R.drawable.dialog_btn_selector);
                feedbackInputActivity.K.c.setTextColor(-1);
                feedbackInputActivity.K.c.setClickable(true);
                feedbackInputActivity.K.b.setFocusable(true);
                feedbackInputActivity.K.b.setFocusableInTouchMode(true);
                feedbackInputActivity.K.b.requestFocus();
                if (((Integer) message.obj).intValue() == 0) {
                    if (feedbackInputActivity.K != null && feedbackInputActivity.K.isShowing()) {
                        feedbackInputActivity.K.dismiss();
                    }
                    if (feedbackInputActivity.K != null) {
                        feedbackInputActivity.K.a();
                    }
                    if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                        Toast.makeText(feedbackInputActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("60"), 0).show();
                    } else {
                        Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.M, 0).show();
                    }
                } else {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), "发生失败，请稍候重试", 1).show();
                }
                feedbackInputActivity.j.notifyDataSetChanged();
                return;
            case 12:
                feedbackInputActivity.a();
                if (feedbackInputActivity.t) {
                    feedbackInputActivity.t = false;
                    return;
                }
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.D = false;
                feedbackInputActivity.E.setEnabled(true);
                feedbackInputActivity.E.setText("");
                feedbackInputActivity.p.setVisibility(8);
                feedbackInputActivity.C.setVisibility(8);
                feedbackInputActivity.f = new StringBuilder().append(message.arg1).toString();
                feedbackInputActivity.e = feedbackInputActivity.f;
                String sb = new StringBuilder().append(message.arg2).toString();
                com.baidu.ufosdk.f.c.a("Handler = 12 PluginInvoker.robotAnswer = " + UfoSDK.robotAnswer + "; tempRobotSwitch = " + feedbackInputActivity.y + "; id = " + feedbackInputActivity.f);
                if (!UfoSDK.robotAnswer || !feedbackInputActivity.y || feedbackInputActivity.f == null || feedbackInputActivity.f.length() <= 0) {
                    return;
                }
                feedbackInputActivity.l.execute(new em(this, feedbackInputActivity, sb));
                return;
            case 13:
                feedbackInputActivity.D = false;
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.E.setEnabled(true);
                feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
                return;
            case 14:
                feedbackInputActivity.E.setEnabled(true);
                feedbackInputActivity.E.setText("");
                feedbackInputActivity.u = false;
                feedbackInputActivity.a();
                if (feedbackInputActivity.t) {
                    feedbackInputActivity.t = false;
                    return;
                }
                feedbackInputActivity.G = false;
                if (!TextUtils.isEmpty(feedbackInputActivity.e) && TextUtils.isEmpty(feedbackInputActivity.F)) {
                    feedbackInputActivity.q.putString(feedbackInputActivity.e, "");
                }
                if (!TextUtils.isEmpty(feedbackInputActivity.F)) {
                    feedbackInputActivity.q.putString(feedbackInputActivity.F, "");
                }
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.D = false;
                feedbackInputActivity.p.setVisibility(8);
                feedbackInputActivity.C.setVisibility(8);
                feedbackInputActivity.f = new StringBuilder().append(message.arg1).toString();
                feedbackInputActivity.e = feedbackInputActivity.f;
                String sb2 = new StringBuilder().append(message.arg2).toString();
                if (feedbackInputActivity.g != null && feedbackInputActivity.e != null) {
                    feedbackInputActivity.g.a(feedbackInputActivity.e);
                }
                feedbackInputActivity.q.putString(Config.TRACE_VISIT_FIRST + feedbackInputActivity.f, this.b);
                feedbackInputActivity.q.commit();
                com.baidu.ufosdk.f.c.a("Handler = 14 tempRobotSwitch = " + feedbackInputActivity.y + "; id = " + feedbackInputActivity.f);
                if (!UfoSDK.robotAnswer || !feedbackInputActivity.y || feedbackInputActivity.f == null || feedbackInputActivity.f.length() <= 0) {
                    feedbackInputActivity.l.execute(new eo(this, feedbackInputActivity, sb2));
                    return;
                } else {
                    feedbackInputActivity.l.execute(new en(this, feedbackInputActivity, sb2));
                    return;
                }
            case 15:
                try {
                    ((InputMethodManager) feedbackInputActivity.E.getContext().getSystemService("input_method")).showSoftInput(feedbackInputActivity.E, 0);
                    return;
                } catch (Exception e4) {
                    com.baidu.ufosdk.f.c.a("Handle message 15", e4);
                    return;
                }
            case 16:
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 0);
                com.baidu.ufosdk.f.c.a("close keyboard! " + message.obj.toString());
                return;
            case 17:
                if (!feedbackInputActivity.H) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("from", 1);
                    if (feedbackInputActivity.v) {
                        hashMap5.put("content", UfoSDK.autoReplyText);
                    } else {
                        hashMap5.put("content", UfoSDK.autoReplyText);
                    }
                    hashMap5.put("contenttype", "0");
                    hashMap5.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap5.put("ask", 0);
                    feedbackInputActivity.h.add(hashMap5);
                }
                feedbackInputActivity.u = true;
                feedbackInputActivity.j.notifyDataSetChanged();
                feedbackInputActivity.i.setSelection(feedbackInputActivity.i.getBottom());
                return;
            case 18:
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).showSoftInput(feedbackInputActivity.K.b, 1);
                com.baidu.ufosdk.f.c.a("show keyboard! " + message.obj.toString());
                return;
        }
    }
}
