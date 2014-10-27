package com.baidu.tieba.recommend;

import android.location.Address;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ DailyClassicalActivity bHR;
    private String boq;
    private ac mNetWork;

    private c(DailyClassicalActivity dailyClassicalActivity) {
        this.bHR = dailyClassicalActivity;
        this.mNetWork = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(DailyClassicalActivity dailyClassicalActivity, c cVar) {
        this(dailyClassicalActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(Object... objArr) {
        String str;
        boolean z;
        long j;
        this.mNetWork = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/tag/gettogether");
        this.mNetWork.mc().na().nd().Gm = false;
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.mNetWork.k("night_type", "1");
        }
        ac acVar = this.mNetWork;
        str = this.bHR.bHQ;
        acVar.k("pn", str);
        this.mNetWork.k("_version_more", "1");
        this.mNetWork.k("platform", "android");
        z = DailyClassicalActivity.bHP;
        if (z) {
            DailyClassicalActivity.bHP = false;
            this.mNetWork.k("msg_click", "1");
            ac acVar2 = this.mNetWork;
            j = DailyClassicalActivity.bwJ;
            acVar2.k("message_id", String.valueOf(j));
        }
        Address address = com.baidu.adp.lib.d.a.dE().getAddress(false);
        if (address != null && aj.wk().wu()) {
            this.mNetWork.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
        }
        try {
            this.boq = this.mNetWork.lA();
            if (this.mNetWork.mf()) {
                return this.boq;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.bHR.aRl = false;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        LinearLayout linearLayout;
        TextView textView;
        BaseWebView baseWebView;
        LinearLayout linearLayout2;
        View.OnClickListener onClickListener;
        BaseWebView baseWebView2;
        TextView textView2;
        BaseWebView baseWebView3;
        this.bHR.bHK = null;
        linearLayout = this.bHR.bHJ;
        linearLayout.setOnClickListener(null);
        if (this.mNetWork != null && this.mNetWork.mf() && str != null && str.length() > 0) {
            baseWebView2 = this.bHR.mWebView;
            baseWebView2.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            textView2 = this.bHR.bHN;
            textView2.setVisibility(8);
            baseWebView3 = this.bHR.mWebView;
            baseWebView3.setVisibility(0);
        } else {
            this.bHR.bHM = false;
            textView = this.bHR.bHN;
            textView.setVisibility(0);
            baseWebView = this.bHR.mWebView;
            baseWebView.setVisibility(8);
            linearLayout2 = this.bHR.bHJ;
            onClickListener = this.bHR.bHI;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.bHR.bHL = true;
        this.bHR.abG();
    }
}
