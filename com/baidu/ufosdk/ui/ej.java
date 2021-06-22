package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobstat.Config;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ej extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference f22977a;

    /* renamed from: b  reason: collision with root package name */
    public String f22978b;

    public ej(FeedbackInputActivity feedbackInputActivity) {
        this.f22977a = new WeakReference(feedbackInputActivity);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:18|(5:20|(1:22)(1:128)|23|24|(1:26)(2:114|(1:116)(2:117|(4:119|(1:121)|122|(1:124))(2:125|(1:127)))))(1:129)|27|(1:29)(1:113)|30|(2:32|33)(1:112)|34|(2:39|(6:109|110|48|49|(2:55|56)|57)(7:43|(2:45|46)(10:65|66|67|(2:69|70)(1:105)|71|72|73|(1:75)(1:101)|76|(11:85|86|87|88|(2:90|91)|(1:97)(1:95)|96|48|49|(1:60)(4:51|53|55|56)|57)(2:80|(1:84)))|47|48|49|(0)(0)|57))|111|110|48|49|(0)(0)|57|16) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02f0, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02f1, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0275 A[Catch: Exception -> 0x027c, TRY_LEAVE, TryCatch #1 {Exception -> 0x027c, blocks: (B:100:0x026f, B:102:0x0275), top: B:134:0x026f, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02da A[Catch: Exception -> 0x02f0, TryCatch #0 {Exception -> 0x02f0, blocks: (B:116:0x02d2, B:118:0x02da, B:120:0x02e2, B:122:0x02ea), top: B:132:0x02d2, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02f4 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(FeedbackInputActivity feedbackInputActivity, Message message) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str15;
        String str16 = "id";
        String str17 = "discontent_labels";
        String str18 = "discontent_reason";
        String str19 = "evaluation";
        feedbackInputActivity.u = false;
        feedbackInputActivity.f22781h.clear();
        HashMap hashMap = new HashMap();
        String str20 = "from";
        hashMap.put("from", 1);
        hashMap.put("content", UfoSDK.firstServerText);
        String str21 = "answer";
        String str22 = "tip";
        String str23 = "0";
        hashMap.put("contenttype", "0");
        String str24 = "robot";
        String str25 = (String) message.obj;
        String str26 = "content";
        com.baidu.ufosdk.f.c.a("第一条会话：" + str25);
        if (str25.equals("newMessage") || str25.length() == 0) {
            str = "extra";
            str2 = "contenttype";
            String valueOf = String.valueOf(System.currentTimeMillis());
            this.f22978b = valueOf;
            hashMap.put("time", valueOf);
        } else {
            str = "extra";
            str2 = "contenttype";
            String string = feedbackInputActivity.r.getString(Config.TRACE_VISIT_FIRST + feedbackInputActivity.f22778e, "0");
            if (string.equals("0")) {
                try {
                    string = (String) new JSONArray(str25).getJSONObject(0).get("time");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            hashMap.put("time", string);
        }
        if (!feedbackInputActivity.o) {
            feedbackInputActivity.f22781h.add(hashMap);
        }
        cg cgVar = feedbackInputActivity.j;
        if (cgVar != null) {
            cgVar.notifyDataSetChanged();
        }
        try {
            JSONArray jSONArray3 = new JSONArray(str25);
            int i2 = 0;
            while (i2 < jSONArray3.length()) {
                HashMap hashMap2 = new HashMap();
                int intValue = ((Integer) jSONArray3.getJSONObject(i2).get(str20)).intValue();
                hashMap2.put(str20, Integer.valueOf(intValue));
                if (intValue == 1) {
                    int intValue2 = jSONArray3.getJSONObject(i2).has(str19) ? ((Integer) jSONArray3.getJSONObject(i2).get(str19)).intValue() : 0;
                    str4 = str20;
                    hashMap2.put(str19, Integer.valueOf(intValue2));
                    if (intValue2 == 0) {
                        hashMap2.put("ask", 0);
                        str3 = str19;
                    } else {
                        str3 = str19;
                        if (intValue2 == 10) {
                            hashMap2.put("ask", 1);
                        } else if (intValue2 <= 9) {
                            hashMap2.put("ask", 9);
                            if (jSONArray3.getJSONObject(i2).has(str18)) {
                                hashMap2.put(str18, (String) jSONArray3.getJSONObject(i2).get(str18));
                            }
                            if (jSONArray3.getJSONObject(i2).has(str17)) {
                                hashMap2.put(str17, (JSONArray) jSONArray3.getJSONObject(i2).get(str17));
                            }
                        } else if (intValue2 >= 11) {
                            hashMap2.put("ask", 11);
                        }
                    }
                } else {
                    str3 = str19;
                    str4 = str20;
                }
                hashMap2.put("chatId", Integer.valueOf(jSONArray3.getJSONObject(i2).has(str16) ? ((Integer) jSONArray3.getJSONObject(i2).get(str16)).intValue() : 0));
                String str27 = str2;
                String str28 = (String) jSONArray3.getJSONObject(i2).get(str27);
                hashMap2.put(str27, str28);
                String str29 = str16;
                String str30 = str;
                String str31 = null;
                if (jSONArray3.getJSONObject(i2).has(str30)) {
                    str6 = jSONArray3.getJSONObject(i2).getString(str30);
                    str5 = str30;
                } else {
                    str5 = str30;
                    str6 = null;
                }
                if (str6 != null && str6.length() != 0) {
                    str7 = str17;
                    JSONObject jSONObject = new JSONObject(str6);
                    if (intValue == 1 && str28.equals(str23)) {
                        int i3 = jSONObject.getInt("flagRobot");
                        hashMap2.put("flagRobot", Integer.valueOf(i3));
                        if (i3 == 0) {
                            str9 = str26;
                            hashMap2.put(str9, jSONArray3.getJSONObject(i2).getString(str9));
                            str10 = str23;
                            str11 = str22;
                            str8 = str24;
                            str12 = str18;
                        } else {
                            str9 = str26;
                            str8 = str24;
                            try {
                                jSONArray = jSONObject.has(str8) ? (JSONArray) jSONObject.get(str8) : null;
                                str10 = str23;
                                str11 = str22;
                            } catch (Exception e3) {
                                e = e3;
                                str10 = str23;
                                str11 = str22;
                                jSONArray = null;
                            }
                            try {
                                str15 = jSONObject.has(str11) ? (String) jSONObject.get(str11) : null;
                                str12 = str18;
                                jSONArray2 = jSONArray;
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                str12 = str18;
                                jSONArray2 = jSONArray;
                                str15 = null;
                                if (jSONArray2 != null) {
                                }
                                hashMap2.put("flagRobot", 0);
                                str13 = str21;
                                try {
                                    if (jSONObject.has(str13)) {
                                    }
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                                hashMap2.put(str9, (str31 != null || str31.length() <= 0) ? jSONArray3.getJSONObject(i2).getString(str9) : jSONObject.getString(str13));
                                str14 = (String) hashMap2.get(str9);
                                if (str14 == null) {
                                }
                                hashMap2.put("time", (String) jSONArray3.getJSONObject(i2).get("time"));
                                feedbackInputActivity.f22781h.add(hashMap2);
                                i2++;
                                str = str5;
                                str21 = str13;
                                str24 = str8;
                                str18 = str12;
                                str16 = str29;
                                str20 = str4;
                                str17 = str7;
                                str22 = str11;
                                str2 = str27;
                                str23 = str10;
                                str26 = str9;
                                str19 = str3;
                            }
                            if (jSONArray2 != null || jSONArray2.length() <= 0) {
                                hashMap2.put("flagRobot", 0);
                                str13 = str21;
                                if (jSONObject.has(str13)) {
                                    str31 = jSONObject.getString(str13);
                                }
                                hashMap2.put(str9, (str31 != null || str31.length() <= 0) ? jSONArray3.getJSONObject(i2).getString(str9) : jSONObject.getString(str13));
                                str14 = (String) hashMap2.get(str9);
                                if (str14 == null) {
                                    hashMap2.put(str27, "1");
                                }
                                hashMap2.put("time", (String) jSONArray3.getJSONObject(i2).get("time"));
                                feedbackInputActivity.f22781h.add(hashMap2);
                                i2++;
                                str = str5;
                                str21 = str13;
                                str24 = str8;
                                str18 = str12;
                                str16 = str29;
                                str20 = str4;
                                str17 = str7;
                                str22 = str11;
                                str2 = str27;
                                str23 = str10;
                                str26 = str9;
                                str19 = str3;
                            } else {
                                hashMap2.put("flagRobot", 1);
                                hashMap2.put(str9, jSONArray2);
                                hashMap2.put(str27, "-1");
                                hashMap2.put("subtype", 0);
                                if (str15 != null && str15.length() > 0) {
                                    hashMap2.put(str11, str15);
                                }
                            }
                        }
                        str13 = str21;
                        str14 = (String) hashMap2.get(str9);
                        if (str14 == null) {
                        }
                        hashMap2.put("time", (String) jSONArray3.getJSONObject(i2).get("time"));
                        feedbackInputActivity.f22781h.add(hashMap2);
                        i2++;
                        str = str5;
                        str21 = str13;
                        str24 = str8;
                        str18 = str12;
                        str16 = str29;
                        str20 = str4;
                        str17 = str7;
                        str22 = str11;
                        str2 = str27;
                        str23 = str10;
                        str26 = str9;
                        str19 = str3;
                    } else {
                        str8 = str24;
                        str9 = str26;
                        str10 = str23;
                        str11 = str22;
                        str12 = str18;
                        str13 = str21;
                        hashMap2.put(str9, (String) jSONArray3.getJSONObject(i2).get(str9));
                        hashMap2.put("flagRobot", 0);
                        str14 = (String) hashMap2.get(str9);
                        if (str14 == null && str14.contains(".jpg") && str14.startsWith("http")) {
                            hashMap2.put(str27, "1");
                        }
                        hashMap2.put("time", (String) jSONArray3.getJSONObject(i2).get("time"));
                        feedbackInputActivity.f22781h.add(hashMap2);
                        i2++;
                        str = str5;
                        str21 = str13;
                        str24 = str8;
                        str18 = str12;
                        str16 = str29;
                        str20 = str4;
                        str17 = str7;
                        str22 = str11;
                        str2 = str27;
                        str23 = str10;
                        str26 = str9;
                        str19 = str3;
                    }
                }
                str7 = str17;
                str8 = str24;
                str9 = str26;
                str10 = str23;
                str11 = str22;
                str12 = str18;
                str13 = str21;
                hashMap2.put(str9, (String) jSONArray3.getJSONObject(i2).get(str9));
                hashMap2.put("flagRobot", 0);
                str14 = (String) hashMap2.get(str9);
                if (str14 == null) {
                }
                hashMap2.put("time", (String) jSONArray3.getJSONObject(i2).get("time"));
                feedbackInputActivity.f22781h.add(hashMap2);
                i2++;
                str = str5;
                str21 = str13;
                str24 = str8;
                str18 = str12;
                str16 = str29;
                str20 = str4;
                str17 = str7;
                str22 = str11;
                str2 = str27;
                str23 = str10;
                str26 = str9;
                str19 = str3;
            }
            feedbackInputActivity.j.notifyDataSetChanged();
            feedbackInputActivity.f22777d.setVisibility(0);
            feedbackInputActivity.f22776c.setVisibility(0);
            feedbackInputActivity.f22775b.setVisibility(8);
            feedbackInputActivity.k.setVisibility(8);
            feedbackInputActivity.f22782i.setSelection(feedbackInputActivity.f22782i.getBottom());
            feedbackInputActivity.n = true;
            new Handler().postDelayed(new ek(this, feedbackInputActivity), 1500L);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    private void b(FeedbackInputActivity feedbackInputActivity, Message message) {
        Object obj;
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
            feedbackInputActivity.f22779f = feedbackInputActivity.f22778e;
        }
        feedbackInputActivity.u = false;
        feedbackInputActivity.f22777d.setVisibility(0);
        ArrayList arrayList = (ArrayList) message.obj;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((String) ((Map) arrayList.get(i2)).get("id")).equals(feedbackInputActivity.f22778e)) {
                HashMap hashMap = new HashMap();
                if (((Integer) ((Map) arrayList.get(i2)).get("flagRobot")).intValue() == 0) {
                    if (((Map) arrayList.get(i2)).containsKey("chatId")) {
                        hashMap.put("chatId", ((Map) arrayList.get(i2)).get("chatId"));
                    }
                    hashMap.put("from", 1);
                    hashMap.put("content", (String) ((Map) arrayList.get(i2)).get("content"));
                    hashMap.put("time", (String) ((Map) arrayList.get(i2)).get("time"));
                    hashMap.put("contenttype", "0");
                    if (!((String) ((Map) arrayList.get(i2)).get("toggle")).equals("yes") || feedbackInputActivity.z) {
                        hashMap.put("ask", 0);
                    } else {
                        hashMap.put("ask", 1);
                        feedbackInputActivity.B = false;
                    }
                    String str = (String) hashMap.get("content");
                    if (str != null && str.contains(".jpg") && str.startsWith("http")) {
                        hashMap.put("contenttype", "1");
                    }
                } else {
                    try {
                        obj = "ask";
                    } catch (JSONException e2) {
                        e = e2;
                        obj = "ask";
                    }
                    try {
                        JSONArray jSONArray = new JSONArray((String) ((Map) arrayList.get(i2)).get("content"));
                        hashMap.put("chatId", ((Map) arrayList.get(i2)).get("chatId"));
                        hashMap.put("from", 1);
                        hashMap.put("content", jSONArray);
                        hashMap.put("time", (String) ((Map) arrayList.get(i2)).get("time"));
                        hashMap.put("contenttype", "-1");
                        hashMap.put("subtype", 0);
                        hashMap.put("tip", (String) ((Map) arrayList.get(i2)).get("tip"));
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (((String) ((Map) arrayList.get(i2)).get("toggle")).equals("yes")) {
                        }
                        hashMap.put(obj, 0);
                        feedbackInputActivity.f22781h.add(hashMap);
                        feedbackInputActivity.j.notifyDataSetChanged();
                        ListView listView = feedbackInputActivity.f22782i;
                        listView.setSelection(listView.getBottom());
                    }
                    if (((String) ((Map) arrayList.get(i2)).get("toggle")).equals("yes") || feedbackInputActivity.z) {
                        hashMap.put(obj, 0);
                    } else {
                        hashMap.put(obj, 1);
                        feedbackInputActivity.B = false;
                    }
                }
                feedbackInputActivity.f22781h.add(hashMap);
                feedbackInputActivity.j.notifyDataSetChanged();
                ListView listView2 = feedbackInputActivity.f22782i;
                listView2.setSelection(listView2.getBottom());
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x012f: IGET  (r4v29 int A[REMOVE]) = (r17v0 android.os.Message) android.os.Message.arg1 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0141: IGET  (r0v91 int A[REMOVE]) = (r17v0 android.os.Message) android.os.Message.arg2 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x01fe: IGET  (r4v20 int A[REMOVE]) = (r17v0 android.os.Message) android.os.Message.arg1 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0210: IGET  (r0v86 int A[REMOVE]) = (r17v0 android.os.Message) android.os.Message.arg2 int)] */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context applicationContext;
        String str;
        Context applicationContext2;
        String str2;
        Toast makeText;
        Context applicationContext3;
        String str3;
        String str4;
        String str5;
        String str6;
        super.handleMessage(message);
        FeedbackInputActivity feedbackInputActivity = (FeedbackInputActivity) this.f22977a.get();
        if (feedbackInputActivity == null) {
            return;
        }
        switch (message.what) {
            case 1:
                HashMap hashMap = new HashMap();
                hashMap.put("from", 0);
                hashMap.put("content", message.obj);
                hashMap.put("contenttype", "0");
                hashMap.put("time", String.valueOf(System.currentTimeMillis()));
                feedbackInputActivity.f22781h.add(hashMap);
                feedbackInputActivity.j.notifyDataSetChanged();
                ListView listView = feedbackInputActivity.f22782i;
                listView.setSelection(listView.getBottom());
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
                            feedbackInputActivity.f22781h.add(hashMap2);
                            feedbackInputActivity.j.notifyDataSetChanged();
                            ListView listView2 = feedbackInputActivity.f22782i;
                            listView2.setSelection(listView2.getBottom());
                            return;
                        }
                        return;
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                        return;
                    }
                }
                return;
            case 4:
                feedbackInputActivity.f22777d.setVisibility(8);
                feedbackInputActivity.f22776c.setVisibility(8);
                com.baidu.ufosdk.f.i.a(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.m);
                feedbackInputActivity.f22775b.setVisibility(0);
                feedbackInputActivity.k.setVisibility(8);
                return;
            case 5:
                a(feedbackInputActivity, message);
                return;
            case 6:
                if (feedbackInputActivity.n) {
                    ListView listView3 = feedbackInputActivity.f22782i;
                    listView3.setSelection(listView3.getBottom());
                    return;
                }
                return;
            case 7:
                try {
                    String b2 = com.baidu.ufosdk.f.k.b((String) message.obj);
                    if (!TextUtils.isEmpty(b2)) {
                        com.baidu.ufosdk.f.c.a("solved replay response: " + b2);
                        if (new JSONObject(b2).optInt("errno", -1) == 0) {
                            feedbackInputActivity.u = false;
                            feedbackInputActivity.j.notifyDataSetChanged();
                            feedbackInputActivity.f22782i.setSelection(feedbackInputActivity.f22782i.getBottom());
                            return;
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                feedbackInputActivity.u = false;
                feedbackInputActivity.j.notifyDataSetChanged();
                ListView listView4 = feedbackInputActivity.f22782i;
                listView4.setSelection(listView4.getBottom());
                if (TextUtils.isEmpty(feedbackInputActivity.L)) {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), com.baidu.ufosdk.f.s.a("44"), 0).show();
                    return;
                } else {
                    Toast.makeText(feedbackInputActivity.getApplicationContext(), feedbackInputActivity.L, 0).show();
                    return;
                }
            case 8:
                if (feedbackInputActivity.H) {
                    if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                        applicationContext2 = feedbackInputActivity.getApplicationContext();
                        str2 = com.baidu.ufosdk.f.s.a("60");
                    } else {
                        applicationContext2 = feedbackInputActivity.getApplicationContext();
                        str2 = feedbackInputActivity.M;
                    }
                    Toast.makeText(applicationContext2, str2, 0).show();
                } else {
                    if (message.obj != null) {
                        if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                            applicationContext = feedbackInputActivity.getApplicationContext();
                            str = com.baidu.ufosdk.f.s.a("60");
                        } else {
                            applicationContext = feedbackInputActivity.getApplicationContext();
                            str = feedbackInputActivity.M;
                        }
                        Toast.makeText(applicationContext, str, 0).show();
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("from", 1);
                    boolean z = feedbackInputActivity.v;
                    hashMap3.put("content", UfoSDK.autoReplyText);
                    hashMap3.put("contenttype", "0");
                    hashMap3.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap3.put("ask", 0);
                    feedbackInputActivity.f22781h.add(hashMap3);
                }
                feedbackInputActivity.u = true;
                feedbackInputActivity.j.notifyDataSetChanged();
                ListView listView5 = feedbackInputActivity.f22782i;
                listView5.setSelection(listView5.getBottom());
                return;
            case 9:
                try {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("from", 1);
                    hashMap4.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap4.put("contenttype", "-1");
                    hashMap4.put("subtype", 1);
                    hashMap4.put("content", (JSONArray) message.obj);
                    feedbackInputActivity.f22781h.add(hashMap4);
                    feedbackInputActivity.j.notifyDataSetChanged();
                    feedbackInputActivity.f22782i.setSelection(feedbackInputActivity.f22782i.getBottom());
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
                intent.putExtra("msgid", feedbackInputActivity.f22778e);
                intent.putExtra("im_content", feedbackInputActivity.A);
                intent.putExtra("come_from", 0);
                feedbackInputActivity.startActivity(intent);
                return;
            case 11:
                feedbackInputActivity.K.f23006a.setVisibility(8);
                feedbackInputActivity.K.f23008c.setBackgroundResource(R.drawable.dialog_btn_selector);
                feedbackInputActivity.K.f23008c.setTextColor(-1);
                feedbackInputActivity.K.f23008c.setClickable(true);
                feedbackInputActivity.K.f23007b.setFocusable(true);
                feedbackInputActivity.K.f23007b.setFocusableInTouchMode(true);
                feedbackInputActivity.K.f23007b.requestFocus();
                if (((Integer) message.obj).intValue() == 0) {
                    ev evVar = feedbackInputActivity.K;
                    if (evVar != null && evVar.isShowing()) {
                        feedbackInputActivity.K.dismiss();
                    }
                    ev evVar2 = feedbackInputActivity.K;
                    if (evVar2 != null) {
                        evVar2.a();
                    }
                    if (TextUtils.isEmpty(feedbackInputActivity.M)) {
                        applicationContext3 = feedbackInputActivity.getApplicationContext();
                        str3 = com.baidu.ufosdk.f.s.a("60");
                    } else {
                        applicationContext3 = feedbackInputActivity.getApplicationContext();
                        str3 = feedbackInputActivity.M;
                    }
                    makeText = Toast.makeText(applicationContext3, str3, 0);
                } else {
                    makeText = Toast.makeText(feedbackInputActivity.getApplicationContext(), "发生失败，请稍候重试", 1);
                }
                makeText.show();
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
                StringBuilder sb = new StringBuilder();
                sb.append(message.arg1);
                String sb2 = sb.toString();
                feedbackInputActivity.f22779f = sb2;
                feedbackInputActivity.f22778e = sb2;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(message.arg2);
                String sb4 = sb3.toString();
                com.baidu.ufosdk.f.c.a("Handler = 12 PluginInvoker.robotAnswer = " + UfoSDK.robotAnswer + "; tempRobotSwitch = " + feedbackInputActivity.y + "; id = " + feedbackInputActivity.f22779f);
                if (!UfoSDK.robotAnswer || !feedbackInputActivity.y || (str4 = feedbackInputActivity.f22779f) == null || str4.length() <= 0) {
                    return;
                }
                feedbackInputActivity.l.execute(new em(this, feedbackInputActivity, sb4));
                return;
            case 13:
                feedbackInputActivity.D = false;
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.E.setEnabled(true);
                TextView textView = feedbackInputActivity.J;
                int i2 = com.baidu.ufosdk.b.v;
                int i3 = com.baidu.ufosdk.b.y;
                int i4 = com.baidu.ufosdk.b.v;
                textView.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
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
                if (!TextUtils.isEmpty(feedbackInputActivity.f22778e) && TextUtils.isEmpty(feedbackInputActivity.F)) {
                    feedbackInputActivity.q.putString(feedbackInputActivity.f22778e, "");
                }
                if (!TextUtils.isEmpty(feedbackInputActivity.F)) {
                    feedbackInputActivity.q.putString(feedbackInputActivity.F, "");
                }
                feedbackInputActivity.s.setVisibility(8);
                feedbackInputActivity.D = false;
                feedbackInputActivity.p.setVisibility(8);
                feedbackInputActivity.C.setVisibility(8);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(message.arg1);
                String sb6 = sb5.toString();
                feedbackInputActivity.f22779f = sb6;
                feedbackInputActivity.f22778e = sb6;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(message.arg2);
                String sb8 = sb7.toString();
                com.baidu.ufosdk.a.a aVar = feedbackInputActivity.f22780g;
                if (aVar != null && (str6 = feedbackInputActivity.f22778e) != null) {
                    aVar.a(str6);
                }
                SharedPreferences.Editor editor = feedbackInputActivity.q;
                editor.putString(Config.TRACE_VISIT_FIRST + feedbackInputActivity.f22779f, this.f22978b);
                feedbackInputActivity.q.commit();
                com.baidu.ufosdk.f.c.a("Handler = 14 tempRobotSwitch = " + feedbackInputActivity.y + "; id = " + feedbackInputActivity.f22779f);
                if (!UfoSDK.robotAnswer || !feedbackInputActivity.y || (str5 = feedbackInputActivity.f22779f) == null || str5.length() <= 0) {
                    feedbackInputActivity.l.execute(new eo(this, feedbackInputActivity, sb8));
                    return;
                } else {
                    feedbackInputActivity.l.execute(new en(this, feedbackInputActivity, sb8));
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
                    boolean z2 = feedbackInputActivity.v;
                    hashMap5.put("content", UfoSDK.autoReplyText);
                    hashMap5.put("contenttype", "0");
                    hashMap5.put("time", String.valueOf(System.currentTimeMillis()));
                    hashMap5.put("ask", 0);
                    feedbackInputActivity.f22781h.add(hashMap5);
                }
                feedbackInputActivity.u = true;
                feedbackInputActivity.j.notifyDataSetChanged();
                ListView listView6 = feedbackInputActivity.f22782i;
                listView6.setSelection(listView6.getBottom());
                return;
            case 18:
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).showSoftInput(feedbackInputActivity.K.f23007b, 1);
                com.baidu.ufosdk.f.c.a("show keyboard! " + message.obj.toString());
                return;
            default:
                return;
        }
    }
}
