package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bf;
import com.baidu.tieba.c.bs;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tieba.e {
    private TextView g;
    private bs c = null;
    private LinearLayout d = null;
    private ImageView e = null;
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

    public static void a(Activity activity, bs bsVar, int i) {
        if (bsVar != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", bsVar);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, bs bsVar, boolean z, int i) {
        if (bsVar != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", bsVar);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
        o();
        a(bundle);
        if (b()) {
            this.h.setVisibility(0);
            d();
            return;
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = (bs) bundle.getSerializable("model");
        } else {
            this.c = (bs) getIntent().getSerializableExtra("model");
        }
        this.r = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.q();
                        return;
                    case 1:
                        NewVcodeActivity.this.p();
                        return;
                    case 2:
                        if (message.obj != null) {
                            NewVcodeActivity.this.a((String) message.obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private boolean b() {
        if (this.m == null) {
            try {
                this.m = (BaseWebView) findViewById(R.id.new_vcode_webview);
                com.baidu.tieba.d.ac.a(this.m, TiebaApplication.d().ar());
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
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.d().n(TiebaApplication.d().au() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.m != null) {
            this.m.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.m != null) {
            this.m.loadUrl(com.baidu.tieba.d.ag.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/anti/gridcaptcha?version=" + com.baidu.tieba.a.i.i()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.m != null && this.n != null && this.n.length() > 0) {
            this.m.loadUrl("javascript:" + this.n + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
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
        com.baidu.tieba.d.ac.a(this.e, i);
        com.baidu.tieba.d.ac.g((TextView) this.f, i);
        com.baidu.tieba.d.ac.d(this.d, i);
        com.baidu.tieba.d.ac.a((View) this.g, i);
        if (this.m != null) {
            com.baidu.tieba.d.ac.a(this.m, TiebaApplication.d().ar());
        }
    }

    private void o() {
        this.h = (ProgressBar) findViewById(R.id.load_webview_progress);
        this.i = (ProgressBar) findViewById(R.id.change_vcode_progress);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (ImageView) findViewById(R.id.back);
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
                NewVcodeActivity.this.n();
            }
        });
        this.g = (TextView) findViewById(R.id.webview_fail_view);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.q) {
                    NewVcodeActivity.this.h.setVisibility(0);
                    NewVcodeActivity.this.c();
                    NewVcodeActivity.this.d();
                }
            }
        });
        this.j = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.g();
                if (NewVcodeActivity.this.k != null) {
                    NewVcodeActivity.this.k.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.l != null) {
            this.l.cancel();
        }
        this.i.setVisibility(0);
        this.l = new ChangeVcodeTask(this, null);
        this.l.setPriority(3);
        this.l.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.p != null && this.p.length() > 0) {
            a(getString(R.string.sending), this.j);
            if (this.k != null) {
                this.k.cancel();
            }
            this.k = new PostThreadTask(this.c);
            this.k.setPriority(3);
            this.k.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends com.baidu.adp.lib.a.a {
        private bs b;
        private com.baidu.tieba.d.t c = null;
        private String d = null;

        public PostThreadTask(bs bsVar) {
            this.b = null;
            this.b = bsVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.a.a
        public bf a(Integer... numArr) {
            Address aL;
            this.c = new com.baidu.tieba.d.t();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.g());
            this.c.a("kw", this.b.h());
            String str = "";
            if (this.b.k() != null && this.b.k().a() != null && this.b.k().a().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.k().a(), Integer.valueOf(this.b.k().b()), Integer.valueOf(this.b.k().c()));
            }
            this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.d()) + str);
            this.c.a("vcode_md5", this.b.l());
            this.c.a("vcode", NewVcodeActivity.this.p);
            this.c.a("vcode_tag", "11");
            this.c.d(true);
            if (this.b.b() == 0 || this.b.b() == 3) {
                this.c.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/thread/add");
                if (this.b.b() == 0) {
                    this.c.a("title", this.b.c());
                } else {
                    this.c.a("thread_type", "7");
                    this.c.a("st_type", "tb_suishoufa");
                }
                if (!com.baidu.tieba.a.i.g().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.d().p() && (aL = TiebaApplication.d().aL()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aL.getLatitude())) + "," + String.valueOf(aL.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/add");
                this.c.a("tid", this.b.e());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.b() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.f()));
                    this.c.a("floor_num", String.valueOf(this.b.i()));
                }
            }
            this.d = this.c.i();
            return null;
        }

        @Override // com.baidu.adp.lib.a.a
        public void cancel() {
            NewVcodeActivity.this.k = null;
            NewVcodeActivity.this.h();
            if (this.c != null) {
                this.c.g();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.a.a
        public void a(bf bfVar) {
            NewVcodeActivity.this.h();
            NewVcodeActivity.this.k = null;
            if (this.c != null) {
                if (this.c.b()) {
                    com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                    oVar.b(this.d);
                    if (oVar.b() == null || oVar.b().length() <= 0) {
                        NewVcodeActivity.this.a(TiebaApplication.d().getString(R.string.send_success));
                    } else {
                        NewVcodeActivity.this.a(oVar.b());
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                } else {
                    if (this.c.d() == 5 || this.c.d() == 6) {
                        bf bfVar2 = new bf();
                        bfVar2.a(this.d);
                        if (bfVar2.b() != null) {
                            NewVcodeActivity.this.c.h(bfVar2.a());
                            NewVcodeActivity.this.c.i(bfVar2.b());
                            if (bfVar2.c().equals("4")) {
                                NewVcodeActivity.this.m();
                            } else {
                                NewVcodeActivity.this.a(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                                NewVcodeActivity.this.finish();
                            }
                        }
                    }
                    NewVcodeActivity.this.a(this.c.f());
                }
            }
            super.a((Object) bfVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends com.baidu.adp.lib.a.a {
        volatile com.baidu.tieba.d.t a;
        bf b;

        private ChangeVcodeTask() {
            this.a = null;
            this.b = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.a.a
        public bf a(String... strArr) {
            this.a = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/anti/vcode");
            this.a.a("fid", NewVcodeActivity.this.c.g());
            this.a.a("kw", NewVcodeActivity.this.c.h());
            if (NewVcodeActivity.this.c.b() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                this.a.a("tid", NewVcodeActivity.this.c.e());
            }
            this.a.a("vcode_tag", "11");
            String i = this.a.i();
            if (this.a.b()) {
                this.b = new bf();
                this.b.a(i);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.a.a
        public void a(bf bfVar) {
            NewVcodeActivity.this.l = null;
            if (bfVar != null) {
                NewVcodeActivity.this.c.h(bfVar.a());
                NewVcodeActivity.this.c.i(bfVar.b());
                if (bfVar.c().equals("4")) {
                    NewVcodeActivity.this.m();
                } else {
                    NewVcodeActivity.this.a(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.a(this.a.f());
            }
            NewVcodeActivity.this.i.setVisibility(8);
            super.a((Object) bfVar);
        }

        @Override // com.baidu.adp.lib.a.a
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
            return NewVcodeActivity.this.c.m();
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
            return String.valueOf(TiebaApplication.d().ar());
        }
    }
}
