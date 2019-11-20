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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes5.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.b {
    private static boolean jcV = false;
    private static long hQD = 0;
    private ImageView BO = null;
    private RelativeLayout gyn = null;
    private RelativeLayout iTr = null;
    private TextView aqd = null;
    private View.OnClickListener jcO = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout jcP = null;
    private a jcQ = null;
    private boolean jcR = false;
    private boolean jcS = true;
    private TextView jcT = null;
    private TextView jcU = null;
    private boolean dvm = false;
    private String jcW = "1";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_SQUARE_DAILY_CLASSICLA, new CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig>() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.1
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
        this.gyn = (RelativeLayout) findViewById(R.id.parent);
        this.iTr = (RelativeLayout) findViewById(R.id.title);
        this.aqd = (TextView) findViewById(R.id.title_text);
        this.jcP = (LinearLayout) findViewById(R.id.tag_webview_item);
        this.BO = (ImageView) findViewById(R.id.back);
        this.jcT = (TextView) this.jcP.findViewById(R.id.webview_fail);
        this.jcU = (TextView) this.jcP.findViewById(R.id.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(R.id.tag_progress);
        this.jcO = new View.OnClickListener() { // from class: com.baidu.tieba.square.recommend.DailyClassicalActivity.2
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
        this.BO.setOnClickListener(this.jcO);
        if (cmO()) {
            this.jcU.setVisibility(8);
            refresh();
            return;
        }
        this.jcU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBgColor(this.gyn, i);
        am.setTopBarBgImage(this.iTr, i);
        am.setTopBarTitleColor(this.aqd, i);
        am.setTopBarBackBgImage(this.BO, i);
        if (this.mWebView != null) {
            am.setBgColor(this.mWebView, i);
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !cmO()) {
            this.jcU.setVisibility(0);
            return;
        }
        this.jcU.setVisibility(8);
        if (!this.dvm) {
            this.dvm = true;
            this.mProgressBar.setVisibility(0);
            this.jcR = false;
            this.jcS = true;
            cancelTask();
            this.jcQ = new a();
            this.jcQ.setPriority(3);
            this.jcQ.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmN() {
        if (this.jcR) {
            if (!this.jcS) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.dvm = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        int a2 = ba.amO().a(getPageContext(), new String[]{str});
        if (a2 == 1) {
            finish();
            return true;
        } else if (a2 == 0) {
            return true;
        } else {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String matchStringFromURL = getMatchStringFromURL(str, "pn=");
                    if (matchStringFromURL != null && matchStringFromURL.length() >= 0) {
                        this.jcW = matchStringFromURL;
                    }
                } else {
                    this.jcW = "1";
                }
                refresh();
                return true;
            }
            com.baidu.tbadk.browser.a.startInternalWebActivity(this, str + "&_client_version=" + TbConfig.getVersion());
            return true;
        }
    }

    private String getMatchStringFromURL(String str, String str2) {
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

    private boolean cmO() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(R.string.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    am.setBgColor(this.mWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.jcP.addView(this.mWebView);
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

    private void cancelTask() {
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
    }

    public boolean getIsLocationOn() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private x bUY;
        private String data;

        private a() {
            this.bUY = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            this.bUY = new x(TbConfig.SERVER_ADDRESS + "c/s/tag/gettogether");
            this.bUY.amp().amP().amS().mIsJson = false;
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.bUY.addPostData("night_type", "1");
            }
            this.bUY.addPostData(Config.PACKAGE_NAME, DailyClassicalActivity.this.jcW);
            this.bUY.addPostData("_version_more", "1");
            this.bUY.addPostData("platform", "android");
            if (DailyClassicalActivity.jcV) {
                boolean unused = DailyClassicalActivity.jcV = false;
                this.bUY.addPostData("msg_click", "1");
                this.bUY.addPostData("message_id", String.valueOf(DailyClassicalActivity.hQD));
            }
            Address address = com.baidu.adp.lib.d.a.fw().getAddress(false);
            if (address != null && DailyClassicalActivity.this.getIsLocationOn()) {
                this.bUY.addPostData("lbs", String.valueOf(address.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(address.getLongitude()));
            }
            try {
                this.data = this.bUY.postNetData();
                if (this.bUY.isNetSuccess()) {
                    return this.data;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            DailyClassicalActivity.this.dvm = false;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            DailyClassicalActivity.this.jcQ = null;
            DailyClassicalActivity.this.jcP.setOnClickListener(null);
            if (this.bUY == null || !this.bUY.isNetSuccess() || str == null || str.length() <= 0) {
                DailyClassicalActivity.this.jcS = false;
                DailyClassicalActivity.this.jcT.setVisibility(0);
                DailyClassicalActivity.this.mWebView.setVisibility(8);
                DailyClassicalActivity.this.jcP.setOnClickListener(DailyClassicalActivity.this.jcO);
            } else {
                DailyClassicalActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
                DailyClassicalActivity.this.jcT.setVisibility(8);
                DailyClassicalActivity.this.mWebView.setVisibility(0);
            }
            DailyClassicalActivity.this.jcR = true;
            DailyClassicalActivity.this.cmN();
        }
    }
}
