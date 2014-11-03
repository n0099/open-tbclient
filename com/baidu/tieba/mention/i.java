package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.az;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, com.baidu.tieba.model.am> {
    private ArrayList<BasicNameValuePair> KX;
    private k bnp;
    final /* synthetic */ c bnx;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;
    private com.baidu.tieba.model.am model = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        if (this.model != null) {
            this.bnx.a(this.model, true);
        }
    }

    public i(c cVar, String str, ArrayList<BasicNameValuePair> arrayList, k kVar) {
        this.bnx = cVar;
        this.mUrl = null;
        this.KX = null;
        this.bnp = null;
        this.mUrl = str;
        this.KX = arrayList;
        this.bnp = kVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        dA(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: u */
    public com.baidu.tieba.model.am doInBackground(Object... objArr) {
        h hVar;
        String str;
        Activity activity;
        int i;
        h hVar2;
        int i2;
        Activity activity2;
        h hVar3;
        hVar = this.bnx.bns;
        String SM = hVar.SM();
        if (SM != null && SM.length() > 0) {
            i2 = this.bnx.aAz;
            if (i2 == 1) {
                activity2 = this.bnx.mActivity;
                this.model = new com.baidu.tieba.model.am(activity2);
                this.model.parserJson(SM);
                if (this.model.isSucc()) {
                    publishProgress(0);
                } else {
                    this.model = null;
                    hVar3 = this.bnx.bns;
                    hVar3.delete();
                }
            }
        }
        try {
            str = this.bnx.bnv;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (az.aA(str)) {
            return null;
        }
        this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
        this.yV.h(this.KX);
        String lA = this.yV.lA();
        if (this.yV.mc().nb().jq() && lA != null) {
            activity = this.bnx.mActivity;
            this.model = new com.baidu.tieba.model.am(activity);
            this.model.parserJson(lA);
            if (this.model.isSucc()) {
                i = this.bnx.aAo;
                if (i != 4) {
                    hVar2 = this.bnx.bns;
                    hVar2.gN(lA);
                }
            } else {
                this.model = null;
            }
        }
        return this.model;
    }

    private void dA(boolean z) {
        int i;
        BdListView bdListView;
        BdListView bdListView2;
        int i2;
        BdListView bdListView3;
        BdListView bdListView4;
        if (z) {
            i2 = this.bnx.aAo;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.bnx.aoo;
                    if (bdListView3 != null) {
                        bdListView4 = this.bnx.aoo;
                        bdListView4.hO();
                        return;
                    }
                    return;
                case 4:
                    this.bnp.dB(true);
                    return;
                default:
                    return;
            }
        }
        i = this.bnx.aAo;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.bnx.aoo;
                if (bdListView != null) {
                    bdListView2 = this.bnx.aoo;
                    bdListView2.hN();
                    return;
                }
                return;
            case 4:
                this.bnp.dB(false);
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.model.am amVar) {
        int i;
        dA(false);
        if (this.yV != null) {
            if (this.yV.mf() && amVar != null) {
                c cVar = this.bnx;
                i = this.bnx.aAo;
                cVar.a(amVar, i == 4);
            } else {
                this.bnp.bO(false);
                this.bnp.notifyDataSetChanged();
            }
        } else {
            this.bnp.bO(false);
            this.bnp.notifyDataSetChanged();
        }
        this.bnx.bnt = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
        }
        dA(false);
        this.bnp.notifyDataSetChanged();
        this.bnx.bnt = null;
        super.cancel(true);
    }
}
