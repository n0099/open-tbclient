package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ h cDL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cDL = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.cDL.cDG;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.cDL.cDG;
            if (newUserGuideActivity2.amZ().ang()) {
                newUserGuideActivity4 = this.cDL.cDG;
                newUserGuideActivity4.anb();
                return;
            }
            newUserGuideActivity3 = this.cDL.cDG;
            RightSlideViewPager amY = newUserGuideActivity3.amY();
            if (amY != null) {
                amY.setCurrentItem(1, true);
            }
        }
    }
}
