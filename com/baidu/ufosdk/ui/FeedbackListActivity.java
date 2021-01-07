package com.baidu.ufosdk.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ufosdk.R;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public class FeedbackListActivity extends Activity {
    private static com.baidu.ufosdk.a.b x;

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f5699a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f5700b;
    private LinearLayout c;
    private TextView d;
    private List e;
    private Button q;
    private ImageView r;
    private TextView s;
    private ListView t;
    private du u;
    private View v;
    private View w;
    private ExecutorService y;
    private PopupWindow z;
    private final int f = 2132344833;
    private final int g = 2132344834;
    private final int h = 2132344836;
    private final int i = 2132344837;
    private final int j = 2132344838;
    private final int k = 2132344839;
    private final int l = 2132344840;
    private final int m = 2132344842;
    private final int n = 2132344843;
    private final int o = 2132344845;
    private int p = -1;
    @SuppressLint({"HandlerLeak"})
    private Handler A = new de(this);
    private BroadcastReceiver B = new dh(this);

    /* JADX INFO: Access modifiers changed from: private */
    public View a(Context context, String str, String str2, String str3) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundDrawable(null);
        try {
            relativeLayout.setBackgroundDrawable(com.baidu.ufosdk.f.o.a(context, "ufo_delete_bg.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(context, 19.0f), com.baidu.ufosdk.f.i.a(context, 23.0f));
        relativeLayout2.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setId(2132345067);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setAdjustViewBounds(true);
        imageView.setImageBitmap(com.baidu.ufosdk.f.m.a(context, "ufo_delete_btn_icon.png"));
        layoutParams.addRule(14);
        relativeLayout2.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, com.baidu.ufosdk.f.i.a(context, 5.0f), 0, 0);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(com.baidu.ufosdk.b.Y);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, imageView.getId());
        relativeLayout2.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, 0, 0, 0);
        relativeLayout2.setPadding(0, 0, 0, 0);
        layoutParams3.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams3);
        relativeLayout.setOnClickListener(new df(this, context, str2, str3));
        return relativeLayout;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            long currentTimeMillis = System.currentTimeMillis() - Long.parseLong(str);
            long ceil = (long) Math.ceil(((float) (currentTimeMillis / 60)) / 1000.0f);
            long ceil2 = (long) Math.ceil(((float) ((currentTimeMillis / 60) / 60)) / 1000.0f);
            if (((long) Math.ceil(((float) (((currentTimeMillis / 24) / 60) / 60)) / 1000.0f)) - 1 > 0) {
                stringBuffer.append(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(Long.parseLong(str))));
            } else if (ceil2 > 1) {
                if (ceil2 < 5) {
                    stringBuffer.append((ceil2 - 1) + com.baidu.ufosdk.f.s.a("9"));
                } else if (ceil2 >= 5) {
                    stringBuffer.append(new SimpleDateFormat("HH:mm").format(Long.valueOf(Long.parseLong(str))));
                }
            } else if (ceil >= 0) {
                if (ceil > 3) {
                    stringBuffer.append(ceil + com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                } else {
                    stringBuffer.append(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE));
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("getStandardDate error!", e);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(FeedbackListActivity feedbackListActivity) {
        if (x == null) {
            x = new com.baidu.ufosdk.a.b(feedbackListActivity.getApplicationContext());
        }
        x.b();
        if (x.isAlive()) {
            return;
        }
        x.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bitmap o(FeedbackListActivity feedbackListActivity) {
        int a2 = com.baidu.ufosdk.f.i.a(feedbackListActivity.getApplicationContext(), 20.0f);
        Bitmap createBitmap = Bitmap.createBitmap(a2, a2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setColor(-1551537);
        canvas.drawCircle(a2 / 2, a2 / 2, a2 / 2, paint);
        return createBitmap;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            setResult(0);
            finish();
            try {
                com.baidu.ufosdk.f.c.d("执行动画...");
                overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_right"));
            } catch (Exception e) {
                com.baidu.ufosdk.f.c.d("执行动画失败！！");
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        com.baidu.ufosdk.f.r.a(this, getWindow());
        com.baidu.ufosdk.f.r.a(getWindow(), com.baidu.ufosdk.b.L);
        boolean booleanExtra = getIntent().getBooleanExtra("backPress", false);
        com.baidu.ufosdk.b.j = getIntent().getIntExtra("feedback_channel", 0);
        this.y = Executors.newSingleThreadExecutor();
        this.p = com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f);
        this.e = new ArrayList();
        this.f5699a = new RelativeLayout(this);
        this.f5699a.setFitsSystemWindows(true);
        this.f5699a.setId(2132344836);
        this.f5699a.setBackgroundColor(com.baidu.ufosdk.b.A);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setId(2132344837);
        relativeLayout.setBackgroundColor(com.baidu.ufosdk.b.A);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(2132344838);
        this.c = new LinearLayout(this);
        this.c.setId(2132344839);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), null, "ufo_back_layout_press.png"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), 0, 0, 0);
        this.r = new ImageView(this);
        this.r.setId(2132344833);
        this.r.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.r.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_back_icon_browser.png")));
        linearLayout2.addView(this.r, layoutParams);
        TextView textView = new TextView(this);
        textView.setText(com.baidu.ufosdk.b.i);
        textView.setTextSize(com.baidu.ufosdk.b.M);
        textView.setTextColor(com.baidu.ufosdk.b.H);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 8.0f), 0);
        linearLayout2.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        relativeLayout.addView(linearLayout2, layoutParams3);
        TextView textView2 = new TextView(this);
        textView2.setId(2132344834);
        textView2.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_START_GROUP));
        textView2.setTextSize(com.baidu.ufosdk.b.W);
        textView2.setGravity(17);
        textView2.setTextColor(com.baidu.ufosdk.b.r);
        textView2.setBackgroundDrawable(null);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(13);
        relativeLayout.addView(textView2, layoutParams4);
        new LinearLayout.LayoutParams(-2, -2).setMargins(0, 0, this.p, 0);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        View view = new View(this);
        view.setId(2132344845);
        view.setBackgroundColor(-3355444);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams5.addRule(3, relativeLayout.getId());
        this.f5699a.addView(view, layoutParams5);
        this.t = new ListView(this);
        this.t.setSelector(new ColorDrawable(0));
        this.t.setCacheColorHint(-1);
        this.t.setDivider(new ColorDrawable(com.baidu.ufosdk.b.G));
        this.t.setDividerHeight(1);
        this.t.setVerticalScrollBarEnabled(false);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams6.setMargins(com.baidu.ufosdk.f.i.a(getApplicationContext(), 5.0f), 0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0);
        this.c.addView(this.t, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams7.addRule(3, view.getId());
        layoutParams7.addRule(2, linearLayout.getId());
        this.f5699a.addView(this.c, layoutParams7);
        this.s = new TextView(this);
        this.s.setText(com.baidu.ufosdk.f.s.a("20"));
        this.s.setTextColor(-10066330);
        this.s.setTextSize(com.baidu.ufosdk.b.X);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        this.f5699a.addView(this.s, layoutParams8);
        this.s.setVisibility(8);
        this.f5700b = new LinearLayout(this);
        this.f5700b.setOrientation(1);
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 115.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 85.0f));
        try {
            imageView.setBackgroundDrawable(new BitmapDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_no_netwrok.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f5700b.addView(imageView, layoutParams9);
        this.d = new TextView(this);
        this.d.setTextColor(com.baidu.ufosdk.b.x);
        this.d.setPadding(com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 18.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 10.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 11.0f));
        this.d.setTextSize(com.baidu.ufosdk.b.O);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        com.baidu.ufosdk.f.i.a(getApplicationContext(), this.d);
        this.f5700b.addView(this.d, layoutParams10);
        this.q = new Button(this);
        this.q.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        this.q.setTextSize(com.baidu.ufosdk.b.P);
        this.q.setTextColor(com.baidu.ufosdk.b.w);
        try {
            this.q.setBackgroundDrawable(com.baidu.ufosdk.f.m.a(getApplicationContext(), "ufo_reload_btn_defult.9.png", "ufo_reload_btn_press.9.png"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 122.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 40.0f));
        layoutParams11.setMargins(0, com.baidu.ufosdk.f.i.a(getApplicationContext(), 15.0f), 0, 0);
        this.f5700b.addView(this.q, layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.addRule(13);
        this.f5699a.addView(this.f5700b, layoutParams12);
        this.f5700b.setGravity(17);
        this.f5700b.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-1, com.baidu.ufosdk.f.i.a(getApplicationContext(), 50.0f));
        layoutParams13.addRule(10);
        this.f5699a.addView(relativeLayout, layoutParams13);
        setContentView(this.f5699a, new ViewGroup.LayoutParams(-1, -1));
        this.v = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.addRule(13);
        this.f5699a.addView(this.v, layoutParams14);
        this.w = com.baidu.ufosdk.f.i.b(this, com.baidu.ufosdk.f.s.a("4"));
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(com.baidu.ufosdk.f.i.a(getApplicationContext(), 114.0f), com.baidu.ufosdk.f.i.a(getApplicationContext(), 39.0f));
        layoutParams15.addRule(13);
        this.w.setVisibility(8);
        this.f5699a.addView(this.w, layoutParams15);
        linearLayout2.setOnClickListener(new dk(this));
        this.q.setOnClickListener(new dl(this));
        this.u = new du(this, this);
        this.t.setAdapter((ListAdapter) this.u);
        this.t.setFocusable(false);
        this.t.setCacheColorHint(-1);
        this.t.setDividerHeight(1);
        this.t.setDivider(getApplicationContext().getResources().getDrawable(R.drawable.list_item_divider));
        this.t.setRecyclerListener(new Cdo(this));
        this.t.setOnItemClickListener(new dp(this));
        this.t.setOnItemLongClickListener(new dq(this));
        if (booleanExtra) {
            return;
        }
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            overridePendingTransition(com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_in_from_right"), com.baidu.ufosdk.f.i.a(getApplicationContext(), "ufo_slide_out_to_left"));
        } catch (Exception e3) {
            com.baidu.ufosdk.f.c.d("执行动画错误！exit!");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            if (x != null) {
                x.a();
                x = null;
            }
            this.w.setVisibility(8);
            unregisterReceiver(this.B);
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("Stop list thread error!", e);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (com.baidu.ufosdk.b.ac != null) {
            com.baidu.ufosdk.b.ac.onResumeCallback();
        }
        this.s.setText(com.baidu.ufosdk.f.s.a("20"));
        ((TextView) findViewById(2132344834)).setText((CharSequence) com.baidu.ufosdk.b.ab.get(Constants.VIA_REPORT_TYPE_START_GROUP));
        this.q.setText(com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_DATALINE));
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.v, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_JOININ_GROUP));
        com.baidu.ufosdk.f.i.a((RelativeLayout) this.w, com.baidu.ufosdk.f.s.a("4"));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                break;
            } else if (!((String) ((Map) this.e.get(i2)).get("newmsg")).equals("0")) {
                this.A.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (UfoSDK.clientid.length() == 0) {
            new Thread(new dr(this)).start();
        } else {
            this.y.execute(new ds(this));
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.ufosdk.gethistorylist");
        intentFilter.addAction("com.baidu.ufosdk.getnewhistoryflag");
        intentFilter.addAction("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag");
        intentFilter.addAction("com.baidu.ufosdk.deletemsg_dialogdismiss");
        intentFilter.addAction("com.baidu.ufosdk.reload");
        registerReceiver(this.B, intentFilter);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
