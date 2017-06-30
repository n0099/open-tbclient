package com.baidu.tieba.write;

import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.gdS = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        PopupWindow popupWindow;
        Runnable runnable;
        textView = this.gdS.gdI;
        if (textView != null && this.gdS.gdA != null) {
            textView2 = this.gdS.gdI;
            popupWindow = this.gdS.gdQ;
            com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow, textView2);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_write_url_tips", true);
            this.gdS.gdP = true;
            View view = this.gdS.gdA;
            runnable = this.gdS.fQQ;
            view.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
