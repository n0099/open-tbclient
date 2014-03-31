package com.baidu.tieba.write;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class NewVcodeActivity extends com.baidu.tbadk.a {
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
            NewVcodeActivity.a(NewVcodeActivity.this);
        }
    };

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.ac.class, NewVcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.new_vcode_activity);
        this.e = (ProgressBar) findViewById(com.baidu.tieba.a.h.load_webview_progress);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.a.h.change_vcode_progress);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.p);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.a.k.send), this.q);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.webview_fail_view);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.NewVcodeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!NewVcodeActivity.this.n) {
                    NewVcodeActivity.this.e.setVisibility(0);
                    NewVcodeActivity.l(NewVcodeActivity.this);
                    NewVcodeActivity.this.b();
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
                        NewVcodeActivity.h(NewVcodeActivity.this);
                        return;
                    case 1:
                        NewVcodeActivity.g(NewVcodeActivity.this);
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
        if (a()) {
            this.e.setVisibility(0);
            b();
            return;
        }
        finish();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean a() {
        if (this.j == null) {
            try {
                this.j = (BaseWebView) findViewById(com.baidu.tieba.a.h.new_vcode_webview);
                com.baidu.tbadk.core.util.ba.a(this.j, TbadkApplication.j().l());
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
                com.baidu.tieba.r.c().f(com.baidu.tieba.r.c().x() + 1);
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void l(NewVcodeActivity newVcodeActivity) {
        if (newVcodeActivity.j != null) {
            newVcodeActivity.j.stopLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j != null) {
            this.j.loadUrl(UtilHelper.appendCuidParam(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/anti/gridcaptcha?version=" + com.baidu.tbadk.core.data.n.c()));
        }
    }

    static /* synthetic */ void d(NewVcodeActivity newVcodeActivity) {
        if (newVcodeActivity.j == null || newVcodeActivity.k == null || newVcodeActivity.k.length() <= 0) {
            return;
        }
        newVcodeActivity.j.loadUrl("javascript:" + newVcodeActivity.k + "()");
    }

    static /* synthetic */ void a(NewVcodeActivity newVcodeActivity) {
        if (newVcodeActivity.j == null || !newVcodeActivity.n || newVcodeActivity.l == null || newVcodeActivity.l.length() <= 0) {
            return;
        }
        newVcodeActivity.j.loadUrl("javascript:" + newVcodeActivity.l + "()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.b(i);
        com.baidu.tbadk.core.util.ba.g(this.c, i);
        com.baidu.tbadk.core.util.ba.a((View) this.d, i);
        if (this.j != null) {
            com.baidu.tbadk.core.util.ba.a(this.j, TbadkApplication.j().l());
        }
    }

    static /* synthetic */ void g(NewVcodeActivity newVcodeActivity) {
        if (newVcodeActivity.i != null) {
            newVcodeActivity.i.cancel();
        }
        newVcodeActivity.f.setVisibility(0);
        newVcodeActivity.i = new ChangeVcodeTask(newVcodeActivity, (byte) 0);
        newVcodeActivity.i.setPriority(3);
        newVcodeActivity.i.execute(new String[0]);
    }

    static /* synthetic */ void h(NewVcodeActivity newVcodeActivity) {
        if (newVcodeActivity.m == null || newVcodeActivity.m.length() <= 0) {
            return;
        }
        newVcodeActivity.mWaitingDialog = ProgressDialog.show(newVcodeActivity, "", newVcodeActivity.getString(com.baidu.tieba.a.k.sending), true, true, newVcodeActivity.g);
        newVcodeActivity.mWaitingDialog.setCanceledOnTouchOutside(false);
        if (newVcodeActivity.h != null) {
            newVcodeActivity.h.cancel();
        }
        newVcodeActivity.h = new PostThreadTask(newVcodeActivity.b);
        newVcodeActivity.h.setPriority(3);
        newVcodeActivity.h.execute(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.ak> {
        private WriteData b;
        private com.baidu.tbadk.core.util.ak c = null;
        private String d = null;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ com.baidu.tieba.data.ak a(Integer... numArr) {
            com.baidu.tbadk.core.util.ak akVar;
            String str;
            String str2;
            Address b;
            this.c = new com.baidu.tbadk.core.util.ak();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String imagesCodeForPost = this.b.getImagesCodeForPost();
            this.c.a("new_vcode", "1");
            this.c.a("content", String.valueOf(this.b.getContent()) + imagesCodeForPost);
            this.c.a("vcode_md5", this.b.getVcodeMD5());
            this.c.a("vcode", NewVcodeActivity.this.m);
            this.c.a("vcode_tag", "11");
            if (this.b.getVoice() != null) {
                this.c.a("voice_md5", this.b.getVoice());
                this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
            }
            this.c.a().a().a = true;
            if (this.b.getType() == 0) {
                this.c.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                this.c.a("is_ntitle", this.b.isNoTitle() ? "1" : "0");
                if (!com.baidu.tbadk.core.data.n.y().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.r.c().j() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                    akVar = this.c;
                    str = "lbs";
                    str2 = String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude());
                    akVar.a(str, str2);
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.getType() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                    this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                    akVar = this.c;
                    str = "is_addition";
                    str2 = this.b.isAddition() ? "1" : "0";
                    akVar.a(str, str2);
                }
            }
            this.d = this.c.i();
            if (!this.c.a().b().b()) {
                if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                    int d = this.c.d();
                    com.baidu.tieba.r.c();
                    return new com.baidu.tieba.data.ak(d, com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.img_upload_error), null);
                }
                return new com.baidu.tieba.data.ak(this.c.d(), this.c.f(), null);
            }
            ErrorData errorData = new ErrorData();
            errorData.parserJson(this.d);
            String error_msg = errorData.getError_msg();
            if (com.baidu.adp.lib.util.h.b(error_msg)) {
                com.baidu.tieba.r.c();
                error_msg = com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.send_success);
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                com.baidu.tieba.r.c();
                error_msg = com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.img_upload_error);
            }
            com.baidu.tieba.data.ak akVar2 = new com.baidu.tieba.data.ak(errorData.getError_code(), error_msg, null);
            if (!akVar2.a()) {
                this.b.deleteUploadedTempImages();
                if (this.b.getType() == 1 && !this.b.isSubFloor()) {
                    com.baidu.tieba.util.m.b(this.b.getThreadId(), (WriteData) null);
                }
            }
            return akVar2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void a(com.baidu.tieba.data.ak akVar) {
            com.baidu.tieba.data.ak akVar2 = akVar;
            super.a((PostThreadTask) akVar2);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.h = null;
            if (akVar2 == null || this.c == null) {
                return;
            }
            if (this.c.a().b().b()) {
                NewVcodeActivity.this.showToast(akVar2.c());
                NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                NewVcodeActivity.this.finish();
                return;
            }
            if (akVar2.b()) {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.a(this.d);
                if (fVar.b() != null) {
                    NewVcodeActivity.this.b.setVcodeMD5(fVar.a());
                    NewVcodeActivity.this.b.setVcodeUrl(fVar.b());
                    if (fVar.c().equals("4")) {
                        NewVcodeActivity.d(NewVcodeActivity.this);
                    } else {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.a.k.change_vcode_type));
                        NewVcodeActivity.this.finish();
                    }
                }
            }
            NewVcodeActivity.this.showToast(akVar2.c());
        }

        public PostThreadTask(WriteData writeData) {
            this.b = null;
            this.b = writeData;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.h = null;
            NewVcodeActivity.this.closeLoadingDialog();
            if (this.c != null) {
                this.c.g();
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        volatile com.baidu.tbadk.core.util.ak a;
        com.baidu.tbadk.coreExtra.data.f b;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ com.baidu.tbadk.coreExtra.data.f a(String... strArr) {
            this.a = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/anti/vcode");
            this.a.a("fid", NewVcodeActivity.this.b.getForumId());
            this.a.a("kw", NewVcodeActivity.this.b.getForumName());
            this.a.a("new_vcode", "1");
            this.a.a("content", NewVcodeActivity.this.b.getContent());
            if (NewVcodeActivity.this.b.getVoice() != null) {
                this.a.a("voice_md5", NewVcodeActivity.this.b.getVoice());
                this.a.a("during_time", String.valueOf(NewVcodeActivity.this.b.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.b.getType() == 0) {
                this.a.a("title", NewVcodeActivity.this.b.getTitle());
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                this.a.a("tid", NewVcodeActivity.this.b.getThreadId());
            }
            this.a.a("vcode_tag", "11");
            String i = this.a.i();
            if (this.a.a().b().b()) {
                this.b = new com.baidu.tbadk.coreExtra.data.f();
                this.b.a(i);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void a(com.baidu.tbadk.coreExtra.data.f fVar) {
            com.baidu.tbadk.coreExtra.data.f fVar2 = fVar;
            NewVcodeActivity.this.i = null;
            if (fVar2 != null) {
                NewVcodeActivity.this.b.setVcodeMD5(fVar2.a());
                NewVcodeActivity.this.b.setVcodeUrl(fVar2.b());
                if (fVar2.c().equals("4")) {
                    NewVcodeActivity.d(NewVcodeActivity.this);
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.a.k.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.a.f());
            }
            NewVcodeActivity.this.f.setVisibility(8);
            super.a((ChangeVcodeTask) fVar2);
        }

        private ChangeVcodeTask() {
            this.a = null;
            this.b = null;
        }

        /* synthetic */ ChangeVcodeTask(NewVcodeActivity newVcodeActivity, byte b) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NewVcodeActivity.this.i = null;
            if (this.a != null) {
                this.a.g();
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

        public final String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.b.getVcodeUrl();
        }

        public final void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.n = z;
            NewVcodeActivity.this.l = str;
        }

        public final void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(2);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(2, NewVcodeActivity.this.getString(com.baidu.tieba.a.k.finish_input_vcode)));
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

        public final void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        public final void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.k = str;
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(1);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(1));
                }
            }
        }

        public final String jsGetSkinType() {
            return String.valueOf(TbadkApplication.j().l());
        }
    }
}
