package com.baidu.tieba.setting.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity ccF;

    private p(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(PersonChangeActivity personChangeActivity, p pVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        View view;
        TextView textView;
        progressBar = this.ccF.avR;
        progressBar.setVisibility(0);
        view = this.ccF.ccl;
        view.setEnabled(false);
        textView = this.ccF.bgV;
        ba.b(textView, s.navi_op_text, 1);
        this.ccF.ccx.setImageDrawable(null);
        this.ccF.baJ = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.o.Y(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        TextView textView;
        this.ccF.ccy = null;
        progressBar = this.ccF.avR;
        progressBar.setVisibility(8);
        view = this.ccF.ccl;
        view.setEnabled(true);
        textView = this.ccF.bgV;
        ba.b(textView, s.cp_link_tip_a, 1);
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        View view;
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.a aVar;
        com.baidu.tbadk.coreExtra.c.f fVar;
        com.baidu.adp.widget.a.a aVar2;
        super.onPostExecute((p) bitmap);
        this.ccF.ccy = null;
        view = this.ccF.ccl;
        view.setEnabled(true);
        textView = this.ccF.bgV;
        ba.b(textView, s.cp_link_tip_a, 1);
        progressBar = this.ccF.avR;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.ccF.baJ = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.ccF.baJ;
            aVar.a(this.ccF.ccx);
            com.baidu.tbadk.imageManager.e zs = com.baidu.tbadk.imageManager.e.zs();
            fVar = this.ccF.ccw;
            String portrait = fVar.vR().getPortrait();
            aVar2 = this.ccF.baJ;
            zs.b(portrait, aVar2, true);
        }
    }
}
