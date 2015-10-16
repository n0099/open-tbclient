package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ h bRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bRT = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.bRT.bRO;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.bRT.bRO;
            if (newUserGuideActivity2.aay().aaF()) {
                newUserGuideActivity4 = this.bRT.bRO;
                newUserGuideActivity4.aaA();
                return;
            }
            newUserGuideActivity3 = this.bRT.bRO;
            RightSlideViewPager aax = newUserGuideActivity3.aax();
            if (aax != null) {
                aax.setCurrentItem(1, true);
            }
        }
    }
}
