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
    final /* synthetic */ PersonChangeActivity ccU;

    private p(PersonChangeActivity personChangeActivity) {
        this.ccU = personChangeActivity;
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
        progressBar = this.ccU.avZ;
        progressBar.setVisibility(0);
        view = this.ccU.ccA;
        view.setEnabled(false);
        textView = this.ccU.bhl;
        ba.b(textView, s.navi_op_text, 1);
        this.ccU.ccM.setImageDrawable(null);
        this.ccU.baZ = null;
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
        this.ccU.ccN = null;
        progressBar = this.ccU.avZ;
        progressBar.setVisibility(8);
        view = this.ccU.ccA;
        view.setEnabled(true);
        textView = this.ccU.bhl;
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
        this.ccU.ccN = null;
        view = this.ccU.ccA;
        view.setEnabled(true);
        textView = this.ccU.bhl;
        ba.b(textView, s.cp_link_tip_a, 1);
        progressBar = this.ccU.avZ;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.ccU.baZ = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.ccU.baZ;
            aVar.a(this.ccU.ccM);
            com.baidu.tbadk.imageManager.e zy = com.baidu.tbadk.imageManager.e.zy();
            fVar = this.ccU.ccL;
            String portrait = fVar.vX().getPortrait();
            aVar2 = this.ccU.baZ;
            zy.b(portrait, aVar2, true);
        }
    }
}
