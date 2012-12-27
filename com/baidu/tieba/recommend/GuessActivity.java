package com.baidu.tieba.recommend;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.as;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.pb.PbActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class GuessActivity extends com.baidu.tieba.e {
    private static volatile long m = 0;
    private static volatile long n = 0;
    private static volatile int o = 0;
    private int c = 3;
    private int d = 1;
    private String e = null;
    private boolean f = false;
    private String g = null;
    private ListView h = null;
    private l i = null;
    private k j = null;
    private com.baidu.tieba.b.e k = null;
    private ProgressBar l = null;
    AlertDialog b = null;
    private Handler p = null;
    private com.baidu.tieba.c.a q = null;
    private Runnable r = new a(this);
    private AdapterView.OnItemLongClickListener s = new c(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    private boolean a(as asVar) {
        String a;
        return asVar == null || asVar.h() == null || (a = asVar.h().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(as asVar) {
        boolean a = a(asVar);
        j jVar = new j(this, asVar);
        String string = getString(R.string.view);
        String string2 = getString(R.string.view_host);
        String string3 = getString(R.string.view_reverse);
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        builder.setTitle(R.string.operation);
        if (a) {
            builder.setItems(new String[]{string, string3}, jVar);
        } else {
            builder.setItems(new String[]{string, string2, string3}, jVar);
        }
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar) {
        boolean a = a(asVar);
        if (this.e != null) {
            if (a) {
                PbActivity.a(this, this.e, false, false, null, false);
            } else {
                PbActivity.a(this, this.e, true, true, null, false);
            }
        }
    }

    private void l() {
        this.q = new com.baidu.tieba.c.a(this);
        this.q.b(true);
        int a = ag.a((Context) this, 234.0f);
        int i = a <= 350 ? a : 350;
        this.q.a(i, (int) (i * 1.62f));
    }

    private void m() {
        this.d = 1;
        this.c = 3;
        this.h = (ListView) findViewById(R.id.home_lv_guess);
        this.i = new l(this, null, ag.a((Context) this));
        this.i.b(new d(this));
        this.i.a(new e(this));
        this.h.setAdapter((ListAdapter) this.i);
        this.h.setOnItemClickListener(new g(this));
        this.h.setOnItemLongClickListener(this.s);
        this.l = (ProgressBar) findViewById(R.id.recommend_progress);
        a(false);
        this.h.setOnScrollListener(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.e != null) {
            PbActivity.a(this, this.e, false, false, null, false);
        }
    }

    private boolean o() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        switch (this.c) {
            case 1:
                if (this.i.b()) {
                    return;
                }
                break;
            case 2:
                if (this.i.c()) {
                    return;
                }
                break;
            case 3:
                if (o()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/s/hotfeed");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.d)));
        arrayList.add(new BasicNameValuePair("rn", String.valueOf(35)));
        if (this.g != null) {
            arrayList.add(new BasicNameValuePair("from", this.g));
        }
        r();
        this.j = new k(this, stringBuffer.toString(), arrayList, this.c);
        this.j.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ArrayList a;
        this.h.setVisibility(0);
        try {
            if (this.k == null || (a = this.k.a()) == null) {
                return;
            }
            this.i.a(a);
            if (this.d > 1) {
                this.i.c(true);
            } else {
                this.i.c(false);
            }
            if (this.k.b().c() == 1) {
                this.i.d(true);
            } else {
                this.i.d(false);
            }
            this.i.a(false);
            this.i.b(false);
            this.i.notifyDataSetInvalidated();
            if (this.c == 1) {
                this.h.setSelection(1);
            } else {
                this.h.setSelection(0);
            }
            a(false);
        } catch (Exception e) {
            ae.b(getClass().getName(), "", "GuessActivity.refreshGuess error = " + e.getMessage());
        }
    }

    private void r() {
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        a(false);
        this.i.a(false);
        this.i.b(false);
        this.i.notifyDataSetChanged();
    }

    public void g() {
        if (this.b != null) {
            this.b.dismiss();
        }
    }

    public void h() {
        this.d = 1;
        this.c = 3;
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guess_activity);
        this.p = new Handler();
        l();
        m();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.p != null) {
            this.p.removeCallbacks(this.r);
        }
        super.onDestroy();
        try {
            if (this.j != null) {
                this.j.a();
                this.j = null;
            }
            if (this.i != null) {
                this.i.d();
            }
            if (this.l != null) {
                this.l.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
            ae.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.i.a().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.a().t());
        if (this.f || System.currentTimeMillis() - valueOf.longValue() <= com.baidu.tieba.a.h.c.longValue()) {
            this.r.run();
        } else {
            h();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }
}
