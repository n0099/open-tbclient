package com.baidu.tieba.write;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.be;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tieba.j {
    private TextView e;

    /* renamed from: a  reason: collision with root package name */
    private WriteData f2659a = null;
    private LinearLayout b = null;
    private ImageView c = null;
    private Button d = null;
    private ProgressBar f = null;
    private ProgressBar g = null;
    private DialogInterface.OnCancelListener h = null;
    private PostThreadTask i = null;
    private ChangeVcodeTask j = null;
    private BaseWebView k = null;
    private String l = null;
    private String m = null;
    private String n = null;
    private boolean o = false;
    private Handler p = null;

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
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
        f();
        a(bundle);
        if (a()) {
            this.f.setVisibility(0);
            c();
            return;
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f2659a = (WriteData) bundle.getSerializable("model");
        } else {
            this.f2659a = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.p = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        NewVcodeActivity.this.h();
                        return;
                    case 1:
                        NewVcodeActivity.this.g();
                        return;
                    case 2:
                        if (message.obj != null) {
                            NewVcodeActivity.this.showToast((String) message.obj);
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
    private boolean a() {
        if (this.k == null) {
            try {
                this.k = (BaseWebView) findViewById(R.id.new_vcode_webview);
                bd.a(this.k, TiebaApplication.g().ap());
                this.k.setHorizontalScrollBarEnabled(false);
                this.k.setHorizontalScrollbarOverlay(false);
                this.k.setScrollBarStyle(33554432);
                this.k.getSettings().setJavaScriptEnabled(true);
                this.k.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.k.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.f.setVisibility(8);
                        if (!NewVcodeActivity.this.o) {
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
                bg.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.g().j(TiebaApplication.g().as() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.k != null) {
            this.k.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.k != null) {
            this.k.loadUrl(UtilHelper.a(com.baidu.tieba.data.h.f1196a + "c/f/anti/gridcaptcha?version=" + com.baidu.tieba.data.h.j()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k != null && this.l != null && this.l.length() > 0) {
            this.k.loadUrl("javascript:" + this.l + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.k != null && this.o && this.m != null && this.m.length() > 0) {
            this.k.loadUrl("javascript:" + this.m + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.p != null) {
            this.p.removeMessages(1);
            this.p.removeMessages(0);
            this.p.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.f2659a);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bd.a(this.c, i);
        bd.f((TextView) this.d, i);
        bd.d(this.b, i);
        bd.a((View) this.e, i);
        if (this.k != null) {
            bd.a(this.k, TiebaApplication.g().ap());
        }
    }

    private void f() {
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
                NewVcodeActivity.this.e();
            }
        });
        this.e = (TextView) findViewById(R.id.webview_fail_view);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.o) {
                    NewVcodeActivity.this.f.setVisibility(0);
                    NewVcodeActivity.this.b();
                    NewVcodeActivity.this.c();
                }
            }
        });
        this.h = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.DeinitWaitingDialog();
                if (NewVcodeActivity.this.i != null) {
                    NewVcodeActivity.this.i.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.j != null) {
            this.j.cancel();
        }
        this.g.setVisibility(0);
        this.j = new ChangeVcodeTask();
        this.j.setPriority(3);
        this.j.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.n != null && this.n.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(this, "", getString(R.string.sending), true, true, this.h);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.i != null) {
                this.i.cancel();
            }
            this.i = new PostThreadTask(this.f2659a);
            this.i.setPriority(3);
            this.i.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, be> {
        private WriteData b;
        private com.baidu.tieba.util.ap c = null;
        private String d = null;

        public PostThreadTask(WriteData writeData) {
            this.b = null;
            this.b = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public be a(Integer... numArr) {
            Address aN;
            this.c = new com.baidu.tieba.util.ap();
            this.c.a("anonymous", SocialConstants.FALSE);
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String str = "";
            if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
            }
            this.c.a("new_vcode", SocialConstants.TRUE);
            this.c.a("content", this.b.getContent() + str);
            this.c.a("vcode_md5", this.b.getVcodeMD5());
            this.c.a("vcode", NewVcodeActivity.this.n);
            this.c.a("vcode_tag", "11");
            if (this.b.getVoice() != null) {
                this.c.a("voice_md5", this.b.getVoice());
                this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
            }
            this.c.e(true);
            if (this.b.getType() == 0) {
                this.c.a(com.baidu.tieba.data.h.f1196a + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                if (!com.baidu.tieba.data.h.h().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (aN = TiebaApplication.g().aN()) != null) {
                    this.c.a("lbs", String.valueOf(aN.getLatitude()) + "," + String.valueOf(aN.getLongitude()));
                }
            } else {
                this.c.a(com.baidu.tieba.data.h.f1196a + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
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
            NewVcodeActivity.this.i = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.c != null) {
                this.c.h();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(be beVar) {
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.i = null;
            if (this.c != null) {
                if (this.c.c()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.d);
                    if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                        NewVcodeActivity.this.showToast(TiebaApplication.g().getString(R.string.send_success));
                    } else {
                        NewVcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                } else {
                    if (this.c.e() == 5 || this.c.e() == 6) {
                        be beVar2 = new be();
                        beVar2.a(this.d);
                        if (beVar2.b() != null) {
                            NewVcodeActivity.this.f2659a.setVcodeMD5(beVar2.a());
                            NewVcodeActivity.this.f2659a.setVcodeUrl(beVar2.b());
                            if (beVar2.c().equals("4")) {
                                NewVcodeActivity.this.d();
                            } else {
                                NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                                NewVcodeActivity.this.finish();
                            }
                        }
                    }
                    NewVcodeActivity.this.showToast(this.c.g());
                }
            }
            super.a((PostThreadTask) beVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, be> {

        /* renamed from: a  reason: collision with root package name */
        volatile com.baidu.tieba.util.ap f2666a;
        be b;

        private ChangeVcodeTask() {
            this.f2666a = null;
            this.b = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public be a(String... strArr) {
            this.f2666a = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/f/anti/vcode");
            this.f2666a.a("fid", NewVcodeActivity.this.f2659a.getForumId());
            this.f2666a.a("kw", NewVcodeActivity.this.f2659a.getForumName());
            this.f2666a.a("new_vcode", SocialConstants.TRUE);
            this.f2666a.a("content", NewVcodeActivity.this.f2659a.getContent());
            if (NewVcodeActivity.this.f2659a.getVoice() != null) {
                this.f2666a.a("voice_md5", NewVcodeActivity.this.f2659a.getVoice());
                this.f2666a.a("during_time", String.valueOf(NewVcodeActivity.this.f2659a.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.f2659a.getType() == 0) {
                this.f2666a.a("title", NewVcodeActivity.this.f2659a.getTitle());
                this.f2666a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.f2666a.a("pub_type", "2");
                this.f2666a.a("tid", NewVcodeActivity.this.f2659a.getThreadId());
            }
            this.f2666a.a("vcode_tag", "11");
            String j = this.f2666a.j();
            if (this.f2666a.c()) {
                this.b = new be();
                this.b.a(j);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(be beVar) {
            NewVcodeActivity.this.j = null;
            if (beVar != null) {
                NewVcodeActivity.this.f2659a.setVcodeMD5(beVar.a());
                NewVcodeActivity.this.f2659a.setVcodeUrl(beVar.b());
                if (beVar.c().equals("4")) {
                    NewVcodeActivity.this.d();
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.f2666a.g());
            }
            NewVcodeActivity.this.g.setVisibility(8);
            super.a((ChangeVcodeTask) beVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.j = null;
            if (this.f2666a != null) {
                this.f2666a.h();
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
            return NewVcodeActivity.this.f2659a.getVcodeUrl();
        }

        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.o = z;
            NewVcodeActivity.this.m = str;
        }

        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.p != null) {
                    NewVcodeActivity.this.p.removeMessages(2);
                    NewVcodeActivity.this.p.sendMessage(NewVcodeActivity.this.p.obtainMessage(2, NewVcodeActivity.this.getString(R.string.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.n = str;
                NewVcodeActivity.this.l = str2;
                if (NewVcodeActivity.this.p != null) {
                    NewVcodeActivity.this.p.removeMessages(0);
                    NewVcodeActivity.this.p.sendMessage(NewVcodeActivity.this.p.obtainMessage(0));
                }
            }
        }

        public void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        public void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.l = str;
                if (NewVcodeActivity.this.p != null) {
                    NewVcodeActivity.this.p.removeMessages(1);
                    NewVcodeActivity.this.p.sendMessage(NewVcodeActivity.this.p.obtainMessage(1));
                }
            }
        }

        public String jsGetSkinType() {
            return String.valueOf(TiebaApplication.g().ap());
        }
    }
}
