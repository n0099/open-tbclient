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
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.bPV = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        af afVar;
        boolean z;
        af afVar2;
        PersonBarActivity adl;
        boolean z2;
        PersonBarActivity adl2;
        PersonBarActivity adl3;
        PersonBarActivity adl4;
        afVar = this.bPV.bPJ;
        if (afVar.getItem(i) != null) {
            z = this.bPV.bPP;
            if (!z) {
                this.bPV.bDX = i;
                afVar2 = this.bPV.bPJ;
                ForumData forumData = (ForumData) afVar2.getItem(i);
                if (forumData != null) {
                    adl = this.bPV.adl();
                    if (adl != null) {
                        z2 = this.bPV.bON;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            adl3 = this.bPV.adl();
                            this.bPV.adl();
                            adl3.setResult(-1, intent);
                            adl4 = this.bPV.adl();
                            adl4.finish();
                            return;
                        }
                        v vVar = this.bPV;
                        adl2 = this.bPV.adl();
                        vVar.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(adl2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
