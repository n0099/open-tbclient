package com.baidu.tieba.launcherGuide.guide;

import android.view.View;
import com.baidu.tieba.launcherGuide.view.RightSlideViewPager;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ h bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bSo = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        NewUserGuideActivity newUserGuideActivity4;
        newUserGuideActivity = this.bSo.bSj;
        if (newUserGuideActivity != null) {
            newUserGuideActivity2 = this.bSo.bSj;
            if (newUserGuideActivity2.aaP().aaW()) {
                newUserGuideActivity4 = this.bSo.bSj;
                newUserGuideActivity4.aaR();
                return;
            }
            newUserGuideActivity3 = this.bSo.bSj;
            RightSlideViewPager aaO = newUserGuideActivity3.aaO();
            if (aaO != null) {
                aaO.setCurrentItem(1, true);
            }
        }
    }
}
