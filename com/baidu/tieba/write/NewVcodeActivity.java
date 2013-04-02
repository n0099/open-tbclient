package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.BaseWebView;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tieba.e {
    private TextView g;
    private com.baidu.tieba.b.z c = null;
    private LinearLayout d = null;
    private Button e = null;
    private Button f = null;
    private ProgressBar h = null;
    private ProgressBar i = null;
    private DialogInterface.OnCancelListener j = null;
    private PostThreadTask k = null;
    private ChangeVcodeTask l = null;
    private BaseWebView m = null;
    private String n = null;
    private String o = null;
    private String p = null;
    private boolean q = false;
    private Handler r = null;

    public static void a(Activity activity, com.baidu.tieba.b.z zVar, int i) {
        if (zVar != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", zVar);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.b.z zVar, boolean z, int i) {
        if (zVar != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", zVar);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
        n();
        a(bundle);
        if (i()) {
            this.h.setVisibility(0);
            k();
            return;
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = (com.baidu.tieba.b.z) bundle.getSerializable("model");
        } else {
            this.c = (com.baidu.tieba.b.z) getIntent().getSerializableExtra("model");
        }
        this.r = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.p();
                        return;
                    case 1:
                        NewVcodeActivity.this.o();
                        return;
                    case 2:
                        if (message.obj != null) {
                            NewVcodeActivity.this.b((String) message.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private boolean i() {
        if (this.m == null) {
            try {
                this.m = (BaseWebView) findViewById(R.id.new_vcode_webview);
                com.baidu.tieba.c.ae.a(this.m, TiebaApplication.b().ah());
                this.m.setHorizontalScrollBarEnabled(false);
                this.m.setHorizontalScrollbarOverlay(false);
                this.m.setScrollBarStyle(33554432);
                this.m.getSettings().setJavaScriptEnabled(true);
                this.m.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.m.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.h.setVisibility(8);
                        if (!NewVcodeActivity.this.q) {
                            NewVcodeActivity.this.g.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.g.setVisibility(8);
                        }
                        super.onPageFinished(webView, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        super.onReceivedError(webView, i, str, str2);
                    }
                });
                return true;
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.b().k(TiebaApplication.b().aj() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.m != null) {
            this.m.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.m != null) {
            this.m.loadUrl(com.baidu.tieba.c.ai.a("http://c.tieba.baidu.com/c/f/anti/gridcaptcha?version=" + com.baidu.tieba.a.i.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.m != null && this.n != null && this.n.length() > 0) {
            this.m.loadUrl("javascript:" + this.n + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.m != null && this.q && this.o != null && this.o.length() > 0) {
            this.m.loadUrl("javascript:" + this.o + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
        if (this.i != null) {
            this.i.setVisibility(8);
        }
        if (this.r != null) {
            this.r.removeMessages(1);
            this.r.removeMessages(0);
            this.r.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.c);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.e((TextView) this.e, i);
        com.baidu.tieba.c.ae.d((TextView) this.f, i);
        com.baidu.tieba.c.ae.c(this.d, i);
        com.baidu.tieba.c.ae.a((View) this.g, i);
        if (this.m != null) {
            com.baidu.tieba.c.ae.a(this.m, TiebaApplication.b().ah());
        }
    }

    private void n() {
        this.h = (ProgressBar) findViewById(R.id.load_webview_progress);
        this.i = (ProgressBar) findViewById(R.id.change_vcode_progress);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.finish();
            }
        });
        this.f = (Button) findViewById(R.id.post);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.m();
            }
        });
        this.g = (TextView) findViewById(R.id.webview_fail_view);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.q) {
                    NewVcodeActivity.this.h.setVisibility(0);
                    NewVcodeActivity.this.j();
                    NewVcodeActivity.this.k();
                }
            }
        });
        this.j = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.c();
                if (NewVcodeActivity.this.k != null) {
                    NewVcodeActivity.this.k.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.l != null) {
            this.l.cancel();
        }
        this.i.setVisibility(0);
        this.l = new ChangeVcodeTask(this, null);
        this.l.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.p != null && this.p.length() > 0) {
            a(getString(R.string.sending), this.j);
            if (this.k != null) {
                this.k.cancel();
            }
            this.k = new PostThreadTask(this.c);
            this.k.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends AsyncTask {
        private com.baidu.tieba.b.z b;
        private com.baidu.tieba.c.t c = null;
        private String d = null;

        public PostThreadTask(com.baidu.tieba.b.z zVar) {
            this.b = null;
            this.b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public com.baidu.tieba.a.ba doInBackground(Integer... numArr) {
            Address aC;
            this.c = new com.baidu.tieba.c.t();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.f());
            this.c.a("kw", this.b.g());
            String str = "";
            if (this.b.j() != null && this.b.j().a() != null && this.b.j().a().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.j().a(), Integer.valueOf(this.b.j().b()), Integer.valueOf(this.b.j().c()));
            }
            this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.c()) + str);
            this.c.a("vcode_md5", this.b.k());
            this.c.a("vcode", NewVcodeActivity.this.p);
            this.c.a("vcode_tag", "11");
            this.c.d(true);
            if (this.b.a() == 0 || this.b.a() == 3) {
                this.c.a("http://c.tieba.baidu.com/c/c/thread/add");
                if (this.b.a() == 0) {
                    this.c.a("title", this.b.b());
                } else {
                    this.c.a("thread_type", "7");
                    this.c.a("st_type", "tb_suishoufa");
                }
                if (!com.baidu.tieba.a.i.f().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.b().m() && (aC = TiebaApplication.b().aC()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
                }
            } else {
                this.c.a("http://c.tieba.baidu.com/c/c/post/add");
                this.c.a("tid", this.b.d());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.a() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.e()));
                    this.c.a("floor_num", String.valueOf(this.b.h()));
                }
            }
            this.d = this.c.i();
            return null;
        }

        public void cancel() {
            NewVcodeActivity.this.k = null;
            NewVcodeActivity.this.d();
            if (this.c != null) {
                this.c.g();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.a.ba baVar) {
            NewVcodeActivity.this.d();
            NewVcodeActivity.this.k = null;
            if (this.c != null) {
                if (this.c.b()) {
                    com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                    oVar.a(this.d);
                    if (oVar.b() == null || oVar.b().length() <= 0) {
                        NewVcodeActivity.this.b(TiebaApplication.b().getString(R.string.send_success));
                    } else {
                        NewVcodeActivity.this.b(oVar.b());
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                } else {
                    if (this.c.d() == 5 || this.c.d() == 6) {
                        com.baidu.tieba.a.ba baVar2 = new com.baidu.tieba.a.ba();
                        baVar2.a(this.d);
                        if (baVar2.b() != null) {
                            NewVcodeActivity.this.c.h(baVar2.a());
                            NewVcodeActivity.this.c.i(baVar2.b());
                            if (baVar2.c().equals("4")) {
                                NewVcodeActivity.this.l();
                            } else {
                                NewVcodeActivity.this.b(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                                NewVcodeActivity.this.finish();
                            }
                        }
                    }
                    NewVcodeActivity.this.b(this.c.f());
                }
            }
            super.onPostExecute(baVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends AsyncTask {
        volatile com.baidu.tieba.c.t a;
        com.baidu.tieba.a.ba b;

        private ChangeVcodeTask() {
            this.a = null;
            this.b = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public com.baidu.tieba.a.ba doInBackground(String... strArr) {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/anti/vcode");
            this.a.a("fid", NewVcodeActivity.this.c.f());
            this.a.a("kw", NewVcodeActivity.this.c.g());
            if (NewVcodeActivity.this.c.a() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                this.a.a("tid", NewVcodeActivity.this.c.d());
            }
            this.a.a("vcode_tag", "11");
            String i = this.a.i();
            if (this.a.b()) {
                this.b = new com.baidu.tieba.a.ba();
                this.b.a(i);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.a.ba baVar) {
            NewVcodeActivity.this.l = null;
            if (baVar != null) {
                NewVcodeActivity.this.c.h(baVar.a());
                NewVcodeActivity.this.c.i(baVar.b());
                if (baVar.c().equals("4")) {
                    NewVcodeActivity.this.l();
                } else {
                    NewVcodeActivity.this.b(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.b(this.a.f());
            }
            NewVcodeActivity.this.i.setVisibility(8);
            super.onPostExecute(baVar);
        }

        public void cancel() {
            NewVcodeActivity.this.l = null;
            if (this.a != null) {
                this.a.g();
            }
            NewVcodeActivity.this.i.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class VcodeJsInterface {
        VcodeJsInterface() {
        }

        public String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.c.l();
        }

        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.q = z;
            NewVcodeActivity.this.o = str;
        }

        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.r != null) {
                    NewVcodeActivity.this.r.removeMessages(2);
                    NewVcodeActivity.this.r.sendMessage(NewVcodeActivity.this.r.obtainMessage(2, NewVcodeActivity.this.getString(R.string.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.p = str;
                NewVcodeActivity.this.n = str2;
                if (NewVcodeActivity.this.r != null) {
                    NewVcodeActivity.this.r.removeMessages(0);
                    NewVcodeActivity.this.r.sendMessage(NewVcodeActivity.this.r.obtainMessage(0));
                }
            }
        }

        public void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        public void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.n = str;
                if (NewVcodeActivity.this.r != null) {
                    NewVcodeActivity.this.r.removeMessages(1);
                    NewVcodeActivity.this.r.sendMessage(NewVcodeActivity.this.r.obtainMessage(1));
                }
            }
        }

        public String jsGetSkinType() {
            return String.valueOf(TiebaApplication.b().ah());
        }
    }
}
