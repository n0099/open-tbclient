package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ g bFr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.bFr = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        boolean z;
        q qVar2;
        PersonBarActivity aag;
        boolean z2;
        PersonBarActivity aag2;
        PersonBarActivity aag3;
        PersonBarActivity aag4;
        qVar = this.bFr.bFg;
        if (qVar.getItem(i) != null) {
            z = this.bFr.bFm;
            if (!z) {
                this.bFr.bwG = i;
                qVar2 = this.bFr.bFg;
                ForumData forumData = (ForumData) qVar2.getItem(i);
                if (forumData != null) {
                    aag = this.bFr.aag();
                    if (aag != null) {
                        z2 = this.bFr.bEP;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aag3 = this.bFr.aag();
                            this.bFr.aag();
                            aag3.setResult(-1, intent);
                            aag4 = this.bFr.aag();
                            aag4.finish();
                            return;
                        }
                        g gVar = this.bFr;
                        aag2 = this.bFr.aag();
                        gVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(aag2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
