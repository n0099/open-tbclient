package com.baidu.tieba.view;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j fQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.fQz = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        PopupWindow popupWindow;
        Handler handler;
        Runnable runnable;
        imageView = this.fQz.fQv;
        if (imageView != null) {
            popupWindow = this.fQz.fQx;
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, imageView);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
            this.fQz.fQy = true;
            handler = this.fQz.mHandler;
            runnable = this.fQz.fGZ;
            handler.postDelayed(runnable, 3000L);
        }
    }
}
