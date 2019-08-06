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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes5.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.b {
    private static boolean jbA = false;
    private static long hQQ = 0;
    private ImageView SX = null;
    private RelativeLayout mParent = null;
    private RelativeLayout iSc = null;
    private TextView ffR = null;
    private View.OnClickListener jbt = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout jbu = null;
    private a jbv = null;
    private boolean jbw = false;
    private boolean jbx = true;
    private TextView jby = null;
    private TextView jbz = null;
    private boolean dng = false;
    private String jbB = "1";

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
        this.iSc = (RelativeLayout) findViewById(R.id.title);
        this.ffR = (TextView) findViewById(R.id.title_text);
        this.jbu = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.SX = (ImageView) findViewById(R.id.back);
        this.jby = (TextView) this.jbu.findViewById(R.id.webview_fail);
        this.jbz = (TextView) this.jbu.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(R.id.tag_progress);
        this.jbt = new View.OnClickListener() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.2
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
        this.SX.setOnClickListener(this.jbt);
        if (con()) {
            this.jbz.setVisibility(8);
            refresh();
            return;
        }
        this.jbz.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.g(this.mParent, i);
        am.i(this.iSc, i);
        am.c(this.ffR, i);
        am.a(this.SX, i);
        if (this.mWebView != null) {
            am.g(this.mWebView, i);
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !con()) {
            this.jbz.setVisibility(0);
            return;
        }
        this.jbz.setVisibility(8);
        if (!this.dng) {
            this.dng = true;
            this.mProgressBar.setVisibility(0);
            this.jbw = false;
            this.jbx = true;
            hc();
            this.jbv = new a();
            this.jbv.setPriority(3);
            this.jbv.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void com() {
        if (this.jbw) {
            if (!this.jbx) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.dng = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        int b = bb.ajE().b(getPageContext(), new String[]{str});
        if (b == 1) {
            finish();
            return true;
        } else if (b == 0) {
            return true;
        } else {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String cf = cf(str, "pn=");
                    if (cf != null && cf.length() >= 0) {
                        this.jbB = cf;
                    }
                } else {
                    this.jbB = "1";
                }
                refresh();
                return true;
            }
            com.baidu.tbadk.browser.a.af(this, str + "&_client_version=" + TbConfig.getVersion());
            return true;
        }
    }

    private String cf(String str, String str2) {
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

    private boolean con() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    am.g(this.mWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.jbu.addView(this.mWebView);
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

    private void hc() {
        if (this.jbv != null) {
            this.jbv.cancel();
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
            this.mNetWork.aiG().ajG().ajJ().bVn = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mNetWork.o("night_type", "1");
            }
            this.mNetWork.o(Config.PACKAGE_NAME, DailyClassicalActivity.this.jbB);
            this.mNetWork.o("_version_more", "1");
            this.mNetWork.o("platform", "android");
            if (DailyClassicalActivity.jbA) {
                boolean unused = DailyClassicalActivity.jbA = false;
                this.mNetWork.o("msg_click", "1");
                this.mNetWork.o(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, String.valueOf(DailyClassicalActivity.hQQ));
            }
            Address X = com.baidu.adp.lib.d.a.hY().X(false);
            if (X != null && DailyClassicalActivity.this.getIsLocationOn()) {
                this.mNetWork.o("lbs", String.valueOf(X.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(X.getLongitude()));
            }
            try {
                this.data = this.mNetWork.aii();
                if (this.mNetWork.aiJ()) {
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
                this.mNetWork.ik();
            }
            DailyClassicalActivity.this.dng = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            DailyClassicalActivity.this.jbv = null;
            DailyClassicalActivity.this.jbu.setOnClickListener(null);
            if (this.mNetWork == null || !this.mNetWork.aiJ() || str == null || str.length() <= 0) {
                DailyClassicalActivity.this.jbx = false;
                DailyClassicalActivity.this.jby.setVisibility(0);
                DailyClassicalActivity.this.mWebView.setVisibility(8);
                DailyClassicalActivity.this.jbu.setOnClickListener(DailyClassicalActivity.this.jbt);
            } else {
                DailyClassicalActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
                DailyClassicalActivity.this.jby.setVisibility(8);
                DailyClassicalActivity.this.mWebView.setVisibility(0);
            }
            DailyClassicalActivity.this.jbw = true;
            DailyClassicalActivity.this.com();
        }
    }
}
