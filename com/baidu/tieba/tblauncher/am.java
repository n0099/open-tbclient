package com.baidu.tieba.tblauncher;

import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ ah fzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ah ahVar) {
        this.fzg = ahVar;
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
        fragmentTabHost = this.fzg.bCH;
        if (fragmentTabHost != null) {
            popupWindow = this.fzg.fza;
            if (popupWindow != null) {
                fragmentTabHost2 = this.fzg.bCH;
                FragmentTabWidget fragmentTabWidget = fragmentTabHost2.getFragmentTabWidget();
                mainTabActivity = this.fzg.fyW;
                int af = com.baidu.adp.lib.util.k.af(mainTabActivity.getActivity());
                mainTabActivity2 = this.fzg.fyW;
                int g = com.baidu.adp.lib.util.k.g(mainTabActivity2.getActivity(), w.f.ds200);
                popupWindow2 = this.fzg.fza;
                View contentView = popupWindow2.getContentView();
                if (contentView != null) {
                    contentView.measure(0, 0);
                    int measuredWidth = contentView.getMeasuredWidth();
                    popupWindow3 = this.fzg.fza;
                    com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(popupWindow3, fragmentTabWidget, (af - measuredWidth) / 2, -g);
                    com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("show_maintab_write_tips", true);
                    this.fzg.fzb = true;
                    handler = this.fzg.mHandler;
                    runnable = this.fzg.fze;
                    handler.postDelayed(runnable, 6000L);
                }
            }
        }
    }
}
