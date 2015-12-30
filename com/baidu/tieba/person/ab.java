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
    final /* synthetic */ s cOw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.cOw = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        boolean z;
        ad adVar2;
        PersonBarActivity aoI;
        boolean z2;
        PersonBarActivity aoI2;
        PersonBarActivity aoI3;
        PersonBarActivity aoI4;
        adVar = this.cOw.cOh;
        if (adVar.getItem(i) != null) {
            z = this.cOw.cOm;
            if (!z) {
                this.cOw.cyc = i;
                adVar2 = this.cOw.cOh;
                ForumData forumData = (ForumData) adVar2.getItem(i);
                if (forumData != null) {
                    aoI = this.cOw.aoI();
                    if (aoI != null) {
                        z2 = this.cOw.cNa;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aoI3 = this.cOw.aoI();
                            this.cOw.aoI();
                            aoI3.setResult(-1, intent);
                            aoI4 = this.cOw.aoI();
                            aoI4.finish();
                            return;
                        }
                        s sVar = this.cOw;
                        aoI2 = this.cOw.aoI();
                        sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aoI2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
