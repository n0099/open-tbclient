package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j bwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bwZ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.bwZ.bwU;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.bwZ.bwU;
            if (newUserGuideActivity2.Wm().Wt()) {
                newUserGuideActivity4 = this.bwZ.bwU;
                newUserGuideActivity4.Wo();
                return;
            }
            newUserGuideActivity3 = this.bwZ.bwU;
            RightSlideViewPager Wl = newUserGuideActivity3.Wl();
            if (Wl != null) {
                Wl.setCurrentItem(1, true);
            }
        }
    }
}
