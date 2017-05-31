package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements Runnable {
    final /* synthetic */ ak fHb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ak akVar) {
        this.fHb = akVar;
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
        fragmentTabHost = this.fHb.aYf;
        if (fragmentTabHost != null) {
            popupWindow = this.fHb.fGV;
            if (popupWindow != null) {
                fragmentTabHost2 = this.fHb.aYf;
                FragmentTabWidget fragmentTabWidget = fragmentTabHost2.getFragmentTabWidget();
                mainTabActivity = this.fHb.fGR;
                int af = com.baidu.adp.lib.util.k.af(mainTabActivity.getActivity());
                mainTabActivity2 = this.fHb.fGR;
                int g = com.baidu.adp.lib.util.k.g(mainTabActivity2.getActivity(), w.f.ds200);
                popupWindow2 = this.fHb.fGV;
                View contentView = popupWindow2.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    popupWindow3 = this.fHb.fGV;
                    com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow3, fragmentTabWidget, (af - measuredWidth) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("show_maintab_write_tips", true);
                    this.fHb.fGW = true;
                    handler = this.fHb.mHandler;
                    runnable = this.fHb.fGZ;
                    handler.postDelayed(runnable, 6000L);
                }
            }
        }
    }
}
