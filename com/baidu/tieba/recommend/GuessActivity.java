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
import com.baidu.tieba.a.at;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
import com.baidu.tieba.c.ai;
import com.baidu.tieba.pb.PbActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class GuessActivity extends com.baidu.tieba.e {
    private static volatile long n = 0;
    private static volatile long o = 0;
    private static volatile int p = 0;
    private int d = 3;
    private int e = 1;
    private String f = null;
    private boolean g = false;
    private String h = null;
    private ListView i = null;
    private l j = null;
    private k k = null;
    private com.baidu.tieba.b.e l = null;
    private ProgressBar m = null;
    AlertDialog c = null;
    private Handler q = null;
    private com.baidu.tieba.c.a r = null;
    private Runnable s = new a(this);
    private AdapterView.OnItemLongClickListener t = new c(this);

    private void n() {
        this.r = new com.baidu.tieba.c.a(this);
        this.r.b(true);
        int a = ai.a(this, 234.0f);
        int i = a <= 350 ? a : 350;
        this.r.a(i, (int) (i * 1.62f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guess_activity);
        this.q = new Handler();
        n();
        o();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        ae.b(this.i, i);
        this.j.notifyDataSetChanged();
    }

    public void i() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.q != null) {
            this.q.removeCallbacks(this.s);
        }
        super.onDestroy();
        try {
            if (this.k != null) {
                this.k.a();
                this.k = null;
            }
            if (this.j != null) {
                this.j.d();
            }
            if (this.m != null) {
                this.m.setVisibility(8);
            }
            System.gc();
        } catch (Exception e) {
            ag.b(getClass().getName(), "onDestroy", e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(TiebaApplication.b().w());
        if (!this.g && System.currentTimeMillis() - valueOf.longValue() > com.baidu.tieba.a.i.c.longValue()) {
            j();
        } else {
            this.s.run();
        }
    }

    private void o() {
        this.e = 1;
        this.d = 3;
        this.i = (ListView) findViewById(R.id.home_lv_guess);
        this.j = new l(this, null, ai.a((Context) this));
        this.j.b(new d(this));
        this.j.a(new e(this));
        this.i.setAdapter((ListAdapter) this.j);
        this.i.setOnItemClickListener(new g(this));
        this.i.setOnItemLongClickListener(this.t);
        this.m = (ProgressBar) findViewById(R.id.recommend_progress);
        a(false);
        this.i.setOnScrollListener(new i(this));
    }

    private boolean a(at atVar) {
        String a;
        return atVar == null || atVar.h() == null || (a = atVar.h().a()) == null || a.equals("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(at atVar) {
        boolean a = a(atVar);
        j jVar = new j(this, atVar);
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
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(at atVar) {
        boolean a = a(atVar);
        if (this.f != null) {
            if (!a) {
                PbActivity.a(this, this.f, true, true, null, false);
            } else {
                PbActivity.a(this, this.f, false, false, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f != null) {
            PbActivity.a(this, this.f, false, false, null, false);
        }
    }

    public void j() {
        this.e = 1;
        this.d = 3;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.g = z;
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    private boolean q() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        switch (this.d) {
            case 1:
                if (this.j.b()) {
                    return;
                }
                break;
            case 2:
                if (this.j.c()) {
                    return;
                }
                break;
            case 3:
                if (q()) {
                    return;
                }
                break;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/s/hotfeed");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.e)));
        arrayList.add(new BasicNameValuePair("rn", String.valueOf(35)));
        if (this.h != null) {
            arrayList.add(new BasicNameValuePair("from", this.h));
        }
        t();
        this.k = new k(this, stringBuffer.toString(), arrayList, this.d);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        ArrayList a;
        this.i.setVisibility(0);
        try {
            if (this.l != null && (a = this.l.a()) != null) {
                this.j.a(a);
                if (this.e > 1) {
                    this.j.c(true);
                } else {
                    this.j.c(false);
                }
                if (this.l.b().c() == 1) {
                    this.j.d(true);
                } else {
                    this.j.d(false);
                }
                this.j.a(false);
                this.j.b(false);
                this.j.notifyDataSetInvalidated();
                if (this.d == 1) {
                    this.i.setSelection(1);
                } else {
                    this.i.setSelection(0);
                }
                a(false);
            }
        } catch (Exception e) {
            ag.b(getClass().getName(), "", "GuessActivity.refreshGuess error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j.a().b();
    }

    private void t() {
        if (this.k != null) {
            this.k.a();
            this.k = null;
        }
        a(false);
        this.j.a(false);
        this.j.b(false);
        this.j.notifyDataSetChanged();
    }

    @Override // android.app.Activity
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        return getParent() instanceof ActivityGroup ? getParent().onSearchRequested() : super.onSearchRequested();
    }
}
