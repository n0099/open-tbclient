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
    final /* synthetic */ s dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(s sVar) {
        this.dst = sVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar;
        boolean z;
        ad adVar2;
        PersonBarActivity aBf;
        boolean z2;
        PersonBarActivity aBf2;
        PersonBarActivity aBf3;
        PersonBarActivity aBf4;
        adVar = this.dst.dsd;
        if (adVar.getItem(i) != null) {
            z = this.dst.dsi;
            if (!z) {
                this.dst.cYb = i;
                adVar2 = this.dst.dsd;
                ForumData forumData = (ForumData) adVar2.getItem(i);
                if (forumData != null) {
                    aBf = this.dst.aBf();
                    if (aBf != null) {
                        z2 = this.dst.dqW;
                        if (z2) {
                            Intent intent = new Intent();
                            intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                            intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                            aBf3 = this.dst.aBf();
                            this.dst.aBf();
                            aBf3.setResult(-1, intent);
                            aBf4 = this.dst.aBf();
                            aBf4.finish();
                            return;
                        }
                        s sVar = this.dst;
                        aBf2 = this.dst.aBf();
                        sVar.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(aBf2.getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba")));
                    }
                }
            }
        }
    }
}
