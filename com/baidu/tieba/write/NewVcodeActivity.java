package com.baidu.tieba.write;

import android.annotation.SuppressLint;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tieba.g {
    private TextView e;

    /* renamed from: a  reason: collision with root package name */
    private WriteData f1886a = null;
    private LinearLayout b = null;
    private ImageView c = null;
    private Button d = null;
    private ProgressBar f = null;
    private ProgressBar g = null;
    private DialogInterface.OnCancelListener j = null;
    private PostThreadTask k = null;
    private ChangeVcodeTask l = null;
    private BaseWebView m = null;
    private String n = null;
    private String o = null;
    private String p = null;
    private boolean q = false;
    private Handler r = null;

    public static void a(Activity activity, WriteData writeData, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", writeData);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, WriteData writeData, boolean z, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", writeData);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
        m();
        a(bundle);
        if (b()) {
            this.f.setVisibility(0);
            d();
            return;
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f1886a = (WriteData) bundle.getSerializable("model");
        } else {
            this.f1886a = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.r = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.o();
                        return;
                    case 1:
                        NewVcodeActivity.this.n();
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

    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean b() {
        if (this.m == null) {
            try {
                this.m = (BaseWebView) findViewById(R.id.new_vcode_webview);
                com.baidu.tieba.util.ao.a(this.m, TiebaApplication.g().an());
                this.m.setHorizontalScrollBarEnabled(false);
                this.m.setHorizontalScrollbarOverlay(false);
                this.m.setScrollBarStyle(33554432);
                this.m.getSettings().setJavaScriptEnabled(true);
                this.m.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.m.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.f.setVisibility(8);
                        if (!NewVcodeActivity.this.q) {
                            NewVcodeActivity.this.e.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.e.setVisibility(8);
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
                com.baidu.tieba.util.aq.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.g().k(TiebaApplication.g().aq() + 1);
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
            this.m.loadUrl(UtilHelper.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/anti/gridcaptcha?version=" + com.baidu.tieba.data.g.j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.m != null && this.n != null && this.n.length() > 0) {
            this.m.loadUrl("javascript:" + this.n + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.m != null && this.q && this.o != null && this.o.length() > 0) {
            this.m.loadUrl("javascript:" + this.o + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.k != null) {
            this.k.cancel();
        }
        if (this.l != null) {
            this.l.cancel();
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.r != null) {
            this.r.removeMessages(1);
            this.r.removeMessages(0);
            this.r.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.f1886a);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ao.a(this.c, i);
        com.baidu.tieba.util.ao.g((TextView) this.d, i);
        com.baidu.tieba.util.ao.d(this.b, i);
        com.baidu.tieba.util.ao.a((View) this.e, i);
        if (this.m != null) {
            com.baidu.tieba.util.ao.a(this.m, TiebaApplication.g().an());
        }
    }

    private void m() {
        this.f = (ProgressBar) findViewById(R.id.load_webview_progress);
        this.g = (ProgressBar) findViewById(R.id.change_vcode_progress);
        this.b = (LinearLayout) findViewById(R.id.title);
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.finish();
            }
        });
        this.d = (Button) findViewById(R.id.post);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewVcodeActivity.this.l();
            }
        });
        this.e = (TextView) findViewById(R.id.webview_fail_view);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.q) {
                    NewVcodeActivity.this.f.setVisibility(0);
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
    public void n() {
        if (this.l != null) {
            this.l.cancel();
        }
        this.g.setVisibility(0);
        this.l = new ChangeVcodeTask(this, null);
        this.l.setPriority(3);
        this.l.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.p != null && this.p.length() > 0) {
            a(getString(R.string.sending), this.j);
            if (this.k != null) {
                this.k.cancel();
            }
            this.k = new PostThreadTask(this.f1886a);
            this.k.setPriority(3);
            this.k.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask {
        private WriteData b;
        private com.baidu.tieba.util.v c = null;
        private String d = null;

        public PostThreadTask(WriteData writeData) {
            this.b = null;
            this.b = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public bj a(Integer... numArr) {
            Address aK;
            this.c = new com.baidu.tieba.util.v();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String str = "";
            if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
            }
            this.c.a("new_vcode", "1");
            this.c.a("content", String.valueOf(this.b.getContent()) + str);
            this.c.a("vcode_md5", this.b.getVcodeMD5());
            this.c.a("vcode", NewVcodeActivity.this.p);
            this.c.a("vcode_tag", "11");
            this.c.e(true);
            if (this.b.getType() == 0) {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                if (!com.baidu.tieba.data.g.h().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().v() && (aK = TiebaApplication.g().aK()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.getType() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                    this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                }
            }
            this.d = this.c.j();
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.k = null;
            NewVcodeActivity.this.h();
            if (this.c != null) {
                this.c.h();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(bj bjVar) {
            NewVcodeActivity.this.h();
            NewVcodeActivity.this.k = null;
            if (this.c != null) {
                if (this.c.c()) {
                    com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                    rVar.b(this.d);
                    if (rVar.b() == null || rVar.b().length() <= 0) {
                        NewVcodeActivity.this.a(TiebaApplication.g().getString(R.string.send_success));
                    } else {
                        NewVcodeActivity.this.a(rVar.b());
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                } else {
                    if (this.c.e() == 5 || this.c.e() == 6) {
                        bj bjVar2 = new bj();
                        bjVar2.a(this.d);
                        if (bjVar2.b() != null) {
                            NewVcodeActivity.this.f1886a.setVcodeMD5(bjVar2.a());
                            NewVcodeActivity.this.f1886a.setVcodeUrl(bjVar2.b());
                            if (bjVar2.c().equals("4")) {
                                NewVcodeActivity.this.k();
                            } else {
                                NewVcodeActivity.this.a(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                                NewVcodeActivity.this.finish();
                            }
                        }
                    }
                    NewVcodeActivity.this.a(this.c.g());
                }
            }
            super.a((Object) bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask {

        /* renamed from: a  reason: collision with root package name */
        volatile com.baidu.tieba.util.v f1893a;
        bj b;

        private ChangeVcodeTask() {
            this.f1893a = null;
            this.b = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public bj a(String... strArr) {
            this.f1893a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/anti/vcode");
            this.f1893a.a("fid", NewVcodeActivity.this.f1886a.getForumId());
            this.f1893a.a("kw", NewVcodeActivity.this.f1886a.getForumName());
            this.f1893a.a("new_vcode", "1");
            this.f1893a.a("content", NewVcodeActivity.this.f1886a.getContent());
            if (NewVcodeActivity.this.f1886a.getType() == 0) {
                this.f1893a.a("title", NewVcodeActivity.this.f1886a.getTitle());
                this.f1893a.a("pub_type", "1");
            } else {
                this.f1893a.a("pub_type", "2");
                this.f1893a.a("tid", NewVcodeActivity.this.f1886a.getThreadId());
            }
            this.f1893a.a("vcode_tag", "11");
            String j = this.f1893a.j();
            if (this.f1893a.c()) {
                this.b = new bj();
                this.b.a(j);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(bj bjVar) {
            NewVcodeActivity.this.l = null;
            if (bjVar != null) {
                NewVcodeActivity.this.f1886a.setVcodeMD5(bjVar.a());
                NewVcodeActivity.this.f1886a.setVcodeUrl(bjVar.b());
                if (bjVar.c().equals("4")) {
                    NewVcodeActivity.this.k();
                } else {
                    NewVcodeActivity.this.a(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.a(this.f1893a.g());
            }
            NewVcodeActivity.this.g.setVisibility(8);
            super.a((Object) bjVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.l = null;
            if (this.f1893a != null) {
                this.f1893a.h();
            }
            NewVcodeActivity.this.g.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class VcodeJsInterface {
        VcodeJsInterface() {
        }

        public String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.f1886a.getVcodeUrl();
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
            return String.valueOf(TiebaApplication.g().an());
        }
    }
}
