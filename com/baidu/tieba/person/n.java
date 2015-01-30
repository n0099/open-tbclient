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
    final /* synthetic */ g bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.bHc = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        boolean z;
        q qVar2;
        PersonBarActivity aaL;
        boolean z2;
        PersonBarActivity aaL2;
        PersonBarActivity aaL3;
        PersonBarActivity aaL4;
        qVar = this.bHc.bGR;
        if (qVar.getItem(i) != null) {
            z = this.bHc.bGX;
            if (!z) {
                this.bHc.byp = i;
                qVar2 = this.bHc.bGR;
                ForumData forumData = (ForumData) qVar2.getItem(i);
                if (forumData != null) {
                    aaL = this.bHc.aaL();
                    if (aaL != null) {
                        z2 = this.bHc.bGA;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aaL3 = this.bHc.aaL();
                            this.bHc.aaL();
                            aaL3.setResult(-1, intent);
                            aaL4 = this.bHc.aaL();
                            aaL4.finish();
                            return;
                        }
                        g gVar = this.bHc;
                        aaL2 = this.bHc.aaL();
                        gVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(aaL2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
