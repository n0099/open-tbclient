package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class d {
    private TextView euB;
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.hhI != null && d.this.hhI.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(d.this.hix.getActivity());
                int h = l.h(d.this.hix.getActivity(), e.C0175e.ds252);
                d.this.hhI.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.hhI, fragmentTabWidget, (aO - l.h(d.this.hix.getActivity(), e.C0175e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.hiy);
                com.baidu.adp.lib.g.e.jI().postDelayed(d.this.fYX, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 1));
            }
        }
    };
    private Runnable fYX = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bkY();
        }
    };
    private View.OnClickListener fYY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bDQ();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.hix, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").x("obj_locate", 1));
        }
    };
    private PopupWindow hhI;
    private TextView hiA;
    private MainTabActivity hix;
    private long hiy;
    private View hiz;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.hix = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hix.findViewById(e.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hiy = j;
            if (this.hiz == null) {
                this.hiz = LayoutInflater.from(this.hix.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.euB = (TextView) this.hiz.findViewById(e.g.tips);
                this.hiA = (TextView) this.hiz.findViewById(e.g.tips_content);
                this.hiz.setOnClickListener(this.fYY);
            }
            this.euB.setText(ao.f(str, 24, "..."));
            this.hiA.setText(e.j.topic_join);
            if (this.hhI == null) {
                this.hhI = new PopupWindow(this.hiz, -2, -2);
                this.hhI.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.hix.getActivity()));
                    }
                });
            } else {
                bDQ();
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fYW, 100L);
        }
    }

    public void bDQ() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYX);
        bkY();
    }

    public void bkY() {
        g.a(this.hhI);
    }

    public void onDestroy() {
        bDQ();
    }
}
