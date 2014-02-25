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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseWebView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tieba.f {
    private TextView d;
    private WriteData b = null;
    private TextView c = null;
    private ProgressBar e = null;
    private ProgressBar f = null;
    private DialogInterface.OnCancelListener g = null;
    private PostThreadTask h = null;
    private ChangeVcodeTask i = null;
    private BaseWebView j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private boolean n = false;
    private Handler o = null;
    protected NavigationBar a = null;
    private final View.OnClickListener p = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.finish();
        }
    };
    private final View.OnClickListener q = new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewVcodeActivity.this.e();
        }
    };

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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
        f();
        a(bundle);
        if (a()) {
            this.e.setVisibility(0);
            c();
            return;
        }
        finish();
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = (WriteData) bundle.getSerializable("model");
        } else {
            this.b = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.o = new Handler() { // from class: com.baidu.tieba.write.NewVcodeActivity.3
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
        if (this.j == null) {
            try {
                this.j = (BaseWebView) findViewById(R.id.new_vcode_webview);
                com.baidu.tieba.util.bq.a(this.j, TiebaApplication.g().al());
                this.j.setHorizontalScrollBarEnabled(false);
                this.j.setHorizontalScrollbarOverlay(false);
                this.j.setScrollBarStyle(33554432);
                this.j.getSettings().setJavaScriptEnabled(true);
                this.j.addJavascriptInterface(new VcodeJsInterface(), "VcodeJsInterface");
                this.j.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.write.NewVcodeActivity.4
                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        NewVcodeActivity.this.e.setVisibility(8);
                        if (!NewVcodeActivity.this.n) {
                            NewVcodeActivity.this.d.setVisibility(0);
                        } else {
                            NewVcodeActivity.this.d.setVisibility(8);
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
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.g().i(TiebaApplication.g().ao() + 1);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j != null) {
            this.j.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j != null) {
            this.j.loadUrl(UtilHelper.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/gridcaptcha?version=" + com.baidu.tieba.data.i.u()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.j != null && this.k != null && this.k.length() > 0) {
            this.j.loadUrl("javascript:" + this.k + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.j != null && this.n && this.l != null && this.l.length() > 0) {
            this.j.loadUrl("javascript:" + this.l + "()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.cancel();
        }
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.e != null) {
            this.e.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setVisibility(8);
        }
        if (this.o != null) {
            this.o.removeMessages(1);
            this.o.removeMessages(0);
            this.o.removeMessages(2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.b);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.c(i);
        com.baidu.tieba.util.bq.h(this.c, i);
        com.baidu.tieba.util.bq.a((View) this.d, i);
        if (this.j != null) {
            com.baidu.tieba.util.bq.a(this.j, TiebaApplication.g().al());
        }
    }

    private void f() {
        this.e = (ProgressBar) findViewById(R.id.load_webview_progress);
        this.f = (ProgressBar) findViewById(R.id.change_vcode_progress);
        this.a = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.p);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.send), this.q);
        this.d = (TextView) findViewById(R.id.webview_fail_view);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.n) {
                    NewVcodeActivity.this.e.setVisibility(0);
                    NewVcodeActivity.this.b();
                    NewVcodeActivity.this.c();
                }
            }
        });
        this.g = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewVcodeActivity.this.DeinitWaitingDialog();
                if (NewVcodeActivity.this.h != null) {
                    NewVcodeActivity.this.h.cancel();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.i != null) {
            this.i.cancel();
        }
        this.f.setVisibility(0);
        this.i = new ChangeVcodeTask(this, null);
        this.i.setPriority(3);
        this.i.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.m != null && this.m.length() > 0) {
            this.mWaitingDialog = ProgressDialog.show(this, "", getString(R.string.sending), true, true, this.g);
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
            if (this.h != null) {
                this.h.cancel();
            }
            this.h = new PostThreadTask(this.b);
            this.h.setPriority(3);
            this.h.execute(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, ai> {
        private WriteData b;
        private com.baidu.tieba.util.ba c = null;
        private String d = null;

        public PostThreadTask(WriteData writeData) {
            this.b = null;
            this.b = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public ai a(Integer... numArr) {
            Address b;
            this.c = new com.baidu.tieba.util.ba();
            this.c.a("anonymous", SocialConstants.FALSE);
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String imagesCodeForPost = this.b.getImagesCodeForPost();
            this.c.a("new_vcode", SocialConstants.TRUE);
            this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.getContent()) + imagesCodeForPost);
            this.c.a("vcode_md5", this.b.getVcodeMD5());
            this.c.a("vcode", NewVcodeActivity.this.m);
            this.c.a("vcode_tag", "11");
            if (this.b.getVoice() != null) {
                this.c.a("voice_md5", this.b.getVoice());
                this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
            }
            this.c.e(true);
            if (this.b.getType() == 0) {
                this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                if (!com.baidu.tieba.data.i.s().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
                if (this.b.getType() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                    this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                }
            }
            this.d = this.c.m();
            if (this.c.d()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.h.b(error_msg)) {
                    error_msg = TiebaApplication.g().b().getString(R.string.send_success);
                } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                    error_msg = TiebaApplication.g().b().getString(R.string.img_upload_error);
                }
                ai aiVar = new ai(errorData.getError_code(), error_msg, null);
                if (!aiVar.a()) {
                    this.b.deleteUploadedTempImages();
                    if (this.b.getType() == 1 && !this.b.isSubFloor()) {
                        af.b(this.b.getThreadId(), (WriteData) null);
                    }
                }
                return aiVar;
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                return new ai(this.c.f(), TiebaApplication.g().b().getString(R.string.img_upload_error), null);
            } else {
                return new ai(this.c.f(), this.c.j(), null);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.h = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.c != null) {
                this.c.k();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(ai aiVar) {
            super.a((PostThreadTask) aiVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.h = null;
            if (aiVar != null && this.c != null) {
                if (this.c.d()) {
                    NewVcodeActivity.this.showToast(aiVar.d());
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (aiVar.b()) {
                    com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
                    bdVar.a(this.d);
                    if (bdVar.b() != null) {
                        NewVcodeActivity.this.b.setVcodeMD5(bdVar.a());
                        NewVcodeActivity.this.b.setVcodeUrl(bdVar.b());
                        if (bdVar.c().equals("4")) {
                            NewVcodeActivity.this.d();
                        } else {
                            NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(aiVar.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tieba.data.bd> {
        volatile com.baidu.tieba.util.ba a;
        com.baidu.tieba.data.bd b;

        private ChangeVcodeTask() {
            this.a = null;
            this.b = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, ChangeVcodeTask changeVcodeTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public com.baidu.tieba.data.bd a(String... strArr) {
            this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/vcode");
            this.a.a("fid", NewVcodeActivity.this.b.getForumId());
            this.a.a("kw", NewVcodeActivity.this.b.getForumName());
            this.a.a("new_vcode", SocialConstants.TRUE);
            this.a.a(PushConstants.EXTRA_CONTENT, NewVcodeActivity.this.b.getContent());
            if (NewVcodeActivity.this.b.getVoice() != null) {
                this.a.a("voice_md5", NewVcodeActivity.this.b.getVoice());
                this.a.a("during_time", String.valueOf(NewVcodeActivity.this.b.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.b.getType() == 0) {
                this.a.a("title", NewVcodeActivity.this.b.getTitle());
                this.a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.a.a("pub_type", "2");
                this.a.a("tid", NewVcodeActivity.this.b.getThreadId());
            }
            this.a.a("vcode_tag", "11");
            String m = this.a.m();
            if (this.a.d()) {
                this.b = new com.baidu.tieba.data.bd();
                this.b.a(m);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void a(com.baidu.tieba.data.bd bdVar) {
            NewVcodeActivity.this.i = null;
            if (bdVar != null) {
                NewVcodeActivity.this.b.setVcodeMD5(bdVar.a());
                NewVcodeActivity.this.b.setVcodeUrl(bdVar.b());
                if (bdVar.c().equals("4")) {
                    NewVcodeActivity.this.d();
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.a.j());
            }
            NewVcodeActivity.this.f.setVisibility(8);
            super.a((ChangeVcodeTask) bdVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.i = null;
            if (this.a != null) {
                this.a.k();
            }
            NewVcodeActivity.this.f.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class VcodeJsInterface {
        VcodeJsInterface() {
        }

        public String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.b.getVcodeUrl();
        }

        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.n = z;
            NewVcodeActivity.this.l = str;
        }

        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(2);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(2, NewVcodeActivity.this.getString(R.string.finish_input_vcode)));
                }
            } else if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
                NewVcodeActivity.this.m = str;
                NewVcodeActivity.this.k = str2;
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(0);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(0));
                }
            }
        }

        public void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        public void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.k = str;
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(1);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(1));
                }
            }
        }

        public String jsGetSkinType() {
            return String.valueOf(TiebaApplication.g().al());
        }
    }
}
