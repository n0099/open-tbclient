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
class ad implements AdapterView.OnItemClickListener {
    final /* synthetic */ s dvP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(s sVar) {
        this.dvP = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ae aeVar;
        boolean z;
        ae aeVar2;
        PersonBarActivity aBF;
        boolean z2;
        PersonBarActivity aBF2;
        PersonBarActivity aBF3;
        PersonBarActivity aBF4;
        aeVar = this.dvP.dvz;
        if (aeVar.getItem(i) != null) {
            z = this.dvP.dvE;
            if (!z) {
                this.dvP.dar = i;
                aeVar2 = this.dvP.dvz;
                ForumData forumData = (ForumData) aeVar2.getItem(i);
                if (forumData != null) {
                    aBF = this.dvP.aBF();
                    if (aBF != null) {
                        z2 = this.dvP.dur;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aBF3 = this.dvP.aBF();
                            this.dvP.aBF();
                            aBF3.setResult(-1, intent);
                            aBF4 = this.dvP.aBF();
                            aBF4.finish();
                            return;
                        }
                        s sVar = this.dvP;
                        aBF2 = this.dvP.aBF();
                        sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aBF2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
