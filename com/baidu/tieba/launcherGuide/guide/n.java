package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import android.widget.Button;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m bxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bxp = mVar;
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
        NewUserGuideActivity newUserGuideActivity5;
        View view2;
        if (view.getTag() == null || !(view.getTag() instanceof InterestFrsData.Tag)) {
            button = this.bxp.mNext;
            if (view == button) {
                newUserGuideActivity = this.bxp.bwU;
                if (newUserGuideActivity.Wk()) {
                    TbadkApplication.getInst().setLikeBarChanged(true);
                }
                m mVar = this.bxp;
                newUserGuideActivity2 = this.bxp.bwU;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2.getPageContext().getPageActivity());
                z = this.bxp.bwy;
                mVar.sendMessage(new CustomMessage(2015001, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.bxp.bwU;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.bxp.bxo;
        if (z2) {
            this.bxp.bxo = false;
            newUserGuideActivity4 = this.bxp.bwU;
            com.baidu.tbadk.core.k.A(newUserGuideActivity4.getPageContext().getPageActivity(), "newUserInterestSelect");
            newUserGuideActivity5 = this.bxp.bwU;
            t tVar = new t(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new o(this));
            view2 = this.bxp.bxb;
            view2.setVisibility(0);
            tVar.show();
            this.bxp.bxo = true;
        }
    }
}
