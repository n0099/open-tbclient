package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ae implements AdapterView.OnItemClickListener {
    final /* synthetic */ v bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(v vVar) {
        this.bSb = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ag agVar;
        boolean z;
        ag agVar2;
        PersonBarActivity ael;
        boolean z2;
        PersonBarActivity ael2;
        PersonBarActivity ael3;
        PersonBarActivity ael4;
        agVar = this.bSb.bRM;
        if (agVar.getItem(i) != null) {
            z = this.bSb.bRR;
            if (!z) {
                this.bSb.bGS = i;
                agVar2 = this.bSb.bRM;
                ForumData forumData = (ForumData) agVar2.getItem(i);
                if (forumData != null) {
                    ael = this.bSb.ael();
                    if (ael != null) {
                        z2 = this.bSb.bQO;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            ael3 = this.bSb.ael();
                            this.bSb.ael();
                            ael3.setResult(-1, intent);
                            ael4 = this.bSb.ael();
                            ael4.finish();
                            return;
                        }
                        v vVar = this.bSb;
                        ael2 = this.bSb.ael();
                        vVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(ael2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
