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
    final /* synthetic */ DailyClassicalActivity bIf;
    private String boE;
    private ac mNetWork;

    private c(DailyClassicalActivity dailyClassicalActivity) {
        this.bIf = dailyClassicalActivity;
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
        this.mNetWork.mc().na().nd().Gn = false;
        if (TbadkApplication.m251getInst().getSkinType() == 1) {
            this.mNetWork.k("night_type", "1");
        }
        ac acVar = this.mNetWork;
        str = this.bIf.bIe;
        acVar.k("pn", str);
        this.mNetWork.k("_version_more", "1");
        this.mNetWork.k("platform", "android");
        z = DailyClassicalActivity.bId;
        if (z) {
            DailyClassicalActivity.bId = false;
            this.mNetWork.k("msg_click", "1");
            ac acVar2 = this.mNetWork;
            j = DailyClassicalActivity.bwX;
            acVar2.k("message_id", String.valueOf(j));
        }
        Address address = com.baidu.adp.lib.d.a.dE().getAddress(false);
        if (address != null && aj.wm().ww()) {
            this.mNetWork.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
        }
        try {
            this.boE = this.mNetWork.lA();
            if (this.mNetWork.mf()) {
                return this.boE;
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
        this.bIf.aRz = false;
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
        this.bIf.bHY = null;
        linearLayout = this.bIf.bHX;
        linearLayout.setOnClickListener(null);
        if (this.mNetWork != null && this.mNetWork.mf() && str != null && str.length() > 0) {
            baseWebView2 = this.bIf.mWebView;
            baseWebView2.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            textView2 = this.bIf.bIb;
            textView2.setVisibility(8);
            baseWebView3 = this.bIf.mWebView;
            baseWebView3.setVisibility(0);
        } else {
            this.bIf.bIa = false;
            textView = this.bIf.bIb;
            textView.setVisibility(0);
            baseWebView = this.bIf.mWebView;
            baseWebView.setVisibility(8);
            linearLayout2 = this.bIf.bHX;
            onClickListener = this.bIf.bHW;
            linearLayout2.setOnClickListener(onClickListener);
        }
        this.bIf.bHZ = true;
        this.bIf.abJ();
    }
}
