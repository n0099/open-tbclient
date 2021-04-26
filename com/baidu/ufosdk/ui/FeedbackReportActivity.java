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
import androidx.core.view.ViewCompat;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.widget.ConfirmDialog;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.R;
import com.baidu.ufosdk.ReportCallback;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.webkit.sdk.WebKitFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SetJavaScriptEnabled"})
@TargetApi(11)
/* loaded from: classes5.dex */
public class FeedbackReportActivity extends Activity {
    public View A;
    public ScrollView L;
    public String M;
    public LinearLayout N;
    public LinearLayout O;
    public TextView P;
    public TextView Q;
    public a U;
    public f V;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f23434b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f23435c;

    /* renamed from: h  reason: collision with root package name */
    public EditText f23440h;
    public byte[] j;
    public RelativeLayout k;
    public ImageView l;
    public Button m;
    public TextView n;
    public LinearLayout o;
    public TextView r;
    public RelativeLayout s;
    public EditText t;
    public EditText u;
    public TextView v;
    public LinearLayout w;
    public List x;
    public String z;

    /* renamed from: d  reason: collision with root package name */
    public String f23436d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f23437e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f23438f = 0;

    /* renamed from: g  reason: collision with root package name */
    public String f23439g = "";

    /* renamed from: i  reason: collision with root package name */
    public String f23441i = "";
    public int p = 0;
    public boolean q = false;
    public Boolean y = Boolean.TRUE;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public String F = "";
    public boolean G = false;
    public boolean H = false;
    public JSONArray I = new JSONArray();
    public JSONArray J = new JSONArray();
    public Handler K = new dv(this);
    public int R = 0;
    public String S = "举报/反馈";
    public boolean T = false;

    /* renamed from: a  reason: collision with root package name */
    public int f23433a = -1;

