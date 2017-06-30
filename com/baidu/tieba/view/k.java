package com.baidu.tieba.view;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.PopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ j gaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.gaq = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        PopupWindow popupWindow;
        Handler handler;
        Runnable runnable;
        imageView = this.gaq.gam;
        if (imageView != null) {
            popupWindow = this.gaq.gao;
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, imageView);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_person_tab_feedback_tips", true);
            this.gaq.gap = true;
            handler = this.gaq.mHandler;
            runnable = this.gaq.fQQ;
            handler.postDelayed(runnable, 3000L);
        }
    }
}
