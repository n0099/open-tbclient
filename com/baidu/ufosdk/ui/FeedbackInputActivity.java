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
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ResumeCallBack;
import com.baidu.ufosdk.SubmitMessageCallBack;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup;
import com.baidu.webkit.sdk.WebKitFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
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
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Bitmap f59291a;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public View C;
    public boolean D;
    public EditText E;
    public String F;
    public boolean G;
    public boolean H;
    public int I;
    public TextView J;
    public ev K;
    public String L;
    public String M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public final int W;
    public final int X;
    public final int Y;
    public final int Z;
    public String aA;
    public Button aB;
    public boolean aC;
    public boolean aD;
    public fa aE;
    public int aF;
    public int aG;
    public String aH;
    public int aI;
    public JSONArray aJ;
    public Handler aK;
    public BroadcastReceiver aL;
    public eq aM;
    public final int aa;
    public final int ab;
    public final int ac;
    public final int ad;
    public final int ae;
    public final int af;
    public final int ag;
    public final int ah;
    public final int ai;
    public final int aj;
    public final int ak;
    public final int al;
    public final int am;
    public LinearLayout an;
    public RelativeLayout ao;
    public ImageView ap;
    public Button aq;
    public String ar;
    public int as;
    public List at;
    public boolean au;
    public final int av;
    public ArrayList aw;
    public View ax;
    public boolean ay;
    public String az;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f59292b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f59293c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f59294d;

    /* renamed from: e  reason: collision with root package name */
    public String f59295e;

    /* renamed from: f  reason: collision with root package name */
    public String f59296f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.ufosdk.a.a f59297g;

    /* renamed from: h  reason: collision with root package name */
    public List f59298h;

    /* renamed from: i  reason: collision with root package name */
    public ListView f59299i;

    /* renamed from: j  reason: collision with root package name */
    public cg f59300j;
    public View k;
    public ExecutorService l;
    public TextView m;
    public boolean n;
    public boolean o;
    public LinearLayout p;
    public SharedPreferences.Editor q;
    public SharedPreferences r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1158355325, "Lcom/baidu/ufosdk/ui/FeedbackInputActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1158355325, "Lcom/baidu/ufosdk/ui/FeedbackInputActivity;");
        }
    }

    public FeedbackInputActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.N = R.id.App_Launch_Circle_Animation_View;
        this.O = R.id.App_Launch_Shimmer_Animation_View;
        this.P = R.id.BLOCK;
        this.Q = R.id.abstract_voice;
        this.R = R.id.MULTI;
        this.S = R.id.CTRL;
        this.T = R.id.DOWN;
        this.U = R.id.BOTH;
        this.V = R.id.BOTTOM;
        this.W = R.id.BOTTOM_END;
        this.X = R.id.NORMAL;
        this.Y = R.id.BOTTOM_START;
        this.Z = R.id.SYM;
        this.aa = R.id.Backward;
        this.ab = R.style.AdNoTitleDialog;
        this.ac = R.style.AiappsGameGuideDialogStyle;
        this.ad = R.style.AlertActivity_AlertStyle;
        this.ae = R.id.FILL;
        this.af = R.id.accept_invite_button;
        this.ag = 2131755011;
        this.ah = 2131755014;
        this.ai = R.id.META;
        this.aj = R.id.NONE;
        this.ak = R.id.Forward;
        this.al = 2131755015;
        this.am = 2131755016;
        this.f59295e = "";
        this.f59296f = "";
        this.ar = "";
        this.f59298h = new ArrayList();
        this.l = Executors.newSingleThreadExecutor();
        this.n = false;
        this.o = false;
        this.as = -1;
        this.at = new ArrayList();
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.x = 0;
        this.y = true;
        this.z = false;
        this.au = false;
        this.av = BannerFocusImageViewGroup.f60295f;
        this.A = "";
        this.B = true;
        this.ay = false;
        this.D = false;
        this.F = "";
        this.G = true;
        this.H = true;
        this.aC = false;
        this.aD = false;
        this.K = null;
        this.aE = null;
        this.aF = 0;
        this.L = null;
        this.M = null;
        this.aG = 0;
        this.aH = null;
        this.aI = 0;
        this.aJ = null;
        this.aK = new ej(this);
        this.aL = new bi(this);
        this.aM = new bx(this);
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bitmap, i2)) == null) {
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
        return (Bitmap) invokeLI.objValue;
    }

    public static /* synthetic */ Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static /* synthetic */ void a(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                View view = adapter.getView(i3, null, listView);
                view.measure(0, 0);
                i2 += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = i2 + (listView.getDividerHeight() * (adapter.getCount() - 1));
            listView.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ void a(FeedbackInputActivity feedbackInputActivity) {
        if (feedbackInputActivity.D) {
            return;
        }
        if (feedbackInputActivity.E.getText().toString().trim().length() <= 0) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL), 0).show();
        } else if (feedbackInputActivity.E.getText().toString().trim().length() > com.baidu.ufosdk.b.aa) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_WAP), 0).show();
        } else if (!com.baidu.ufosdk.b.d.c(feedbackInputActivity.getApplicationContext())) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a(WebKitFactory.OS_64), 1).show();
        } else if (UfoSDK.clientid.length() == 0) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("62"), 1).show();
            new Thread(new bj(feedbackInputActivity)).start();
        } else {
            if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
            }
            String str = feedbackInputActivity.f59295e;
            if (str == null || str.length() <= 0 || !feedbackInputActivity.f59295e.equals("newMessage") || !UfoSDK.contactDialogSwitch) {
                feedbackInputActivity.D = true;
                feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
                feedbackInputActivity.E.setEnabled(false);
                feedbackInputActivity.s.setVisibility(0);
                feedbackInputActivity.s.bringToFront();
                new Thread(new bl(feedbackInputActivity)).start();
                return;
            }
            String str2 = feedbackInputActivity.aA;
            if (str2 == null || str2.equals(StringUtil.NULL_STRING) || feedbackInputActivity.aA.length() == 0) {
                er erVar = new er(feedbackInputActivity, "");
                erVar.a(new bm(feedbackInputActivity, erVar));
                erVar.show();
                return;
            }
            feedbackInputActivity.D = true;
            feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
            feedbackInputActivity.E.setEnabled(false);
            feedbackInputActivity.s.setVisibility(0);
            feedbackInputActivity.s.bringToFront();
            new Thread(new bk(feedbackInputActivity)).start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(FeedbackInputActivity feedbackInputActivity, boolean z, boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (feedbackInputActivity.aG == 0) {
            feedbackInputActivity.aK.obtainMessage(8, 0).sendToTarget();
        } else if (!z) {
            if (feedbackInputActivity.K == null) {
                feedbackInputActivity.K = new ev(feedbackInputActivity, com.baidu.ufosdk.R.style.dialog_bottom_full, feedbackInputActivity.aJ, feedbackInputActivity.aI, feedbackInputActivity.aH, feedbackInputActivity.aK, feedbackInputActivity.f59298h);
            }
            ev evVar = feedbackInputActivity.K;
            evVar.f59533f = z2;
            evVar.f59532e = feedbackInputActivity.aF;
            evVar.f59531d = feedbackInputActivity.f59296f;
            evVar.show();
        } else {
            String str = null;
            try {
                jSONArray2 = ((Map) feedbackInputActivity.f59298h.get(feedbackInputActivity.aF)).containsKey("discontent_labels") ? (JSONArray) ((Map) feedbackInputActivity.f59298h.get(feedbackInputActivity.aF)).get("discontent_labels") : null;
                try {
                    if (((Map) feedbackInputActivity.f59298h.get(feedbackInputActivity.aF)).containsKey("discontent_reason")) {
                        str = (String) ((Map) feedbackInputActivity.f59298h.get(feedbackInputActivity.aF)).get("discontent_reason");
                    }
                } catch (Exception e2) {
                    jSONArray = jSONArray2;
                    e = e2;
                    com.baidu.ufosdk.f.c.a("get show error!", e);
                    jSONArray2 = jSONArray;
                    if (feedbackInputActivity.aE == null) {
                    }
                    feedbackInputActivity.aE.a(jSONArray2, str);
                    feedbackInputActivity.aE.show();
                }
            } catch (Exception e3) {
                e = e3;
                jSONArray = null;
            }
            if (feedbackInputActivity.aE == null) {
                feedbackInputActivity.aE = new fa(feedbackInputActivity, com.baidu.ufosdk.R.style.dialog_bottom_full);
            }
            feedbackInputActivity.aE.a(jSONArray2, str);
            feedbackInputActivity.aE.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.p.removeAllViews();
            if (z) {
                this.at.add(com.baidu.ufosdk.f.m.a(this));
            }
            int i2 = 0;
            while (i2 < this.at.size()) {
                RelativeLayout relativeLayout = new RelativeLayout(this);
                if (i2 != this.at.size() - 1) {
                    ez ezVar = new ez(this);
                    ezVar.setTag(Integer.valueOf(i2));
                    ezVar.setBackgroundDrawable(null);
                    ezVar.setPadding(0, 0, 0, 0);
                    ezVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ezVar.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    ezVar.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    ezVar.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    ezVar.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    relativeLayout.addView(ezVar, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f)));
                    try {
                        if (this.at.get(i2) == null) {
                            bitmap = null;
                        } else if (BitmapFactory.decodeByteArray((byte[]) this.at.get(i2), 0, ((byte[]) this.at.get(i2)).length) == null) {
                            return;
                        } else {
                            bitmap = BitmapFactory.decodeByteArray((byte[]) this.at.get(i2), 0, ((byte[]) this.at.get(i2)).length);
                        }
                        if (bitmap == null || a(bitmap, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                            return;
                        }
                        ezVar.setImageBitmap(bitmap);
                        ImageButton imageButton = new ImageButton(this);
                        imageButton.setTag(Integer.valueOf(i2));
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
                    } catch (OutOfMemoryError unused) {
                        System.gc();
                        return;
                    }
                } else {
                    ImageView imageView = new ImageView(this);
                    imageView.setTag(Integer.valueOf(i2));
                    imageView.setBackgroundDrawable(null);
                    imageView.setPadding(0, 0, 0, 0);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setMaxHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    imageView.setMinimumHeight(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    imageView.setMaxWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    imageView.setMinimumWidth(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                    relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f)));
                    try {
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) this.at.get(i2), 0, ((byte[]) this.at.get(i2)).length);
                        if (decodeByteArray == null || a(decodeByteArray, com.baidu.ufosdk.f.i.a(getApplicationContext(), 45.0f)) == null) {
                            return;
                        }
                        imageView.setImageBitmap(decodeByteArray);
                        imageView.setOnClickListener(new br(this));
                    } catch (OutOfMemoryError unused2) {
                        System.gc();
                        return;
                    }
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 48.0f));
                layoutParams2.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), i2 == 0 ? 6.0f : 10.0f), 0, 0, 0);
                layoutParams2.gravity = 80;
                this.p.addView(relativeLayout, layoutParams2);
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, this, context, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            String str3 = this.ar;
            hashMap.put("appid", (str3 == null || str3.length() <= 0) ? UfoSDK.appid : this.ar);
            hashMap.put("id", str);
            hashMap.put("content", str2);
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com//?m=Index&a=getRobotQList", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
                com.baidu.ufosdk.f.c.c("getRobotQList response is -----------------> " + jSONObject.toString());
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    String valueOf = String.valueOf(jSONObject.get("id"));
                    if (com.baidu.ufosdk.b.ad != null) {
                        com.baidu.ufosdk.b.ad.onSubmitMessageAfterCallback(str2, valueOf);
                    }
                    com.baidu.ufosdk.f.c.a("sendChat --> msgId = " + str);
                    (str.contains("newMessage") ? this.aK.obtainMessage(14, valueOf) : this.aK.obtainMessage(12, valueOf)).sendToTarget();
                    return true;
                }
                return false;
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
                Looper.prepare();
                Toast.makeText(context, com.baidu.ufosdk.f.s.a("65"), 1).show();
                this.aK.obtainMessage(13).sendToTarget();
                Looper.loop();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, Handler handler, int i2) {
        InterceptResult invokeCommon;
        String str7;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, this, new Object[]{context, str, str2, str3, str4, str5, str6, handler, Integer.valueOf(i2)})) == null) {
            if (com.baidu.ufosdk.b.ag != null && str2.equals("newMessage")) {
                com.baidu.ufosdk.b.ag.onSubmitNewMessage();
            }
            SubmitMessageCallBack submitMessageCallBack = com.baidu.ufosdk.b.ad;
            if (submitMessageCallBack != null && str2 != null) {
                submitMessageCallBack.onSubmitMessageBeforeCallback(str4, str2.contains("newMessage") ? "newMessage" : str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", str);
            if (str3 == null || str3.length() <= 0) {
                hashMap.put("appid", UfoSDK.appid);
            } else {
                hashMap.put("appid", str3);
            }
            hashMap.put("devid", UfoSDK.devid);
            if (i2 != -999) {
                hashMap.put("robotQuestionId", Integer.valueOf(i2));
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
            int i3 = com.baidu.ufosdk.f.i.a(str5) ? 1 : com.baidu.ufosdk.f.i.b(str5) ? 2 : com.baidu.ufosdk.f.i.c(str5) ? 3 : 0;
            com.baidu.ufosdk.f.c.c("contactWay is " + str5 + "; type = " + i3);
            if (i3 == 0) {
                str7 = "contact_way";
            } else if (i3 == 1) {
                com.baidu.ufosdk.f.c.c("contactWay is email");
                str7 = "email";
            } else if (i3 == 2) {
                com.baidu.ufosdk.f.c.c("contactWay is tel");
                str7 = "tel";
            } else {
                com.baidu.ufosdk.f.c.c("contactWay is qq");
                str7 = LoginConstants.QQ_LOGIN;
            }
            hashMap.put(str7, str5);
            hashMap.put("brand", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            hashMap.put("sdkvn", "2.9.10");
            hashMap.put("os", "android");
            hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
            hashMap.put("freespace", String.valueOf(com.baidu.ufosdk.b.a.a()));
            hashMap.put("uid", com.baidu.ufosdk.b.f59171d);
            hashMap.put("username", com.baidu.ufosdk.b.f59169b);
            hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f59171d);
            hashMap.put("osvn", Build.VERSION.RELEASE);
            hashMap.put("extra", com.baidu.ufosdk.b.f59173f);
            hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.f59177j));
            hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
            hashMap.put("referer", com.baidu.ufosdk.b.p);
            hashMap.put("baiducuid", com.baidu.ufosdk.b.f59170c);
            if (!TextUtils.isEmpty(this.F)) {
                hashMap.put("faq_id", this.F);
            }
            hashMap.put("phonetime", String.valueOf(System.currentTimeMillis()));
            hashMap.put("nettype", com.baidu.ufosdk.f.p.a(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) ? com.baidu.ufosdk.b.d.a(context) : "N/A");
            hashMap.put("screenSize", com.baidu.ufosdk.b.f.a(context));
            if (com.baidu.ufosdk.b.f59168a) {
                hashMap.put("logcat", com.baidu.ufosdk.b.b.a());
            }
            if (!TextUtils.isEmpty(com.baidu.ufosdk.b.f59175h)) {
                hashMap.put("ip_location", com.baidu.ufosdk.b.f59175h);
            }
            String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
            try {
                if (TextUtils.isEmpty(str6)) {
                    sb = new StringBuilder("sdk_encrypt=");
                    sb.append(URLEncoder.encode(a2, "UTF-8"));
                } else {
                    sb = new StringBuilder("sdk_encrypt=");
                    sb.append(URLEncoder.encode(a2, "UTF-8"));
                    sb.append("&screenshot=");
                    sb.append(URLEncoder.encode(str6, "UTF-8"));
                }
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=postmsg", sb.toString());
                if (TextUtils.isEmpty(a3)) {
                    com.baidu.ufosdk.f.c.c("sendChat -> response is empty!");
                    Looper.prepare();
                    Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
                    handler.obtainMessage(13).sendToTarget();
                    Looper.loop();
                    return false;
                }
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
                int intValue = ((Integer) jSONObject.get("errno")).intValue();
                if (intValue != 0) {
                    if (intValue == 4) {
                        String str8 = (String) jSONObject.get("errmsg");
                        Looper.prepare();
                        if (str8 != null && str8.length() > 0) {
                            Toast.makeText(context, str8, 1).show();
                        }
                        handler.obtainMessage(13, str8).sendToTarget();
                        Looper.loop();
                        return true;
                    }
                    return false;
                }
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
                ((str2 == null || !str2.contains("newMessage")) ? (str3 == null || str3.length() <= 0) ? handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(UfoSDK.appid)) : handler.obtainMessage(12, Integer.parseInt(valueOf), Integer.parseInt(str3)) : (str3 == null || str3.length() <= 0) ? handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(UfoSDK.appid)) : handler.obtainMessage(14, Integer.parseInt(valueOf), Integer.parseInt(str3))).sendToTarget();
                return true;
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
                Looper.prepare();
                Toast.makeText(context, com.baidu.ufosdk.f.s.a("63"), 1).show();
                handler.obtainMessage(13).sendToTarget();
                Looper.loop();
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (this.s.getVisibility() != 0) {
                new cy(this).execute(new Void[0]);
                return;
            }
            this.s.setVisibility(8);
            this.D = false;
            TextView textView = this.J;
            int i2 = com.baidu.ufosdk.b.v;
            int i3 = com.baidu.ufosdk.b.y;
            int i4 = com.baidu.ufosdk.b.v;
            textView.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
            this.E.setEnabled(true);
        }
    }

    public static /* synthetic */ void g(FeedbackInputActivity feedbackInputActivity) {
        com.baidu.ufosdk.f.c.a("getEvaluateConfig url: https://ufosdk.baidu.com/?m=Index&a=getEvaluationConf");
        HashMap hashMap = new HashMap();
        hashMap.put("clientid", UfoSDK.clientid);
        hashMap.put("appid", UfoSDK.appid);
        hashMap.put("devid", UfoSDK.devid);
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("model", Build.MODEL);
        hashMap.put("sdkvn", "2.9.10");
        hashMap.put("os", "android");
        hashMap.put("appvn", com.baidu.ufosdk.b.e.b());
        hashMap.put("uid", com.baidu.ufosdk.b.f59171d);
        hashMap.put("username", com.baidu.ufosdk.b.f59169b);
        hashMap.put(DpStatConstants.KEY_USER_ID, com.baidu.ufosdk.b.f59171d);
        hashMap.put("osvn", Build.VERSION.RELEASE);
        hashMap.put("extra", com.baidu.ufosdk.b.f59173f);
        hashMap.put("extend_feedback_channel", Integer.valueOf(com.baidu.ufosdk.b.f59177j));
        hashMap.put("osvc", String.valueOf(com.baidu.ufosdk.f.j.a()));
        hashMap.put("baiducuid", com.baidu.ufosdk.b.f59170c);
        String a2 = com.baidu.ufosdk.f.k.a(com.baidu.ufosdk.c.a.a(hashMap));
        try {
            String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getEvaluationConf", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(com.baidu.ufosdk.f.k.b(a3));
            com.baidu.ufosdk.f.c.c("getEvaluateConfig response is -----------------> " + jSONObject.toString());
            if (jSONObject.optInt("errno", 1) == 1) {
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
            int optInt = optJSONObject.optInt("discontent_switch");
            feedbackInputActivity.aG = optInt;
            if (optInt == 0) {
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
        } catch (Exception e2) {
            com.baidu.ufosdk.f.c.a("getEvaluateConfig error!", e2);
        }
    }

    public static /* synthetic */ void j(FeedbackInputActivity feedbackInputActivity) {
        feedbackInputActivity.B = true;
        feedbackInputActivity.A = feedbackInputActivity.E.getText().toString();
        if (feedbackInputActivity.at.size() < 2) {
            Context applicationContext = feedbackInputActivity.getApplicationContext();
            String str = UfoSDK.clientid;
            String str2 = feedbackInputActivity.f59295e;
            String str3 = feedbackInputActivity.ar;
            if (!feedbackInputActivity.a(applicationContext, str, str2, str3, com.baidu.ufosdk.b.l + feedbackInputActivity.E.getText().toString() + com.baidu.ufosdk.b.m, feedbackInputActivity.aA, (String) null, feedbackInputActivity.aK, BannerFocusImageViewGroup.f60295f)) {
                com.baidu.ufosdk.f.c.c("SendFeedback --> 反馈发送失败！");
                return;
            }
            com.baidu.ufosdk.f.c.c("SendFeedback --> 反馈发送成功！--" + feedbackInputActivity.E.getText().toString());
            feedbackInputActivity.aK.obtainMessage(1, feedbackInputActivity.E.getText().toString()).sendToTarget();
            com.baidu.ufosdk.f.c.c("346 --> tempRobotSwitch = " + feedbackInputActivity.y);
            if ((UfoSDK.robotAnswer && feedbackInputActivity.y) || feedbackInputActivity.f59295e.contains("newMessage") || feedbackInputActivity.u || !feedbackInputActivity.aC) {
                return;
            }
            feedbackInputActivity.aK.obtainMessage(8).sendToTarget();
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < feedbackInputActivity.at.size() - 1; i2++) {
            try {
                jSONArray.put(Base64.encodeToString((byte[]) feedbackInputActivity.at.get(i2), 0));
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("Base64 error!", e2);
                return;
            }
        }
        if (jSONArray.toString().length() >= 2097152) {
            Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("21"), 1).show();
            return;
        }
        Context applicationContext2 = feedbackInputActivity.getApplicationContext();
        String str4 = UfoSDK.clientid;
        String str5 = feedbackInputActivity.f59295e;
        String str6 = feedbackInputActivity.ar;
        if (!feedbackInputActivity.a(applicationContext2, str4, str5, str6, com.baidu.ufosdk.b.l + feedbackInputActivity.E.getText().toString() + com.baidu.ufosdk.b.m, feedbackInputActivity.aA, jSONArray.toString(), feedbackInputActivity.aK, BannerFocusImageViewGroup.f60295f)) {
            com.baidu.ufosdk.f.c.d("发送失败");
            return;
        }
        feedbackInputActivity.aK.obtainMessage(1, feedbackInputActivity.E.getText().toString()).sendToTarget();
        for (int i3 = 0; i3 < feedbackInputActivity.at.size() - 1; i3++) {
            feedbackInputActivity.aK.obtainMessage(3, feedbackInputActivity.at.get(i3)).sendToTarget();
        }
        if ((UfoSDK.robotAnswer && feedbackInputActivity.y) || feedbackInputActivity.f59295e.contains("newMessage") || feedbackInputActivity.u || !feedbackInputActivity.aC) {
            return;
        }
        feedbackInputActivity.aK.obtainMessage(8).sendToTarget();
    }

    public static /* synthetic */ void l(FeedbackInputActivity feedbackInputActivity) {
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(BdUploadHandler.IMAGE_MIME_TYPE);
        if (feedbackInputActivity.as == feedbackInputActivity.at.size() - 1) {
            if (feedbackInputActivity.getCurrentFocus() != null && feedbackInputActivity.getCurrentFocus().getWindowToken() != null) {
                ((InputMethodManager) feedbackInputActivity.getSystemService("input_method")).hideSoftInputFromWindow(feedbackInputActivity.getCurrentFocus().getWindowToken(), 2);
            }
            try {
                feedbackInputActivity.startActivityForResult(intent, feedbackInputActivity.as);
                try {
                    feedbackInputActivity.overridePendingTransition(com.baidu.ufosdk.f.i.a(feedbackInputActivity.getApplicationContext(), "ufo_slide_in_from_bottom"), 0);
                } catch (Exception unused) {
                }
            } catch (ActivityNotFoundException unused2) {
                Toast.makeText(feedbackInputActivity, com.baidu.ufosdk.f.s.a("0"), 1).show();
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.at.clear();
            a(true);
        }
    }

    public final void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            popupWindow.showAsDropDown(view);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, keyEvent)) == null) {
            if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
                this.t = true;
                b();
                return false;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        InputMethodManager inputMethodManager;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            boolean z2 = true;
            if (motionEvent.getAction() != 0) {
                if (getWindow().superDispatchTouchEvent(motionEvent)) {
                    return true;
                }
                return onTouchEvent(motionEvent);
            }
            LinearLayout linearLayout = this.f59293c;
            if (linearLayout != null && (linearLayout instanceof LinearLayout)) {
                int[] iArr = {0, 0};
                linearLayout.getLocationInWindow(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                int height = linearLayout.getHeight() + i3;
                int width = linearLayout.getWidth() + i2;
                if (motionEvent.getX() <= i2 || motionEvent.getX() >= width || motionEvent.getY() <= i3 || motionEvent.getY() >= height) {
                    ArrayList arrayList = this.aw;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            View view = (View) it.next();
                            int[] iArr2 = new int[2];
                            view.getLocationOnScreen(iArr2);
                            int i4 = iArr2[0];
                            int i5 = iArr2[1];
                            if (motionEvent.getX() < i4 || motionEvent.getX() > i4 + view.getWidth() || motionEvent.getY() < i5 || motionEvent.getY() > i5 + view.getHeight()) {
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
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e9  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri uri;
        InputStream openInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (!this.ay) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
                dVar.c(dVar.c() + 1);
                this.ay = true;
            }
            if (i3 == -1 && intent != null) {
                byte[] bArr = null;
                try {
                    uri = intent.getData();
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    return;
                }
                try {
                    openInputStream = getContentResolver().openInputStream(uri);
                } catch (Exception e2) {
                    e = e2;
                }
                if (openInputStream.available() >= 8388608) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                    return;
                }
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                openInputStream.close();
                try {
                } catch (Exception e3) {
                    e = e3;
                    bArr = byteArray;
                }
                if (byteArray == null) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                    return;
                }
                byte[] bArr3 = com.baidu.ufosdk.f.q.a(byteArray);
                try {
                } catch (Exception e4) {
                    e = e4;
                    bArr = bArr3;
                    System.out.println(e.getMessage());
                    bArr3 = bArr;
                    if (i2 != this.at.size() - 1) {
                    }
                    a(true);
                    this.E.setFocusable(true);
                    this.E.setFocusableInTouchMode(true);
                }
                if (bArr3 == null) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                } else if (bArr3.length > 307200) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a("21"), 1).show();
                } else if (bArr3.length == 0) {
                    Toast.makeText(this, com.baidu.ufosdk.f.s.a("54"), 1).show();
                } else {
                    if (com.baidu.ufosdk.f.i.a(this) < 35000) {
                        Toast.makeText(this, com.baidu.ufosdk.f.s.a(BaseUtils.METHOD_SENDMESSAGE), 1).show();
                        System.gc();
                        return;
                    }
                    if (i2 != this.at.size() - 1) {
                        this.at.set(i2, bArr3);
                    } else {
                        Toast.makeText(this, "内存不足，图片读取失败，请尝试清理内存稍后再试.", 1).show();
                        com.baidu.ufosdk.f.c.b("picBytesList--->clear");
                        this.at.clear();
                    }
                    a(true);
                    this.E.setFocusable(true);
                    this.E.setFocusableInTouchMode(true);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            com.baidu.ufosdk.f.c.c("*** onCreate!");
            super.onCreate(bundle);
            requestWindowFeature(1);
            getWindow().setSoftInputMode(16);
            com.baidu.ufosdk.f.r.a(this, getWindow());
            com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
            SharedPreferences sharedPreferences = getSharedPreferences("UfoSharePreference", 0);
            this.r = sharedPreferences;
            this.q = sharedPreferences.edit();
            this.F = getIntent().getStringExtra("faq_id");
            this.f59295e = getIntent().getStringExtra("msgid");
            this.ar = getIntent().getStringExtra("appid");
            this.aD = getIntent().getBooleanExtra("openList", false);
            this.H = getIntent().getBooleanExtra("fromList", false);
            this.o = getIntent().getBooleanExtra("fromEdit", false);
            this.az = getIntent().getStringExtra("no_result");
            if (TextUtils.isEmpty(this.f59295e)) {
                this.f59295e = "newMessage";
            }
            if (TextUtils.isEmpty(this.F)) {
                this.F = "";
            }
            this.aA = this.r.getString("cryptContactData", "");
            this.q.putBoolean("ADD_PIC_FLAG", true);
            this.q.commit();
            String str = this.aA;
            if (str == null || str.trim().length() <= 0) {
                this.aA = "";
            } else {
                this.aA = com.baidu.ufosdk.f.k.b(this.aA);
            }
            this.aC = getIntent().getBooleanExtra("from_facepage", false);
            com.baidu.ufosdk.b.f59177j = getIntent().getIntExtra("feedback_channel", 0);
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.ao = relativeLayout;
            relativeLayout.setFitsSystemWindows(true);
            this.ao.setId(R.id.BOTH);
            this.ao.setBackgroundColor(com.baidu.ufosdk.b.A);
            RelativeLayout relativeLayout2 = new RelativeLayout(this);
            relativeLayout2.setId(R.id.BOTTOM);
            relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
            new RelativeLayout(this).setId(R.id.BOTTOM_START);
            Button button = new Button(this);
            this.aq = button;
            button.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR));
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
            ImageView imageView = new ImageView(this);
            this.ap = imageView;
            imageView.setId(R.id.App_Launch_Circle_Animation_View);
            this.ap.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ap.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
            linearLayout.addView(this.ap, layoutParams2);
            TextView textView = new TextView(this);
            textView.setText(com.baidu.ufosdk.b.f59176i);
            textView.setTextSize(com.baidu.ufosdk.b.M);
            textView.setTextColor(com.baidu.ufosdk.b.H);
            textView.setGravity(16);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            linearLayout.addView(textView, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(9);
            layoutParams4.addRule(15);
            relativeLayout2.addView(linearLayout, layoutParams4);
            TextView textView2 = new TextView(this);
            textView2.setId(R.id.App_Launch_Shimmer_Animation_View);
            textView2.setText(com.baidu.ufosdk.f.s.a(this.o ? "49" : RoomMasterTable.DEFAULT_ID));
            textView2.setTextColor(com.baidu.ufosdk.b.r);
            textView2.setTextSize(com.baidu.ufosdk.b.N);
            textView2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams5.addRule(13);
            relativeLayout2.addView(textView2, layoutParams5);
            Button button2 = new Button(this);
            this.aB = button2;
            button2.setVisibility(8);
            this.aB.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_GROUP));
            this.aB.setId(R.style.AlertActivity_AlertStyle);
            this.aB.setTextColor(com.baidu.ufosdk.b.s);
            this.aB.setTextSize(com.baidu.ufosdk.b.U);
            this.aB.setGravity(17);
            Button button3 = this.aB;
            int i3 = com.baidu.ufosdk.b.s;
            int i4 = com.baidu.ufosdk.b.t;
            int i5 = com.baidu.ufosdk.b.s;
            button3.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
            this.aB.setBackgroundColor(16777215);
            this.aB.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(11);
            layoutParams6.addRule(15);
            layoutParams6.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0);
            relativeLayout2.addView(this.aB, layoutParams6);
            relativeLayout2.setBackgroundColor(com.baidu.ufosdk.b.A);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
            layoutParams7.addRule(10);
            this.ao.addView(relativeLayout2, layoutParams7);
            View view = new View(this);
            view.setId(2131755011);
            view.setBackgroundColor(-2894893);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams8.addRule(3, relativeLayout2.getId());
            this.ao.addView(view, layoutParams8);
            this.s = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("25"));
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(13);
            this.ao.addView(this.s, layoutParams9);
            this.s.setVisibility(8);
            LinearLayout linearLayout2 = new LinearLayout(this);
            this.an = linearLayout2;
            linearLayout2.setId(R.id.MULTI);
            this.an.setOrientation(0);
            LinearLayout linearLayout3 = new LinearLayout(this);
            this.f59293c = linearLayout3;
            linearLayout3.setId(R.id.BLOCK);
            this.f59293c.setOrientation(1);
            this.f59293c.setBackgroundColor(com.baidu.ufosdk.b.z);
            RelativeLayout relativeLayout3 = new RelativeLayout(this);
            relativeLayout3.setId(R.id.CTRL);
            relativeLayout3.setFocusable(true);
            relativeLayout3.setFocusableInTouchMode(true);
            TextView textView3 = new TextView(this);
            this.J = textView3;
            textView3.setText(com.baidu.ufosdk.f.s.a("24"));
            this.J.setTextColor(com.baidu.ufosdk.b.v);
            this.J.setTextSize(13.0f);
            this.J.setGravity(17);
            this.J.setId(R.id.abstract_voice);
            this.J.setBackgroundColor(com.baidu.ufosdk.b.z);
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams10.addRule(11);
            layoutParams10.addRule(15);
            layoutParams10.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), 0);
            relativeLayout3.addView(this.J, layoutParams10);
            LinearLayout linearLayout4 = new LinearLayout(this);
            linearLayout4.setOrientation(0);
            linearLayout4.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
            linearLayout4.setClickable(true);
            linearLayout4.setId(R.id.accept_invite_button);
            ImageView imageView2 = new ImageView(this);
            imageView2.setId(R.id.FILL);
            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView2.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_pluspic_icon.png")));
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams11.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            linearLayout4.addView(imageView2, layoutParams11);
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 33.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 33.0f));
            layoutParams12.addRule(15);
            layoutParams12.addRule(9);
            relativeLayout3.addView(linearLayout4, layoutParams12);
            EditText editText = new EditText(this);
            this.E = editText;
            editText.setImeOptions(4);
            this.E.setInputType(262144);
            this.E.setSingleLine(false);
            this.E.setId(R.id.DOWN);
            this.E.setVisibility(0);
            this.E.setTextSize(15.0f);
            this.E.setGravity(16);
            this.E.setHint(com.baidu.ufosdk.f.s.a("6"));
            this.E.setTextColor(-13421773);
            try {
                this.E.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(getApplicationContext(), "ufo_input_edt_bg.9.png"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.E.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0);
            RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams13.addRule(1, linearLayout4.getId());
            layoutParams13.addRule(0, this.J.getId());
            layoutParams13.addRule(15);
            relativeLayout3.addView(this.E, layoutParams13);
            this.E.setOnEditorActionListener(new be(this));
            this.E.addTextChangedListener(new bt(this));
            this.J.setOnClickListener(new bz(this));
            linearLayout4.setOnClickListener(new ca(this));
            this.aB.setOnClickListener(new cb(this));
            this.an.addView(relativeLayout3, new LinearLayout.LayoutParams(-1, -1));
            this.an.setGravity(16);
            LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
            this.an.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 4.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
            this.f59293c.setGravity(3);
            this.f59293c.addView(this.an, layoutParams14);
            View view2 = new View(this);
            this.C = view2;
            view2.setId(R.id.META);
            this.C.setBackgroundColor(com.baidu.ufosdk.b.G);
            LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams15.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 3.0f));
            this.f59293c.addView(this.C, layoutParams15);
            this.C.setVisibility(8);
            LinearLayout linearLayout5 = new LinearLayout(this);
            this.p = linearLayout5;
            linearLayout5.setOrientation(0);
            this.p.setPadding(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f));
            this.p.setId(R.id.Forward);
            this.p.setVisibility(8);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("shot");
            if (byteArrayExtra == null || byteArrayExtra.length <= 0) {
                this.p.setVisibility(8);
            } else {
                this.at.add(byteArrayExtra);
                this.p.setVisibility(0);
            }
            a(true);
            this.f59293c.addView(this.p, new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 229.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 64.0f)));
            RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams16.addRule(12);
            this.f59293c.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 7.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f));
            this.f59293c.bringToFront();
            this.ao.addView(this.f59293c, layoutParams16);
            View view3 = new View(this);
            this.ax = view3;
            view3.setId(R.id.NONE);
            this.ax.setBackgroundColor(com.baidu.ufosdk.b.G);
            RelativeLayout.LayoutParams layoutParams17 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 0.5f));
            layoutParams17.addRule(2, this.f59293c.getId());
            this.ao.addView(this.ax, layoutParams17);
            ListView listView = new ListView(this);
            this.f59299i = listView;
            listView.setBackgroundColor(com.baidu.ufosdk.b.z);
            this.f59299i.setDivider(new ColorDrawable(com.baidu.ufosdk.b.I));
            this.f59299i.setDividerHeight(0);
            cg cgVar = new cg(this, this);
            this.f59300j = cgVar;
            this.f59299i.setAdapter((ListAdapter) cgVar);
            this.f59299i.setFocusable(false);
            this.f59299i.setCacheColorHint(com.baidu.ufosdk.b.I);
            this.f59299i.setClickable(false);
            this.f59299i.setTranscriptMode(2);
            this.f59299i.setRecyclerListener(new cc(this));
            LinearLayout linearLayout6 = new LinearLayout(this);
            this.f59294d = linearLayout6;
            linearLayout6.setId(R.id.SYM);
            this.f59294d.setBackgroundColor(com.baidu.ufosdk.b.D);
            this.f59294d.clearAnimation();
            LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-1, -1);
            RelativeLayout.LayoutParams layoutParams19 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams19.addRule(3, view.getId());
            layoutParams19.addRule(2, this.ax.getId());
            layoutParams19.setMargins(0, 0, 0, 0);
            this.f59294d.addView(this.f59299i, layoutParams18);
            this.ao.addView(this.f59294d, layoutParams19);
            LinearLayout linearLayout7 = new LinearLayout(this);
            this.f59292b = linearLayout7;
            linearLayout7.setOrientation(1);
            ImageView imageView3 = new ImageView(this);
            LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
            try {
                imageView3.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.f59292b.addView(imageView3, layoutParams20);
            TextView textView4 = new TextView(this);
            this.m = textView4;
            textView4.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
            this.m.setTextSize(com.baidu.ufosdk.b.O);
            this.m.setTextColor(com.baidu.ufosdk.b.x);
            LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-2, -2);
            com.baidu.ufosdk.f.i.a(getApplicationContext(), this.m);
            this.f59292b.addView(this.m, layoutParams21);
            Button button4 = new Button(this);
            this.aq = button4;
            button4.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
            this.aq.setTextSize(com.baidu.ufosdk.b.P);
            this.aq.setTextColor(com.baidu.ufosdk.b.w);
            try {
                this.aq.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
            layoutParams22.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
            this.f59292b.addView(this.aq, layoutParams22);
            RelativeLayout.LayoutParams layoutParams23 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams23.addRule(13);
            this.ao.addView(this.f59292b, layoutParams23);
            this.f59292b.setGravity(17);
            this.f59292b.setVisibility(8);
            setContentView(this.ao, new ViewGroup.LayoutParams(-1, -1));
            this.k = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("13"));
            RelativeLayout.LayoutParams layoutParams24 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams24.addRule(13);
            this.ao.addView(this.k, layoutParams24);
            if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(getApplicationContext(), com.baidu.ufosdk.f.s.a("62"), 1).show();
                Intent intent = new Intent(this, FeedbackListActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59177j);
                startActivity(intent);
                finish();
                return;
            }
            com.baidu.ufosdk.f.c.a("1606 --> msgId = " + this.f59295e);
            String str2 = this.f59295e;
            if (str2 == null || str2.length() <= 0 || this.f59295e.equals("newMessage")) {
                if (UfoSDK.showFeedbackBtn) {
                    this.aB.setVisibility(0);
                    i2 = 8;
                } else {
                    i2 = 8;
                    this.aB.setVisibility(8);
                }
                this.y = true;
                this.H = false;
                this.v = false;
                this.k.setVisibility(i2);
                this.s.setVisibility(i2);
                this.aK.obtainMessage(5, "newMessage").sendToTarget();
            } else {
                this.aB.setVisibility(8);
                this.y = false;
                this.H = true;
                this.v = true;
                this.l.execute(new cd(this));
            }
            linearLayout.setOnClickListener(new ce(this));
            this.f59293c.setOnClickListener(new cf(this));
            this.aq.setOnClickListener(new bf(this));
            try {
                com.baidu.ufosdk.f.c.d("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
            } catch (Exception unused) {
                com.baidu.ufosdk.f.c.d("执行动画错误！exit!");
            }
            new Thread(new bh(this)).start();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            com.baidu.ufosdk.f.a.f59206a = null;
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        SharedPreferences.Editor editor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            com.baidu.ufosdk.f.c.a("***onPause!");
            super.onPause();
            if (this.G) {
                if (TextUtils.isEmpty(this.F)) {
                    editor = this.q;
                    str = this.f59295e;
                } else {
                    editor = this.q;
                    str = this.F;
                }
                editor.putString(str, this.E.getText().toString());
            }
            this.q.commit();
            com.baidu.ufosdk.a.a aVar = this.f59297g;
            if (aVar != null) {
                aVar.a();
                this.f59297g = null;
            }
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onRestart();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        SharedPreferences sharedPreferences;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.baidu.ufosdk.f.c.c("***onResume!");
            super.onResume();
            String str2 = "";
            if (TextUtils.isEmpty(UfoSDK.clientid)) {
                SharedPreferences sharedPreferences2 = getSharedPreferences("UfoSharePreference", 0);
                UfoSDK.clientid = sharedPreferences2.getString("UfoClientId", "");
                UfoSDK.appid = sharedPreferences2.getString("UfoAppId", "");
                UfoSDK.devid = sharedPreferences2.getString("UfoDevId", "");
                UfoSDK.productid = sharedPreferences2.getString("UfoProductId", "");
            }
            ResumeCallBack resumeCallBack = com.baidu.ufosdk.b.ac;
            if (resumeCallBack != null) {
                resumeCallBack.onResumeCallback();
            }
            this.aq.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.k, com.baidu.ufosdk.f.s.a("13"));
            String str3 = this.f59295e;
            if (str3 != null && str3.length() > 0) {
                if (this.f59297g == null) {
                    String str4 = this.ar;
                    this.f59297g = new com.baidu.ufosdk.a.a(getApplicationContext(), this.f59295e, (str4 == null || str4.length() <= 0) ? UfoSDK.appid : this.ar);
                }
                this.f59297g.b();
                if (!this.f59297g.isAlive()) {
                    this.f59297g.start();
                }
            }
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this);
            dVar.a(dVar.a() + 1);
            ResumeCallBack resumeCallBack2 = com.baidu.ufosdk.b.ac;
            if (resumeCallBack2 != null) {
                resumeCallBack2.onResumeCallback();
            }
            com.baidu.ufosdk.f.i.a((RelativeLayout) this.s, com.baidu.ufosdk.f.s.a("25"));
            this.G = true;
            String str5 = this.f59295e;
            if (str5 == null || str5.length() == 0) {
                this.f59295e = "newMessage";
            }
            String str6 = this.az;
            if (str6 != null) {
                this.E.setText(str6);
            } else {
                if (TextUtils.isEmpty(this.F)) {
                    sharedPreferences = this.r;
                    str = this.f59295e;
                } else {
                    sharedPreferences = this.r;
                    str = this.F;
                }
                str2 = sharedPreferences.getString(str, "");
                this.E.setText(str2);
            }
            this.E.setSelection(str2.length());
            if (this.E.getText().toString().trim().length() <= 0) {
                this.J.setTextColor(com.baidu.ufosdk.b.y);
            } else {
                TextView textView = this.J;
                int i2 = com.baidu.ufosdk.b.v;
                int i3 = com.baidu.ufosdk.b.y;
                int i4 = com.baidu.ufosdk.b.v;
                textView.setTextColor(com.baidu.ufosdk.f.i.a(i2, i3, i4, i4));
            }
            (UfoSDK.clientid.length() == 0 ? new Thread(new bs(this)) : new Thread(new bu(this))).start();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.baidu.ufosdk.f.c.a("***onStart!");
            super.onStart();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.ufosdk.getchat");
            intentFilter.addAction("com.baidu.ufosdk.getmsgid");
            intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
            intentFilter.addAction("com.baidu.ufosdk.reload");
            registerReceiver(this.aL, intentFilter);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        View currentFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.baidu.ufosdk.f.c.a("***onStop!");
            super.onStop();
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && (currentFocus = getCurrentFocus()) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getApplicationWindowToken(), 2);
            }
            unregisterReceiver(this.aL);
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, motionEvent)) == null) ? super.onTouchEvent(motionEvent) : invokeL.booleanValue;
    }
}
