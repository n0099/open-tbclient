package com.baidu.tieba.view;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j fIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.fIG = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        PopupWindow popupWindow;
        Handler handler;
        Runnable runnable;
        imageView = this.fIG.fIC;
        if (imageView != null) {
            popupWindow = this.fIG.fIE;
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, imageView);
            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("show_person_tab_feedback_tips", true);
            this.fIG.fIF = true;
            handler = this.fIG.mHandler;
            runnable = this.fIG.fze;
            handler.postDelayed(runnable, 3000L);
        }
    }
}
