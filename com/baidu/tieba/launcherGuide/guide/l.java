package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ j bwJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.bwJ = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.bwJ.bwE;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.bwJ.bwE;
            if (newUserGuideActivity2.VZ().Wg()) {
                newUserGuideActivity4 = this.bwJ.bwE;
                newUserGuideActivity4.Wb();
                return;
            }
            newUserGuideActivity3 = this.bwJ.bwE;
            RightSlideViewPager VY = newUserGuideActivity3.VY();
            if (VY != null) {
                VY.setCurrentItem(1, true);
            }
        }
    }
}
