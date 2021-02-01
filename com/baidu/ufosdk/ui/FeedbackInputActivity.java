package com.baidu.ufosdk.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobstat.Config;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class FeedbackInputActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static Bitmap f5416a = null;
    public View C;
    public EditText E;
    protected int I;
    public TextView J;
    private String aA;
    private Button aB;
    private LinearLayout an;
    private RelativeLayout ao;
    private ImageView ap;
    private Button aq;
    private ArrayList aw;
    private View ax;
    private String az;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f5417b;
    public LinearLayout c;
    public LinearLayout d;
    public com.baidu.ufosdk.a.a g;
    public ListView i;
    public cg j;
    public View k;
    public TextView m;
    public LinearLayout p;
    public SharedPreferences.Editor q;
    public SharedPreferences r;
    public View s;
    private final int N = R.id.BLOCK;
    private final int O = R.id.BOTH;
    private final int P = R.id.BOTTOM;
    private final int Q = R.id.account_item_container;
    private final int R = R.id.SHIFT;
    private final int S = R.id.FUNCTION;
    private final int T = R.id.Forward;
    private final int U = R.id.Backward;
    private final int V = R.id.CTRL;
    private final int W = R.id.DOWN;
    private final int X = R.id.SYM;
    private final int Y = R.id.Emoji_GridView;
    private final int Z = R.id.about_guide;
    private final int aa = R.id.FILL;
    private final int ab = R.style.AlertActivity_AlertStyle;
    private final int ac = 2131755009;
    private final int ad = 2131755010;
    private final int ae = R.id.LEFT;
    private final int af = R.id.account_status;
    private final int ag = 2131755011;
    private final int ah = 2131755014;
    private final int ai = R.id.SELECT;
    private final int aj = R.id.STROKE;
    private final int ak = R.id.NORMAL;
    private final int al = R.style.AppBaseTheme;
    private final int am = R.style.AppTheme;
    public String e = "";
    public String f = "";
    private String ar = "";
    public List h = new ArrayList();
    public ExecutorService l = Executors.newSingleThreadExecutor();
    public boolean n = false;
    public boolean o = false;
    private int as = -1;
    private List at = new ArrayList();
    public boolean t = false;
    protected boolean u = false;
    protected boolean v = false;
    public int w = 0;
    public int x = 0;
    public boolean y = true;
    public boolean z = false;
    private boolean au = false;
    private final int av = AdCard.INVALID_NUM;
    public String A = "";
    public boolean B = true;
    private boolean ay = false;
    public boolean D = false;
    public String F = "";
    public boolean G = true;
    public boolean H = true;
    private boolean aC = false;
    private boolean aD = false;
    public ev K = null;
    private fa aE = null;
    private int aF = 0;
    public String L = null;
    public String M = null;
    private int aG = 0;
    private String aH = null;
    private int aI = 0;
    private JSONArray aJ = null;
    private Handler aK = new ej(this);
    private BroadcastReceiver aL = new bi(this);
    private eq aM = new bx(this);

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(FeedbackInputActivity feedbackInputActivity) {
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.E.getText().toString().trim().length() <= 0) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("33"), 0).show();
        } else if (feedbackInputActivity.E.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (!com.baidu.ufosdk.b.d.c(feedbackInputActivity.getApplicationContext())) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("64"), 1).show();
        } else if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("62"), 1).show();
            new Thread(new bj(feedbackInputActivity)).start();
        } else {
            if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
            }
            if (feedbackInputActivity.e == null || feedbackInputActivity.e.length() <= 0 || !feedbackInputActivity.e.equals("newMessage") || !UfoSDK.contactDialogSwitch) {
                feedbackInputActivity.D = true;
                feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
                feedbackInputActivity.E.setEnabled(false);
                feedbackInputActivity.s.setVisibility(0);
                feedbackInputActivity.s.bringToFront();
                new Thread(new bl(feedbackInputActivity)).start();
            } else if (feedbackInputActivity.aA == null || feedbackInputActivity.aA.equals("null") || feedbackInputActivity.aA.length() == 0) {
                er erVar = new er(feedbackInputActivity, "");
                erVar.a(new bm(feedbackInputActivity, erVar));
                erVar.show();
            } else {
                feedbackInputActivity.D = true;
                feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
                feedbackInputActivity.E.setEnabled(false);
                feedbackInputActivity.s.setVisibility(0);
                feedbackInputActivity.s.bringToFront();
                new Thread(new bk(feedbackInputActivity)).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(FeedbackInputActivity feedbackInputActivity, boolean z, boolean z2) {
        JSONArray jSONArray;
        String str;
        if (feedbackInputActivity.aG == 0) {
            feedbackInputActivity.aK.obtainMessage(8, 0).sendToTarget();
        } else if (!z) {
            if (feedbackInputActivity.K == null) {
                feedbackInputActivity.K = new ev(feedbackInputActivity, com.baidu.ufosdk.R.style.dialog_bottom_full, feedbackInputActivity.aJ, feedbackInputActivity.aI, feedbackInputActivity.aH, feedbackInputActivity.aK, feedbackInputActivity.h);
            }
            feedbackInputActivity.K.f = z2;
            feedbackInputActivity.K.e = feedbackInputActivity.aF;
            feedbackInputActivity.K.d = feedbackInputActivity.f;
            feedbackInputActivity.K.show();
        } else {
            try {
                jSONArray = ((Map) feedbackInputActivity.h.get(feedbackInputActivity.aF)).containsKey("discontent_labels") ? (JSONArray) ((Map) feedbackInputActivity.h.get(feedbackInputActivity.aF)).get("discontent_labels") : null;
            } catch (Exception e) {
                e = e;
                jSONArray = null;
            }
            try {
            } catch (Exception e2) {
                e = e2;
                com.baidu.ufosdk.f.c.a("get show error!", e);
                str = null;
                if (feedbackInputActivity.aE == null) {
                }
                feedbackInputActivity.aE.a(jSONArray, str);
                feedbackInputActivity.aE.show();
            }
            if (((Map) feedbackInputActivity.h.get(feedbackInputActivity.aF)).containsKey("discontent_reason")) {
                str = (String) ((Map) feedbackInputActivity.h.get(feedbackInputActivity.aF)).get("discontent_reason");
                if (feedbackInputActivity.aE == null) {
                    feedbackInputActivity.aE = new fa(feedbackInputActivity, com.baidu.ufosdk.R.style.dialog_bottom_full);
                }
                feedbackInputActivity.aE.a(jSONArray, str);
                feedbackInputActivity.aE.show();
            }
            str = null;
            if (feedbackInputActivity.aE == null) {
            }
            feedbackInputActivity.aE.a(jSONArray, str);
            feedbackInputActivity.aE.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Bitmap bitmap;
        this.p.removeAllViews();
        if (z) {
            this.at.add(com.baidu.ufosdk.f.m.a(this));
        }
        for (int i = 0; i < this.at.size(); i++) {
            RelativeLayout relativeLayout = new RelativeLayout(this);
            if (i != this.at.size() - 1) {
                ez ezVar = new ez(this);
                ezVar.setTag(Integer.valueOf(i));
                ezVar.setBackgroundDrawable(null);
                ezVar.setPadding(0, 0, 0, 0);
                ezVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                ezVar.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                ezVar.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                ezVar.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                ezVar.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                relativeLayout.addView(ezVar, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f)));
                try {
                    if (this.at.get(i) == null) {
                        bitmap = null;
                    } else if (BitmapFactory.decodeByteArray((byte[]) this.at.get(i), 0, ((byte[]) this.at.get(i)).length) == null) {
                        return;
                    } else {
                        bitmap = BitmapFactory.decodeByteArray((byte[]) this.at.get(i), 0, ((byte[]) this.at.get(i)).length);
                    }
                    if (bitmap == null || a(bitmap, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                        return;
                    }
                    ezVar.setImageBitmap(bitmap);
                    ImageButton imageButton = new ImageButton(this);
                    imageButton.setTag(Integer.valueOf(i));
                    imageButton.setBackgroundDrawable(null);
                    imageButton.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f), 0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 9.0f));
                    imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
                    Bitmap a2 = com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_delete_little_icon.png");
                    if (a2 == null) {
                        return;
                    }
                    imageButton.setImageBitmap(a2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 24.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 24.0f));
                    layoutParams.addRule(11);
                    layoutParams.addRule(10);
                    layoutParams.setMargins(0, 0, 0, 0);
                    relativeLayout.addView(imageButton, layoutParams);
                    imageButton.setOnClickListener(new bq(this));
                } catch (OutOfMemoryError e) {
                    System.gc();
                    return;
                }
            } else {
                ImageView imageView = new ImageView(this);
                imageView.setTag(Integer.valueOf(i));
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(0, 0, 0, 0);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                imageView.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                imageView.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                imageView.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f)));
                try {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.at.get(i), 0, ((byte[]) this.at.get(i)).length);
                    if (decodeByteArray == null || a(decodeByteArray, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                        return;
                    }
                    imageView.setImageBitmap(decodeByteArray);
                    imageView.setOnClickListener(new br(this));
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    return;
                }
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
            if (i == 0) {
                layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 6.0f), 0, 0, 0);
            } else {
                layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
            }
            layoutParams2.gravity = 80;
            this.p.addView(relativeLayout, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (this.ar == null || this.ar.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", this.ar);
        }
        hashMap.put("id", str);
        hashMap.put("content", str2);
        try {
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com//?m=Index&a=getRobotQList", "sdk_encrypt=" + URLEncoder.encode(com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a2));
                com.baidu.ufosdk.f.c.c("getRobotQList response is -----------------> " + jSONObject.toString());
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    String valueOf = String.valueOf(jSONObject.get("id"));
                    if (com.baidu.ufosdk.b.ad != null) {
                        com.baidu.ufosdk.b.ad.onSubmitMessageAfterCallback(str2, valueOf);
                    }
                    com.baidu.ufosdk.f.c.a("sendChat --> msgId = " + str);
                    if (str.contains("newMessage")) {
                        this.aK.obtainMessage(14, valueOf).sendToTarget();
                    } else {
                        this.aK.obtainMessage(12, valueOf).sendToTarget();
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
            Looper.prepare();
            Toast.makeText(context, com.baidu.ufosdk.f.s.a("65"), 1).show();
            this.aK.obtainMessage(13).sendToTarget();
            Looper.loop();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, Handler handler, int i) {
        if (com.baidu.ufosdk.b.ag != null && str2.equals("newMessage")) {
            com.baidu.ufosdk.b.ag.onSubmitNewMessage();
        }
        if (com.baidu.ufosdk.b.ad != null && str2 != null) {
            com.baidu.ufosdk.b.ad.onSubmitMessageBeforeCallback(str4, str2.contains("newMessage") ? "newMessage" : str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", str);
        if (str3 == null || str3.length() <= 0) {
            hashMap.put("appid", UfoSDK.appid);
        } else {
            hashMap.put("appid", str3);
        }
        hashMap.put("devid", UfoSDK.devid);
        if (i != -999) {
            hashMap.put("robotQuestionId", Integer.valueOf(i));
        }
        com.baidu.ufosdk.f.c.a("sendChat---2018 tempRobotSwitch = " + this.y);
        if (UfoSDK.robotAnswer && this.y) {
            hashMap.put("answerPerson", "robot");
        }
        if (str2 != null && !str2.contains("newMessage")) {
            hashMap.put("id", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("content", str4);
        }
        int i2 = com.baidu.ufosdk.f.i.a(str5) ? 1 : com.baidu.ufosdk.f.i.b(str5) ? 2 : com.baidu.ufosdk.f.i.c(str5) ? 3 : 0;
        com.baidu.ufosdk.f.c.c("contactWay is " + str5 + "; type = " + i2);
        if (i2 == 0) {
            hashMap.put("contact_way", str5);
        } else if (i2 == 1) {
            com.baidu.ufosdk.f.c.c("contactWay is email");
            hashMap.put(NotificationCompat.CATEGORY_EMAIL, str5);
        } else if (i2 == 2) {
            com.baidu.ufosdk.f.c.c("contactWay is tel");
            hashMap.put("tel", str5);
        } else {
            com.baidu.ufosdk.f.c.c("contactWay is qq");
            hashMap.put("qq", str5);
        }
        hashMap.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.f5358b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put(Config.LAUNCH_REFERER, com.baidu.ufosdk.b.p);
        hashMap.put("baiducuid", com.baidu.ufosdk.b.c);
        if (!TextUtils.isEmpty(this.F)) {
            hashMap.put("faq_id", this.F);
        }
        hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
        if (com.baidu.ufosdk.f.p.a("android.permission.ACCESS_NETWORK_STATE")) {
            hashMap.put("nettype", com.baidu.ufosdk.b.d.a(context));
        } else {
            hashMap.put("nettype", "N/A");
        }
        hashMap.put("screenSize", com.baidu.ufosdk.b.f.a(context));
        if (com.baidu.ufosdk.b.f5357a) {
            hashMap.put("logcat", com.baidu.ufosdk.b.b.a());
        }
        if (!TextUtils.isEmpty(com.baidu.ufosdk.b.h)) {
            hashMap.put("ip_location", com.baidu.ufosdk.b.h);
        }
        String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
        try {
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", TextUtils.isEmpty(str6) ? "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8") : "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8") + "&screenshot=" + URLEncoder.encode(str6, "UTF-8"));
            if (TextUtils.isEmpty(a3)) {
                com.baidu.ufosdk.f.c.c("sendChat -> response is empty!");
                Looper.prepare();
                Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
                handler.obtainMessage(13).sendToTarget();
                Looper.loop();
            } else {
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                com.baidu.ufosdk.f.c.c("sendChat response is -----------------> " + jSONObject.toString());
                com.baidu.ufosdk.f.c.a("sendChat---2111 tempRobotSwitch = " + this.y);
                if (UfoSDK.robotAnswer && this.y) {
                    if (jSONObject.has("round")) {
                        this.w = ((Integer) jSONObject.get("round")).intValue();
                    } else {
                        this.y = false;
                    }
                }
                int intValue = ((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue();
                if (intValue == 0) {
                    UfoSDK.neverFeedback = false;
                    UfoSDK.lastSendTime = System.currentTimeMillis();
                    SharedPreferences.Editor edit = context.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.putLong("Ufolastsendtime", UfoSDK.lastSendTime);
                    edit.commit();
                    String valueOf = String.valueOf(jSONObject.get("id"));
                    if (com.baidu.ufosdk.b.ad != null) {
                        com.baidu.ufosdk.b.ad.onSubmitMessageAfterCallback(str4, valueOf);
                    }
                    com.baidu.ufosdk.f.c.a("sendChat --> msgId = " + str2);
                    if (str2 == null || !str2.contains("newMessage")) {
                        if (str3 == null || str3.length() <= 0) {
                            handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(UfoSDK.appid)).sendToTarget();
                        } else {
                            handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(str3)).sendToTarget();
                        }
                    } else if (str3 == null || str3.length() <= 0) {
                        handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(UfoSDK.appid)).sendToTarget();
                    } else {
                        handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(str3)).sendToTarget();
                    }
                    return true;
                } else if (intValue == 4) {
                    String str7 = (String) jSONObject.get(BaseJsonData.TAG_ERRMSG);
                    Looper.prepare();
                    if (str7 != null && str7.length() > 0) {
                        Toast.makeText(context, str7, 1).show();
                    }
                    handler.obtainMessage(13, str7).sendToTarget();
                    Looper.loop();
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
            Looper.prepare();
            Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
            handler.obtainMessage(13).sendToTarget();
            Looper.loop();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.s.getVisibility() != 0) {
            new cy(this).execute(new Void[0]);
            return;
        }
        this.s.setVisibility(8);
        this.D = false;
        this.J.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
        this.E.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(FeedbackInputActivity feedbackInputActivity) {
        com.baidu.ufosdk.f.c.a("getEvaluateConfig url: https://ufosdk.baidu.com/?m=Index&a=getEvaluationConf");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("uid", com.baidu.ufosdk.b.d);
        hashMap.put("username", com.baidu.ufosdk.b.f5358b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put("baiducuid", com.baidu.ufosdk.b.c);
        try {
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationConf", "sdk_encrypt=" + URLEncoder.encode(com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a2));
            com.baidu.ufosdk.f.c.c("getEvaluateConfig response is -----------------> " + jSONObject.toString());
            if (jSONObject.optInt(BaseJsonData.TAG_ERRNO, 1) == 1) {
                com.baidu.ufosdk.f.c.d("getEvaluateConfig error!");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("conf");
            if (optJSONObject == null) {
                com.baidu.ufosdk.f.c.d("The config is null!");
                return;
            }
            feedbackInputActivity.L = optJSONObject.optString("good_toast");
            feedbackInputActivity.M = optJSONObject.optString("bad_toast");
            feedbackInputActivity.aG = optJSONObject.optInt("discontent_switch");
            if (feedbackInputActivity.aG == 0) {
                com.baidu.ufosdk.f.c.b("The evaluation dialog is set closed!");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("discontent");
            if (optJSONObject2 == null) {
                com.baidu.ufosdk.f.c.c("The disContent is null");
                return;
            }
            feedbackInputActivity.aH = optJSONObject2.optString("discontent_reason_tips");
            JSONArray optJSONArray = optJSONObject2.optJSONArray("required_discontent_fields");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (optJSONArray.length() == 2) {
                    feedbackInputActivity.aI = 3;
                } else if (optJSONArray.length() == 1) {
                    if (optJSONArray.toString().contains("discontent_reason")) {
                        feedbackInputActivity.aI = 1;
                    } else if (optJSONArray.toString().contains("discontent_labels")) {
                        feedbackInputActivity.aI = 2;
                    }
                }
            }
            feedbackInputActivity.aJ = optJSONObject2.optJSONArray("discontent_labels");
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("getEvaluateConfig error!", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(FeedbackInputActivity feedbackInputActivity) {
        feedbackInputActivity.B = true;
        feedbackInputActivity.A = feedbackInputActivity.E.getText().toString();
        if (feedbackInputActivity.at.size() < 2) {
            if (!feedbackInputActivity.a(feedbackInputActivity.getApplicationContext(), UfoSDK.clientid, feedbackInputActivity.e, feedbackInputActivity.ar, com.baidu.ufosdk.b.l + feedbackInputActivity.E.getText().toString() + com.baidu.ufosdk.b.m, feedbackInputActivity.aA, (String) null, feedbackInputActivity.aK, AdCard.INVALID_NUM)) {
                com.baidu.ufosdk.f.c.c("SendFeedback --> 反馈发送失败！");
                return;
            }
            com.baidu.ufosdk.f.c.c("SendFeedback --> 反馈发送成功！--" + feedbackInputActivity.E.getText().toString());
            feedbackInputActivity.aK.obtainMessage(1, feedbackInputActivity.E.getText().toString()).sendToTarget();
            com.baidu.ufosdk.f.c.c("346 --> tempRobotSwitch = " + feedbackInputActivity.y);
            if ((UfoSDK.robotAnswer && feedbackInputActivity.y) || feedbackInputActivity.e.contains("newMessage") || feedbackInputActivity.u || !feedbackInputActivity.aC) {
                return;
            }
            feedbackInputActivity.aK.obtainMessage(8).sendToTarget();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < feedbackInputActivity.at.size() - 1; i++) {
            try {
                jSONArray.put(Base64.encodeToString((byte[]) feedbackInputActivity.at.get(i), 0));
            } catch (Exception e) {
                com.baidu.ufosdk.f.c.a("Base64 error!", e);
                return;
            }
        }
        if (jSONArray.toString().length() >= 2097152) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
        } else if (!feedbackInputActivity.a(feedbackInputActivity.getApplicationContext(), UfoSDK.clientid, feedbackInputActivity.e, feedbackInputActivity.ar, com.baidu.ufosdk.b.l + feedbackInputActivity.E.getText().toString() + com.baidu.ufosdk.b.m, feedbackInputActivity.aA, jSONArray.toString(), feedbackInputActivity.aK, AdCard.INVALID_NUM)) {
            com.baidu.ufosdk.f.c.d("发送失败");
        } else {
            feedbackInputActivity.aK.obtainMessage(1, feedbackInputActivity.E.getText().toString()).sendToTarget();
            for (int i2 = 0; i2 < feedbackInputActivity.at.size() - 1; i2++) {
                feedbackInputActivity.aK.obtainMessage(3, feedbackInputActivity.at.get(i2)).sendToTarget();
            }
            if ((UfoSDK.robotAnswer && feedbackInputActivity.y) || feedbackInputActivity.e.contains("newMessage") || feedbackInputActivity.u || !feedbackInputActivity.aC) {
                return;
            }
            feedbackInputActivity.aK.obtainMessage(8).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(FeedbackInputActivity feedbackInputActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        if (feedbackInputActivity.as == feedbackInputActivity.at.size() - 1) {
            if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
            }
            try {
                feedbackInputActivity.startActivityForResult(intent, feedbackInputActivity.as);
                try {
                    feedbackInputActivity.overridePendingTransition(com.baidu.ufosdk.f.i.a(feedbackInputActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                } catch (Exception e) {
                }
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
            }
        }
    }

    public final void a() {
        this.at.clear();
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(View view) {
        Button button = new Button(this);
        button.setBackgroundDrawable(null);
        button.setText(com.baidu.ufosdk.f.s.a("1"));
        button.setTextSize(12.0f);
        button.setTextColor(-1);
        button.setGravity(17);
        PopupWindow popupWindow = new PopupWindow((View) button, com.baidu.ufosdk.f.i.a(getApplicationContext(), 60.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 35.0f), true);
        popupWindow.setTouchable(true);
        popupWindow.getContentView().setOnClickListener(new bv(this, view, popupWindow));
        popupWindow.setTouchInterceptor(new bw(this));
        try {
            popupWindow.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(this, "ufo_loading_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        popupWindow.showAsDropDown(view);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            this.t = true;
            b();
            return false;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InputMethodManager inputMethodManager;
        View view;
        boolean z;
        boolean z2 = true;
        if (motionEvent.getAction() != 0) {
            if (getWindow().superDispatchTouchEvent(motionEvent)) {
                return true;
            }
            return onTouchEvent(motionEvent);
        }
        LinearLayout linearLayout = this.c;
        if (linearLayout != null && (linearLayout instanceof LinearLayout)) {
            int[] iArr = {0, 0};
            linearLayout.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int height = linearLayout.getHeight() + i2;
            int width = linearLayout.getWidth() + i;
            if (motionEvent.getX() <= i || motionEvent.getX() >= width || motionEvent.getY() <= i2 || motionEvent.getY() >= height) {
                if (this.aw != null) {
                    Iterator it = this.aw.iterator();
                    while (it.hasNext()) {
                        int[] iArr2 = new int[2];
                        ((View) it.next()).getLocationOnScreen(iArr2);
                        int i3 = iArr2[0];
                        int i4 = iArr2[1];
                        if (motionEvent.getX() < i3 || motionEvent.getX() > i3 + view.getWidth() || motionEvent.getY() < i4 || motionEvent.getY() > view.getHeight() + i4) {
                            z = false;
                            continue;
                        } else {
                            z = true;
                            continue;
                        }
                        if (z) {
                        }
                    }
                }
                if (z2 && (inputMethodManager = (InputMethodManager) getSystemService("input_method")) != null) {
                    inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        z2 = false;
        if (z2) {
            inputMethodManager.hideSoftInputFromWindow(linearLayout.getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0090 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:54:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0104  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0063 -> B:52:0x001c). Please submit an issue!!! */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri uri;
        byte[] bArr;
        byte[] bArr2;
        InputStream openInputStream;
        super.onActivityResult(i, i2, intent);
        if (!this.ay) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.c(dVar.c() + 1);
            this.ay = true;
        }
        if (i2 == -1 && intent != null) {
            try {
                uri = intent.getData();
            } catch (Exception e) {
                uri = null;
            }
            if (uri != null) {
                try {
                    openInputStream = getContentResolver().openInputStream(uri);
                } catch (Exception e2) {
                    e = e2;
                    bArr = null;
                    System.out.println(e.getMessage());
                    bArr2 = bArr;
                    if (i == this.at.size() - 1) {
                    }
                    a(true);
                    this.E.setFocusable(true);
                    EditText editText = this.E;
                    editText.setFocusableInTouchMode(true);
                    bArr = editText;
                }
                if (openInputStream.available() >= 8388608) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    return;
                }
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                openInputStream.close();
                try {
                } catch (Exception e3) {
                    e = e3;
                    System.out.println(e.getMessage());
                    bArr2 = bArr;
                    if (i == this.at.size() - 1) {
                    }
                    a(true);
                    this.E.setFocusable(true);
                    EditText editText2 = this.E;
                    editText2.setFocusableInTouchMode(true);
                    bArr = editText2;
                }
                if (bArr == 0) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                    bArr = bArr;
                } else {
                    byte[] a2 = com.baidu.ufosdk.f.q.a(bArr);
                    if (a2 == null) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1).show();
                        bArr = a2;
                    } else if (a2.length > 307200) {
                        Toast makeText = Toast.makeText(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 1);
                        makeText.show();
                        bArr = makeText;
                    } else if (a2.length == 0) {
                        Toast makeText2 = Toast.makeText(this, com.baidu.ufosdk.f.s.a("54"), 1);
                        makeText2.show();
                        bArr = makeText2;
                    } else {
                        bArr2 = a2;
                        if (com.baidu.ufosdk.f.i.a(this) < 35000) {
                            Toast makeText3 = Toast.makeText(this, com.baidu.ufosdk.f.s.a(BaseUtils.METHOD_SENDMESSAGE), 1);
                            makeText3.show();
                            System.gc();
                            bArr = makeText3;
                        }
                        if (i == this.at.size() - 1) {
                            this.at.set(i, bArr2);
                        } else {
                            Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                            com.baidu.ufosdk.f.c.b("picBytesList--->clear");
                            this.at.clear();
                        }
                        a(true);
                        this.E.setFocusable(true);
                        EditText editText22 = this.E;
                        editText22.setFocusableInTouchMode(true);
                        bArr = editText22;
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        com.baidu.ufosdk.f.c.c("*** onCreate!");
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(16);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        this.r = getSharedPreferences("UfoSharePreference", 0);
        this.q = this.r.edit();
        this.F = getIntent().getStringExtra("faq_id");
        this.e = getIntent().getStringExtra("msgid");
        this.ar = getIntent().getStringExtra("appid");
        this.aD = getIntent().getBooleanExtra("openList", false);
        this.H = getIntent().getBooleanExtra("fromList", false);
        this.o = getIntent().getBooleanExtra("fromEdit", false);
        this.az = getIntent().getStringExtra("no_result");
        if (TextUtils.isEmpty(this.e)) {
            this.e = "newMessage";
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = "";
        }
        this.aA = this.r.getString("cryptContactData", "");
        this.q.putBoolean("ADD_PIC_FLAG", true);
        this.q.commit();
        if (this.aA == null || this.aA.trim().length() <= 0) {
            this.aA = "";
        } else {
            this.aA = com.baidu.ufosdk.f.k.b(this.aA);
        }
        this.aC = getIntent().getBooleanExtra("from_facepage", false);
        com.baidu.ufosdk.b.j = getIntent().getIntExtra("feedback_channel", 0);
        this.ao = new RelativeLayout(this);
        this.ao.setFitsSystemWindows(true);
        this.ao.setId(R.id.Backward);
        this.ao.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(R.id.CTRL);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        new RelativeLayout(this).setId(R.id.Emoji_GridView);
        this.aq = new Button(this);
        this.aq.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.ao.addView(this.aq, layoutParams);
        this.aq.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.ap = new ImageView(this);
        this.ap.setId(R.id.BLOCK);
        this.ap.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ap.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout.addView(this.ap, layoutParams2);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout.addView(textView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(9);
        layoutParams4.addRule(15);
        relativeLayout.addView(linearLayout, layoutParams4);
        TextView textView2 = new TextView(this);
        textView2.setId(R.id.BOTH);
        if (this.o) {
            textView2.setText(com.baidu.ufosdk.f.s.a("49"));
        } else {
            textView2.setText(com.baidu.ufosdk.f.s.a("42"));
        }
        textView2.setTextColor(com.baidu.ufosdk.b.r);
        textView2.setTextSize(com.baidu.ufosdk.b.N);
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams5.addRule(13);
        relativeLayout.addView(textView2, layoutParams5);
        this.aB = new Button(this);
        this.aB.setVisibility(8);
        this.aB.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_GROUP));
        this.aB.setId(2131755010);
        this.aB.setTextColor(com.baidu.ufosdk.b.s);
        this.aB.setTextSize(com.baidu.ufosdk.b.U);
        this.aB.setGravity(17);
        this.aB.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.t, com.baidu.ufosdk.b.s, com.baidu.ufosdk.b.s));
        this.aB.setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        this.aB.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0);
        relativeLayout.addView(this.aB, layoutParams6);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams7.addRule(10);
        this.ao.addView(relativeLayout, layoutParams7);
        View view = new View(this);
        view.setId(2131755011);
        view.setBackgroundColor(-2894893);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams8.addRule(3, relativeLayout.getId());
        this.ao.addView(view, layoutParams8);
        this.s = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(13);
        this.ao.addView(this.s, layoutParams9);
        this.s.setVisibility(8);
        this.an = new LinearLayout(this);
        this.an.setId(R.id.SHIFT);
        this.an.setOrientation(0);
        this.c = new LinearLayout(this);
        this.c.setId(R.id.BOTTOM);
        this.c.setOrientation(1);
        this.c.setBackgroundColor(com.baidu.ufosdk.b.z);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setId(R.id.FUNCTION);
        relativeLayout2.setFocusable(true);
        relativeLayout2.setFocusableInTouchMode(true);
        this.J = new TextView(this);
        this.J.setText(com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_DEFAULT));
        this.J.setTextColor(com.baidu.ufosdk.b.v);
        this.J.setTextSize(13.0f);
        this.J.setGravity(17);
        this.J.setId(R.id.account_item_container);
        this.J.setBackgroundColor(com.baidu.ufosdk.b.z);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(11);
        layoutParams10.addRule(15);
        layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), 0);
        relativeLayout2.addView(this.J, layoutParams10);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        linearLayout2.setClickable(true);
        linearLayout2.setId(R.id.account_status);
        ImageView imageView = new ImageView(this);
        imageView.setId(R.id.LEFT);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_pluspic_icon.png")));
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams11.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        linearLayout2.addView(imageView, layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 33.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 33.0f));
        layoutParams12.addRule(15);
        layoutParams12.addRule(9);
        relativeLayout2.addView(linearLayout2, layoutParams12);
        this.E = new EditText(this);
        this.E.setImeOptions(4);
        this.E.setInputType(262144);
        this.E.setSingleLine(false);
        this.E.setId(R.id.Forward);
        this.E.setVisibility(0);
        this.E.setTextSize(15.0f);
        this.E.setGravity(16);
        this.E.setHint(com.baidu.ufosdk.f.s.a("6"));
        this.E.setTextColor(-13421773);
        try {
            this.E.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(getApplicationContext(), "ufo_input_edt_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.E.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams13.addRule(1, linearLayout2.getId());
        layoutParams13.addRule(0, this.J.getId());
        layoutParams13.addRule(15);
        relativeLayout2.addView(this.E, layoutParams13);
        this.E.setOnEditorActionListener(new be(this));
        this.E.addTextChangedListener(new bt(this));
        this.J.setOnClickListener(new bz(this));
        linearLayout2.setOnClickListener(new ca(this));
        this.aB.setOnClickListener(new cb(this));
        this.an.addView(relativeLayout2, new LinearLayout.LayoutParams(-1, -1));
        this.an.setGravity(16);
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        this.an.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        this.c.setGravity(3);
        this.c.addView(this.an, layoutParams14);
        this.C = new View(this);
        this.C.setId(R.id.SELECT);
        this.C.setBackgroundColor(com.baidu.ufosdk.b.G);
        LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
        this.c.addView(this.C, layoutParams15);
        this.C.setVisibility(8);
        this.p = new LinearLayout(this);
        this.p.setOrientation(0);
        this.p.setPadding(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f));
        this.p.setId(R.id.NORMAL);
        this.p.setVisibility(8);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
        if (byteArrayExtra == null || byteArrayExtra.length <= 0) {
            this.p.setVisibility(8);
        } else {
            this.at.add(byteArrayExtra);
            this.p.setVisibility(0);
        }
        a(true);
        this.c.addView(this.p, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 229.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 64.0f)));
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams16.addRule(12);
        this.c.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
        this.c.bringToFront();
        this.ao.addView(this.c, layoutParams16);
        this.ax = new View(this);
        this.ax.setId(R.id.STROKE);
        this.ax.setBackgroundColor(com.baidu.ufosdk.b.G);
        RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
        layoutParams17.addRule(2, this.c.getId());
        this.ao.addView(this.ax, layoutParams17);
        this.i = new ListView(this);
        this.i.setBackgroundColor(com.baidu.ufosdk.b.z);
        this.i.setDivider(new ColorDrawable(com.baidu.ufosdk.b.I));
        this.i.setDividerHeight(0);
        this.j = new cg(this, this);
        this.i.setAdapter((ListAdapter) this.j);
        this.i.setFocusable(false);
        this.i.setCacheColorHint(com.baidu.ufosdk.b.I);
        this.i.setClickable(false);
        this.i.setTranscriptMode(2);
        this.i.setRecyclerListener(new cc(this));
        this.d = new LinearLayout(this);
        this.d.setId(R.id.about_guide);
        this.d.setBackgroundColor(com.baidu.ufosdk.b.D);
        this.d.clearAnimation();
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams19.addRule(3, view.getId());
        layoutParams19.addRule(2, this.ax.getId());
        layoutParams19.setMargins(0, 0, 0, 0);
        this.d.addView(this.i, layoutParams18);
        this.ao.addView(this.d, layoutParams19);
        this.f5417b = new LinearLayout(this);
        this.f5417b.setOrientation(1);
        ImageView imageView2 = new ImageView(this);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
        try {
            imageView2.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f5417b.addView(imageView2, layoutParams20);
        this.m = new TextView(this);
        this.m.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
        this.m.setTextSize(com.baidu.ufosdk.b.O);
        this.m.setTextColor(com.baidu.ufosdk.b.x);
        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-2, -2);
        com.baidu.ufosdk.f.i.a(getApplicationContext(), this.m);
        this.f5417b.addView(this.m, layoutParams21);
        this.aq = new Button(this);
        this.aq.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        this.aq.setTextSize(com.baidu.ufosdk.b.P);
        this.aq.setTextColor(com.baidu.ufosdk.b.w);
        try {
            this.aq.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams22.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
        this.f5417b.addView(this.aq, layoutParams22);
        RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams23.addRule(13);
        this.ao.addView(this.f5417b, layoutParams23);
        this.f5417b.setGravity(17);
        this.f5417b.setVisibility(8);
        setContentView(this.ao, new ViewGroup.LayoutParams(-1, -1));
        this.k = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams24.addRule(13);
        this.ao.addView(this.k, layoutParams24);
        if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
            Intent intent = new Intent(this, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            startActivity(intent);
            finish();
            return;
        }
        com.baidu.ufosdk.f.c.a("1606 --> msgId = " + this.e);
        if (this.e == null || this.e.length() <= 0 || this.e.equals("newMessage")) {
            if (UfoSDK.showFeedbackBtn) {
                this.aB.setVisibility(0);
            } else {
                this.aB.setVisibility(8);
            }
            this.y = true;
            this.H = false;
            this.v = false;
            this.k.setVisibility(8);
            this.s.setVisibility(8);
            this.aK.obtainMessage(5, "newMessage").sendToTarget();
        } else {
            this.aB.setVisibility(8);
            this.y = false;
            this.H = true;
            this.v = true;
            this.l.execute(new cd(this));
        }
        linearLayout.setOnClickListener(new ce(this));
        this.c.setOnClickListener(new cf(this));
        this.aq.setOnClickListener(new bf(this));
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e4) {
            com.baidu.ufosdk.f.c.d("执行动画错误！exit!");
        }
        new Thread(new bh(this)).start();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.baidu.ufosdk.f.a.f5377a = null;
    }

    @Override // android.app.Activity
    public void onPause() {
        com.baidu.ufosdk.f.c.a("***onPause!");
        super.onPause();
        if (this.G) {
            if (TextUtils.isEmpty(this.F)) {
                this.q.putString(this.e, this.E.getText().toString());
            } else {
                this.q.putString(this.F, this.E.getText().toString());
            }
        }
        this.q.commit();
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        com.baidu.ufosdk.f.c.c("***onResume!");
        super.onResume();
        if (TextUtils.isEmpty(UfoSDK.clientid)) {
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            UfoSDK.clientid = sharedPreferences.getString("UfoClientId", "");
            UfoSDK.appid = sharedPreferences.getString("UfoAppId", "");
            UfoSDK.devid = sharedPreferences.getString("UfoDevId", "");
            UfoSDK.productid = sharedPreferences.getString("UfoProductId", "");
        }
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        this.aq.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.k, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        if (this.e != null && this.e.length() > 0) {
            if (this.g == null) {
                this.g = new com.baidu.ufosdk.a.a(getApplicationContext(), this.e, (this.ar == null || this.ar.length() <= 0) ? UfoSDK.appid : this.ar);
            }
            this.g.b();
            if (!this.g.isAlive()) {
                this.g.start();
            }
        }
        com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
        dVar.a(dVar.a() + 1);
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.s, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_NEW_SO));
        this.G = true;
        if (this.e == null) {
            this.e = "newMessage";
        } else if (this.e.length() == 0) {
            this.e = "newMessage";
        }
        String str = "";
        if (this.az != null) {
            this.E.setText(this.az);
        } else if (TextUtils.isEmpty(this.F)) {
            str = this.r.getString(this.e, "");
            this.E.setText(str);
        } else {
            str = this.r.getString(this.F, "");
            this.E.setText(str);
        }
        this.E.setSelection(str.length());
        if (this.E.getText().toString().trim().length() <= 0) {
            this.J.setTextColor(com.baidu.ufosdk.b.y);
        } else {
            this.J.setTextColor(com.baidu.ufosdk.f.i.a(com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.y, com.baidu.ufosdk.b.v, com.baidu.ufosdk.b.v));
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new bs(this)).start();
        } else {
            new Thread(new bu(this)).start();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        com.baidu.ufosdk.f.c.a("***onStart!");
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ufosdk.getchat");
        intentFilter.addAction("com.baidu.ufosdk.getmsgid");
        intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
        intentFilter.addAction("com.baidu.ufosdk.reload");
        registerReceiver(this.aL, intentFilter);
    }

    @Override // android.app.Activity
    public void onStop() {
        View currentFocus;
        com.baidu.ufosdk.f.c.a("***onStop!");
        super.onStop();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
        }
        unregisterReceiver(this.aL);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
