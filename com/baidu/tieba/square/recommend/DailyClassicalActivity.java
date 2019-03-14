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
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes5.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.b {
    private static boolean iBB = false;
    private static long hsm = 0;
    private ImageView US = null;
    private RelativeLayout mParent = null;
    private RelativeLayout isb = null;
    private TextView eKt = null;
    private View.OnClickListener iBu = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout iBv = null;
    private a iBw = null;
    private boolean iBx = false;
    private boolean iBy = true;
    private TextView iBz = null;
    private TextView iBA = null;
    private boolean daI = false;
    private String iBC = "1";

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
        setContentView(d.h.day_classical_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.isb = (RelativeLayout) findViewById(d.g.title);
        this.eKt = (TextView) findViewById(d.g.title_text);
        this.iBv = (LinearLayout) findViewById(d.g.tag_webview_item);
        this.US = (ImageView) findViewById(d.g.back);
        this.iBz = (TextView) this.iBv.findViewById(d.g.webview_fail);
        this.iBA = (TextView) this.iBv.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(d.g.tag_progress);
        this.iBu = new View.OnClickListener() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int id = view.getId();
                if (id == d.g.back) {
                    DailyClassicalActivity.this.finish();
                } else if (id == d.g.tag_webview_item) {
                    DailyClassicalActivity.this.refresh();
                }
            }
        };
        this.US.setOnClickListener(this.iBu);
        if (cda()) {
            this.iBA.setVisibility(8);
            refresh();
            return;
        }
        this.iBA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.g(this.mParent, i);
        al.i(this.isb, i);
        al.c(this.eKt, i);
        al.a(this.US, i);
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
        if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !cda()) {
            this.iBA.setVisibility(0);
            return;
        }
        this.iBA.setVisibility(8);
        if (!this.daI) {
            this.daI = true;
            this.mProgressBar.setVisibility(0);
            this.iBx = false;
            this.iBy = true;
            hZ();
            this.iBw = new a();
            this.iBw.setPriority(3);
            this.iBw.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccZ() {
        if (this.iBx) {
            if (!this.iBy) {
                showToast(getResources().getString(d.j.neterror));
            }
            this.daI = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        int b = ba.adD().b(getPageContext(), new String[]{str});
        if (b == 1) {
            finish();
            return true;
        } else if (b == 0) {
            return true;
        } else {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String bU = bU(str, "pn=");
                    if (bU != null && bU.length() >= 0) {
                        this.iBC = bU;
                    }
                } else {
                    this.iBC = "1";
                }
                refresh();
                return true;
            }
            com.baidu.tbadk.browser.a.as(this, str + "&_client_version=" + TbConfig.getVersion());
            return true;
        }
    }

    private String bU(String str, String str2) {
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

    private boolean cda() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(d.j.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    al.g(this.mWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.iBv.addView(this.mWebView);
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

    private void hZ() {
        if (this.iBw != null) {
            this.iBw.cancel();
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
            this.mNetWork.acH().adF().adI().bMr = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mNetWork.x("night_type", "1");
            }
            this.mNetWork.x(Config.PACKAGE_NAME, DailyClassicalActivity.this.iBC);
            this.mNetWork.x("_version_more", "1");
            this.mNetWork.x("platform", "android");
            if (DailyClassicalActivity.iBB) {
                boolean unused = DailyClassicalActivity.iBB = false;
                this.mNetWork.x("msg_click", "1");
                this.mNetWork.x("message_id", String.valueOf(DailyClassicalActivity.hsm));
            }
            Address af = com.baidu.adp.lib.d.a.iW().af(false);
            if (af != null && DailyClassicalActivity.this.getIsLocationOn()) {
                this.mNetWork.x("lbs", String.valueOf(af.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(af.getLongitude()));
            }
            try {
                this.data = this.mNetWork.acj();
                if (this.mNetWork.acK()) {
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
                this.mNetWork.ji();
            }
            DailyClassicalActivity.this.daI = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            DailyClassicalActivity.this.iBw = null;
            DailyClassicalActivity.this.iBv.setOnClickListener(null);
            if (this.mNetWork == null || !this.mNetWork.acK() || str == null || str.length() <= 0) {
                DailyClassicalActivity.this.iBy = false;
                DailyClassicalActivity.this.iBz.setVisibility(0);
                DailyClassicalActivity.this.mWebView.setVisibility(8);
                DailyClassicalActivity.this.iBv.setOnClickListener(DailyClassicalActivity.this.iBu);
            } else {
                DailyClassicalActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
                DailyClassicalActivity.this.iBz.setVisibility(8);
                DailyClassicalActivity.this.mWebView.setVisibility(0);
            }
            DailyClassicalActivity.this.iBx = true;
            DailyClassicalActivity.this.ccZ();
        }
    }
}
