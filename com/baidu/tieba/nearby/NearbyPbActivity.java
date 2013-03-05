package com.baidu.tieba.nearby;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.zeus.WebChromeClient;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NearbyPbActivity extends com.baidu.tieba.e {
    private static volatile long C = 0;
    private static volatile long D = 0;
    private static volatile int E = 0;
    private RelativeLayout c = null;
    private ListView d = null;
    private Button e = null;
    private Button f = null;
    private Button g = null;
    private Button h = null;
    private EditText i = null;
    private GridView j = null;
    private DialogInterface.OnCancelListener k = null;
    private ae l = null;
    private af m = null;
    private ab n = null;
    private com.baidu.tieba.b.q o = null;
    private String p = null;
    private ProgressBar q = null;
    private Handler r = new Handler();
    private View.OnClickListener s = null;
    private LinearLayout t = null;
    private LinearLayout u = null;
    private String v = null;
    private int w = -1;
    private String x = null;
    private boolean y = false;
    private String z = null;
    private String A = null;
    private com.baidu.tieba.b.y B = null;
    private Runnable F = new k(this);

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, NearbyPbActivity.class);
        if (str2 != null) {
            intent.putExtra("st_type", str2);
        }
        intent.putExtra("is_reply", z);
        if (str != null) {
            intent.putExtra("id", str);
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, String str, String str2, boolean z, int i) {
        Intent intent = new Intent(activity, NearbyPbActivity.class);
        if (str2 != null) {
            intent.putExtra("st_type", str2);
        }
        intent.putExtra("is_reply", z);
        if (str != null) {
            intent.putExtra("id", str);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_pb_activity);
        this.x = TiebaApplication.x();
        m();
        a(bundle);
    }

    private void m() {
        this.c = (RelativeLayout) findViewById(R.id.parent);
        this.t = (LinearLayout) findViewById(R.id.title);
        this.u = (LinearLayout) findViewById(R.id.layout_reply);
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(new t(this));
        this.g = (Button) findViewById(R.id.share);
        this.g.setOnClickListener(new u(this));
        this.e = (Button) findViewById(R.id.reply_button);
        this.e.setEnabled(false);
        this.e.setOnClickListener(new v(this));
        this.q = (ProgressBar) findViewById(R.id.progress);
        this.q.setVisibility(8);
        this.s = new w(this);
        this.d = (ListView) findViewById(R.id.pb_list);
        this.d.setFastScrollEnabled(true);
        this.m = new af(this, null, com.baidu.tieba.c.ai.a((Context) this) - com.baidu.tieba.c.ai.a(this, 34.0f), this.s);
        this.m.c(TiebaApplication.b().ae());
        this.m.c(true);
        this.m.b(0);
        this.m.a(0);
        this.d.setAdapter((ListAdapter) this.m);
        this.d.setOnItemClickListener(new x(this));
        this.d.setOnScrollListener(new y(this));
        this.d.setOnItemLongClickListener(new z(this));
        this.i = (EditText) findViewById(R.id.reply_content);
        Handler handler = new Handler();
        this.j = (GridView) findViewById(R.id.face_view);
        this.h = (Button) findViewById(R.id.button_face);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        this.j.setAdapter((ListAdapter) mVar);
        this.j.setOnItemClickListener(new aa(this, mVar));
        this.h.setOnClickListener(new o(this, handler, new n(this)));
        this.i.setOnTouchListener(new p(this));
        this.k = new q(this);
        r();
    }

    private void a(Bundle bundle) {
        this.y = false;
        this.o = new com.baidu.tieba.b.q();
        if (bundle != null) {
            this.p = bundle.getString("id");
            this.v = bundle.getString("st_type");
            this.y = bundle.getBoolean("is_reply");
        } else {
            Intent intent = getIntent();
            this.p = intent.getStringExtra("id");
            this.v = intent.getStringExtra("st_type");
            this.y = intent.getBooleanExtra("is_reply", false);
        }
        this.o.a(true);
        this.o.g(false);
        this.o.b(true);
        this.o.c(false);
        this.o.i(false);
        e(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void a() {
        i();
        if (this.z != null && this.A != null) {
            Intent intent = new Intent();
            intent.putExtra("reply_content", this.z);
            intent.putExtra("reply_tid", this.A);
            setResult(-1, intent);
        }
        super.a();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        if (i == 4) {
            a();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.r.removeCallbacks(this.F);
        try {
            if (this.n != null) {
                this.n.a();
                this.n = null;
            }
            if (this.m != null) {
                this.m.a();
                this.m.b().b();
            }
            if (this.o != null && this.o.a() != null) {
                this.o.a((com.baidu.tieba.a.ai) null);
            }
            i();
            this.q.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.p);
        if (this.v != null) {
            bundle.putString("st_type", this.v);
        }
    }

    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.m != null && this.m.h() != TiebaApplication.b().ae()) {
            this.m.c(TiebaApplication.b().ae());
            this.m.notifyDataSetChanged();
        }
        if (this.o != null) {
            String x = TiebaApplication.x();
            if (this.x == null && x != null && x.length() > 0) {
                this.x = x;
                if (this.o.a() != null && this.o.a().f() != null) {
                    this.o.a().f().a(1);
                }
            }
        }
        if (this.m != null) {
            this.m.notifyDataSetChanged();
        }
        this.F.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.m.b().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.c(this.t, i);
        com.baidu.tieba.c.ae.e((TextView) this.f, i);
        com.baidu.tieba.c.ae.c(this.d, i);
        this.m.notifyDataSetChanged();
        if (i == 1) {
            com.baidu.tieba.c.ae.i(this.u, R.drawable.sub_pb_reply_bg_1);
            this.c.setBackgroundColor(-13158601);
            this.e.setTextColor(-2236963);
            return;
        }
        com.baidu.tieba.c.ae.i(this.u, R.drawable.sub_pb_reply_bg);
        this.c.setBackgroundColor(-1380623);
        this.e.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog n() {
        if (e() != null && e().isShowing()) {
            return e();
        }
        return a(new String[]{getString(R.string.copy)}, new r(this));
    }

    private void d(int i) {
        ArrayList d;
        if (this.o != null && this.o.a() != null && (d = this.o.a().d()) != null && d.size() > 0) {
            if (i == 0) {
                e(2);
            } else {
                e(1);
            }
            if (this.n != null) {
                if (i == 0) {
                    this.m.b(true);
                } else {
                    this.m.a(true);
                }
                this.m.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.p));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(30)));
            arrayList.add(new BasicNameValuePair("weipost", "1"));
            if (this.p != null && this.p.length() > 0) {
                if (i == 2) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(1)));
                    arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.l() + (-1) < 0 ? 1 : this.o.l() - 1)).toString()));
                    ArrayList d = this.o.a().d();
                    if (d != null && d.size() > 0) {
                        int size = d.size();
                        String a = ((com.baidu.tieba.a.al) d.get(0)).a();
                        if (a != null && a.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a));
                        }
                        if (size > com.baidu.tieba.a.i.b() - 30) {
                            for (int i2 = 1; i2 <= size - (com.baidu.tieba.a.i.b() - 30) && size - i2 >= 0; i2++) {
                                d.remove(size - i2);
                            }
                            this.m.b(2);
                            this.m.notifyDataSetChanged();
                        }
                    }
                } else if (i == 1) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    ArrayList d2 = this.o.a().d();
                    if (d2 != null && d2.size() > 0) {
                        int size2 = d2.size();
                        String a2 = ((com.baidu.tieba.a.al) d2.get(size2 - 1)).a();
                        if (a2 != null && a2.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", a2));
                        }
                        if (size2 > com.baidu.tieba.a.i.b() - 30) {
                            for (int b = com.baidu.tieba.a.i.b() - 30; b < size2; b++) {
                                d2.remove(0);
                            }
                            this.m.a(2);
                            this.m.notifyDataSetChanged();
                        }
                    }
                    if (this.o.k() < this.o.a().e().a()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.o.k() + 1)).toString()));
                        this.o.h(false);
                    } else {
                        this.o.h(true);
                    }
                } else if (i == 3) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    arrayList.add(new BasicNameValuePair("pn", "1"));
                    if (this.o != null && this.o.a() != null) {
                        this.o.a().d().clear();
                        this.m.notifyDataSetChanged();
                    }
                    this.m.b(0);
                    this.m.a(0);
                    if (this.v != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.v));
                    }
                    this.q.setVisibility(0);
                }
                this.n = new ab(this, stringBuffer.toString(), arrayList, i);
                this.n.execute(stringBuffer.toString(), arrayList);
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("NearbyPbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            String x = TiebaApplication.x();
            if (x == null || x.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100024);
                return;
            }
            String editable = this.i.getText().toString();
            if (editable != null && editable.length() > 0 && this.p != null && this.p.length() > 0) {
                if (s()) {
                    editable = editable.substring(0, 140);
                }
                if (this.o != null && this.o.a() != null) {
                    a(getString(R.string.sending), this.k);
                    com.baidu.tieba.b.y yVar = new com.baidu.tieba.b.y();
                    yVar.e(this.o.a().a().b());
                    yVar.f(this.o.a().a().c());
                    yVar.b(editable);
                    yVar.g(null);
                    yVar.d(null);
                    yVar.c(this.p);
                    yVar.b(0);
                    yVar.a(1);
                    this.l = new ae(this, yVar);
                    this.l.execute(new Integer[0]);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("NearbyPbActivity", "reply", "error" + e.getMessage());
        }
    }

    private void r() {
        this.i.addTextChangedListener(new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.i.getText().getSpans(0, this.i.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.i.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        b(TiebaApplication.b().getString(R.string.send_success));
        this.i.setText((CharSequence) null);
        if (this.j.getVisibility() == 0) {
            this.j.setVisibility(8);
        }
        com.baidu.tieba.c.ai.a(this, this.i);
        this.h.setBackgroundResource(R.drawable.sub_pb_face);
        this.m.b(2);
        this.m.notifyDataSetChanged();
        if (!this.m.e()) {
            o();
        }
        this.z = this.B.c();
        this.A = this.B.d();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100024:
                    q();
                    return;
                case 1200005:
                    t();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            if (this.o != null && this.o.a() != null && this.o.a().d() != null) {
                this.m.a(this.o);
                this.m.notifyDataSetChanged();
            }
            if (this.y) {
                a(this.i, WebChromeClient.STRING_DLG_BTN_SET);
                this.y = false;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("NearbyPbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }
}
