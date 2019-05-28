package com.baidu.tieba.square.recommend;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes5.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.b {
    private static boolean iUc = false;
    private static long hJH = 0;
    private ImageView SD = null;
    private RelativeLayout mParent = null;
    private RelativeLayout iKC = null;
    private TextView faq = null;
    private View.OnClickListener iTV = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout iTW = null;
    private a iTX = null;
    private boolean iTY = false;
    private boolean iTZ = true;
    private TextView iUa = null;
    private TextView iUb = null;
    private boolean dls = false;
    private String iUd = "1";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2902021, new CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig>() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<DailyClassicalActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(DailyClassicalActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.day_classical_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(R.id.parent);
        this.iKC = (RelativeLayout) findViewById(R.id.title);
        this.faq = (TextView) findViewById(R.id.title_text);
        this.iTW = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.SD = (ImageView) findViewById(R.id.back);
        this.iUa = (TextView) this.iTW.findViewById(R.id.webview_fail);
        this.iUb = (TextView) this.iTW.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(R.id.tag_progress);
        this.iTV = new View.OnClickListener() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.back) {
                    DailyClassicalActivity.this.finish();
                } else if (id == R.id.tag_webview_item) {
                    DailyClassicalActivity.this.refresh();
                }
            }
        };
        this.SD.setOnClickListener(this.iTV);
        if (clc()) {
            this.iUb.setVisibility(8);
            refresh();
            return;
        }
        this.iUb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.g(this.mParent, i);
        al.i(this.iKC, i);
        al.c(this.faq, i);
        al.a(this.SD, i);
        if (this.mWebView != null) {
            al.g(this.mWebView, i);
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !clc()) {
            this.iUb.setVisibility(0);
            return;
        }
        this.iUb.setVisibility(8);
        if (!this.dls) {
            this.dls = true;
            this.mProgressBar.setVisibility(0);
            this.iTY = false;
            this.iTZ = true;
            gT();
            this.iTX = new a();
            this.iTX.setPriority(3);
            this.iTX.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clb() {
        if (this.iTY) {
            if (!this.iTZ) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.dls = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        int b = ba.aiz().b(getPageContext(), new String[]{str});
        if (b == 1) {
            finish();
            return true;
        } else if (b == 0) {
            return true;
        } else {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String ce = ce(str, "pn=");
                    if (ce != null && ce.length() >= 0) {
                        this.iUd = ce;
                    }
                } else {
                    this.iUd = "1";
                }
                refresh();
                return true;
            }
            com.baidu.tbadk.browser.a.ag(this, str + "&_client_version=" + TbConfig.getVersion());
            return true;
        }
    }

    private String ce(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            int length = str2.length() + indexOf;
            int i = length;
            while (i < str.length() && str.charAt(i) != '&') {
                i++;
            }
            return URLDecoder.decode(str.substring(length, i));
        }
        return "";
    }

    private boolean clc() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    al.g(this.mWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.iTW.addView(this.mWebView);
                    z = true;
                }
                return z;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return z;
            }
        }
        return true;
    }

    private void gT() {
        if (this.iTX != null) {
            this.iTX.cancel();
        }
    }

    public boolean getIsLocationOn() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private String data;
        private x mNetWork;

        private a() {
            this.mNetWork = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.mNetWork = new x(TbConfig.SERVER_ADDRESS + "c/s/tag/gettogether");
            this.mNetWork.ahC().aiB().aiE().bUf = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mNetWork.o("night_type", "1");
            }
            this.mNetWork.o(Config.PACKAGE_NAME, DailyClassicalActivity.this.iUd);
            this.mNetWork.o("_version_more", "1");
            this.mNetWork.o("platform", "android");
            if (DailyClassicalActivity.iUc) {
                boolean unused = DailyClassicalActivity.iUc = false;
                this.mNetWork.o("msg_click", "1");
                this.mNetWork.o(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, String.valueOf(DailyClassicalActivity.hJH));
            }
            Address X = com.baidu.adp.lib.d.a.hO().X(false);
            if (X != null && DailyClassicalActivity.this.getIsLocationOn()) {
                this.mNetWork.o("lbs", String.valueOf(X.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(X.getLongitude()));
            }
            try {
                this.data = this.mNetWork.ahe();
                if (this.mNetWork.ahF()) {
                    return this.data;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            DailyClassicalActivity.this.dls = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            DailyClassicalActivity.this.iTX = null;
            DailyClassicalActivity.this.iTW.setOnClickListener(null);
            if (this.mNetWork == null || !this.mNetWork.ahF() || str == null || str.length() <= 0) {
                DailyClassicalActivity.this.iTZ = false;
                DailyClassicalActivity.this.iUa.setVisibility(0);
                DailyClassicalActivity.this.mWebView.setVisibility(8);
                DailyClassicalActivity.this.iTW.setOnClickListener(DailyClassicalActivity.this.iTV);
            } else {
                DailyClassicalActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
                DailyClassicalActivity.this.iUa.setVisibility(8);
                DailyClassicalActivity.this.mWebView.setVisibility(0);
            }
            DailyClassicalActivity.this.iTY = true;
            DailyClassicalActivity.this.clb();
        }
    }
}
