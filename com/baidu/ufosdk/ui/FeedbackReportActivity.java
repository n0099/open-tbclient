package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.R;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
@TargetApi(11)
/* loaded from: classes21.dex */
public class FeedbackReportActivity extends Activity {
    private View A;
    private ScrollView L;
    private String M;
    private LinearLayout N;
    private LinearLayout O;
    private TextView P;
    private TextView Q;
    private a U;
    private f V;
    private SharedPreferences.Editor b;
    private SharedPreferences c;
    private EditText h;
    private byte[] j;
    private RelativeLayout k;
    private ImageView l;
    private Button m;
    private TextView n;
    private LinearLayout o;
    private TextView r;
    private RelativeLayout s;
    private EditText t;
    private EditText u;
    private TextView v;
    private LinearLayout w;
    private List x;
    private String z;
    private String d = "";
    private String e = "";
    private int f = 0;
    private String g = "";
    private String i = "";
    private int p = 0;
    private boolean q = false;
    private Boolean y = true;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private String F = "";
    private boolean G = false;
    private boolean H = false;
    private JSONArray I = new JSONArray();
    private JSONArray J = new JSONArray();
    private Handler K = new dv(this);
    private int R = 0;
    private String S = "举报/反馈";
    private boolean T = false;
    protected int a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void D(FeedbackReportActivity feedbackReportActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        if (feedbackReportActivity.a == feedbackReportActivity.x.size() - 1) {
            if (feedbackReportActivity.getCurrentFocus() != null && feedbackReportActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackReportActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackReportActivity.getCurrentFocus().getWindowToken(), 2);
            }
            try {
                feedbackReportActivity.D = true;
                feedbackReportActivity.startActivityForResult(intent, feedbackReportActivity.a);
                try {
                    feedbackReportActivity.overridePendingTransition(com.baidu.ufosdk.f.i.a(feedbackReportActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                } catch (Exception e) {
                }
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
            }
        }
    }

    private static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null || i <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i || height <= i) {
            return bitmap;
        }
        int max = (Math.max(width, height) * i) / Math.min(width, height);
        int i2 = width > height ? max : i;
        if (width > height) {
            max = i;
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, max, true);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (i2 - i) / 2, (max - i) / 2, i, i);
                createScaledBitmap.recycle();
                return createBitmap;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.A.getVisibility() != 0) {
            getApplicationContext();
            new ei(this).execute(new Void[0]);
            return;
        }
        this.A.setVisibility(8);
        this.m.setTextColor(com.baidu.ufosdk.b.v);
        this.B = false;
    }

    private static byte[] a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private String b() {
        ArrayList c = this.U.c();
        String str = "";
        int i = 0;
        while (i < c.size()) {
            String str2 = ((String) c.get(i)).equals("播放问题") ? str + ((String) c.get(i)) + ":" + this.F + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : i == c.size() + (-1) ? str + ((String) c.get(i)) : str + ((String) c.get(i)) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
            i++;
            str = str2;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(FeedbackReportActivity feedbackReportActivity) {
        feedbackReportActivity.w.removeAllViews();
        feedbackReportActivity.x.clear();
        feedbackReportActivity.x.add(com.baidu.ufosdk.f.m.b(feedbackReportActivity));
        feedbackReportActivity.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Bitmap bitmap;
        com.baidu.ufosdk.f.c.a(" --*^o^*-- updatePicView()");
        if (this.w == null) {
            return;
        }
        this.w.removeAllViews();
        for (int i = 0; i < this.x.size(); i++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i != this.x.size() - 1) {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f)));
                try {
                    if (this.x.get(i) != null) {
                        bitmap = BitmapFactory.decodeByteArray((byte[]) this.x.get(i), 0, ((byte[]) this.x.get(i)).length);
                        if (bitmap == null) {
                            com.baidu.ufosdk.f.c.d(" --*^o^*-- temp == null:1767");
                            return;
                        }
                    } else {
                        com.baidu.ufosdk.f.c.d(" --*^o^*-- picBytesList.get(i) == null:1771");
                        bitmap = null;
                    }
                    if (bitmap == null || a(bitmap, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                    ImageButton imageButton = new ImageButton(this);
                    imageButton.setTag(Integer.valueOf(i));
                    imageButton.setBackgroundDrawable(null);
                    imageButton.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f), 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f));
                    imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                    Bitmap a = com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_little_icon.png");
                    if (a == null) {
                        return;
                    }
                    imageButton.setImageBitmap(a);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 19.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 19.0f));
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(0, 0, 0, 0);
                    relativeLayout.addView(imageButton, layoutParams);
                    imageButton.setOnClickListener(new dy(this));
                } catch (OutOfMemoryError e) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView2 = new ImageView(this);
                imageView2.setTag(Integer.valueOf(i));
                imageView2.setBackgroundDrawable(null);
                imageView2.setPadding(0, 0, 0, 0);
                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView2.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView2, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.x.get(i), 0, ((byte[]) this.x.get(i)).length);
                    if (decodeByteArray == null || a(decodeByteArray, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                        return;
                    }
                    imageView2.setImageBitmap(decodeByteArray);
                    imageView2.setOnClickListener(new dz(this));
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    return;
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
            layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0, 0, 0);
            layoutParams2.gravity = 80;
            this.w.addView(relativeLayout, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(FeedbackReportActivity feedbackReportActivity) {
        if (feedbackReportActivity.B) {
            return;
        }
        if (feedbackReportActivity.U.c().size() == 0) {
            Toast.makeText(feedbackReportActivity, "请选择举报内容问题", 0).show();
            return;
        }
        if (feedbackReportActivity.p == 1 || feedbackReportActivity.q) {
            if (com.baidu.ufosdk.b.d.length() == 0 && !feedbackReportActivity.G) {
                if (com.baidu.ufosdk.b.af != null) {
                    com.baidu.ufosdk.b.af.getReportResult(-1);
                    return;
                }
                return;
            } else if (feedbackReportActivity.h.getText().toString().trim().length() < 5) {
                Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("34"), 0).show();
                return;
            } else if (feedbackReportActivity.x.size() <= 1) {
                Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("35"), 0).show();
                return;
            }
        }
        if (feedbackReportActivity.U.c().contains("播放问题") && feedbackReportActivity.F.length() <= 0) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("61"), 0).show();
        } else if (feedbackReportActivity.u.getText().toString().trim().length() > 30) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("32"), 0).show();
        } else if (feedbackReportActivity.U.c().size() == 0 && feedbackReportActivity.t.getText().toString().trim().length() < 4) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("12"), 0).show();
        } else if (feedbackReportActivity.t.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (!com.baidu.ufosdk.b.d.c(feedbackReportActivity.getApplicationContext())) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("64"), 0).show();
        } else if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("62"), 0).show();
            new Thread(new eg(feedbackReportActivity)).start();
        } else {
            if (feedbackReportActivity.getCurrentFocus() != null && feedbackReportActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackReportActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackReportActivity.getCurrentFocus().getWindowToken(), 2);
            }
            feedbackReportActivity.A.setVisibility(0);
            feedbackReportActivity.A.bringToFront();
            feedbackReportActivity.B = true;
            feedbackReportActivity.m.setTextColor(com.baidu.ufosdk.b.y);
            new Thread(new eh(feedbackReportActivity)).start();
        }
    }

    public final boolean a(Context context, String str, String str2, String str3, String str4, String str5, Handler handler) {
        com.baidu.ufosdk.f.c.c("url is https://ufosdk.baidu.com/?m=Index&a=postmsg");
        ArrayList c = this.U.c();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c.size()) {
                break;
            }
            this.I.put(c.get(i2));
            if (((String) c.get(i2)).equals("播放问题")) {
                this.J.put(this.F);
            }
            i = i2 + 1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", str);
        hashMap.put("appid", (this.i == null || this.i.length() <= 0) ? UfoSDK.appid : this.i);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("id", str2);
        int i3 = com.baidu.ufosdk.f.i.a(str4) ? 1 : com.baidu.ufosdk.f.i.b(str4) ? 2 : com.baidu.ufosdk.f.i.c(str4) ? 3 : 0;
        com.baidu.ufosdk.f.c.c("contactWay is " + str4 + "; type = " + i3);
        if (i3 == 0) {
            hashMap.put("contact_way", str4);
        } else if (i3 == 1) {
            com.baidu.ufosdk.f.c.c("contactWay is email");
            hashMap.put(NotificationCompat.CATEGORY_EMAIL, str4);
        } else if (i3 == 2) {
            com.baidu.ufosdk.f.c.c("contactWay is tel");
            hashMap.put("tel", str4);
        } else if (i3 == 3) {
            com.baidu.ufosdk.f.c.c("contactWay is qq");
            hashMap.put("qq", str4);
        } else {
            hashMap.put("contact_way", str4);
            com.baidu.ufosdk.f.c.c("contactWay is invalidate");
        }
        hashMap.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("os", "android");
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.b);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.f);
            if (this.h.getText().toString() != null && this.h.getText().toString().length() > 0) {
                jSONObject.put("extend_url", this.h.getText().toString());
                this.J.put(this.h.getText().toString());
                com.baidu.ufosdk.b.f = jSONObject.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        hashMap.put("extra", com.baidu.ufosdk.b.f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(this.f));
        hashMap.put("content", "[举报]" + b() + "/" + str3);
        hashMap.put("extend_keyword", b());
        com.baidu.ufosdk.f.c.a("问题选择：" + b());
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put(Config.LAUNCH_REFERER, com.baidu.ufosdk.b.p);
        hashMap.put("baiducuid", com.baidu.ufosdk.b.c);
        if (!TextUtils.isEmpty(this.g)) {
            hashMap.put("faq_id", this.g);
        }
        hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
        if (com.baidu.ufosdk.f.p.a("android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("nettype", com.baidu.ufosdk.b.d.a(context));
        } else {
            hashMap.put("nettype", "N/A");
        }
        hashMap.put("screenSize", com.baidu.ufosdk.b.f.a(context));
        if (com.baidu.ufosdk.b.a) {
            hashMap.put("logcat", com.baidu.ufosdk.b.b.a());
        }
        if (!TextUtils.isEmpty(com.baidu.ufosdk.b.h)) {
            hashMap.put("ip_location", com.baidu.ufosdk.b.h);
        }
        String a = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
        try {
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", TextUtils.isEmpty(str5) ? "sdk_encrypt=" + URLEncoder.encode(a, "UTF-8") : "sdk_encrypt=" + URLEncoder.encode(a, "UTF-8") + "&screenshot=" + URLEncoder.encode(str5, "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject2 = new JSONObject(com.baidu.ufosdk.f.k.b(a2));
                com.baidu.ufosdk.f.c.a("response is -----------------> " + jSONObject2.toString());
                int intValue = ((Integer) jSONObject2.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    UfoSDK.lastSendTime = System.currentTimeMillis();
                    UfoSDK.neverFeedback = false;
                    SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
                    edit.commit();
                    if (str2.contains("newMessage")) {
                        handler.obtainMessage(14, String.valueOf(jSONObject2.get("id"))).sendToTarget();
                    } else {
                        handler.obtainMessage(12).sendToTarget();
                    }
                    return true;
                } else if (intValue == 4) {
                    String str6 = (String) jSONObject2.get(BaseJsonData.TAG_ERRMSG);
                    Looper.prepare();
                    if (str6 != null && str6.length() > 0) {
                        Toast.makeText(context, str6, 1).show();
                    }
                    handler.obtainMessage(17, str6).sendToTarget();
                    Looper.loop();
                    return true;
                }
            }
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
            Looper.prepare();
            Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
            handler.obtainMessage(13).sendToTarget();
            Looper.loop();
        }
        this.B = false;
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x0037 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d  */
    /* JADX WARN: Type inference failed for: r0v23, types: [android.widget.Toast] */
    /* JADX WARN: Type inference failed for: r1v13, types: [byte[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v8, types: [byte[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b0 -> B:57:0x0037). Please submit an issue!!! */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        Exception e;
        byte[] bArr;
        byte[] bArr2;
        int size;
        int i3;
        Object obj;
        ?? r1;
        byte[] bArr3;
        InputStream openInputStream;
        byte[] bArr4 = null;
        bArr4 = 0;
        bArr4 = 0;
        bArr4 = 0;
        PrintStream printStream = null;
        bArr4 = 0;
        com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode = " + i + "; resultCode = " + i2);
        if (!this.T) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.c(dVar.c() + 1);
            this.T = true;
        }
        if (i2 != -1) {
            return;
        }
        this.D = false;
        if (intent == null) {
            com.baidu.ufosdk.f.c.a(" --*^o^*-- data == null");
            return;
        }
        try {
            uri = intent.getData();
        } catch (Exception e2) {
            uri = null;
        }
        if (uri == null) {
            com.baidu.ufosdk.f.c.a(" --*^o^*-- originalUri == null");
            return;
        }
        try {
            openInputStream = getContentResolver().openInputStream(uri);
        } catch (Exception e3) {
            e = e3;
            bArr = bArr4;
            PrintStream printStream2 = System.out;
            printStream2.println(e.getMessage());
            bArr2 = bArr;
            printStream = printStream2;
            size = this.x.size() - 1;
            int i4 = size;
            if (i != size) {
            }
            c();
            bArr3 = obj;
            r1 = i3;
            bArr4 = printStream;
        }
        if (openInputStream.available() >= 8388608) {
            Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
            com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1648");
        }
        byte[] a = a(openInputStream);
        try {
        } catch (Exception e4) {
            bArr = r1;
            e = e4;
            PrintStream printStream22 = System.out;
            printStream22.println(e.getMessage());
            bArr2 = bArr;
            printStream = printStream22;
            size = this.x.size() - 1;
            int i42 = size;
            if (i != size) {
            }
            c();
            bArr3 = obj;
            r1 = i3;
            bArr4 = printStream;
        }
        if (a == null) {
            bArr4 = 1;
            Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
            com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1655");
            bArr3 = " --*^o^*-- tempCompressContent == null-1655";
            r1 = a;
        } else {
            byte[] a2 = com.baidu.ufosdk.f.q.a(a);
            try {
            } catch (Exception e5) {
                e = e5;
                bArr = bArr3;
                PrintStream printStream222 = System.out;
                printStream222.println(e.getMessage());
                bArr2 = bArr;
                printStream = printStream222;
                size = this.x.size() - 1;
                int i422 = size;
                if (i != size) {
                }
                c();
                bArr3 = obj;
                r1 = i3;
                bArr4 = printStream;
            }
            if (a2 == null) {
                bArr4 = 1;
                Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1666");
                bArr3 = a2;
                r1 = " --*^o^*-- tempCompressContent == null-1666";
            } else if (a2.length > 1048576) {
                r1 = 1;
                Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent.length > 1024 * 1024");
                bArr3 = " --*^o^*-- tempCompressContent.length > 1024 * 1024";
            } else if (a2.length == 0) {
                r1 = 1;
                Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent.length == 0");
                bArr3 = " --*^o^*-- tempCompressContent.length == 0";
            } else {
                bArr2 = a2;
                if (com.baidu.ufosdk.f.i.a(this) < 35000) {
                    r1 = 1;
                    Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                    System.gc();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- CommonUtil.getmem_UNUSED(FeedbackReportActivity.this) < 35000");
                    bArr3 = " --*^o^*-- CommonUtil.getmem_UNUSED(FeedbackReportActivity.this) < 35000";
                }
                size = this.x.size() - 1;
                int i4222 = size;
                if (i != size) {
                    if (bArr2 != null) {
                        int length = bArr2.length;
                        i4222 = length;
                        if (length != 0) {
                            this.x.set(i, bArr2);
                            List list = this.x;
                            ?? b = com.baidu.ufosdk.f.m.b(this);
                            list.add(b);
                            com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode == picBytesList.size() - 1");
                            obj = " --*^o^*-- requestCode == picBytesList.size() - 1";
                            i3 = b;
                        }
                    }
                    ?? makeText = Toast.makeText(this, "图片错误，请重新选择一张。", 1);
                    makeText.show();
                    obj = makeText;
                    i3 = i4222;
                } else {
                    Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                    com.baidu.ufosdk.f.c.a("picBytesList--->clear:1710");
                    this.x.clear();
                    List list2 = this.x;
                    ?? b2 = com.baidu.ufosdk.f.m.b(this);
                    list2.add(b2);
                    obj = list2;
                    i3 = b2;
                }
                c();
                bArr3 = obj;
                r1 = i3;
                bArr4 = printStream;
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        this.c = getSharedPreferences("UfoSharePreference", 0);
        this.M = this.c.getString("cryptContactData", "");
        if (this.M == null || this.M.trim().length() <= 0) {
            this.M = "";
        } else {
            this.M = com.baidu.ufosdk.f.k.b(this.M);
        }
        this.b = this.c.edit();
        this.g = getIntent().getStringExtra("faq_id");
        this.z = getIntent().getStringExtra("msgid");
        this.R = getIntent().getIntExtra("product_type", 0);
        this.i = getIntent().getStringExtra("app_id");
        this.j = getIntent().getByteArrayExtra("shot");
        if (TextUtils.isEmpty(this.z)) {
            this.z = "newMessage";
        }
        if (TextUtils.isEmpty(this.g)) {
            this.g = "";
        }
        this.b.putBoolean("ADD_PIC_FLAG", true);
        this.b.commit();
        this.f = getIntent().getIntExtra("feedback_channel", 0);
        if (this.f == 33487 || this.f == 33496 || this.f == 33497 || this.f == 33506 || this.f == 33509) {
            this.G = true;
        }
        this.L = new ScrollView(this);
        this.k = new RelativeLayout(this);
        this.k.setFitsSystemWindows(true);
        this.k.setId(R.raw.ala_play);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.string.abc_action_mode_done);
        this.k.setBackgroundColor(com.baidu.ufosdk.b.A);
        new RelativeLayout.LayoutParams(-1, -1);
        new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.l = new ImageView(this);
        this.l.setId(R.raw.aiapp_guide);
        this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.l.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout.addView(this.l, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        relativeLayout.addView(linearLayout, layoutParams3);
        this.n = new TextView(this);
        this.n.setId(R.raw.ala_live1);
        this.n.setText(this.S);
        this.n.setTextColor(com.baidu.ufosdk.b.r);
        this.n.setTextSize(com.baidu.ufosdk.b.T);
        this.n.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(13);
        relativeLayout.addView(this.n, layoutParams4);
        this.m = new Button(this);
        if (getIntent().getIntExtra("continue", 0) == 1) {
            this.m.setVisibility(4);
        }
        this.m.setText("提交");
        this.m.setId(R.string.abc_capital_off);
        this.m.setTextColor(com.baidu.ufosdk.b.y);
        this.m.setTextSize(com.baidu.ufosdk.b.U);
        this.m.setGravity(17);
        this.m.setBackgroundColor(16777215);
        this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.baidu.ufosdk.f.i.a(getApplicationContext(), 28.0f));
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        relativeLayout.addView(this.m, layoutParams5);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 44.0f));
        layoutParams6.addRule(10);
        this.k.addView(relativeLayout, layoutParams6);
        new LinearLayout.LayoutParams(-1, -1).weight = 1.0f;
        View view = new View(this);
        view.setId(133201936);
        view.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams7.addRule(3, relativeLayout.getId());
        this.k.addView(view, layoutParams7);
        this.s = new RelativeLayout(this);
        this.s.setId(R.raw.bottom_bar_bg);
        this.s.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams8.addRule(3, view.getId());
        this.L.addView(this.s);
        this.k.addView(this.L, layoutParams8);
        this.A = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(13);
        this.s.addView(this.A, layoutParams9);
        this.A.setVisibility(8);
        linearLayout.setOnClickListener(new ea(this));
        this.m.setOnClickListener(new eb(this));
        this.x = new ArrayList();
        if (this.j != null && this.j.length > 0) {
            this.x.add(this.j);
        }
        this.N = new LinearLayout(this);
        this.N.setId(R.string.abc_capital_on);
        this.N.setOrientation(1);
        this.N.setBackgroundColor(com.baidu.ufosdk.b.A);
        new LinearLayout.LayoutParams(-1, -2);
        this.P = new TextView(this);
        this.P.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.P.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString = new SpannableString("举报内容问题*");
        spannableString.setSpan(new ForegroundColorSpan(com.baidu.ufosdk.b.K), 6, 7, 34);
        this.P.setText(spannableString);
        this.P.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        this.P.setGravity(16);
        this.P.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), 0, 0);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams10.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 20.0f), 0, 0);
        this.N.addView(this.P, layoutParams10);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        float a = com.baidu.ufosdk.f.i.a((Context) this, 3.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(a);
        gradientDrawable.setStroke(1, -3355444);
        linearLayout2.setBackgroundDrawable(null);
        ArrayList arrayList = new ArrayList();
        arrayList.add("违法");
        arrayList.add("谣言");
        arrayList.add("色情");
        arrayList.add("恐怖恶心");
        arrayList.add("广告");
        arrayList.add("题文不符");
        arrayList.add("新闻过期");
        arrayList.add("抄袭");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("播放问题");
        arrayList2.add("标题内容不符");
        arrayList2.add("广告");
        arrayList2.add("低俗色情");
        arrayList2.add("过期旧闻");
        arrayList2.add("虚假谣言");
        arrayList2.add("违法反动");
        arrayList2.add("内容不完整");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("题文不符");
        arrayList3.add("低俗色情");
        arrayList3.add("虚假广告");
        arrayList3.add("广告重复");
        arrayList3.add("页面无法打开");
        arrayList3.add("样式排版异常");
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("播放问题");
        arrayList4.add("低俗色情");
        arrayList4.add("令人不适");
        arrayList4.add("骗点击");
        arrayList4.add("侮辱谩骂");
        arrayList4.add("疑似抄袭");
        arrayList4.add("广告");
        arrayList4.add("违法反动");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("播放问题");
        arrayList5.add("封面内容不符");
        arrayList5.add("明显广告");
        arrayList5.add("视频涉黄涉反");
        arrayList5.add("疑似抄袭");
        arrayList5.add("视频与搜索词无关");
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add("垃圾广告内容");
        arrayList6.add("违规违法内容");
        arrayList6.add("淫秽色情信息");
        arrayList6.add("不友善内容");
        arrayList6.add("内容不专业");
        arrayList6.add("涉嫌侵权");
        arrayList6.add("其他");
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add("淫秽色情");
        arrayList7.add("政治有害");
        arrayList7.add("违法违禁品");
        arrayList7.add("血腥暴力");
        arrayList7.add("其他违规内容");
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add("播放问题");
        arrayList8.add("标题内容不符");
        arrayList8.add("广告");
        arrayList8.add("低俗色情");
        arrayList8.add("疑似抄袭");
        arrayList8.add("过期旧闻");
        arrayList8.add("虚假谣言");
        arrayList8.add("违法反动");
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(arrayList);
        arrayList9.add(arrayList2);
        arrayList9.add(arrayList3);
        arrayList9.add(arrayList4);
        arrayList9.add(arrayList5);
        arrayList9.add(arrayList6);
        arrayList9.add(arrayList7);
        arrayList9.add(arrayList8);
        ec ecVar = new ec(this);
        if (this.f == 32600 || this.f == 33101) {
            this.U = new a((ArrayList) arrayList9.get(1), this, ecVar);
        } else if (this.f == 32601) {
            this.U = new a((ArrayList) arrayList9.get(2), this, ecVar);
        } else if (this.f == 33115) {
            this.U = new a((ArrayList) arrayList9.get(3), this, ecVar);
        } else if (this.G) {
            this.U = new a((ArrayList) arrayList9.get(4), this, ecVar);
        } else if (this.f == 33712 || this.f == 33711 || this.f == 33710) {
            this.U = new a((ArrayList) arrayList9.get(5), this, ecVar);
        } else if (this.f == 33717) {
            this.U = new a((ArrayList) arrayList9.get(6), this, ecVar);
        } else if (this.f == 33131) {
            this.U = new a((ArrayList) arrayList9.get(7), this, ecVar);
        } else {
            this.U = new a((ArrayList) arrayList9.get(0), this, ecVar);
        }
        LinearLayout a2 = this.U.a();
        LinearLayout b = this.U.b();
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.weight = 1.0f;
        linearLayout2.addView(a2, layoutParams11);
        linearLayout2.addView(b, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams12.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        this.N.addView(linearLayout2, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams13.addRule(10);
        this.s.addView(this.N, layoutParams13);
        this.O = new LinearLayout(this);
        this.O.setId(R.string.sapi_sdk_common_loading_timeout);
        this.O.setVisibility(8);
        this.O.setOrientation(1);
        this.O.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.Q = new TextView(this);
        this.Q.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.Q.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString2 = new SpannableString("请明确所遇到的播放问题*（单选）");
        spannableString2.setSpan(new ForegroundColorSpan(com.baidu.ufosdk.b.K), 11, 12, 34);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 12, 16, 34);
        spannableString2.setSpan(new AbsoluteSizeSpan(12, true), 12, 16, 34);
        this.Q.setText(spannableString2);
        this.Q.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        this.Q.setGravity(16);
        this.Q.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        this.O.addView(this.Q, new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f)));
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(a);
        gradientDrawable2.setStroke(1, -3355444);
        linearLayout3.setBackgroundDrawable(gradientDrawable2);
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add("持续加载");
        arrayList10.add("播放卡顿");
        arrayList10.add("播放失败");
        arrayList10.add("视频下线");
        arrayList10.add("有声音无画面");
        arrayList10.add("有画面无声音");
        this.V = new f(arrayList10, this, new ed(this));
        LinearLayout a3 = this.V.a();
        LinearLayout b2 = this.V.b();
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams14.weight = 1.0f;
        linearLayout3.addView(a3, layoutParams14);
        linearLayout3.addView(b2, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        this.O.addView(linearLayout3, layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams16.addRule(3, this.N.getId());
        this.s.addView(this.O, layoutParams16);
        this.o = new LinearLayout(this);
        this.o.setVisibility(8);
        this.o.setId(R.string.status_bar_notification_info_overflow);
        this.o.setOrientation(1);
        this.o.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView2 = new TextView(this);
        textView2.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView2.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString3 = new SpannableString(this.G ? "原创作品链接*" : "原创视频链接*");
        spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#f7534f")), 6, 7, 34);
        textView2.setText(spannableString3);
        textView2.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f), 0, 0);
        textView2.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView2.setGravity(16);
        this.o.addView(textView2, new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f)));
        float a4 = com.baidu.ufosdk.f.i.a((Context) this, 3.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(-1);
        gradientDrawable3.setCornerRadius(a4);
        gradientDrawable3.setStroke(3, -3355444);
        this.h = new EditText(this);
        this.h.setBackgroundDrawable(gradientDrawable3);
        this.h.setTextColor(-13421773);
        this.h.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
        this.h.setGravity(16);
        this.h.setSingleLine();
        this.h.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams17.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        this.o.addView(this.h, layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams18.addRule(3, this.O.getId());
        this.s.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 30.0f));
        this.s.addView(this.o, layoutParams18);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setId(R.string.abc_toolbar_collapse_description);
        linearLayout4.setOrientation(1);
        linearLayout4.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.r = new TextView(this);
        this.r.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.r.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString4 = new SpannableString("问题截图（系统自动截取）");
        spannableString4.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 4, spannableString4.length(), 34);
        spannableString4.setSpan(new AbsoluteSizeSpan(12, true), 4, spannableString4.length(), 34);
        if (this.j == null || !this.x.contains(this.j)) {
            this.r.setText("上传截图");
        } else {
            this.r.setText(spannableString4);
        }
        this.r.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        this.r.setGravity(16);
        this.r.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams19.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout4.addView(this.r, layoutParams19);
        this.w = new LinearLayout(this);
        this.w.setOrientation(0);
        this.w.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 350.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
        this.x.add(com.baidu.ufosdk.f.m.b(this));
        c();
        linearLayout4.addView(this.w, layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams21.addRule(3, this.o.getId());
        this.s.addView(linearLayout4, layoutParams21);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setId(R.string.abc_search_hint);
        linearLayout5.setOrientation(1);
        linearLayout5.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView3 = new TextView(this);
        textView3.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView3.setTextColor(com.baidu.ufosdk.b.r);
        textView3.setText("更多问题及建议");
        textView3.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        textView3.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView3.setGravity(16);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams22.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 22.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout5.addView(textView3, layoutParams22);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(-1);
        gradientDrawable4.setCornerRadius(com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
        gradientDrawable4.setStroke(3, -3355444);
        relativeLayout2.setBackgroundDrawable(gradientDrawable4);
        this.t = new EditText(this);
        this.t.setId(R.string.abc_searchview_description_clear);
        this.t.setBackgroundColor(-1);
        this.t.setTextColor(-13421773);
        this.t.setTextSize(com.baidu.ufosdk.b.U);
        this.t.setHint("请描述问题或建议，播放问题请勾选具体问题；抄袭请附链接和截图");
        this.t.setHintTextColor(-6710887);
        this.t.setGravity(3);
        this.t.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 62.0f));
        layoutParams23.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f), com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
        relativeLayout2.addView(this.t, layoutParams23);
        this.v = new TextView(this);
        this.v.setBackgroundColor(-1);
        this.v.setTextSize(com.baidu.ufosdk.b.V);
        this.v.setTextColor(-5131855);
        this.v.setText("4-" + com.baidu.ufosdk.b.aa + "字");
        RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams24.addRule(3, this.t.getId());
        layoutParams24.addRule(11);
        this.v.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0);
        relativeLayout2.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f));
        relativeLayout2.addView(this.v, layoutParams24);
        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams25.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        linearLayout5.addView(relativeLayout2, layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams26.addRule(3, linearLayout4.getId());
        this.s.addView(linearLayout5, layoutParams26);
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setId(R.string.search_menu_title);
        linearLayout6.setOrientation(1);
        linearLayout6.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView4 = new TextView(this);
        textView4.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView4.setTextColor(com.baidu.ufosdk.b.r);
        textView4.setText("联系方式");
        textView4.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        textView4.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView4.setGravity(16);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams27.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 22.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout6.addView(textView4, layoutParams27);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(-1);
        gradientDrawable5.setCornerRadius(a4);
        gradientDrawable5.setStroke(3, -3355444);
        this.u = new EditText(this);
        this.u.setBackgroundDrawable(gradientDrawable3);
        this.u.setTextColor(-13421773);
        this.u.setTextSize(com.baidu.ufosdk.b.U);
        this.u.setGravity(16);
        this.u.setHint("请留下您的邮箱/手机/QQ号");
        this.u.setHintTextColor(-6710887);
        this.u.setSingleLine();
        this.u.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams28.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        linearLayout6.addView(this.u, layoutParams28);
        RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams29.addRule(3, linearLayout5.getId());
        this.s.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f));
        this.s.addView(linearLayout6, layoutParams29);
        this.t.addTextChangedListener(new ee(this));
        this.u.addTextChangedListener(new ef(this));
        setContentView(this.k);
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("exit!");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.C = true;
            a();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        String obj = this.u.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            this.b.putString("cryptContactData", "");
        } else {
            this.b.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        if (this.y.booleanValue()) {
            if (TextUtils.isEmpty(this.g)) {
                this.b.putString(this.z, this.t.getText().toString());
            } else {
                this.b.putString(this.g, this.t.getText().toString());
            }
        }
        this.b.commit();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(UfoSDK.clientid)) {
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            UfoSDK.clientid = sharedPreferences.getString("UfoClientId", "");
            UfoSDK.appid = sharedPreferences.getString("UfoAppId", "");
            UfoSDK.devid = sharedPreferences.getString("UfoDevId", "");
            UfoSDK.productid = sharedPreferences.getString("UfoProductId", "");
        }
        com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
        dVar.a(dVar.a() + 1);
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        if ("".equals(com.baidu.ufosdk.b.n)) {
            this.t.setHint("请描述问题或建议，播放问题请勾选具体问题；抄袭请附链接和截图");
        } else {
            this.t.setHint(com.baidu.ufosdk.b.n);
        }
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.A, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        this.m.setTextSize(com.baidu.ufosdk.b.U);
        this.y = true;
        if (this.z == null) {
            this.z = "newMessage";
        } else if (this.z.length() == 0) {
            this.z = "newMessage";
        }
        String string = this.c.getString("cryptContactData", "");
        if (string == null || string.trim().length() <= 0) {
            this.u.setText("");
        } else {
            this.u.setText(com.baidu.ufosdk.f.k.b(string));
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new dw(this)).start();
        } else {
            new Thread(new dx(this)).start();
        }
    }
}
