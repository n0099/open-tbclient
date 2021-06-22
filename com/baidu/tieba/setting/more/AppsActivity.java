package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import d.a.c.e.m.h;
/* loaded from: classes5.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    public static final long PULL_INVERVAL = 86400000;
    public String mUrl = null;
    public BaseWebView mWebView = null;
    public ImageView mBack = null;
    public d mTask = null;
    public LinearLayout mFailView = null;
    public ProgressBar mProcess = null;
    public ImageView mRefresh = null;
    public RelativeLayout mParent = null;
    public RelativeLayout mTitle = null;
    public TextView mTitleText = null;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppsActivity.this.refresh();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppsActivity.this.refresh();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AppsActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Object, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20583a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f20584b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f20586e;

            public a(d dVar, String str) {
                this.f20586e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                TbadkCoreApplication.getInst().cashNoAccountData(this.f20586e, 7);
            }
        }

        public d(String str) {
            this.f20584b = null;
            this.f20584b = str;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            NetWork netWork = this.f20583a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            AppsActivity.this.mProcess.setVisibility(8);
            AppsActivity.this.mTask = null;
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.mProcess.setVisibility(0);
            AppsActivity.this.mFailView.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            String str = this.f20584b;
            if (str == null) {
                return null;
            }
            NetWork netWork = new NetWork(str);
            this.f20583a = netWork;
            netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
            this.f20583a.addPostData("client", "android");
            return this.f20583a.postNetData();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.mProcess.setVisibility(8);
            NetWork netWork = this.f20583a;
            if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                if (!AppsActivity.this.loadCacheData() && str == null) {
                    AppsActivity.this.mWebView.setVisibility(8);
                    AppsActivity.this.mFailView.setVisibility(0);
                    AppsActivity appsActivity = AppsActivity.this;
                    appsActivity.showToast(appsActivity.getPageContext().getString(R.string.neterror));
                    return;
                }
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(R.string.server_404), SapiWebView.DATA_MIME_TYPE, "utf-8", "");
                return;
            }
            h.a().b(new a(this, str));
            d.a.n0.r.d0.b.j().w("app_inverval", System.currentTimeMillis());
            AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
        }
    }

    private void InitData(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - d.a.n0.r.d0.b.j().l("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (loadCacheData()) {
        } else {
            refresh();
        }
    }

    private void InitUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.mTitle = (RelativeLayout) findViewById(R.id.title);
        this.mTitleText = (TextView) findViewById(R.id.title_text);
        BaseWebView baseWebView = (BaseWebView) findViewById(R.id.app_webView);
        this.mWebView = baseWebView;
        baseWebView.setDownloadEnabled(true);
        this.mProcess = (ProgressBar) findViewById(R.id.app_progress);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.mFailView = linearLayout;
        linearLayout.setOnClickListener(new a());
        ImageView imageView = (ImageView) findViewById(R.id.refresh);
        this.mRefresh = imageView;
        imageView.setOnClickListener(new b());
        ImageView imageView2 = (ImageView) findViewById(R.id.back);
        this.mBack = imageView2;
        imageView2.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadCacheData() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.mProcess.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        d dVar = this.mTask;
        if (dVar != null) {
            dVar.cancel();
        }
        d dVar2 = new d(this.mUrl);
        this.mTask = dVar2;
        dVar2.setPriority(3);
        this.mTask.execute(new Object[0]);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setBgColor(this.mParent, i2);
        SkinManager.setBgColor(this.mWebView, i2);
        SkinManager.setTopBarBgImage(this.mTitle, i2);
        SkinManager.setTopBarBackBgImage(this.mBack, i2);
        SkinManager.setTopBarTitleColor(this.mTitleText, i2);
        SkinManager.setTopBarRefrshBgImage(this.mRefresh, i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        InitUI();
        InitData(bundle);
    }
}
