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
            NewVcodeActivity.a(NewVcodeActivity.this);
        }
    };

    public static void a(Activity activity, WriteData writeData, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", writeData);
            activity.startActivityForResult(intent, 12006);
        }
    }

    public static void a(Activity activity, WriteData writeData, boolean z, int i) {
        if (writeData != null) {
            Intent intent = new Intent(activity, NewVcodeActivity.class);
            intent.putExtra("model", writeData);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, 12006);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_vcode_activity);
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
                this.j = (BaseWebView) findViewById(R.id.new_vcode_webview);
                com.baidu.tieba.util.bq.a(this.j, TiebaApplication.g().ae());
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                TiebaApplication.g().i(TiebaApplication.g().ah() + 1);
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
            this.j.loadUrl(UtilHelper.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/gridcaptcha?version=" + com.baidu.tieba.data.i.u()));
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
        this.a.b(i);
        com.baidu.tieba.util.bq.h(this.c, i);
        com.baidu.tieba.util.bq.a((View) this.d, i);
        if (this.j != null) {
            com.baidu.tieba.util.bq.a(this.j, TiebaApplication.g().ae());
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
        newVcodeActivity.mWaitingDialog = ProgressDialog.show(newVcodeActivity, "", newVcodeActivity.getString(R.string.sending), true, true, newVcodeActivity.g);
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
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, ah> {
        private WriteData b;
        private com.baidu.tieba.util.ba c = null;
        private String d = null;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ ah a(Integer... numArr) {
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
                if (!com.baidu.tieba.data.i.s().equals(NewVcodeActivity.this.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().o() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
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
            this.d = this.c.l();
            if (!this.c.c()) {
                return (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(new StringBuilder(String.valueOf(this.b.getContent())).append(imagesCodeForPost).toString())) ? new ah(this.c.e(), TiebaApplication.g().b().getString(R.string.img_upload_error), null) : new ah(this.c.e(), this.c.i(), null);
            }
            ErrorData errorData = new ErrorData();
            errorData.parserJson(this.d);
            String error_msg = errorData.getError_msg();
            if (com.baidu.adp.lib.util.g.b(error_msg)) {
                error_msg = TiebaApplication.g().b().getString(R.string.send_success);
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                error_msg = TiebaApplication.g().b().getString(R.string.img_upload_error);
            }
            ah ahVar = new ah(errorData.getError_code(), error_msg, null);
            if (!ahVar.a()) {
                this.b.deleteUploadedTempImages();
                if (this.b.getType() == 1 && !this.b.isSubFloor()) {
                    ae.b(this.b.getThreadId(), (WriteData) null);
                }
            }
            return ahVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void a(ah ahVar) {
            ah ahVar2 = ahVar;
            super.a((PostThreadTask) ahVar2);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.h = null;
            if (ahVar2 == null || this.c == null) {
                return;
            }
            if (this.c.c()) {
                NewVcodeActivity.this.showToast(ahVar2.b);
                NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                NewVcodeActivity.this.finish();
                return;
            }
            if (ahVar2.b()) {
                com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
                bdVar.a(this.d);
                if (bdVar.b() != null) {
                    NewVcodeActivity.this.b.setVcodeMD5(bdVar.a());
                    NewVcodeActivity.this.b.setVcodeUrl(bdVar.b());
                    if (bdVar.c().equals("4")) {
                        NewVcodeActivity.d(NewVcodeActivity.this);
                    } else {
                        NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                        NewVcodeActivity.this.finish();
                    }
                }
            }
            NewVcodeActivity.this.showToast(ahVar2.b);
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
                this.c.j();
            }
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tieba.data.bd> {
        volatile com.baidu.tieba.util.ba a;
        com.baidu.tieba.data.bd b;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ com.baidu.tieba.data.bd a(String... strArr) {
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
            String l = this.a.l();
            if (this.a.c()) {
                this.b = new com.baidu.tieba.data.bd();
                this.b.a(l);
                return this.b;
            }
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public final /* synthetic */ void a(com.baidu.tieba.data.bd bdVar) {
            com.baidu.tieba.data.bd bdVar2 = bdVar;
            NewVcodeActivity.this.i = null;
            if (bdVar2 != null) {
                NewVcodeActivity.this.b.setVcodeMD5(bdVar2.a());
                NewVcodeActivity.this.b.setVcodeUrl(bdVar2.b());
                if (bdVar2.c().equals("4")) {
                    NewVcodeActivity.d(NewVcodeActivity.this);
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(R.string.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.a.i());
            }
            NewVcodeActivity.this.f.setVisibility(8);
            super.a((ChangeVcodeTask) bdVar2);
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
                this.a.j();
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
            return String.valueOf(TiebaApplication.g().ae());
        }
    }
}
