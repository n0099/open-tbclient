package com.baidu.tieba.recommend;

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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class DailyClassicalActivity extends BaseActivity implements com.baidu.tbadk.coreExtra.view.f {
    private static boolean bHP = false;
    private static long bwJ = 0;
    private ImageView xL = null;
    private RelativeLayout mParent = null;
    private RelativeLayout bqh = null;
    private TextView atA = null;
    private View.OnClickListener bHI = null;
    private BaseWebView mWebView = null;
    private ProgressBar mProgressBar = null;
    private LinearLayout bHJ = null;
    private c bHK = null;
    private boolean bHL = false;
    private boolean bHM = true;
    private TextView bHN = null;
    private TextView bHO = null;
    private boolean aRl = false;
    private String bHQ = "1";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010021, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.day_classical_activity);
        initUI();
    }

    private void initUI() {
        this.mParent = (RelativeLayout) findViewById(v.parent);
        this.bqh = (RelativeLayout) findViewById(v.title);
        this.atA = (TextView) findViewById(v.title_text);
        this.bHJ = (LinearLayout) findViewById(v.tag_webview_item);
        this.xL = (ImageView) findViewById(v.back);
        this.bHN = (TextView) this.bHJ.findViewById(v.webview_fail);
        this.bHO = (TextView) this.bHJ.findViewById(v.webview_crash_tip);
        this.mProgressBar = (ProgressBar) findViewById(v.tag_progress);
        this.bHI = new b(this);
        this.xL.setOnClickListener(this.bHI);
        if (createWebView()) {
            this.bHO.setVisibility(8);
            refresh();
            return;
        }
        this.bHO.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.d(this.mParent, i);
        aw.g(this.bqh, i);
        aw.d(this.atA, i);
        aw.a(this.xL, i);
        if (this.mWebView != null) {
            aw.d(this.mWebView, i);
            refresh();
        }
    }

    public void refresh() {
        if (TbadkApplication.m251getInst().getWebviewCrashCount() == 0 && !createWebView()) {
            this.bHO.setVisibility(0);
            return;
        }
        this.bHO.setVisibility(8);
        if (!this.aRl) {
            this.aRl = true;
            this.mProgressBar.setVisibility(0);
            this.bHL = false;
            this.bHM = true;
            bT();
            this.bHK = new c(this, null);
            this.bHK.setPriority(3);
            this.bHK.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abG() {
        if (this.bHL) {
            if (!this.bHM) {
                showToast(getResources().getString(y.neterror));
            }
            this.aRl = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.f
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!com.baidu.tbadk.util.i.r(this, str)) {
            if (str.contains("jumptoapp_browser=classic_everyday")) {
                if (str.contains("pn=")) {
                    String Z = Z(str, "pn=");
                    if (Z != null && Z.length() >= 0) {
                        this.bHQ = Z;
                    }
                } else {
                    this.bHQ = "1";
                }
                refresh();
            } else {
                com.baidu.tbadk.browser.a.j(this, String.valueOf(str) + "&_client_version=" + TbConfig.getVersion());
            }
        }
        return true;
    }

    private String Z(String str, String str2) {
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

    private boolean createWebView() {
        boolean z = false;
        if (this.mWebView == null) {
            try {
                if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                    super.showToast(getString(y.web_view_corrupted));
                } else {
                    this.mWebView = new BaseWebView(this);
                    aw.d(this.mWebView, TbadkApplication.m251getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.bHJ.addView(this.mWebView);
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

    private void bT() {
        if (this.bHK != null) {
            this.bHK.cancel();
        }
    }
}
