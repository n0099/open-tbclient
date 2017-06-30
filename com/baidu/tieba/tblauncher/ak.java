package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ad fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ad adVar) {
        this.fQS = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FragmentTabHost fragmentTabHost;
        PopupWindow popupWindow;
        FragmentTabHost fragmentTabHost2;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        Handler handler;
        Runnable runnable;
        fragmentTabHost = this.fQS.aZL;
        if (fragmentTabHost != null) {
            popupWindow = this.fQS.fQM;
            if (popupWindow != null) {
                fragmentTabHost2 = this.fQS.aZL;
                FragmentTabWidget fragmentTabWidget = fragmentTabHost2.getFragmentTabWidget();
                mainTabActivity = this.fQS.fQI;
                int af = com.baidu.adp.lib.util.k.af(mainTabActivity.getActivity());
                mainTabActivity2 = this.fQS.fQI;
                int g = com.baidu.adp.lib.util.k.g(mainTabActivity2.getActivity(), w.f.ds200);
                popupWindow2 = this.fQS.fQM;
                View contentView = popupWindow2.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    popupWindow3 = this.fQS.fQM;
                    com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow3, fragmentTabWidget, (af - measuredWidth) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_last_new_write_tips", true);
                    this.fQS.fQN = true;
                    handler = this.fQS.mHandler;
                    runnable = this.fQS.fQQ;
                    handler.postDelayed(runnable, TbConfig.NOTIFY_SOUND_INTERVAL);
                }
            }
        }
    }
}