    public static /* synthetic */ void D(FeedbackReportActivity feedbackReportActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        if (feedbackReportActivity.f23433a == feedbackReportActivity.x.size() - 1) {
            if (feedbackReportActivity.getCurrentFocus() != null && feedbackReportActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackReportActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackReportActivity.getCurrentFocus().getWindowToken(), 2);
            }
            try {
                feedbackReportActivity.D = true;
                feedbackReportActivity.startActivityForResult(intent, feedbackReportActivity.f23433a);
                try {
                    feedbackReportActivity.overridePendingTransition(com.baidu.ufosdk.f.i.a(feedbackReportActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                } catch (Exception unused) {
                }
            } catch (ActivityNotFoundException unused2) {
                Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        if (bitmap == null || i2 <= 0) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= i2 || height <= i2) {
            return bitmap;
        }
        int max = (Math.max(width, height) * i2) / Math.min(width, height);
        int i3 = width > height ? max : i2;
        if (width > height) {
            max = i2;
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i3, max, true);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap, (i3 - i2) / 2, (max - i2) / 2, i2, i2);
            createScaledBitmap.recycle();
            return createBitmap;
        } catch (Exception unused) {
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

    public static byte[] a(InputStream inputStream) {
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
        StringBuilder sb;
        String str;
        ArrayList c2 = this.U.c();
        String str2 = "";
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (((String) c2.get(i2)).equals("播放问题")) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append((String) c2.get(i2));
                sb.append(":");
                str = this.F;
            } else if (i2 == c2.size() - 1) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append((String) c2.get(i2));
                str2 = sb.toString();
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                str = (String) c2.get(i2);
            }
            sb.append(str);
            sb.append(";");
            str2 = sb.toString();
        }
        return str2;
    }

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
        LinearLayout linearLayout = this.w;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i2 != this.x.size() - 1) {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i2));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f)));
                try {
                    if (this.x.get(i2) != null) {
                        bitmap = BitmapFactory.decodeByteArray((byte[]) this.x.get(i2), 0, ((byte[]) this.x.get(i2)).length);
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
                    imageButton.setTag(Integer.valueOf(i2));
                    imageButton.setBackgroundDrawable(null);
                    imageButton.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f), 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f));
                    imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                    Bitmap a2 = com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_little_icon.png");
                    if (a2 == null) {
                        return;
                    }
                    imageButton.setImageBitmap(a2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 19.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 19.0f));
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(0, 0, 0, 0);
                    relativeLayout.addView(imageButton, layoutParams);
                    imageButton.setOnClickListener(new dy(this));
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView2 = new ImageView(this);
                imageView2.setTag(Integer.valueOf(i2));
                imageView2.setBackgroundDrawable(null);
                imageView2.setPadding(0, 0, 0, 0);
                imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView2.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                imageView2.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
                relativeLayout.addView(imageView2, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.x.get(i2), 0, ((byte[]) this.x.get(i2)).length);
                    if (decodeByteArray == null || a(decodeByteArray, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                        return;
                    }
                    imageView2.setImageBitmap(decodeByteArray);
                    imageView2.setOnClickListener(new dz(this));
                } catch (OutOfMemoryError unused2) {
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

    public static /* synthetic */ void o(FeedbackReportActivity feedbackReportActivity) {
        if (feedbackReportActivity.B) {
            return;
        }
        if (feedbackReportActivity.U.c().size() == 0) {
            Toast.makeText(feedbackReportActivity, "请选择举报内容问题", 0).show();
            return;
        }
        if (feedbackReportActivity.p == 1 || feedbackReportActivity.q) {
            if (com.baidu.ufosdk.b.f23300d.length() == 0 && !feedbackReportActivity.G) {
                ReportCallback reportCallback = com.baidu.ufosdk.b.af;
                if (reportCallback != null) {
                    reportCallback.getReportResult(-1);
                    return;
                }
                return;
            } else if (feedbackReportActivity.f23440h.getText().toString().trim().length() < 5) {
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
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SET_AVATAR), 0).show();
        } else if (feedbackReportActivity.t.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (!com.baidu.ufosdk.b.d.c(feedbackReportActivity.getApplicationContext())) {
            Toast.makeText(feedbackReportActivity, com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 0).show();
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
        String str6;
        StringBuilder sb;
        com.baidu.ufosdk.f.c.c("url is https://ufosdk.baidu.com/?m=Index&a=postmsg");
        ArrayList c2 = this.U.c();
        for (int i2 = 0; i2 < c2.size(); i2++) {
            this.I.put(c2.get(i2));
            if (((String) c2.get(i2)).equals("播放问题")) {
                this.J.put(this.F);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", str);
        String str7 = this.f23441i;
        hashMap.put("appid", (str7 == null || str7.length() <= 0) ? UfoSDK.appid : this.f23441i);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("id", str2);
        int i3 = com.baidu.ufosdk.f.i.a(str4) ? 1 : com.baidu.ufosdk.f.i.b(str4) ? 2 : com.baidu.ufosdk.f.i.c(str4) ? 3 : 0;
        com.baidu.ufosdk.f.c.c("contactWay is " + str4 + "; type = " + i3);
        if (i3 == 0) {
            hashMap.put("contact_way", str4);
        } else {
            if (i3 == 1) {
                com.baidu.ufosdk.f.c.c("contactWay is email");
                str6 = "email";
            } else if (i3 == 2) {
                com.baidu.ufosdk.f.c.c("contactWay is tel");
                str6 = "tel";
            } else if (i3 == 3) {
                com.baidu.ufosdk.f.c.c("contactWay is qq");
                str6 = LoginConstants.QQ_LOGIN;
            } else {
                hashMap.put("contact_way", str4);
                com.baidu.ufosdk.f.c.c("contactWay is invalidate");
            }
            hashMap.put(str6, str4);
        }
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put(IAdRequestParam.OS, "android");
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
        hashMap.put("uid", com.baidu.ufosdk.b.f23300d);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f23300d);
        hashMap.put("username", com.baidu.ufosdk.b.f23298b);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        try {
            JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.b.f23302f);
            if (this.f23440h.getText().toString() != null && this.f23440h.getText().toString().length() > 0) {
                jSONObject.put("extend_url", this.f23440h.getText().toString());
                this.J.put(this.f23440h.getText().toString());
                com.baidu.ufosdk.b.f23302f = jSONObject.toString();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("extra", com.baidu.ufosdk.b.f23302f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(this.f23438f));
        hashMap.put("content", "[举报]" + b() + "/" + str3);
        hashMap.put("extend_keyword", b());
        StringBuilder sb2 = new StringBuilder("问题选择：");
        sb2.append(b());
        com.baidu.ufosdk.f.c.a(sb2.toString());
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put(Config.LAUNCH_REFERER, com.baidu.ufosdk.b.p);
        hashMap.put("baiducuid", com.baidu.ufosdk.b.f23299c);
        if (!TextUtils.isEmpty(this.f23439g)) {
            hashMap.put("faq_id", this.f23439g);
        }
        hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
        hashMap.put("nettype", com.baidu.ufosdk.f.p.a(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) ? com.baidu.ufosdk.b.d.a(context) : "N/A");
        hashMap.put("screenSize", com.baidu.ufosdk.b.f.a(context));
        if (com.baidu.ufosdk.b.f23297a) {
            hashMap.put("logcat", com.baidu.ufosdk.b.b.a());
        }
        if (!TextUtils.isEmpty(com.baidu.ufosdk.b.f23304h)) {
            hashMap.put("ip_location", com.baidu.ufosdk.b.f23304h);
        }
        String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
        try {
            if (TextUtils.isEmpty(str5)) {
                sb = new StringBuilder("sdk_encrypt=");
                sb.append(URLEncoder.encode(a2, "UTF-8"));
            } else {
                sb = new StringBuilder("sdk_encrypt=");
                sb.append(URLEncoder.encode(a2, "UTF-8"));
                sb.append("&screenshot=");
                sb.append(URLEncoder.encode(str5, "UTF-8"));
            }
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", sb.toString());
            if (!TextUtils.isEmpty(a3)) {
                JSONObject jSONObject2 = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                com.baidu.ufosdk.f.c.a("response is -----------------> " + jSONObject2.toString());
                int intValue = ((Integer) jSONObject2.get("errno")).intValue();
                if (intValue == 0) {
                    UfoSDK.lastSendTime = System.currentTimeMillis();
                    UfoSDK.neverFeedback = false;
                    SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
                    edit.commit();
                    (str2.contains("newMessage") ? handler.obtainMessage(14, String.valueOf(jSONObject2.get("id"))) : handler.obtainMessage(12)).sendToTarget();
                    return true;
                } else if (intValue == 4) {
                    String str8 = (String) jSONObject2.get("errmsg");
                    Looper.prepare();
                    if (str8 != null && str8.length() > 0) {
                        Toast.makeText(context, str8, 1).show();
                    }
                    handler.obtainMessage(17, str8).sendToTarget();
                    Looper.loop();
                    return true;
                }
            }
        } catch (Exception e3) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e3);
            Looper.prepare();
            Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
            handler.obtainMessage(13).sendToTarget();
            Looper.loop();
        }
        this.B = false;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0119  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri uri;
        byte[] bArr;
        Exception e2;
        InputStream openInputStream;
        String str;
        com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode = " + i2 + "; resultCode = " + i3);
        if (!this.T) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.c(dVar.c() + 1);
            this.T = true;
        }
        if (i3 != -1) {
            return;
        }
        this.D = false;
        if (intent == null) {
            str = " --*^o^*-- data == null";
        } else {
            try {
                uri = intent.getData();
            } catch (Exception unused) {
                uri = null;
            }
            if (uri != null) {
                try {
                    openInputStream = getContentResolver().openInputStream(uri);
                } catch (Exception e3) {
                    bArr = null;
                    e2 = e3;
                }
                if (openInputStream.available() >= 8388608) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1648");
                    return;
                }
                bArr = a(openInputStream);
                try {
                } catch (Exception e4) {
                    e2 = e4;
                    System.out.println(e2.getMessage());
                    if (i2 == this.x.size() - 1) {
                    }
                    c();
                    return;
                }
                if (bArr == null) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1655");
                    return;
                }
                bArr = com.baidu.ufosdk.f.q.a(bArr);
                if (bArr == null) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent == null-1666");
                    return;
                } else if (bArr.length > 1048576) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent.length > 1024 * 1024");
                    return;
                } else if (bArr.length == 0) {
                    Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                    com.baidu.ufosdk.f.c.a(" --*^o^*-- tempCompressContent.length == 0");
                    return;
                } else {
                    if (com.baidu.ufosdk.f.i.a(this) < 35000) {
                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                        System.gc();
                        com.baidu.ufosdk.f.c.a(" --*^o^*-- CommonUtil.getmem_UNUSED(FeedbackReportActivity.this) < 35000");
                        return;
                    }
                    if (i2 == this.x.size() - 1) {
                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                        com.baidu.ufosdk.f.c.a("picBytesList--->clear:1710");
                        this.x.clear();
                        this.x.add(com.baidu.ufosdk.f.m.b(this));
                    } else if (bArr == null || bArr.length == 0) {
                        Toast.makeText(this, "图片错误，请重新选择一张。", 1).show();
                    } else {
                        this.x.set(i2, bArr);
                        this.x.add(com.baidu.ufosdk.f.m.b(this));
                        com.baidu.ufosdk.f.c.a(" --*^o^*-- requestCode == picBytesList.size() - 1");
                    }
                    c();
                    return;
                }
            }
            str = " --*^o^*-- originalUri == null";
        }
        com.baidu.ufosdk.f.c.a(str);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
        this.f23435c = sharedPreferences;
        String string = sharedPreferences.getString("cryptContactData", "");
        this.M = string;
        this.M = (string == null || string.trim().length() <= 0) ? "" : com.baidu.ufosdk.f.k.b(this.M);
        this.f23434b = this.f23435c.edit();
        this.f23439g = getIntent().getStringExtra("faq_id");
        this.z = getIntent().getStringExtra("msgid");
        this.R = getIntent().getIntExtra("product_type", 0);
        this.f23441i = getIntent().getStringExtra(com.xiaomi.mipush.sdk.Constants.APP_ID);
        this.j = getIntent().getByteArrayExtra("shot");
        if (TextUtils.isEmpty(this.z)) {
            this.z = "newMessage";
        }
        if (TextUtils.isEmpty(this.f23439g)) {
            this.f23439g = "";
        }
        this.f23434b.putBoolean("ADD_PIC_FLAG", true);
        this.f23434b.commit();
        int intExtra = getIntent().getIntExtra("feedback_channel", 0);
        this.f23438f = intExtra;
        if (intExtra == 33487 || intExtra == 33496 || intExtra == 33497 || intExtra == 33506 || intExtra == 33509) {
            this.G = true;
        }
        this.L = new ScrollView(this);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.k = relativeLayout;
        relativeLayout.setFitsSystemWindows(true);
        this.k.setId(R.drawable.res_0x7f080004_avd_show_password__1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setId(R.id.BOTTOM);
        this.k.setBackgroundColor(com.baidu.ufosdk.b.A);
        new RelativeLayout.LayoutParams(-1, -1);
        new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        ImageView imageView = new ImageView(this);
        this.l = imageView;
        imageView.setId(R.drawable.res_0x7f080001_avd_hide_password__1);
        this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.l.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout.addView(this.l, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.f23305i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        relativeLayout2.addView(linearLayout, layoutParams3);
        TextView textView2 = new TextView(this);
        this.n = textView2;
        textView2.setId(R.drawable.res_0x7f080002_avd_hide_password__2);
        this.n.setText(this.S);
        this.n.setTextColor(com.baidu.ufosdk.b.r);
        this.n.setTextSize(com.baidu.ufosdk.b.T);
        this.n.setGravity(17);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(13);
        relativeLayout2.addView(this.n, layoutParams4);
        this.m = new Button(this);
        if (getIntent().getIntExtra("continue", 0) == 1) {
            this.m.setVisibility(4);
        }
        this.m.setText("提交");
        this.m.setId(R.id.Backward);
        this.m.setTextColor(com.baidu.ufosdk.b.y);
        this.m.setTextSize(com.baidu.ufosdk.b.U);
        this.m.setGravity(17);
        this.m.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.baidu.ufosdk.f.i.a(getApplicationContext(), 28.0f));
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        relativeLayout2.addView(this.m, layoutParams5);
        relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 44.0f));
        layoutParams6.addRule(10);
        this.k.addView(relativeLayout2, layoutParams6);
        new LinearLayout.LayoutParams(-1, -1).weight = 1.0f;
        View view = new View(this);
        view.setId(133201936);
        view.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams7.addRule(3, relativeLayout2.getId());
        this.k.addView(view, layoutParams7);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        this.s = relativeLayout3;
        relativeLayout3.setId(R.drawable.res_0x7f080005_avd_show_password__2);
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
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        byte[] bArr = this.j;
        if (bArr != null && bArr.length > 0) {
            arrayList.add(bArr);
        }
        LinearLayout linearLayout2 = new LinearLayout(this);
        this.N = linearLayout2;
        linearLayout2.setId(R.id.CTRL);
        this.N.setOrientation(1);
        this.N.setBackgroundColor(com.baidu.ufosdk.b.A);
        new LinearLayout.LayoutParams(-1, -2);
        TextView textView3 = new TextView(this);
        this.P = textView3;
        textView3.setBackgroundColor(com.baidu.ufosdk.b.A);
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
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setOrientation(0);
        float a2 = com.baidu.ufosdk.f.i.a((Context) this, 3.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(a2);
        gradientDrawable.setStroke(1, -3355444);
        linearLayout3.setBackgroundDrawable(null);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("违法");
        arrayList2.add("谣言");
        arrayList2.add("色情");
        arrayList2.add("恐怖恶心");
        arrayList2.add("广告");
        arrayList2.add("题文不符");
        arrayList2.add("新闻过期");
        arrayList2.add("抄袭");
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("播放问题");
        arrayList3.add("标题内容不符");
        arrayList3.add("广告");
        arrayList3.add("低俗色情");
        arrayList3.add("过期旧闻");
        arrayList3.add("虚假谣言");
        arrayList3.add("违法反动");
        arrayList3.add("内容不完整");
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("题文不符");
        arrayList4.add("低俗色情");
        arrayList4.add("虚假广告");
        arrayList4.add("广告重复");
        arrayList4.add("页面无法打开");
        arrayList4.add("样式排版异常");
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("播放问题");
        arrayList5.add("低俗色情");
        arrayList5.add("令人不适");
        arrayList5.add("骗点击");
        arrayList5.add("侮辱谩骂");
        arrayList5.add("疑似抄袭");
        arrayList5.add("广告");
        arrayList5.add("违法反动");
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add("播放问题");
        arrayList6.add("封面内容不符");
        arrayList6.add("明显广告");
        arrayList6.add("视频涉黄涉反");
        arrayList6.add("疑似抄袭");
        arrayList6.add("视频与搜索词无关");
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add("垃圾广告内容");
        arrayList7.add("违规违法内容");
        arrayList7.add("淫秽色情信息");
        arrayList7.add("不友善内容");
        arrayList7.add("内容不专业");
        arrayList7.add("涉嫌侵权");
        arrayList7.add("其他");
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add("淫秽色情");
        arrayList8.add("政治有害");
        arrayList8.add("违法违禁品");
        arrayList8.add("血腥暴力");
        arrayList8.add("其他违规内容");
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add("播放问题");
        arrayList9.add("标题内容不符");
        arrayList9.add("广告");
        arrayList9.add("低俗色情");
        arrayList9.add("疑似抄袭");
        arrayList9.add("过期旧闻");
        arrayList9.add("虚假谣言");
        arrayList9.add("违法反动");
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(arrayList2);
        arrayList10.add(arrayList3);
        arrayList10.add(arrayList4);
        arrayList10.add(arrayList5);
        arrayList10.add(arrayList6);
        arrayList10.add(arrayList7);
        arrayList10.add(arrayList8);
        arrayList10.add(arrayList9);
        ec ecVar = new ec(this);
        int i2 = this.f23438f;
        this.U = (i2 == 32600 || i2 == 33101) ? new a((ArrayList) arrayList10.get(1), this, ecVar) : i2 == 32601 ? new a((ArrayList) arrayList10.get(2), this, ecVar) : i2 == 33115 ? new a((ArrayList) arrayList10.get(3), this, ecVar) : this.G ? new a((ArrayList) arrayList10.get(4), this, ecVar) : (i2 == 33712 || i2 == 33711 || i2 == 33710) ? new a((ArrayList) arrayList10.get(5), this, ecVar) : i2 == 33717 ? new a((ArrayList) arrayList10.get(6), this, ecVar) : i2 == 33131 ? new a((ArrayList) arrayList10.get(7), this, ecVar) : new a((ArrayList) arrayList10.get(0), this, ecVar);
        LinearLayout a3 = this.U.a();
        LinearLayout b2 = this.U.b();
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.weight = 1.0f;
        linearLayout3.addView(a3, layoutParams11);
        linearLayout3.addView(b2, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams12.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        this.N.addView(linearLayout3, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams13.addRule(10);
        this.s.addView(this.N, layoutParams13);
        LinearLayout linearLayout4 = new LinearLayout(this);
        this.O = linearLayout4;
        linearLayout4.setId(R.id.STROKE);
        this.O.setVisibility(8);
        this.O.setOrientation(1);
        this.O.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView4 = new TextView(this);
        this.Q = textView4;
        textView4.setBackgroundColor(com.baidu.ufosdk.b.A);
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
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setOrientation(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(a2);
        gradientDrawable2.setStroke(1, -3355444);
        linearLayout5.setBackgroundDrawable(gradientDrawable2);
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add("持续加载");
        arrayList11.add("播放卡顿");
        arrayList11.add("播放失败");
        arrayList11.add("视频下线");
        arrayList11.add("有声音无画面");
        arrayList11.add("有画面无声音");
        f fVar = new f(arrayList11, this, new ed(this));
        this.V = fVar;
        LinearLayout a4 = fVar.a();
        LinearLayout b3 = this.V.b();
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams14.weight = 1.0f;
        linearLayout5.addView(a4, layoutParams14);
        linearLayout5.addView(b3, layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        this.O.addView(linearLayout5, layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams16.addRule(3, this.N.getId());
        this.s.addView(this.O, layoutParams16);
        LinearLayout linearLayout6 = new LinearLayout(this);
        this.o = linearLayout6;
        linearLayout6.setVisibility(8);
        this.o.setId(R.id.SHIFT);
        this.o.setOrientation(1);
        this.o.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView5 = new TextView(this);
        textView5.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView5.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString3 = new SpannableString(this.G ? "原创作品链接*" : "原创视频链接*");
        spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#f7534f")), 6, 7, 34);
        textView5.setText(spannableString3);
        textView5.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 2.0f), 0, 0);
        textView5.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView5.setGravity(16);
        this.o.addView(textView5, new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f)));
        float a5 = com.baidu.ufosdk.f.i.a((Context) this, 3.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(-1);
        gradientDrawable3.setCornerRadius(a5);
        gradientDrawable3.setStroke(3, -3355444);
        EditText editText = new EditText(this);
        this.f23440h = editText;
        editText.setBackgroundDrawable(gradientDrawable3);
        this.f23440h.setTextColor(-13421773);
        this.f23440h.setTextSize(com.baidu.ufosdk.b.U + 1.0f);
        this.f23440h.setGravity(16);
        this.f23440h.setSingleLine();
        this.f23440h.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams17.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        this.o.addView(this.f23440h, layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams18.addRule(3, this.O.getId());
        this.s.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 30.0f));
        this.s.addView(this.o, layoutParams18);
        LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setId(R.id.RIGHT);
        linearLayout7.setOrientation(1);
        linearLayout7.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView6 = new TextView(this);
        this.r = textView6;
        textView6.setBackgroundColor(com.baidu.ufosdk.b.A);
        this.r.setTextColor(com.baidu.ufosdk.b.r);
        SpannableString spannableString4 = new SpannableString("问题截图（系统自动截取）");
        spannableString4.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 4, spannableString4.length(), 34);
        spannableString4.setSpan(new AbsoluteSizeSpan(12, true), 4, spannableString4.length(), 34);
        byte[] bArr2 = this.j;
        if (bArr2 == null || !this.x.contains(bArr2)) {
            this.r.setText("上传截图");
        } else {
            this.r.setText(spannableString4);
        }
        this.r.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        this.r.setGravity(16);
        this.r.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams19.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout7.addView(this.r, layoutParams19);
        LinearLayout linearLayout8 = new LinearLayout(this);
        this.w = linearLayout8;
        linearLayout8.setOrientation(0);
        this.w.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f));
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 350.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 77.0f));
        this.x.add(com.baidu.ufosdk.f.m.b(this));
        c();
        linearLayout7.addView(this.w, layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams21.addRule(3, this.o.getId());
        this.s.addView(linearLayout7, layoutParams21);
        LinearLayout linearLayout9 = new LinearLayout(this);
        linearLayout9.setId(R.id.DOWN);
        linearLayout9.setOrientation(1);
        linearLayout9.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView7 = new TextView(this);
        textView7.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView7.setTextColor(com.baidu.ufosdk.b.r);
        textView7.setText("更多问题及建议");
        textView7.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        textView7.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView7.setGravity(16);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams22.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 22.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout9.addView(textView7, layoutParams22);
        RelativeLayout relativeLayout4 = new RelativeLayout(this);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(-1);
        gradientDrawable4.setCornerRadius(com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
        gradientDrawable4.setStroke(3, -3355444);
        relativeLayout4.setBackgroundDrawable(gradientDrawable4);
        EditText editText2 = new EditText(this);
        this.t = editText2;
        editText2.setId(R.id.FILL);
        this.t.setBackgroundColor(-1);
        this.t.setTextColor(-13421773);
        this.t.setTextSize(com.baidu.ufosdk.b.U);
        this.t.setHint("请描述问题或建议，播放问题请勾选具体问题；抄袭请附链接和截图");
        this.t.setHintTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
        this.t.setGravity(3);
        this.t.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 62.0f));
        layoutParams23.setMargins(com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f), com.baidu.ufosdk.f.i.a((Context) this, 2.0f), com.baidu.ufosdk.f.i.a((Context) this, 3.0f));
        relativeLayout4.addView(this.t, layoutParams23);
        TextView textView8 = new TextView(this);
        this.v = textView8;
        textView8.setBackgroundColor(-1);
        this.v.setTextSize(com.baidu.ufosdk.b.V);
        this.v.setTextColor(-5131855);
        this.v.setText("4-" + com.baidu.ufosdk.b.aa + "字");
        RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams24.addRule(3, this.t.getId());
        layoutParams24.addRule(11);
        this.v.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0);
        relativeLayout4.setPadding(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 1.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f));
        relativeLayout4.addView(this.v, layoutParams24);
        LinearLayout.LayoutParams layoutParams25 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams25.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        linearLayout9.addView(relativeLayout4, layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams26.addRule(3, linearLayout7.getId());
        this.s.addView(linearLayout9, layoutParams26);
        LinearLayout linearLayout10 = new LinearLayout(this);
        linearLayout10.setId(R.id.SELECT);
        linearLayout10.setOrientation(1);
        linearLayout10.setBackgroundColor(com.baidu.ufosdk.b.A);
        TextView textView9 = new TextView(this);
        textView9.setBackgroundColor(com.baidu.ufosdk.b.A);
        textView9.setTextColor(com.baidu.ufosdk.b.r);
        textView9.setText("联系方式");
        textView9.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0, 0);
        textView9.setTextSize(com.baidu.ufosdk.b.U + 2.0f);
        textView9.setGravity(16);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 41.0f));
        layoutParams27.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 22.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        linearLayout10.addView(textView9, layoutParams27);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(-1);
        gradientDrawable5.setCornerRadius(a5);
        gradientDrawable5.setStroke(3, -3355444);
        EditText editText3 = new EditText(this);
        this.u = editText3;
        editText3.setBackgroundDrawable(gradientDrawable3);
        this.u.setTextColor(-13421773);
        this.u.setTextSize(com.baidu.ufosdk.b.U);
        this.u.setGravity(16);
        this.u.setHint("请留下您的邮箱/手机/QQ号");
        this.u.setHintTextColor(ConfirmDialog.APP_DESC_COLOR_DEFAULT);
        this.u.setSingleLine();
        this.u.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams28.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        linearLayout10.addView(this.u, layoutParams28);
        RelativeLayout.LayoutParams layoutParams29 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams29.addRule(3, linearLayout9.getId());
        this.s.setPadding(0, 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 13.0f));
        this.s.addView(linearLayout10, layoutParams29);
        this.t.addTextChangedListener(new ee(this));
        this.u.addTextChangedListener(new ef(this));
        setContentView(this.k);
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("exit!");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.C = true;
            a();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        SharedPreferences.Editor editor;
        String str;
        super.onPause();
        String obj = this.u.getText().toString();
        if (obj == null || obj.trim().length() <= 0) {
            this.f23434b.putString("cryptContactData", "");
        } else {
            this.f23434b.putString("cryptContactData", com.baidu.ufosdk.f.k.a(obj));
        }
        if (this.y.booleanValue()) {
            if (TextUtils.isEmpty(this.f23439g)) {
                editor = this.f23434b;
                str = this.z;
            } else {
                editor = this.f23434b;
                str = this.f23439g;
            }
            editor.putString(str, this.t.getText().toString());
        }
        this.f23434b.commit();
    }

    @Override // android.app.Activity
    public void onResume() {
        EditText editText;
        String str;
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
        ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
        if (resumeCallBack != null) {
            resumeCallBack.onResumeCallback();
        }
        if ("".equals(com.baidu.ufosdk.b.n)) {
            editText = this.t;
            str = "请描述问题或建议，播放问题请勾选具体问题；抄袭请附链接和截图";
        } else {
            editText = this.t;
            str = com.baidu.ufosdk.b.n;
        }
        editText.setHint(str);
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.A, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        this.m.setTextSize(com.baidu.ufosdk.b.U);
        this.y = Boolean.TRUE;
        String str2 = this.z;
        if (str2 == null || str2.length() == 0) {
            this.z = "newMessage";
        }
        String string = this.f23435c.getString("cryptContactData", "");
        if (string == null || string.trim().length() <= 0) {
            this.u.setText("");
        } else {
            this.u.setText(com.baidu.ufosdk.f.k.b(string));
        }
        (UfoSDK.clientid.length() == 0 ? new Thread(new dw(this)) : new Thread(new dx(this))).start();
    }
}
