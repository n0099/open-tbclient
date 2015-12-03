package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ h ciB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.ciB = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.ciB.ciw;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.ciB.ciw;
            if (newUserGuideActivity2.aev().aeC()) {
                newUserGuideActivity4 = this.ciB.ciw;
                newUserGuideActivity4.aex();
                return;
            }
            newUserGuideActivity3 = this.ciB.ciw;
            RightSlideViewPager aeu = newUserGuideActivity3.aeu();
            if (aeu != null) {
                aeu.setCurrentItem(1, true);
            }
        }
    }
}
