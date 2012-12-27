package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.ImagePbPagerAdapter;
import com.baidu.tieba.view.KeyboardLayout;
import com.baidu.tieba.write.WriteImageActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ImagePbActivity extends com.baidu.tieba.e implements com.baidu.tieba.view.a {
    private EditText k;
    private Button l;
    private Button m;
    private GridView n;
    private ab b = null;
    private Button c = null;
    private Button d = null;
    private Button e = null;
    private Button f = null;
    private TextView g = null;
    private TextView h = null;
    private AlertDialog i = null;
    private View j = null;
    private ProgressBar o = null;
    private LinearLayout p = null;
    private LinearLayout q = null;
    private KeyboardLayout r = null;
    private DialogInterface.OnCancelListener s = null;
    private ae t = null;
    private com.baidu.tieba.a.b u = null;
    private int v = 0;
    private af w = null;
    private BaseViewPager x = null;
    private ImagePbPagerAdapter y = null;
    private ad z = null;
    private boolean A = false;
    private String B = null;
    private String C = null;
    private String D = null;
    private int E = 0;
    private com.baidu.tieba.a.u F = null;
    private com.baidu.tieba.a.u G = null;
    private AlertDialog H = null;
    private int I = 0;
    private MyOnPageChangeListener J = null;
    private String K = null;
    private long L = 0;
    private HashMap M = null;
    private boolean N = false;
    private Handler O = null;
    private Runnable P = new j(this);
    private ac Q = new t(this);
    private com.baidu.tieba.view.aa R = new u(this);

    /* loaded from: classes.dex */
    public class MyOnPageChangeListener implements android.support.v4.view.aj {
        public MyOnPageChangeListener() {
        }

        @Override // android.support.v4.view.aj
        public void a(int i) {
            ImagePbActivity.this.a(ImagePbActivity.this.I, i);
            ImagePbActivity.this.I = i;
            ImagePbActivity.this.d.setVisibility(4);
            ImagePbActivity.this.d.setClickable(false);
            ImagePbActivity.this.h.setText((CharSequence) null);
            if (ImagePbActivity.this.F != null && ImagePbActivity.this.F.k() > 0) {
                if (i == ImagePbActivity.this.F.k()) {
                    ImagePbActivity.this.h.setVisibility(8);
                    ImagePbActivity.this.g.setText(ImagePbActivity.this.getString(R.string.image_recommend));
                    ImagePbActivity.this.q.setVisibility(8);
                    return;
                }
                ImagePbActivity.this.g.setText(ImagePbActivity.this.D);
                ImagePbActivity.this.h.setVisibility(0);
                ImagePbActivity.this.q.setVisibility(0);
                ImagePbActivity.this.h.setText(String.valueOf(String.valueOf(i + 1)) + "/" + String.valueOf(ImagePbActivity.this.F.k()));
                LinkedList h = ImagePbActivity.this.F.h();
                if (h != null && ImagePbActivity.this.I < h.size() && h.get(ImagePbActivity.this.I) != null) {
                    ImagePbActivity.this.K = ((com.baidu.tieba.a.t) h.get(ImagePbActivity.this.I)).d();
                    if (((com.baidu.tieba.a.t) h.get(ImagePbActivity.this.I)).i().equals(TiebaApplication.u())) {
                        ImagePbActivity.this.d.setVisibility(0);
                        ImagePbActivity.this.d.setClickable(true);
                    }
                }
            }
            ImagePbActivity.this.L = System.nanoTime();
            ImagePbActivity.this.O.removeCallbacks(ImagePbActivity.this.P);
            ImagePbActivity.this.O.postDelayed(ImagePbActivity.this.P, 300L);
        }

        @Override // android.support.v4.view.aj
        public void a(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.aj
        public void b(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this.M) {
            if (System.nanoTime() - this.L > 300000000 && this.F != null && this.F.h() != null && this.I < this.F.h().size()) {
                this.M.put(((com.baidu.tieba.a.t) this.F.h().get(i)).b(), true);
            }
            this.L = System.nanoTime();
            if (this.F.h() != null && i2 < this.F.h().size() && this.M.get(((com.baidu.tieba.a.t) this.F.h().get(i2)).b()) == null) {
                this.M.put(((com.baidu.tieba.a.t) this.F.h().get(i2)).b(), false);
            }
        }
        if (this.M.size() >= 100) {
            p();
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, ImagePbActivity.class);
        if (str != null && str.length() > 0) {
            intent.putExtra("id", str);
            intent.putExtra("forum", str2);
            intent.putExtra("title", str3);
        }
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        this.O = new Handler();
        this.E = 0;
        if (bundle != null) {
            this.C = bundle.getString("id");
            this.B = bundle.getString("forum");
            this.D = bundle.getString("title");
            this.E = bundle.getInt("current_page");
        } else {
            this.C = getIntent().getStringExtra("id");
            this.B = getIntent().getStringExtra("forum");
            this.D = getIntent().getStringExtra("title");
        }
        this.F.a(this.C);
        this.F.b(this.D);
        this.g.setText(this.D);
        this.y = new ImagePbPagerAdapter(this);
        this.y.a(this.Q);
        this.y.a(this.C);
        this.x.setAdapter(this.y);
        this.J = new MyOnPageChangeListener();
        this.x.setOnPageChangeListener(this.J);
        this.x.setCurrentItem(this.E);
        if (this.B != null && this.B.length() > 0 && this.C != null && this.C.length() > 0) {
            a((String) null, 0, 9, true);
        }
        this.M = new HashMap();
        a(this.I, this.I);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 int)] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2, boolean z) {
        com.baidu.tieba.c.ae.a(getClass().getName(), str, new StringBuilder().append(i2).toString());
        if (this.F.a()) {
            return;
        }
        if (this.b != null) {
            this.b.a();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("kw", this.B));
        arrayList.add(new BasicNameValuePair("tid", this.C));
        if (str != null) {
            arrayList.add(new BasicNameValuePair("pic_id", str));
        }
        arrayList.add(new BasicNameValuePair("prev", String.valueOf(i)));
        arrayList.add(new BasicNameValuePair("next", String.valueOf(i2)));
        if (this.N) {
            this.N = false;
            arrayList.add(new BasicNameValuePair("st_type", "commend_pic_page"));
        }
        a(true);
        com.baidu.tieba.c.ae.a(getClass().getName(), "startImagePbAsyncTask", str);
        this.b = new ab(this, "http://c.tieba.baidu.com/c/f/pb/picpage".toString(), arrayList, z);
        this.b.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.o == null) {
            return;
        }
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Intent intent = new Intent("com.baidu.tieba.broadcast.imagepb.pageadded");
        LinkedList h = this.F.h();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < h.size(); i2++) {
            com.baidu.tieba.a.t tVar = (com.baidu.tieba.a.t) h.get(i2);
            StringBuffer stringBuffer = new StringBuffer(100);
            if (tVar.g() * tVar.f() > com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) {
                double sqrt = Math.sqrt((com.baidu.tieba.a.h.g() * com.baidu.tieba.a.h.g()) / (tVar.g() * tVar.f()));
                stringBuffer.append("width=");
                stringBuffer.append(String.valueOf((int) (tVar.f() * sqrt)));
                stringBuffer.append("&height=");
                stringBuffer.append(String.valueOf((int) (sqrt * tVar.g())));
            } else {
                stringBuffer.append("width=");
                stringBuffer.append(String.valueOf(tVar.f()));
                stringBuffer.append("&height=");
                stringBuffer.append(String.valueOf(tVar.g()));
            }
            stringBuffer.append("&src=");
            stringBuffer.append(com.baidu.tieba.c.ad.f(tVar.b()));
            arrayList.add(stringBuffer.toString());
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        intent.putStringArrayListExtra("url", arrayList);
        intent.putExtra("count", this.F.k());
        if (this.F.b() && arrayList.size() == this.F.k()) {
            intent.putExtra("hasnext", true);
            intent.putExtra("nexttitle", this.F.g());
        }
        if (i == 0) {
            intent.putExtra("index", this.F.k() - 1);
        } else if (i == 1) {
            intent.putExtra("index", 0);
        } else {
            intent.putExtra("index", -1);
        }
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (!z) {
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            this.q.setVisibility(0);
            com.baidu.tieba.c.ag.a(this, this.k);
            return;
        }
        this.k.requestFocus();
        this.p.setVisibility(0);
        this.n.setVisibility(8);
        com.baidu.tieba.c.ag.b(this, this.k);
        this.m.setBackgroundResource(R.drawable.sub_pb_face);
        this.q.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            if (this.u != null) {
                this.u.a(1);
            }
            LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100005);
        } else if (this.u != null && this.u.a() == 0) {
            com.baidu.tieba.c.ag.a((Context) this, this.u.e());
        } else {
            String editable = this.k.getText().toString();
            if (editable == null || editable.length() <= 0 || this.F == null) {
                return;
            }
            if (m()) {
                editable = editable.substring(0, 140);
            }
            a(getString(R.string.sending), this.s);
            com.baidu.tieba.b.u uVar = new com.baidu.tieba.b.u();
            uVar.e(String.valueOf(this.F.j()));
            uVar.f(this.F.i());
            uVar.b(editable);
            uVar.g(null);
            uVar.d(this.K);
            uVar.c(this.C);
            uVar.b(0);
            uVar.a(2);
            this.t = new ae(this, uVar);
            this.t.execute(new Integer[0]);
        }
    }

    private void c(boolean z) {
        this.O.removeCallbacks(this.P);
        com.baidu.tieba.c.a d = this.y.d();
        if (d != null) {
            d.b();
        }
        if (!z) {
            String str = this.D;
            if (this.D != null) {
                if (this.D.length() > 6) {
                    str = String.valueOf(this.D.substring(0, 6)) + getString(R.string.three_point);
                }
                b(getString(R.string.image_pb_imagethread).replace("?", str));
            }
        }
        this.F.a(this.C);
        this.F.b(this.D);
        this.g.setText(this.D);
        this.y.b();
        this.y.a(this.C);
        this.y.a(this.F);
        this.y.notifyDataSetChanged();
        this.y.a();
        if (!z || this.B == null || this.B.length() <= 0 || this.C == null || this.C.length() <= 0) {
            b(0);
        } else {
            a((String) null, 0, 9, true);
        }
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
        a(this.I, this.I);
    }

    private void g() {
        this.z = new ad(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.imagepb.pagechanged");
        registerReceiver(this.z, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.i == null) {
            this.i = new AlertDialog.Builder(this).create();
            this.i.setCanceledOnTouchOutside(true);
            this.j = getLayoutInflater().inflate(R.layout.pb_title_dialog, (ViewGroup) null);
        }
    }

    private void i() {
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new v(this));
        this.d = (Button) findViewById(R.id.camera);
        this.d.setOnClickListener(new w(this));
        this.e = (Button) findViewById(R.id.reply);
        this.e.setOnClickListener(new x(this));
        this.f = (Button) findViewById(R.id.save);
        this.f.setOnClickListener(new y(this));
        this.g = (TextView) findViewById(R.id.title_text);
        this.g.setOnClickListener(new z(this));
        this.h = (TextView) findViewById(R.id.title_page);
        this.x = (BaseViewPager) findViewById(R.id.content_view);
        this.x.setOnScrollOutListener(this);
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new aa(this));
        this.p = (LinearLayout) findViewById(R.id.layout_reply);
        this.k = (EditText) findViewById(R.id.reply_content);
        this.m = (Button) findViewById(R.id.button_face);
        this.l = (Button) findViewById(R.id.reply_button);
        this.l.setEnabled(false);
        o();
        this.n = (GridView) findViewById(R.id.face_view);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        this.n.setAdapter((ListAdapter) mVar);
        this.n.setOnItemClickListener(new l(this, mVar));
        this.r = (KeyboardLayout) findViewById(R.id.image_pb_layout);
        this.r.setOnkbdStateListener(this.R);
        this.l.setOnClickListener(new m(this));
        this.m.setOnClickListener(new o(this, new Handler(), new n(this)));
        this.q = (LinearLayout) findViewById(R.id.image_pb_bottom);
        this.k.setOnTouchListener(new p(this));
        this.o = (ProgressBar) findViewById(R.id.image_pb_progress);
        this.s = new q(this);
        if (this.H == null) {
            this.H = builder.create();
            this.H.setCanceledOnTouchOutside(true);
        }
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ArrayList arrayList = new ArrayList(0);
        arrayList.add(new BasicNameValuePair("fname", this.B));
        arrayList.add(new BasicNameValuePair("tid", this.C));
        if (this.F != null) {
            arrayList.add(new BasicNameValuePair("fid", String.valueOf(this.F.j())));
        }
        if (this.y.d() != null) {
            this.y.d().a(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.w != null) {
            this.w.a();
        }
        this.w = new af(this, null);
        this.w.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String u = TiebaApplication.u();
        if (u != null && u.length() > 0) {
            if (this.F != null) {
                this.H.show();
                return;
            }
            return;
        }
        if (this.F != null && this.F.e() != null) {
            this.F.e().a(1);
        }
        LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100016);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.k.getText().getSpans(0, this.k.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.k.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        b(TiebaApplication.a().getString(R.string.send_success));
        this.k.setText((CharSequence) null);
        GridView gridView = (GridView) findViewById(R.id.face_view);
        if (gridView.getVisibility() == 0) {
            gridView.setVisibility(8);
        }
        com.baidu.tieba.c.ag.a(this, this.k);
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        this.m.setBackgroundResource(R.drawable.sub_pb_face);
        this.y.e();
    }

    private void o() {
        this.k.addTextChangedListener(new r(this));
        this.k.setFilters(new InputFilter[]{new s(this)});
    }

    private void p() {
        if (this.M == null) {
            return;
        }
        synchronized (this.M) {
            if (this.M.size() > 0) {
                int i = 0;
                for (Map.Entry entry : this.M.entrySet()) {
                    if (((Boolean) entry.getValue()).booleanValue()) {
                        i++;
                    }
                }
                TiebaApplication.a().a(i, this.M.size(), "photo");
                this.M.clear();
            }
        }
    }

    @Override // com.baidu.tieba.view.a
    public void a(int i) {
        switch (i) {
            case 0:
                if (this.F.f() == null || this.F.g() == null) {
                    return;
                }
                if (this.b != null) {
                    this.b.a();
                }
                this.C = this.F.f();
                this.B = this.F.i();
                this.D = this.F.g();
                this.I = 0;
                this.x.a(0, false);
                this.h.setText((CharSequence) null);
                this.G = this.F;
                this.F = new com.baidu.tieba.a.u();
                this.N = true;
                c(true);
                return;
            case 1:
                if (this.G != null) {
                    if (this.b != null) {
                        this.b.a();
                    }
                    this.F = this.G;
                    this.G = null;
                    this.C = this.F.c();
                    this.B = this.F.i();
                    this.D = this.F.d();
                    this.I = this.F.k() - 1;
                    this.N = false;
                    c(false);
                    this.x.a(this.I, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.e
    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    @Override // com.baidu.tieba.e
    public void c() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0030: INVOKE  (r3v2 int A[REMOVE]) = (r15v0 android.content.Intent), ("index"), (0 int) type: VIRTUAL call: android.content.Intent.getIntExtra(java.lang.String, int):int)] */
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1100005:
                    c(this.v);
                    return;
                case 1100016:
                    this.H.show();
                    return;
                case 1200001:
                    if (this.F == null || this.F.i() == null || this.B == null) {
                        return;
                    }
                    WriteImageActivity.a(this, 1200001, 12000010, null, String.valueOf(this.F.j()), this.B, this.C, null);
                    return;
                case 1200002:
                    if (this.F == null || this.F.i() == null || this.B == null) {
                        return;
                    }
                    if (intent == null || intent.getData() == null) {
                        com.baidu.tieba.write.ba.b(this);
                        return;
                    } else {
                        WriteImageActivity.a(this, 1200002, 1200008, intent.getData(), String.valueOf(this.F.j()), this.B, this.C, null);
                        return;
                    }
                case 1200005:
                    if (intent.getSerializableExtra("model") != null) {
                        n();
                        return;
                    }
                    return;
                case 1400001:
                    if (intent == null || intent.getIntExtra("index", -1) < 0) {
                        return;
                    }
                    com.baidu.tieba.c.ae.a(getClass().getName(), "onActivityResult", new StringBuilder().append(intent.getIntExtra("index", 0)).toString());
                    this.x.a(intent.getIntExtra("index", 0), false);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.image_pb_activity);
        this.F = new com.baidu.tieba.a.u(this);
        i();
        a(bundle);
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        a(this.I, this.I);
        p();
        if (this.w != null) {
            this.w.a();
        }
        if (this.o != null) {
            this.o.setVisibility(8);
        }
        if (this.t != null) {
            this.t.a();
        }
        if (this.b != null) {
            this.b.a();
        }
        if (this.i != null && this.i.isShowing()) {
            this.i.dismiss();
        }
        this.y.c();
        unregisterReceiver(this.z);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.O.removeCallbacks(this.P);
        com.baidu.tieba.c.a d = this.y.d();
        if (d != null) {
            d.b();
        }
        this.A = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.O.removeCallbacks(this.P);
        this.O.post(this.P);
        this.A = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.C);
        bundle.putString("forum", this.B);
        bundle.putInt("current_page", this.E);
        bundle.putString("title", this.D);
    }
}
