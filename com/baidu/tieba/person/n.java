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
    final /* synthetic */ g bHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar) {
        this.bHb = gVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        boolean z;
        q qVar2;
        PersonBarActivity aaG;
        boolean z2;
        PersonBarActivity aaG2;
        PersonBarActivity aaG3;
        PersonBarActivity aaG4;
        qVar = this.bHb.bGQ;
        if (qVar.getItem(i) != null) {
            z = this.bHb.bGW;
            if (!z) {
                this.bHb.byo = i;
                qVar2 = this.bHb.bGQ;
                ForumData forumData = (ForumData) qVar2.getItem(i);
                if (forumData != null) {
                    aaG = this.bHb.aaG();
                    if (aaG != null) {
                        z2 = this.bHb.bGz;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aaG3 = this.bHb.aaG();
                            this.bHb.aaG();
                            aaG3.setResult(-1, intent);
                            aaG4 = this.bHb.aaG();
                            aaG4.finish();
                            return;
                        }
                        g gVar = this.bHb;
                        aaG2 = this.bHb.aaG();
                        gVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(aaG2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
