package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.baidu.tieba.view.KeyboardLayout;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends com.baidu.tieba.j implements com.baidu.tieba.view.a {
    private EditText m;
    private Button n;
    private Button o;
    private GridView p;

    /* renamed from: a  reason: collision with root package name */
    private ac f1514a = null;
    private ImageView b = null;
    private ImageView c = null;
    private Button d = null;
    private Button e = null;
    private RelativeLayout f = null;
    private TextView g = null;
    private TextView j = null;
    private AlertDialog k = null;
    private View l = null;
    private ProgressBar q = null;
    private LinearLayout r = null;
    private LinearLayout s = null;
    private KeyboardLayout t = null;
    private DialogInterface.OnCancelListener u = null;
    private af v = null;
    private AntiData w = null;
    private int x = 0;
    private ag y = null;
    private BaseViewPager z = null;
    private ImagePbPagerAdapter A = null;
    private ae B = null;
    private boolean C = false;
    private String D = null;
    private String E = null;
    private String F = null;
    private int G = 0;
    private com.baidu.tieba.data.ac H = null;
    private com.baidu.tieba.data.ac I = null;
    private AlertDialog J = null;
    private int K = 0;
    private MyOnPageChangeListener L = null;
    private String M = null;
    private long N = 0;
    private HashMap<String, Boolean> O = null;
    private boolean P = false;
    private Handler Q = null;
    private Runnable R = new k(this);
    private ad S = new u(this);
    private com.baidu.tieba.view.ap T = new v(this);

    @Override // com.baidu.tieba.j
    public boolean f() {
        return TiebaApplication.g().u();
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ImagePbActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra(LocaleUtil.INDONESIAN, str);
            intent.putExtra("forum", str2);
            intent.putExtra("title", str3);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image_pb_activity);
        this.H = new com.baidu.tieba.data.ac(this);
        d();
        a(bundle);
        b();
    }

    private void b() {
        this.B = new ae(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pagechanged");
        registerReceiver(this.B, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Q.removeCallbacks(this.R);
        com.baidu.tieba.util.a d = this.A.d();
        if (d != null) {
            d.b();
        }
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.Q.removeCallbacks(this.R);
        this.Q.post(this.R);
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        a(this.K, this.K);
        r();
        if (this.y != null) {
            this.y.cancel();
        }
        if (this.q != null) {
            this.q.setVisibility(8);
        }
        if (this.v != null) {
            this.v.cancel();
        }
        if (this.f1514a != null) {
            this.f1514a.cancel();
        }
        if (this.k != null && this.k.isShowing()) {
            this.k.dismiss();
        }
        this.A.c();
        unregisterReceiver(this.B);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.k == null) {
            this.k = new AlertDialog.Builder(this).create();
            this.k.setCanceledOnTouchOutside(true);
            this.l = getLayoutInflater().inflate(R.layout.pb_title_dialog, (ViewGroup) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.as.a(this.t, i);
        com.baidu.tieba.util.as.d(this.f, i);
        com.baidu.tieba.util.as.f(this.g, i);
        com.baidu.tieba.util.as.f(this.j, i);
        com.baidu.tieba.util.as.a(this.b, i);
        int childCount = this.z.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.z.getChildAt(i2);
            if (childAt.getId() == R.id.image_next) {
                TextView textView = (TextView) childAt.findViewById(R.id.next);
                TextView textView2 = (TextView) childAt.findViewById(R.id.thread_name);
                ImageView imageView = (ImageView) childAt.findViewById(R.id.image);
                if (textView != null && textView2 != null && imageView != null) {
                    if (i == 1) {
                        textView.setTextColor(com.baidu.tieba.util.as.c(1));
                        textView2.setTextColor(com.baidu.tieba.util.as.a(1));
                        imageView.setBackgroundResource(R.drawable.image_pb_next_default_1);
                    } else {
                        textView.setTextColor(-9539986);
                        textView2.setTextColor(-6250336);
                        imageView.setBackgroundResource(R.drawable.image_pb_next_default);
                    }
                }
            } else {
                View findViewById = childAt.findViewById(R.id.image_pb_listview);
                if (findViewById != null && (findViewById instanceof ListView)) {
                    ListView listView = (ListView) findViewById;
                    com.baidu.tieba.util.as.a(listView, i);
                    if (childAt.getTag() != null && (childAt.getTag() instanceof ah)) {
                        com.baidu.tieba.util.as.a(listView, i);
                        ((ah) childAt.getTag()).notifyDataSetChanged();
                    }
                }
            }
        }
        if (i == 1) {
            this.c.setImageResource(R.drawable.frs_bottom_camera_1);
            a(this.d, R.drawable.pb_bottom_btn_reply_1);
            a(this.e, R.drawable.image_pb_bottom_save_1);
            this.d.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.e.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color_1));
            this.p.setBackgroundColor(getResources().getColor(R.color.skin_1_face_bg_color));
            com.baidu.tieba.util.as.e(this.r, (int) R.drawable.sub_pb_reply_bg_1);
            this.s.setBackgroundResource(R.drawable.maintab_toolbar_bg_1);
            return;
        }
        this.c.setImageResource(R.drawable.frs_bottom_camera);
        a(this.d, R.drawable.pb_bottom_btn_reply);
        a(this.e, R.drawable.image_pb_bottom_save);
        this.d.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.e.setTextColor(getResources().getColorStateList(R.color.text_blue_selector_color));
        this.p.setBackgroundColor(-1644826);
        com.baidu.tieba.util.as.e(this.r, (int) R.drawable.sub_pb_reply_bg);
        this.s.setBackgroundResource(R.drawable.maintab_toolbar_bg);
    }

    private void a(Button button, int i) {
        button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getResources().getDrawable(i), (Drawable) null, (Drawable) null);
    }

    private void d() {
        this.f = (RelativeLayout) findViewById(R.id.title);
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(new w(this));
        this.c = (ImageView) findViewById(R.id.camera);
        this.c.setOnClickListener(new x(this));
        this.d = (Button) findViewById(R.id.reply);
        this.d.setOnClickListener(new y(this));
        this.e = (Button) findViewById(R.id.save);
        this.e.setOnClickListener(new z(this));
        this.g = (TextView) findViewById(R.id.title_text);
        this.g.setOnClickListener(new aa(this));
        this.j = (TextView) findViewById(R.id.title_page);
        this.z = (BaseViewPager) findViewById(R.id.content_view);
        this.z.setOnFlipOutListener(this);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new ab(this));
        this.r = (LinearLayout) findViewById(R.id.layout_reply);
        this.m = (EditText) findViewById(R.id.reply_content);
        this.o = (Button) findViewById(R.id.button_face);
        this.n = (Button) findViewById(R.id.reply_button);
        this.n.setEnabled(false);
        q();
        this.p = (GridView) findViewById(R.id.face_view);
        com.baidu.tieba.write.o oVar = new com.baidu.tieba.write.o(this);
        this.p.setAdapter((ListAdapter) oVar);
        this.p.setOnItemClickListener(new m(this, oVar));
        this.t = (KeyboardLayout) findViewById(R.id.image_pb_layout);
        this.t.setOnkbdStateListener(this.T);
        this.n.setOnClickListener(new n(this));
        this.o.setOnClickListener(new p(this, new Handler(), new o(this)));
        this.s = (LinearLayout) findViewById(R.id.image_pb_bottom);
        this.m.setOnTouchListener(new q(this));
        this.q = (ProgressBar) findViewById(R.id.image_pb_progress);
        this.u = new r(this);
        if (this.J == null) {
            this.J = builder.create();
            this.J.setCanceledOnTouchOutside(true);
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.q != null) {
            if (z) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.m.requestFocus();
            this.r.setVisibility(0);
            this.p.setVisibility(8);
            UtilHelper.b(this, this.m);
            this.o.setBackgroundResource(R.drawable.sub_pb_face);
            this.s.setVisibility(4);
            return;
        }
        this.r.setVisibility(8);
        this.p.setVisibility(8);
        this.s.setVisibility(0);
        UtilHelper.a(this, this.m);
    }

    private void a(Bundle bundle) {
        this.Q = new Handler();
        this.G = 0;
        if (bundle != null) {
            this.E = bundle.getString(LocaleUtil.INDONESIAN);
            this.D = bundle.getString("forum");
            this.F = bundle.getString("title");
            this.G = bundle.getInt("current_page");
        } else {
            this.E = getIntent().getStringExtra(LocaleUtil.INDONESIAN);
            this.D = getIntent().getStringExtra("forum");
            this.F = getIntent().getStringExtra("title");
        }
        this.H.a(this.E);
        this.H.b(this.F);
        this.g.setText(this.F);
        this.A = new ImagePbPagerAdapter(this);
        this.A.a(this.S);
        this.A.a(this.E);
        this.z.setAdapter(this.A);
        this.L = new MyOnPageChangeListener();
        this.z.setOnPageChangeListener(this.L);
        this.z.setCurrentItem(this.G);
        if (this.D != null && this.D.length() > 0 && this.E != null && this.E.length() > 0) {
            a((String) null, 0, 9, true);
        }
        this.O = new HashMap<>();
        a(this.K, this.K);
    }

    private void c(boolean z) {
        this.Q.removeCallbacks(this.R);
        com.baidu.tieba.util.a d = this.A.d();
        if (d != null) {
            d.b();
        }
        if (!z) {
            String str = this.F;
            if (this.F != null) {
                if (this.F.length() > 6) {
                    str = String.valueOf(this.F.substring(0, 6)) + getString(R.string.three_point);
                }
                a(getString(R.string.image_pb_imagethread).replace("?", str));
            }
        }
        this.H.a(this.E);
        this.H.b(this.F);
        this.g.setText(this.F);
        this.A.b();
        this.A.a(this.E);
        this.A.a(this.H);
        this.A.notifyDataSetChanged();
        this.A.a();
        if (z && this.D != null && this.D.length() > 0 && this.E != null && this.E.length() > 0) {
            a((String) null, 0, 9, true);
        } else {
            b(0);
        }
        if (this.k != null && this.k.isShowing()) {
            this.k.dismiss();
        }
        a(this.K, this.K);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList<BasicNameValuePair> arrayList = new ArrayList<>(0);
        arrayList.add(new BasicNameValuePair("fname", this.D));
        arrayList.add(new BasicNameValuePair("tid", this.E));
        if (this.H != null) {
            arrayList.add(new BasicNameValuePair("fid", this.H.j()));
        }
        if (this.A.d() != null) {
            this.A.d().a(arrayList);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(LocaleUtil.INDONESIAN, this.E);
        bundle.putString("forum", this.D);
        bundle.putInt("current_page", this.G);
        bundle.putString("title", this.F);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0033: INVOKE  (r3v2 int A[REMOVE]) = (r14v0 android.content.Intent), ("index"), (0 int) type: VIRTUAL call: android.content.Intent.getIntExtra(java.lang.String, int):int)] */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11005:
                    e(this.x);
                    return;
                case 11016:
                    this.J.show();
                    return;
                case 12001:
                    if (this.H != null && this.H.i() != null && this.D != null) {
                        WriteImageActivity.a(this, 12001, 12010, null, this.H.j(), this.D, null);
                        return;
                    }
                    return;
                case 12002:
                    if (this.H != null && this.H.i() != null && this.D != null) {
                        if (intent != null && intent.getData() != null) {
                            WriteImageActivity.a(this, 12002, 12009, intent.getData(), String.valueOf(this.H.j()), this.D, null);
                            return;
                        } else {
                            com.baidu.tieba.write.bf.b(this);
                            return;
                        }
                    }
                    return;
                case 12006:
                    if (intent.getSerializableExtra("model") != null) {
                        p();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    if (this.H != null) {
                        if (intent == null || intent.getStringExtra("filename") == null) {
                            WriteActivity.a(this, this.H.j(), this.D, this.E, (AntiData) null, (String) null);
                            return;
                        } else {
                            WriteActivity.a(this, this.H.j(), this.D, this.E, (AntiData) null, intent.getStringExtra("filename"));
                            return;
                        }
                    }
                    return;
                case 14001:
                    if (intent != null && intent.getIntExtra("index", -1) >= 0) {
                        com.baidu.tieba.util.av.a(getClass().getName(), "onActivityResult", new StringBuilder().append(intent.getIntExtra("index", 0)).toString());
                        this.z.a(intent.getIntExtra("index", 0), false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.y != null) {
            this.y.cancel();
        }
        this.y = new ag(this, null);
        this.y.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.H != null && this.H.e() != null) {
                this.H.e().setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 11016);
        } else if (this.H != null) {
            this.J.show();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        com.baidu.tieba.util.av.a(getClass().getName(), str, new StringBuilder().append(i2).toString());
        if (!this.H.a() && this.f1514a == null) {
            String str2 = String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/pb/picpage";
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kw", this.D));
            arrayList.add(new BasicNameValuePair("tid", this.E));
            if (str != null) {
                arrayList.add(new BasicNameValuePair("pic_id", str));
            }
            arrayList.add(new BasicNameValuePair("prev", String.valueOf(i)));
            arrayList.add(new BasicNameValuePair("next", String.valueOf(i2)));
            if (this.P) {
                this.P = false;
                arrayList.add(new BasicNameValuePair("st_type", "commend_pic_page"));
            }
            a(true);
            com.baidu.tieba.util.av.a(getClass().getName(), "startImagePbAsyncTask", str);
            this.f1514a = new ac(this, str2.toString(), arrayList, z);
            this.f1514a.setPriority(3);
            this.f1514a.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pageadded");
        LinkedList<com.baidu.tieba.data.ab> h = this.H.h();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < h.size(); i2++) {
            com.baidu.tieba.data.ab abVar = h.get(i2);
            StringBuilder sb = new StringBuilder(100);
            if (abVar.g() * abVar.f() > com.baidu.tieba.data.g.i() * com.baidu.tieba.data.g.i()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.g.i() * com.baidu.tieba.data.g.i()) / (abVar.g() * abVar.f()));
                sb.append("width=");
                sb.append(String.valueOf((int) (abVar.f() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * abVar.g())));
            } else {
                sb.append("width=");
                sb.append(String.valueOf(abVar.f()));
                sb.append("&height=");
                sb.append(String.valueOf(abVar.g()));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.at.d(abVar.b()));
            arrayList.add(sb.toString());
        }
        if (arrayList != null && arrayList.size() > 0) {
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("count", this.H.k());
            if (this.H.b() && arrayList.size() == this.H.k()) {
                intent.putExtra("hasnext", true);
                intent.putExtra("nexttitle", this.H.g());
            }
            if (i == 0) {
                intent.putExtra("index", this.H.k() - 1);
            } else if (i == 1) {
                intent.putExtra("index", 0);
            } else {
                intent.putExtra("index", -1);
            }
            sendBroadcast(intent);
        }
    }

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements android.support.v4.view.bq {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.v4.view.bq
        public void b(int i) {
        }

        @Override // android.support.v4.view.bq
        public void a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.bq
        public void a_(int i) {
            ImagePbActivity.this.a(ImagePbActivity.this.K, i);
            ImagePbActivity.this.K = i;
            ImagePbActivity.this.c.setVisibility(4);
            ImagePbActivity.this.c.setClickable(false);
            ImagePbActivity.this.j.setText((CharSequence) null);
            if (ImagePbActivity.this.H != null && ImagePbActivity.this.H.k() > 0) {
                if (i == ImagePbActivity.this.H.k()) {
                    ImagePbActivity.this.j.setVisibility(8);
                    ImagePbActivity.this.g.setText(ImagePbActivity.this.getString(R.string.image_recommend));
                    ImagePbActivity.this.s.setVisibility(8);
                    return;
                }
                ImagePbActivity.this.g.setText(ImagePbActivity.this.F);
                ImagePbActivity.this.j.setVisibility(0);
                ImagePbActivity.this.s.setVisibility(0);
                ImagePbActivity.this.j.setText(String.valueOf(String.valueOf(i + 1)) + "/" + String.valueOf(ImagePbActivity.this.H.k()));
                LinkedList<com.baidu.tieba.data.ab> h = ImagePbActivity.this.H.h();
                if (h != null && ImagePbActivity.this.K < h.size() && h.get(ImagePbActivity.this.K) != null) {
                    ImagePbActivity.this.M = h.get(ImagePbActivity.this.K).d();
                    if (h.get(ImagePbActivity.this.K).i().equals(TiebaApplication.C())) {
                        ImagePbActivity.this.c.setVisibility(0);
                        ImagePbActivity.this.c.setClickable(true);
                    }
                }
            }
            ImagePbActivity.this.N = System.nanoTime();
            ImagePbActivity.this.Q.removeCallbacks(ImagePbActivity.this.R);
            ImagePbActivity.this.Q.postDelayed(ImagePbActivity.this.R, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.m.getText().getSpans(0, this.m.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.m.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            if (this.w != null) {
                this.w.setIfpost(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 11005);
        } else if (this.w != null && this.w.getIfpost() == 0) {
            UtilHelper.a((Context) this, this.w.getForbid_info());
        } else {
            String editable = this.m.getText().toString();
            if (editable != null && editable.length() > 0 && this.H != null) {
                if (o()) {
                    editable = editable.substring(0, 140);
                }
                a(getString(R.string.sending), this.u);
                WriteData writeData = new WriteData();
                writeData.setForumId(this.H.j());
                writeData.setForumName(this.H.i());
                writeData.setContent(editable);
                writeData.setVcode(null);
                writeData.setFloor(this.M);
                writeData.setThreadId(this.E);
                writeData.setFloorNum(0);
                writeData.setType(2);
                this.v = new af(this, writeData);
                this.v.setPriority(3);
                this.v.execute(new Integer[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        a(TiebaApplication.g().getString(R.string.send_success));
        this.m.setText((CharSequence) null);
        GridView gridView = (GridView) findViewById(R.id.face_view);
        if (gridView.getVisibility() == 0) {
            gridView.setVisibility(8);
        }
        UtilHelper.a(this, this.m);
        this.r.setVisibility(8);
        this.s.setVisibility(0);
        this.o.setBackgroundResource(R.drawable.sub_pb_face);
        this.A.e();
    }

    @Override // com.baidu.tieba.j
    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    @Override // com.baidu.tieba.j
    public void i() {
        if (this.h != null) {
            try {
                if (this.h.isShowing()) {
                    this.h.dismiss();
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.h = null;
        }
    }

    private void q() {
        this.m.addTextChangedListener(new s(this));
        this.m.setFilters(new InputFilter[]{new t(this)});
    }

    @Override // com.baidu.tieba.view.a
    public void b_(int i) {
        switch (i) {
            case 0:
                if (this.H.f() != null && this.H.g() != null) {
                    if (this.f1514a != null) {
                        this.f1514a.cancel();
                    }
                    this.E = this.H.f();
                    this.D = this.H.i();
                    this.F = this.H.g();
                    this.K = 0;
                    this.z.a(0, false);
                    this.j.setText((CharSequence) null);
                    this.I = this.H;
                    this.H = new com.baidu.tieba.data.ac();
                    this.P = true;
                    c(true);
                    return;
                }
                return;
            case 1:
                if (this.I != null) {
                    if (this.f1514a != null) {
                        this.f1514a.cancel();
                    }
                    this.H = this.I;
                    this.I = null;
                    this.E = this.H.c();
                    this.D = this.H.i();
                    this.F = this.H.d();
                    this.K = this.H.k() - 1;
                    this.P = false;
                    c(false);
                    this.z.a(this.K, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.O) {
            if (System.nanoTime() - this.N > 300000000 && this.H != null && this.H.h() != null && this.K < this.H.h().size()) {
                this.O.put(this.H.h().get(i).b(), true);
            }
            this.N = System.nanoTime();
            if (this.H.h() != null && i2 < this.H.h().size() && this.O.get(this.H.h().get(i2).b()) == null) {
                this.O.put(this.H.h().get(i2).b(), false);
            }
        }
        if (this.O.size() >= 100) {
            r();
        }
    }

    private void r() {
        if (this.O != null) {
            synchronized (this.O) {
                if (this.O.size() > 0) {
                    int i = 0;
                    for (Map.Entry<String, Boolean> entry : this.O.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            i++;
                        }
                    }
                    TiebaApplication.g().a(i, this.O.size(), "photo");
                    this.O.clear();
                }
            }
        }
    }
}
