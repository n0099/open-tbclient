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
    final /* synthetic */ k ciR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ciR = kVar;
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
            button = this.ciR.mNext;
            if (view == button) {
                newUserGuideActivity = this.ciR.ciw;
                if (newUserGuideActivity.aet()) {
                    TbadkApplication.getInst().setLikeBarChanged(true);
                }
                k kVar = this.ciR;
                newUserGuideActivity2 = this.ciR.ciw;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2.getPageContext().getPageActivity());
                z = this.ciR.chX;
                kVar.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.ciR.ciw;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.ciR.ciQ;
        if (z2) {
            this.ciR.ciQ = false;
            TiebaStatic.log("newUserInterestSelect");
            newUserGuideActivity4 = this.ciR.ciw;
            p pVar = new p(newUserGuideActivity4, (InterestFrsData.Tag) view.getTag(), new m(this));
            view2 = this.ciR.ciD;
            view2.setVisibility(0);
            pVar.show();
            this.ciR.ciQ = true;
        }
    }
}
