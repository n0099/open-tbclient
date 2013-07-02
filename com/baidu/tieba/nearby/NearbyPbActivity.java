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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.model.WriteModel;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NearbyPbActivity extends com.baidu.tieba.g {
    private static volatile long B = 0;
    private static volatile long C = 0;
    private static volatile int D = 0;
    private RelativeLayout a = null;
    private ListView b = null;
    private Button c = null;
    private ImageView d = null;
    private Button e = null;
    private EditText f = null;
    private GridView g = null;
    private DialogInterface.OnCancelListener j = null;
    private ad k = null;
    private ae l = null;
    private aa m = null;
    private com.baidu.tieba.model.bg n = null;
    private String o = null;
    private ProgressBar p = null;
    private Handler q = new Handler();
    private View.OnClickListener r = null;
    private LinearLayout s = null;
    private LinearLayout t = null;
    private String u = null;
    private int v = -1;
    private String w = null;
    private boolean x = false;
    private String y = null;
    private String z = null;
    private WriteModel A = null;
    private Runnable E = new k(this);

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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_pb_activity);
        this.w = TiebaApplication.E();
        n();
        a(bundle);
    }

    private void n() {
        this.a = (RelativeLayout) findViewById(R.id.parent);
        this.s = (LinearLayout) findViewById(R.id.title);
        this.t = (LinearLayout) findViewById(R.id.layout_reply);
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new s(this));
        this.c = (Button) findViewById(R.id.reply_button);
        this.c.setEnabled(false);
        this.c.setOnClickListener(new t(this));
        this.p = (ProgressBar) findViewById(R.id.progress);
        this.p.setVisibility(8);
        this.r = new u(this);
        this.b = (ListView) findViewById(R.id.pb_list);
        this.b.setFastScrollEnabled(true);
        this.l = new ae(this, null, com.baidu.tieba.util.ab.a((Context) this) - com.baidu.tieba.util.ab.a(this, 34.0f), this.r);
        this.l.c(TiebaApplication.f().aq());
        this.l.c(true);
        this.l.b(0);
        this.l.a(0);
        this.b.setAdapter((ListAdapter) this.l);
        this.b.setOnItemClickListener(new v(this));
        this.b.setOnScrollListener(new w(this));
        this.b.setOnItemLongClickListener(new x(this));
        this.f = (EditText) findViewById(R.id.reply_content);
        Handler handler = new Handler();
        this.g = (GridView) findViewById(R.id.face_view);
        this.e = (Button) findViewById(R.id.button_face);
        com.baidu.tieba.write.m mVar = new com.baidu.tieba.write.m(this);
        this.g.setAdapter((ListAdapter) mVar);
        this.g.setOnItemClickListener(new y(this, mVar));
        this.e.setOnClickListener(new n(this, handler, new z(this)));
        this.f.setOnTouchListener(new o(this));
        this.j = new p(this);
        s();
    }

    private void a(Bundle bundle) {
        this.x = false;
        this.n = new com.baidu.tieba.model.bg();
        if (bundle != null) {
            this.o = bundle.getString("id");
            this.u = bundle.getString("st_type");
            this.x = bundle.getBoolean("is_reply");
        } else {
            Intent intent = getIntent();
            this.o = intent.getStringExtra("id");
            this.u = intent.getStringExtra("st_type");
            this.x = intent.getBooleanExtra("is_reply", false);
        }
        this.n.a(true);
        this.n.d(false);
        this.n.b(true);
        this.n.c(false);
        e(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void f() {
        b();
        if (this.y != null && this.z != null) {
            Intent intent = new Intent();
            intent.putExtra("reply_content", this.y);
            intent.putExtra("reply_tid", this.z);
            setResult(-1, intent);
        }
        super.f();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        if (i == 4) {
            f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.removeCallbacks(this.E);
        try {
            if (this.m != null) {
                this.m.cancel();
                this.m = null;
            }
            if (this.l != null) {
                this.l.a();
                this.l.b().b();
            }
            if (this.n != null && this.n.a() != null) {
                this.n.a((com.baidu.tieba.data.aj) null);
            }
            b();
            this.p.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.util.z.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.o);
        if (this.u != null) {
            bundle.putString("st_type", this.u);
        }
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.l != null && this.l.h() != TiebaApplication.f().aq()) {
            this.l.c(TiebaApplication.f().aq());
            this.l.notifyDataSetChanged();
        }
        if (this.n != null) {
            String E = TiebaApplication.E();
            if (this.w == null && E != null && E.length() > 0) {
                this.w = E;
                if (this.n.a() != null && this.n.a().f() != null) {
                    this.n.a().f().setIfpost(1);
                }
            }
        }
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        this.E.run();
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.b().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.x.d(this.s, i);
        com.baidu.tieba.util.x.a(this.d, i);
        com.baidu.tieba.util.x.b(this.b, i);
        this.l.notifyDataSetChanged();
        if (i == 1) {
            com.baidu.tieba.util.x.h(this.t, (int) R.drawable.sub_pb_reply_bg_1);
            this.a.setBackgroundColor(-13158601);
            this.c.setTextColor(-2236963);
            return;
        }
        com.baidu.tieba.util.x.h(this.t, (int) R.drawable.sub_pb_reply_bg);
        this.a.setBackgroundColor(-1380623);
        this.c.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog o() {
        if (i() != null && i().isShowing()) {
            return i();
        }
        return a(new String[]{getString(R.string.copy)}, new q(this));
    }

    private void d(int i) {
        ArrayList d;
        if (this.n != null && this.n.a() != null && (d = this.n.a().d()) != null && d.size() > 0) {
            if (i == 0) {
                e(2);
            } else {
                e(1);
            }
            if (this.m != null) {
                if (i == 0) {
                    this.l.b(true);
                } else {
                    this.l.a(true);
                }
                this.l.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.g.a);
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.o));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(30)));
            arrayList.add(new BasicNameValuePair("weipost", "1"));
            if (this.o != null && this.o.length() > 0) {
                if (i == 2) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(1)));
                    arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.d() + (-1) < 0 ? 1 : this.n.d() - 1)).toString()));
                    ArrayList d = this.n.a().d();
                    if (d != null && d.size() > 0) {
                        int size = d.size();
                        String d2 = ((com.baidu.tieba.data.an) d.get(0)).d();
                        if (d2 != null && d2.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", d2));
                        }
                        if (size > com.baidu.tieba.data.g.b() - 30) {
                            for (int i2 = 1; i2 <= size - (com.baidu.tieba.data.g.b() - 30) && size - i2 >= 0; i2++) {
                                d.remove(size - i2);
                            }
                            this.l.b(2);
                            this.l.notifyDataSetChanged();
                        }
                    }
                } else if (i == 1) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    ArrayList d3 = this.n.a().d();
                    if (d3 != null && d3.size() > 0) {
                        int size2 = d3.size();
                        String d4 = ((com.baidu.tieba.data.an) d3.get(size2 - 1)).d();
                        if (d4 != null && d4.length() > 0) {
                            arrayList.add(new BasicNameValuePair("pid", d4));
                        }
                        if (size2 > com.baidu.tieba.data.g.b() - 30) {
                            for (int b = com.baidu.tieba.data.g.b() - 30; b < size2; b++) {
                                d3.remove(0);
                            }
                            this.l.a(2);
                            this.l.notifyDataSetChanged();
                        }
                    }
                    if (this.n.c() < this.n.a().e().a()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.c() + 1)).toString()));
                        this.n.e(false);
                    } else {
                        this.n.e(true);
                    }
                } else if (i == 3) {
                    arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                    arrayList.add(new BasicNameValuePair("pn", "1"));
                    if (this.n != null && this.n.a() != null) {
                        this.n.a().d().clear();
                        this.l.notifyDataSetChanged();
                    }
                    this.l.b(0);
                    this.l.a(0);
                    if (this.u != null) {
                        arrayList.add(new BasicNameValuePair("st_type", this.u));
                    }
                    this.p.setVisibility(0);
                }
                this.m = new aa(this, stringBuffer.toString(), arrayList, i);
                this.m.setPriority(3);
                this.m.execute(stringBuffer.toString(), arrayList);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyPbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        try {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_post), true, 1100024);
                return;
            }
            String editable = this.f.getText().toString();
            if (editable != null && editable.length() > 0 && this.o != null && this.o.length() > 0) {
                if (t()) {
                    editable = editable.substring(0, 140);
                }
                if (this.n != null && this.n.a() != null) {
                    a(getString(R.string.sending), this.j);
                    WriteModel writeModel = new WriteModel();
                    writeModel.setForumId(this.n.a().a().a());
                    writeModel.setForumName(this.n.a().a().b());
                    writeModel.setContent(editable);
                    writeModel.setVcode(null);
                    writeModel.setFloor(null);
                    writeModel.setThreadId(this.o);
                    writeModel.setFloorNum(0);
                    writeModel.setType(1);
                    this.k = new ad(this, writeModel);
                    this.k.setPriority(3);
                    this.k.execute(new Integer[0]);
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyPbActivity", "reply", "error" + e.getMessage());
        }
    }

    private void s() {
        this.f.addTextChangedListener(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.f.getText().getSpans(0, this.f.getText().length(), ImageSpan.class);
        int length = imageSpanArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (imageSpanArr[i2] != null && imageSpanArr[i2].getSource() != null) {
                i += imageSpanArr[i2].getSource().length();
            }
        }
        return (this.f.getText().toString().length() - i) + length > 140;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        a(TiebaApplication.f().getString(R.string.send_success));
        this.f.setText((CharSequence) null);
        if (this.g.getVisibility() == 0) {
            this.g.setVisibility(8);
        }
        com.baidu.tieba.util.ab.a(this, this.f);
        this.e.setBackgroundResource(R.drawable.sub_pb_face);
        this.l.b(2);
        this.l.notifyDataSetChanged();
        if (!this.l.e()) {
            p();
        }
        this.y = this.A.getContent();
        this.z = this.A.getThreadId();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100024:
                    r();
                    return;
                case 1200006:
                    u();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        try {
            if (this.n != null && this.n.a() != null && this.n.a().d() != null) {
                this.l.a(this.n);
                this.l.notifyDataSetChanged();
            }
            if (this.x) {
                a(this.f, WebChromeClient.STRING_DLG_BTN_SET);
                this.x = false;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyPbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }
}
