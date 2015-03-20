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
    final /* synthetic */ m bwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bwZ = mVar;
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
            button = this.bwZ.mNext;
            if (view == button) {
                newUserGuideActivity = this.bwZ.bwE;
                if (newUserGuideActivity.VX()) {
                    TbadkApplication.getInst().setLikeBarChanged(true);
                }
                m mVar = this.bwZ;
                newUserGuideActivity2 = this.bwZ.bwE;
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(newUserGuideActivity2.getPageContext().getPageActivity());
                z = this.bwZ.bwi;
                mVar.sendMessage(new CustomMessage(2015001, mainTabActivityConfig.createNewUserCfg(1, z)));
                newUserGuideActivity3 = this.bwZ.bwE;
                newUserGuideActivity3.finish();
                return;
            }
            return;
        }
        z2 = this.bwZ.bwY;
        if (z2) {
            this.bwZ.bwY = false;
            newUserGuideActivity4 = this.bwZ.bwE;
            com.baidu.tbadk.core.k.A(newUserGuideActivity4.getPageContext().getPageActivity(), "newUserInterestSelect");
            newUserGuideActivity5 = this.bwZ.bwE;
            t tVar = new t(newUserGuideActivity5, (InterestFrsData.Tag) view.getTag(), new o(this));
            view2 = this.bwZ.bwL;
            view2.setVisibility(0);
            tVar.show();
            this.bwZ.bwY = true;
        }
    }
}
