package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k bSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bSj = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        boolean z;
        NewUserGuideActivity newUserGuideActivity3;
        boolean z2;
        NewUserGuideActivity newUserGuideActivity4;
        View view2;
        if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
            button = this.bSj.mNext;
            if (view == button) {
                newUserGuideActivity = this.bSj.bRO;
                if (newUserGuideActivity.aas()) {
                    TbadkApplication.getInst().setLikeBarChanged(true);
                }
                k kVar = this.bSj;
                newUserGuideActivity2 = this.bSj.bRO;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2.getPageContext().getPageActivity());
                z = this.bSj.bRq;
                kVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.bSj.bRO;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.bSj.bSi;
        if (z2) {
            this.bSj.bSi = false;
            TiebaStatic.log("newUserInterestSelect");
            newUserGuideActivity4 = this.bSj.bRO;
            p pVar = new p(newUserGuideActivity4, (InterestFrsData.Tag) view.getTag(), new m(this));
            view2 = this.bSj.bRV;
            view2.setVisibility(0);
            pVar.show();
            this.bSj.bSi = true;
        }
    }
}
