package com.baidu.tieba.write;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.location.Address;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class NewVcodeActivity extends BaseActivity {
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

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ap.class, NewVcodeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.new_vcode_activity);
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

    @JavascriptInterface
    @SuppressLint({"SetJavaScriptEnabled"})
    private boolean a() {
        if (this.j == null) {
            try {
                this.j = (BaseWebView) findViewById(com.baidu.tieba.r.new_vcode_webview);
                com.baidu.tbadk.core.util.bc.a(this.j, TbadkApplication.m252getInst().getSkinType());
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
                BdLog.e(getClass().getName(), "", "NewVcodeActivity.initWebView error = " + e.getMessage());
                com.baidu.tieba.ad.c().e(com.baidu.tieba.ad.c().z() + 1);
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
            this.j.loadUrl(com.baidu.tieba.util.r.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/gridcaptcha?version=" + TbConfig.getVersion()));
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
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
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
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.c(i);
        com.baidu.tbadk.core.util.bc.g(this.c, i);
        com.baidu.tbadk.core.util.bc.a((View) this.d, i);
        if (this.j != null) {
            com.baidu.tbadk.core.util.bc.a(this.j, TbadkApplication.m252getInst().getSkinType());
        }
    }

    private void f() {
        this.e = (ProgressBar) findViewById(com.baidu.tieba.r.load_webview_progress);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.r.change_vcode_progress);
        this.a = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.a.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.p);
        this.c = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.u.send), this.q);
        this.d = (TextView) findViewById(com.baidu.tieba.r.webview_fail_view);
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
            this.mWaitingDialog = ProgressDialog.show(this, "", getString(com.baidu.tieba.u.sending), true, true, this.g);
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
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.al> {
        private WriteData b;
        private com.baidu.tbadk.core.util.al c = null;
        private String d = null;

        public PostThreadTask(WriteData writeData) {
            this.b = null;
            this.b = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public com.baidu.tieba.data.al doInBackground(Integer... numArr) {
            Address b;
            this.c = new com.baidu.tbadk.core.util.al();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String imagesCodeForPost = this.b.getImagesCodeForPost();
            this.c.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
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
                this.c.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                this.c.a("is_ntitle", this.b.isNoTitle() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                if (this.b.getLiveCardData() != null) {
                    this.c.a(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, String.valueOf(this.b.getLiveCardData().getGroupId()));
                    this.c.a("start_time", String.valueOf(this.b.getLiveCardData().getStartTime()));
                }
                if (!TbConfig.getPositionPagerId().equals(NewVcodeActivity.this.getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID)) && com.baidu.tieba.ad.c().m() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", NewVcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                if (this.b.getType() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                    this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                    this.c.a("is_addition", this.b.isAddition() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                }
            }
            this.d = this.c.i();
            if (this.c.a().b().b()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                String error_msg = errorData.getError_msg();
                if (com.baidu.adp.lib.util.g.b(error_msg)) {
                    error_msg = com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.send_success);
                } else if (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                    error_msg = com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.img_upload_error);
                }
                com.baidu.tieba.data.al alVar = new com.baidu.tieba.data.al(errorData.getError_code(), error_msg, null);
                if (!alVar.a()) {
                    this.b.deleteUploadedTempImages();
                    if (this.b.getType() == 1 && !this.b.isSubFloor()) {
                        com.baidu.tieba.util.m.b(this.b.getThreadId(), (WriteData) null);
                    }
                }
                return alVar;
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                return new com.baidu.tieba.data.al(this.c.d(), com.baidu.tieba.ad.c().d().getString(com.baidu.tieba.u.img_upload_error), null);
            } else {
                return new com.baidu.tieba.data.al(this.c.d(), this.c.f(), null);
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.data.al alVar) {
            super.onPostExecute(alVar);
            NewVcodeActivity.this.closeLoadingDialog();
            NewVcodeActivity.this.h = null;
            if (alVar != null && this.c != null) {
                if (this.c.a().b().b()) {
                    NewVcodeActivity.this.showToast(alVar.c());
                    if (this.b.getLiveCardData() != null) {
                        NewVcodeActivity.this.sendMessage(new CustomMessage(2005001, new com.baidu.tbadk.core.atomData.m(NewVcodeActivity.this).c(this.b.getForumName(), "post live's thread")));
                    }
                    NewVcodeActivity.this.setResult(-1, NewVcodeActivity.this.getIntent());
                    NewVcodeActivity.this.finish();
                    return;
                }
                if (alVar.b()) {
                    com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                    fVar.a(this.d);
                    if (fVar.b() != null) {
                        NewVcodeActivity.this.b.setVcodeMD5(fVar.a());
                        NewVcodeActivity.this.b.setVcodeUrl(fVar.b());
                        if (fVar.c().equals("4")) {
                            NewVcodeActivity.this.d();
                        } else {
                            NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.u.change_vcode_type));
                            NewVcodeActivity.this.finish();
                        }
                    }
                }
                NewVcodeActivity.this.showToast(alVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ChangeVcodeTask extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.f> {
        volatile com.baidu.tbadk.core.util.al a;
        com.baidu.tbadk.coreExtra.data.f b;

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
        /* renamed from: a */
        public com.baidu.tbadk.coreExtra.data.f doInBackground(String... strArr) {
            this.a = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.a.a("fid", NewVcodeActivity.this.b.getForumId());
            this.a.a("kw", NewVcodeActivity.this.b.getForumName());
            this.a.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            this.a.a("content", NewVcodeActivity.this.b.getContent());
            if (NewVcodeActivity.this.b.getVoice() != null) {
                this.a.a("voice_md5", NewVcodeActivity.this.b.getVoice());
                this.a.a("during_time", String.valueOf(NewVcodeActivity.this.b.getVoiceDuringTime()));
            }
            if (NewVcodeActivity.this.b.getType() == 0) {
                this.a.a("title", NewVcodeActivity.this.b.getTitle());
                this.a.a("pub_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            } else {
                this.a.a("pub_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
            NewVcodeActivity.this.i = null;
            if (fVar != null) {
                NewVcodeActivity.this.b.setVcodeMD5(fVar.a());
                NewVcodeActivity.this.b.setVcodeUrl(fVar.b());
                if (fVar.c().equals("4")) {
                    NewVcodeActivity.this.d();
                } else {
                    NewVcodeActivity.this.showToast(NewVcodeActivity.this.getString(com.baidu.tieba.u.change_vcode_type));
                    NewVcodeActivity.this.finish();
                }
            } else {
                NewVcodeActivity.this.showToast(this.a.f());
            }
            NewVcodeActivity.this.f.setVisibility(8);
            super.onPostExecute(fVar);
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

        @JavascriptInterface
        public String jsGetVcodeImageUrl() {
            return NewVcodeActivity.this.b.getVcodeUrl();
        }

        @JavascriptInterface
        public void jsSetLoadVcodeFinished(boolean z, String str) {
            NewVcodeActivity.this.n = z;
            NewVcodeActivity.this.l = str;
        }

        @JavascriptInterface
        public void jsSetVcodeInputResult(boolean z, String str, String str2) {
            if (!z) {
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(2);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(2, NewVcodeActivity.this.getString(com.baidu.tieba.u.finish_input_vcode)));
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

        @JavascriptInterface
        public void jsCancelVcode() {
            NewVcodeActivity.this.finish();
        }

        @JavascriptInterface
        public void jsChangeVcode(String str) {
            if (str != null && str.length() > 0) {
                NewVcodeActivity.this.k = str;
                if (NewVcodeActivity.this.o != null) {
                    NewVcodeActivity.this.o.removeMessages(1);
                    NewVcodeActivity.this.o.sendMessage(NewVcodeActivity.this.o.obtainMessage(1));
                }
            }
        }

        @JavascriptInterface
        public String jsGetSkinType() {
            return String.valueOf(TbadkApplication.m252getInst().getSkinType());
        }
    }
}
