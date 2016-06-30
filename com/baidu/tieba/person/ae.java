package com.baidu.tieba.person;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class ae implements AdapterView.OnItemClickListener {
    final /* synthetic */ t eeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(t tVar) {
        this.eeh = tVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        af afVar;
        boolean z;
        af afVar2;
        PersonBarActivity aKx;
        boolean z2;
        PersonBarActivity aKx2;
        PersonBarActivity aKx3;
        PersonBarActivity aKx4;
        afVar = this.eeh.edR;
        if (afVar.getItem(i) != null) {
            z = this.eeh.edW;
            if (!z) {
                this.eeh.dGZ = i;
                afVar2 = this.eeh.edR;
                ForumData forumData = (ForumData) afVar2.getItem(i);
                if (forumData != null) {
                    aKx = this.eeh.aKx();
                    if (aKx != null) {
                        z2 = this.eeh.ecI;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aKx3 = this.eeh.aKx();
                            this.eeh.aKx();
                            aKx3.setResult(-1, intent);
                            aKx4 = this.eeh.aKx();
                            aKx4.finish();
                            return;
                        }
                        t tVar = this.eeh;
                        aKx2 = this.eeh.aKx();
                        tVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aKx2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
