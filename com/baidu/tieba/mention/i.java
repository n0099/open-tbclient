package com.baidu.tieba.mention;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, com.baidu.tieba.model.am> {
    private ArrayList<BasicNameValuePair> KW;
    private k bnb;
    final /* synthetic */ c bnj;
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
            this.bnj.a(this.model, true);
        }
    }

    public i(c cVar, String str, ArrayList<BasicNameValuePair> arrayList, k kVar) {
        this.bnj = cVar;
        this.mUrl = null;
        this.KW = null;
        this.bnb = null;
        this.mUrl = str;
        this.KW = arrayList;
        this.bnb = kVar;
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
        hVar = this.bnj.bne;
        String SJ = hVar.SJ();
        if (SJ != null && SJ.length() > 0) {
            i2 = this.bnj.aAp;
            if (i2 == 1) {
                activity2 = this.bnj.mActivity;
                this.model = new com.baidu.tieba.model.am(activity2);
                this.model.parserJson(SJ);
                if (this.model.isSucc()) {
                    publishProgress(0);
                } else {
                    this.model = null;
                    hVar3 = this.bnj.bne;
                    hVar3.delete();
                }
            }
        }
        try {
            str = this.bnj.bnh;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (ay.aA(str)) {
            return null;
        }
        this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
        this.yV.h(this.KW);
        String lA = this.yV.lA();
        if (this.yV.mc().nb().jq() && lA != null) {
            activity = this.bnj.mActivity;
            this.model = new com.baidu.tieba.model.am(activity);
            this.model.parserJson(lA);
            if (this.model.isSucc()) {
                i = this.bnj.aAf;
                if (i != 4) {
                    hVar2 = this.bnj.bne;
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
            i2 = this.bnj.aAf;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    bdListView3 = this.bnj.aof;
                    if (bdListView3 != null) {
                        bdListView4 = this.bnj.aof;
                        bdListView4.hO();
                        return;
                    }
                    return;
                case 4:
                    this.bnb.dB(true);
                    return;
                default:
                    return;
            }
        }
        i = this.bnj.aAf;
        switch (i) {
            case 1:
            case 2:
            case 3:
                bdListView = this.bnj.aof;
                if (bdListView != null) {
                    bdListView2 = this.bnj.aof;
                    bdListView2.hN();
                    return;
                }
                return;
            case 4:
                this.bnb.dB(false);
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
                c cVar = this.bnj;
                i = this.bnj.aAf;
                cVar.a(amVar, i == 4);
            } else {
                this.bnb.bO(false);
                this.bnb.notifyDataSetChanged();
            }
        } else {
            this.bnb.bO(false);
            this.bnb.notifyDataSetChanged();
        }
        this.bnj.bnf = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.yV != null) {
            this.yV.dM();
        }
        dA(false);
        this.bnb.notifyDataSetChanged();
        this.bnj.bnf = null;
        super.cancel(true);
    }
}
