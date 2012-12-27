package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbActivity extends com.baidu.tieba.e {
    private static volatile long ao = 0;
    private static volatile long ap = 0;
    private static volatile int aq = 0;
    private TextView aj;
    private ListView c = null;
    private AlertDialog d = null;
    private TextView e = null;
    private Button f = null;
    private Button g = null;
    private Button h = null;
    private Button i = null;
    private EditText j = null;
    private Button k = null;
    private bt l = null;
    private bp m = null;
    private com.baidu.tieba.b.n n = null;
    private String o = null;
    private ProgressBar p = null;
    private Handler q = new Handler();
    private AdapterView.OnItemLongClickListener r = null;
    private View.OnClickListener s = null;
    private long t = -1;
    private com.baidu.tieba.a.am u = null;
    private AlertDialog v = null;
    private AlertDialog w = null;
    private Dialog x = null;
    private View y = null;
    private View z = null;
    private LinearLayout A = null;
    private Button B = null;
    private Dialog C = null;
    private View D = null;
    private Button E = null;
    private Button F = null;
    private TextView G = null;
    private Dialog H = null;
    private View I = null;
    private int J = 0;
    private RadioGroup K = null;
    private RadioButton L = null;
    private RadioButton M = null;
    private RadioButton N = null;
    private Button O = null;
    private Button P = null;
    private TextView Q = null;
    private Dialog R = null;
    private View S = null;
    private RadioGroup T = null;
    private CompoundButton.OnCheckedChangeListener U = null;
    private Button V = null;
    private Button W = null;
    private String X = null;
    private bn Y = null;
    private bo Z = null;
    private bs aa = null;
    private b ab = null;
    private a ac = null;
    private String ad = null;
    private int ae = -1;
    private com.baidu.tieba.a.ae af = null;
    private boolean ag = true;
    private String ah = null;
    private boolean ai = false;
    private String ak = null;
    private boolean al = false;
    private boolean am = false;
    private long an = 0;
    private Runnable ar = new ak(this);
    DialogInterface.OnClickListener b = new ax(this);

    public static void a(Context context, com.baidu.tieba.a.ae aeVar) {
        Intent intent = new Intent(context, PbActivity.class);
        if (aeVar.d() == null || aeVar.j() == null) {
            return;
        }
        intent.putExtra("mark", aeVar);
        intent.putExtra("st_type", "my_mark");
        context.startActivity(intent);
    }

    public static void a(Context context, String str, Boolean bool, Boolean bool2, String str2, boolean z) {
        Intent intent = new Intent(context, PbActivity.class);
        if (str == null || str.length() <= 0) {
            return;
        }
        intent.putExtra("id", str);
        intent.putExtra("sequence", bool);
        intent.putExtra("hostMode", bool2);
        intent.putExtra("isAd", z);
        if (str2 != null) {
            intent.putExtra("st_type", str2);
        }
        if ("tb_frslist".equals(str2)) {
            ((Activity) context).startActivityForResult(intent, 1300004);
        } else {
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, true, false, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        a(context, str, true, false, str2, z);
    }

    public static void a(Context context, String str, boolean z, long j) {
        Intent intent = new Intent(context, PbActivity.class);
        if (str == null || str.length() <= 0) {
            return;
        }
        intent.putExtra("id", str);
        intent.putExtra("sequence", true);
        intent.putExtra("hostMode", false);
        intent.putExtra("back_special", true);
        intent.putExtra("is_message_pv", z);
        intent.putExtra("message_id", j);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        Boolean valueOf;
        Boolean valueOf2;
        this.ac = new a(this, new String[]{getString(R.string.reply), getString(R.string.mark), getString(R.string.view_info)});
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setAdapter(this.ac, this.b);
        if (this.d == null) {
            this.d = builder.create();
            this.d.setCanceledOnTouchOutside(true);
        }
        this.n = new com.baidu.tieba.b.n();
        Boolean.valueOf(true);
        Boolean.valueOf(false);
        String str = null;
        this.ai = getIntent().getBooleanExtra("back_special", false);
        this.am = getIntent().getBooleanExtra("is_message_pv", false);
        this.an = getIntent().getLongExtra("message_id", 0L);
        if (bundle != null) {
            this.o = bundle.getString("id");
            Boolean valueOf3 = Boolean.valueOf(bundle.getBoolean("sequence", true));
            Boolean valueOf4 = Boolean.valueOf(bundle.getBoolean("hostMode", false));
            String string = bundle.getString("markid");
            this.n.i(bundle.getBoolean("markMode", false));
            this.ad = bundle.getString("st_type");
            valueOf = valueOf3;
            valueOf2 = valueOf4;
            str = string;
        } else {
            Intent intent = getIntent();
            this.ad = intent.getStringExtra("st_type");
            com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) intent.getSerializableExtra("mark");
            if (aeVar != null) {
                this.o = aeVar.d();
                Boolean h = aeVar.h();
                Boolean valueOf5 = Boolean.valueOf(aeVar.i());
                String j = aeVar.j();
                this.n.i(true);
                valueOf = h;
                valueOf2 = valueOf5;
                str = j;
            } else {
                this.o = intent.getStringExtra("id");
                valueOf = Boolean.valueOf(intent.getBooleanExtra("sequence", true));
                valueOf2 = Boolean.valueOf(intent.getBooleanExtra("hostMode", false));
                com.baidu.tieba.a.ae k = com.baidu.tieba.c.k.k(this.o);
                if (k != null) {
                    str = k.j();
                }
            }
        }
        TiebaApplication tiebaApplication = (TiebaApplication) getApplication();
        if (tiebaApplication != null) {
            this.n.a(tiebaApplication.q());
            this.n.g(tiebaApplication.r());
        }
        if (valueOf2.booleanValue()) {
            valueOf = true;
        }
        this.n.b(valueOf.booleanValue());
        this.n.c(valueOf2.booleanValue());
        this.n.a(str);
        if (!this.n.n()) {
            c(3);
            return;
        }
        a(false);
        c(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.ae aeVar, boolean z) {
        if (aeVar == null) {
            return;
        }
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100009);
            return;
        }
        aeVar.e(TiebaApplication.u());
        if (z) {
            if (!com.baidu.tieba.c.k.a(aeVar)) {
                b(getString(R.string.fail));
                return;
            }
            b(getString(R.string.success));
            this.n.a(aeVar.j());
            this.l.notifyDataSetChanged();
        } else if (!com.baidu.tieba.c.k.l(aeVar.d())) {
            b(getString(R.string.fail));
        } else {
            b(getString(R.string.success));
            this.n.a((String) null);
            this.l.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.am amVar) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            if (this.n != null && this.n.a() != null && this.n.a().e() != null) {
                this.n.a().e().a(1);
            }
            if (amVar != null) {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100005);
            } else {
                LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100004);
            }
        } else if (this.o == null || this.o.length() <= 0 || this.n.a() == null) {
        } else {
            if (amVar != null) {
                WriteActivity.a(this, this.n.a().a().b(), this.n.a().a().c(), this.o, amVar.a(), amVar.b(), getIntent().getBooleanExtra("isAd", false), this.n.a().e());
            } else {
                WriteActivity.a(this, this.n.a().a().b(), this.n.a().a().c(), this.o, null, 0, getIntent().getBooleanExtra("isAd", false), this.n.a().e());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.g.setEnabled(true);
        } else {
            this.g.setEnabled(false);
        }
    }

    public static boolean a(com.baidu.tieba.b.n nVar) {
        com.baidu.tieba.a.as b;
        String a;
        return nVar == null || nVar.a() == null || (b = nVar.a().b()) == null || b.h() == null || (a = b.h().a()) == null || a.equals("0");
    }

    private void b(int i) {
        ArrayList c;
        if (this.n == null || this.n.a() == null || (c = this.n.a().c()) == null || c.size() <= 0) {
            return;
        }
        if (i == 0) {
            c(2);
        } else {
            c(1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100017);
        } else if (this.n.f()) {
        } else {
            this.n.d(true);
            if (this.Y != null) {
                this.Y.a();
                this.Y = null;
            }
            com.baidu.tieba.a.p a = this.n.a().a();
            this.Y = new bn(this, a.b(), a.c(), this.n.a().b().a(), str, i, i2);
            this.Y.execute(i == 1 ? String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delthread" : String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/delpost");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/pb/page");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("kz", this.o));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(30)));
            if (!this.n.c()) {
                arrayList.add(new BasicNameValuePair("r", String.valueOf(1)));
            }
            if (this.n.d()) {
                arrayList.add(new BasicNameValuePair("lz", String.valueOf(1)));
            }
            if (this.o == null || this.o.length() <= 0) {
                return;
            }
            if (i == 5) {
                int parseInt = Integer.parseInt(this.j.getText().toString(), 10);
                int a = this.n.a().d().a();
                int i2 = parseInt >= 1 ? parseInt : 1;
                if (i2 <= a) {
                    a = i2;
                }
                arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(a)).toString()));
                arrayList.add(new BasicNameValuePair("back", "0"));
                this.p.setVisibility(0);
            } else if (i == 2) {
                arrayList.add(new BasicNameValuePair("back", "1"));
                if (!this.n.n()) {
                    if (this.n.c()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.l() + (-1) < 0 ? 1 : this.n.l() - 1)).toString()));
                    } else if (this.n.k() < this.n.a().d().a()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.k() + 1)).toString()));
                        this.n.h(false);
                    } else {
                        this.n.h(true);
                    }
                }
                ArrayList c = this.n.a().c();
                if (c != null && c.size() > 0) {
                    int size = c.size();
                    String a2 = ((com.baidu.tieba.a.am) c.get(0)).a();
                    if (a2 != null && a2.length() > 0) {
                        arrayList.add(new BasicNameValuePair("pid", a2));
                    }
                    if (size > com.baidu.tieba.a.h.b() - 30) {
                        for (int i3 = 1; i3 <= size - (com.baidu.tieba.a.h.b() - 30) && size - i3 >= 0; i3++) {
                            c.remove(size - i3);
                        }
                        this.l.b(2);
                        this.l.notifyDataSetChanged();
                    }
                }
            } else if (i == 1) {
                arrayList.add(new BasicNameValuePair("back", String.valueOf(0)));
                ArrayList c2 = this.n.a().c();
                if (c2 != null && c2.size() > 0) {
                    int size2 = c2.size();
                    String a3 = ((com.baidu.tieba.a.am) c2.get(size2 - 1)).a();
                    if (a3 != null && a3.length() > 0) {
                        arrayList.add(new BasicNameValuePair("pid", a3));
                    }
                    if (size2 > com.baidu.tieba.a.h.b() - 30) {
                        for (int b = com.baidu.tieba.a.h.b() - 30; b < size2; b++) {
                            c2.remove(0);
                        }
                        this.l.a(2);
                        this.l.notifyDataSetChanged();
                    }
                } else if (!this.n.c()) {
                    arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                }
                if (!this.n.n()) {
                    if (!this.n.c()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.l() - 1)).toString()));
                    } else if (this.n.k() < this.n.a().d().a()) {
                        arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.k() + 1)).toString()));
                        this.n.h(false);
                    } else {
                        this.n.h(true);
                    }
                }
            } else if (i == 4) {
                arrayList.add(new BasicNameValuePair("pid", this.n.j()));
                arrayList.add(new BasicNameValuePair("back", "0"));
                arrayList.add(new BasicNameValuePair("st_type", "tb_bookmarklist"));
                this.l.b(0);
                this.l.a(0);
                this.p.setVisibility(0);
            } else {
                arrayList.add(new BasicNameValuePair("back", "0"));
                if (this.n.c()) {
                    arrayList.add(new BasicNameValuePair("pn", "1"));
                } else if ((getIntent().getStringExtra("st_type") == null || !getIntent().getStringExtra("st_type").equals("tb_frslist") || getIntent().getBooleanExtra("sequence", true)) && this.n != null && this.n.a() != null && this.n.a().d() != null) {
                    arrayList.add(new BasicNameValuePair("pn", new StringBuilder(String.valueOf(this.n.a().d().a())).toString()));
                }
                if (this.n != null) {
                    this.n.i(false);
                    if (!this.n.c()) {
                        arrayList.add(new BasicNameValuePair("last", String.valueOf(1)));
                    }
                    if (this.n.a() != null) {
                        this.n.a().c().clear();
                        this.l.notifyDataSetChanged();
                    }
                }
                this.l.b(0);
                this.l.a(0);
                if (this.ad != null) {
                    arrayList.add(new BasicNameValuePair("st_type", this.ad));
                }
                this.p.setVisibility(0);
                System.gc();
            }
            arrayList.add(i == 4 ? new BasicNameValuePair("mark", "1") : new BasicNameValuePair("mark", "0"));
            this.m = new bp(this, stringBuffer.toString(), arrayList, i);
            this.m.execute(stringBuffer.toString(), arrayList);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PbActivity", "startPbAsyncTask", "error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100018);
        } else if (this.n.g()) {
        } else {
            this.n.e(true);
            if (this.Z != null) {
                this.Z.a();
                this.Z = null;
            }
            com.baidu.tieba.a.p a = this.n.a().a();
            this.Z = new bo(this, a.b(), a.c(), this.n.a().b().a(), str, String.valueOf(this.J));
            this.Z.execute("http://c.tieba.baidu.com/c/c/bawu/commitprison");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, 1100022);
        } else if (this.n.h()) {
        } else {
            this.n.f(true);
            if (this.aa != null) {
                this.aa.a();
                this.aa = null;
            }
            com.baidu.tieba.a.p a = this.n.a().a();
            this.aa = new bs(this, a.b(), a.c(), this.n.a().b().a(), i);
            this.aa.execute(i == 5 ? String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/goodlist" : (i == 1 || i == 2) ? String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/commitgood" : String.valueOf("http://c.tieba.baidu.com/") + "c/c/bawu/committop");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("cates");
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.baidu.tieba.a.s sVar = new com.baidu.tieba.a.s();
                sVar.a(optJSONArray.optJSONObject(i));
                arrayList.add(sVar);
            }
            if (this.R == null) {
                this.R = new Dialog(this, R.style.common_alert_dialog);
                this.R.setCanceledOnTouchOutside(true);
                this.R.setCancelable(true);
                this.S = getLayoutInflater().inflate(R.layout.commit_good, (ViewGroup) null);
                this.R.setContentView(this.S);
                WindowManager.LayoutParams attributes = this.R.getWindow().getAttributes();
                attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
                this.R.getWindow().setAttributes(attributes);
                this.U = new az(this);
                this.T = (RadioGroup) this.S.findViewById(R.id.good_class_group);
                this.W = (Button) this.S.findViewById(R.id.dialog_button_cancel);
                this.W.setOnClickListener(new ba(this));
                this.V = (Button) this.S.findViewById(R.id.dialog_button_ok);
                this.V.setOnClickListener(new bb(this));
            }
            if (this.n == null || this.n.a() == null) {
                return;
            }
            this.T.removeAllViews();
            LayoutInflater layoutInflater = getLayoutInflater();
            RadioButton radioButton = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
            radioButton.setTag("0");
            radioButton.setText(getResources().getString(R.string.def_good_class));
            radioButton.setOnCheckedChangeListener(this.U);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.tieba.c.ag.a((Context) this, 10.0f), com.baidu.tieba.c.ag.a((Context) this, 5.0f), com.baidu.tieba.c.ag.a((Context) this, 10.0f), com.baidu.tieba.c.ag.a((Context) this, 5.0f));
            this.T.addView(radioButton, layoutParams);
            this.T.requestLayout();
            this.T.check(radioButton.getId());
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                RadioButton radioButton2 = (RadioButton) layoutInflater.inflate(R.layout.good_class_radio_button, (ViewGroup) null);
                radioButton2.setTag(String.valueOf(((com.baidu.tieba.a.s) arrayList.get(i2)).b()));
                radioButton2.setText(((com.baidu.tieba.a.s) arrayList.get(i2)).a());
                radioButton2.setOnCheckedChangeListener(this.U);
                this.T.addView(radioButton2, layoutParams);
                this.T.requestLayout();
            }
            this.R.show();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "openCommitGoodDialog", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.ae l() {
        com.baidu.tieba.a.ae aeVar = new com.baidu.tieba.a.ae();
        Date date = new Date();
        aeVar.e(TiebaApplication.u());
        aeVar.b(this.o);
        if (this.n.a() != null) {
            aeVar.c(this.n.a().b().c());
            if (this.t >= 0 && this.t < this.n.a().c().size()) {
                aeVar.c(((com.baidu.tieba.a.am) this.n.a().c().get((int) this.t)).b());
                aeVar.d(((com.baidu.tieba.a.am) this.n.a().c().get((int) this.t)).a());
            }
            aeVar.a(this.n.a().b().h().c());
            aeVar.a(this.n.a().b().d());
        }
        aeVar.a(date.getTime());
        aeVar.a(this.n.d());
        aeVar.a(Boolean.valueOf(this.n.c()));
        if (this.n.a().f()) {
            aeVar.b(1);
            aeVar.f(this.n.a().a().b());
            aeVar.g(this.n.a().a().c());
            aeVar.h(this.n.a().b().a());
        }
        return aeVar;
    }

    private boolean m() {
        boolean booleanExtra = getIntent().getBooleanExtra("message_push_entry", false);
        getIntent().putExtra("message_push_entry", false);
        if (booleanExtra) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals("com.baidu.tieba.pb.PbActivity")) {
                    if (next.numActivities <= 1) {
                        MainTabActivity.a(this, "goto_more", 1, getIntent().getStringExtra("id"), getIntent());
                        g();
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void n() {
        this.r = new bc(this);
        this.s = new bd(this);
        this.e = (TextView) findViewById(R.id.titel_text);
        this.A = (LinearLayout) findViewById(R.id.bottom_bar);
        this.e.setClickable(true);
        this.e.setOnClickListener(new be(this));
        this.i = (Button) findViewById(R.id.more);
        this.i.setOnClickListener(new bf(this));
        this.h = (Button) findViewById(R.id.back);
        this.h.setOnClickListener(new bh(this));
        this.g = (Button) findViewById(R.id.skip_page);
        this.g.setOnClickListener(new bi(this));
        this.f = (Button) findViewById(R.id.reply);
        this.f.setOnClickListener(new bm(this));
        this.k = (Button) findViewById(R.id.recommend);
        this.k.setOnClickListener(new an(this));
        this.B = (Button) findViewById(R.id.refresh);
        this.B.setOnClickListener(new ao(this));
        this.c = (ListView) findViewById(R.id.pb_list);
        this.c.setFastScrollEnabled(true);
        this.l = new bt(this, null, com.baidu.tieba.c.ag.a((Context) this, 234.0f), this.s);
        this.l.c(TiebaApplication.a().aa());
        this.l.c(TiebaApplication.a().Z());
        this.l.b(0);
        this.l.a(0);
        this.c.setAdapter((ListAdapter) this.l);
        this.c.setOnItemClickListener(new ap(this));
        this.c.setOnScrollListener(new aq(this));
        this.c.setOnItemLongClickListener(this.r);
        this.p = (ProgressBar) findViewById(R.id.progress);
        this.p.setVisibility(8);
        this.aj = (TextView) findViewById(R.id.tofrs_textview);
        this.aj.setOnClickListener(new ar(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AlertDialog o() {
        if (d() == null || !d().isShowing()) {
            as asVar = new as(this);
            com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) this.l.getItem(this.ae);
            String string = (amVar == null || this.n == null || amVar.a() == null) ? null : amVar.a().equals(this.n.j()) ? getString(R.string.delete_mark) : getString(R.string.add_mark);
            return string != null ? a(new String[]{getString(R.string.copy), string}, asVar) : a(new String[]{getString(R.string.copy)}, asVar);
        }
        return d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        b(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.n.c(true);
        this.n.b(true);
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.n.c(false);
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.n.b(false);
        this.n.c(false);
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        this.n.b(true);
        c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.n.g(true);
        TiebaApplication.a().b((Boolean) true);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.n.g(false);
        TiebaApplication.a().b((Boolean) false);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            if (this.n != null && this.n.a() != null) {
                if (this.n.a().c() != null) {
                    this.l.a(this.n);
                    this.l.notifyDataSetChanged();
                }
                com.baidu.tieba.a.p a = this.n.a().a();
                if (a != null && a.c() != null) {
                    this.e.setText(String.valueOf(a.c()) + getString(R.string.forum));
                }
            }
            if (this.al) {
                this.c.setSelection(this.c.getCount());
            }
            this.al = false;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("PbActivity", "refreshActivity", "error = " + e.getMessage());
        }
    }

    public void a(int i, String str, int i2) {
        if (this.C == null) {
            this.C = new Dialog(this, R.style.common_alert_dialog);
            this.C.setCanceledOnTouchOutside(true);
            this.C.setCancelable(true);
            this.D = getLayoutInflater().inflate(R.layout.del_post, (ViewGroup) null);
            this.C.setContentView(this.D);
            WindowManager.LayoutParams attributes = this.C.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
            this.C.getWindow().setAttributes(attributes);
            this.E = (Button) this.D.findViewById(R.id.dialog_button_ok);
            this.F = (Button) this.D.findViewById(R.id.dialog_button_cancel);
            this.F.setOnClickListener(new at(this));
            this.G = (TextView) this.D.findViewById(R.id.confirm_text);
        }
        if (this.n == null || this.n.a() == null) {
            return;
        }
        this.E.setOnClickListener(new au(this, i, str, i2));
        if (i == 1) {
            this.G.setText(R.string.del_thread_confirm);
        } else {
            this.G.setText(R.string.del_post_confirm);
        }
        this.C.show();
    }

    public void a(String str, int i) {
        if (this.H == null) {
            this.H = new Dialog(this, R.style.common_alert_dialog);
            this.H.setCanceledOnTouchOutside(true);
            this.H.setCancelable(true);
            this.I = getLayoutInflater().inflate(R.layout.forbid_user, (ViewGroup) null);
            this.H.setContentView(this.I);
            WindowManager.LayoutParams attributes = this.H.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.tieba.c.ag.a((Context) this) * 0.9d);
            this.H.getWindow().setAttributes(attributes);
            this.K = (RadioGroup) this.I.findViewById(R.id.radio_group);
            this.L = (RadioButton) this.I.findViewById(R.id.radio_button_1day);
            this.M = (RadioButton) this.I.findViewById(R.id.radio_button_3day);
            this.N = (RadioButton) this.I.findViewById(R.id.radio_button_10day);
            av avVar = new av(this);
            this.L.setOnCheckedChangeListener(avVar);
            this.M.setOnCheckedChangeListener(avVar);
            this.N.setOnCheckedChangeListener(avVar);
            this.O = (Button) this.I.findViewById(R.id.dialog_button_ok);
            this.P = (Button) this.I.findViewById(R.id.dialog_button_cancel);
            this.P.setOnClickListener(new aw(this));
            this.Q = (TextView) this.I.findViewById(R.id.user_name);
        }
        if (this.n == null || this.n.a() == null) {
            return;
        }
        this.Q.setText(str);
        this.K.check(R.id.radio_button_1day);
        if (i == 2) {
            this.M.setVisibility(8);
            this.N.setVisibility(8);
        }
        this.O.setOnClickListener(new ay(this, str));
        this.H.show();
    }

    public void g() {
        h();
        if (this.ai) {
            MainTabActivity.a(this, "goto_recommend");
        } else {
            finish();
        }
    }

    public void h() {
        if (this.d != null && this.d.isShowing()) {
            this.d.dismiss();
        }
        if (this.v != null && this.v.isShowing()) {
            this.v.dismiss();
        }
        if (this.w != null && this.w.isShowing()) {
            this.w.dismiss();
        }
        if (this.x != null && this.x.isShowing()) {
            this.x.dismiss();
        }
        if (this.C != null && this.C.isShowing()) {
            this.C.dismiss();
        }
        if (this.H != null && this.H.isShowing()) {
            this.H.dismiss();
        }
        if (this.R == null || !this.R.isShowing()) {
            return;
        }
        this.R.dismiss();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100004:
                    a((com.baidu.tieba.a.am) null);
                    return;
                case 1100005:
                    a(this.u);
                    return;
                case 1100006:
                    r();
                    return;
                case 1100007:
                    t();
                    return;
                case 1100009:
                    a(this.af, this.ag);
                    return;
                case 1300001:
                case 1300002:
                    try {
                        String u = TiebaApplication.u();
                        String a = this.n.a().b().h().a();
                        if (!this.n.d() || u.equals(a)) {
                            if (this.n.c() && this.l.f() == 1) {
                                p();
                            } else if (!this.n.c() && this.l.d() == 1) {
                                q();
                            }
                        }
                        return;
                    } catch (Exception e) {
                        com.baidu.tieba.c.ae.b(getClass().getName(), "onActivityResult", e.getMessage());
                        return;
                    }
                case 1300004:
                    String stringExtra = intent.getStringExtra("del_post_id");
                    if (stringExtra == null || this.n == null || this.n.a() == null) {
                        return;
                    }
                    ArrayList c = this.n.a().c();
                    int size = c.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 < size) {
                            if (stringExtra.equals(((com.baidu.tieba.a.am) c.get(i3)).a())) {
                                c.remove(i3);
                            } else {
                                i3++;
                            }
                        }
                    }
                    x();
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
        if (m()) {
            setContentView(R.layout.pb_activity);
            this.ah = TiebaApplication.u();
            n();
            a(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.q.removeCallbacks(this.ar);
        try {
            if (this.m != null) {
                this.m.a();
                this.m = null;
            }
            if (this.l != null) {
                this.l.a();
                this.l.b().b();
            }
            if (this.ab != null) {
                this.ab.a();
            }
            if (this.n != null && this.n.a() != null) {
                this.n.a((com.baidu.tieba.a.ak) null);
            }
            if (this.Y != null) {
                this.Y.a();
                this.Y = null;
            }
            if (this.Z != null) {
                this.Z.a();
                this.Z = null;
            }
            h();
            this.p.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.a(getClass().getName(), "onDestroy", e.toString());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        if (i == 4) {
            g();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.l.b().b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        if (this.l != null && this.l.j() != TiebaApplication.a().aa()) {
            this.l.c(TiebaApplication.a().aa());
            this.l.notifyDataSetChanged();
        }
        if (this.l != null && this.l.i() != TiebaApplication.a().Z()) {
            this.l.c(TiebaApplication.a().Z());
            this.l.notifyDataSetChanged();
        }
        com.baidu.tieba.a.ae k = com.baidu.tieba.c.k.k(this.o);
        if (this.n != null) {
            if (k != null) {
                this.n.a(k.j());
            } else {
                this.n.a((String) null);
            }
            String u = TiebaApplication.u();
            if (this.ah == null && u != null && u.length() > 0) {
                this.ah = u;
                if (this.n.a() != null && this.n.a().e() != null) {
                    this.n.a().e().a(1);
                }
            }
        }
        if (this.l != null) {
            this.l.notifyDataSetChanged();
        }
        this.ar.run();
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("id", this.o);
        bundle.putBoolean("sequence", this.n.c());
        bundle.putBoolean("hostMode", this.n.d());
        bundle.putString("markid", this.n.j());
        bundle.putBoolean("markMode", this.n.n());
        if (this.ad != null) {
            bundle.putString("st_type", this.ad);
        }
    }
}
