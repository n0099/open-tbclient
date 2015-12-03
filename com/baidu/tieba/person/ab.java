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
class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ s cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.cKg = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        boolean z;
        ad adVar2;
        PersonBarActivity anx;
        boolean z2;
        PersonBarActivity anx2;
        PersonBarActivity anx3;
        PersonBarActivity anx4;
        adVar = this.cKg.cJR;
        if (adVar.getItem(i) != null) {
            z = this.cKg.cJW;
            if (!z) {
                this.cKg.cua = i;
                adVar2 = this.cKg.cJR;
                ForumData forumData = (ForumData) adVar2.getItem(i);
                if (forumData != null) {
                    anx = this.cKg.anx();
                    if (anx != null) {
                        z2 = this.cKg.cIK;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            anx3 = this.cKg.anx();
                            this.cKg.anx();
                            anx3.setResult(-1, intent);
                            anx4 = this.cKg.anx();
                            anx4.finish();
                            return;
                        }
                        s sVar = this.cKg;
                        anx2 = this.cKg.anx();
                        sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(anx2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
