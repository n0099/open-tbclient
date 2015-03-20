package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ac implements AdapterView.OnItemClickListener {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.bPF = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        af afVar;
        boolean z;
        af afVar2;
        PersonBarActivity acW;
        boolean z2;
        PersonBarActivity acW2;
        PersonBarActivity acW3;
        PersonBarActivity acW4;
        afVar = this.bPF.bPt;
        if (afVar.getItem(i) != null) {
            z = this.bPF.bPz;
            if (!z) {
                this.bPF.bDK = i;
                afVar2 = this.bPF.bPt;
                ForumData forumData = (ForumData) afVar2.getItem(i);
                if (forumData != null) {
                    acW = this.bPF.acW();
                    if (acW != null) {
                        z2 = this.bPF.bOx;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            acW3 = this.bPF.acW();
                            this.bPF.acW();
                            acW3.setResult(-1, intent);
                            acW4 = this.bPF.acW();
                            acW4.finish();
                            return;
                        }
                        v vVar = this.bPF;
                        acW2 = this.bPF.acW();
                        vVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(acW2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
