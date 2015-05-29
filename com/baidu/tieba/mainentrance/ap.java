package com.baidu.tieba.mainentrance;

import android.widget.FrameLayout;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<Object, Integer, com.baidu.tieba.postsearch.j> {
    private com.baidu.tbadk.core.util.aa aaG = null;
    final /* synthetic */ SquareSearchActivity bCE;
    private ArrayList<BasicNameValuePair> bCL;
    private String mUrl;

    public ap(SquareSearchActivity squareSearchActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.bCE = squareSearchActivity;
        this.mUrl = null;
        this.bCL = null;
        this.mUrl = str;
        this.bCL = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        FrameLayout frameLayout;
        com.baidu.tbadk.core.view.x xVar;
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.showLoadingView(frameLayout, true, this.bCE.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds320));
        xVar = this.bCE.mNoDataView;
        xVar.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public com.baidu.tieba.postsearch.j doInBackground(Object... objArr) {
        Exception exc;
        com.baidu.tieba.postsearch.j jVar;
        String str;
        try {
            this.aaG = new com.baidu.tbadk.core.util.aa(this.mUrl);
            Iterator<BasicNameValuePair> it = this.bCL.iterator();
            while (it.hasNext()) {
                this.aaG.a(it.next());
            }
            String sw = this.aaG.sw();
            if (!this.aaG.sX().tT().ta() || sw == null) {
                return null;
            }
            com.baidu.tieba.postsearch.j jVar2 = new com.baidu.tieba.postsearch.j();
            try {
                jVar2.parseJson(sw);
                if (sw != null && this.aaG != null && this.aaG.sX().tT().qa()) {
                    Iterator<BasicNameValuePair> it2 = this.bCL.iterator();
                    while (it2.hasNext()) {
                        BasicNameValuePair next = it2.next();
                        if ("word".equals(next.getName())) {
                            this.bCE.bCh = next.getValue();
                        }
                        if ("pn".equals(next.getName())) {
                            this.bCE.bCj = Integer.valueOf(next.getValue()).intValue();
                        }
                    }
                }
                if (this.aaG.sX().tT().qa()) {
                    str = this.bCE.bCf;
                    com.baidu.tieba.tbadkCore.util.j.jI(str);
                    return jVar2;
                }
                return jVar2;
            } catch (Exception e) {
                jVar = jVar2;
                exc = e;
                BdLog.e(exc.getMessage());
                return jVar;
            }
        } catch (Exception e2) {
            exc = e2;
            jVar = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.postsearch.j jVar) {
        FrameLayout frameLayout;
        com.baidu.tieba.postsearch.w wVar;
        this.bCE.bCp = false;
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.hideLoadingView(frameLayout);
        wVar = this.bCE.bBZ;
        wVar.notifyDataSetChanged();
        if (jVar == null || this.aaG == null || !this.aaG.sX().tT().ta()) {
            this.bCE.showToast(this.bCE.getPageContext().getString(com.baidu.tieba.t.neterror));
        } else if (this.aaG.sX().tT().qa()) {
            this.bCE.bCc = jVar;
            this.bCE.refresh();
        } else {
            this.bCE.showToast(this.aaG.getErrorString());
        }
        this.bCE.bCe = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        com.baidu.tieba.postsearch.w wVar;
        FrameLayout frameLayout;
        wVar = this.bCE.bBZ;
        wVar.notifyDataSetChanged();
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        SquareSearchActivity squareSearchActivity = this.bCE;
        frameLayout = this.bCE.bBK;
        squareSearchActivity.hideLoadingView(frameLayout);
        this.bCE.bCe = null;
        super.onCancelled();
    }
}
