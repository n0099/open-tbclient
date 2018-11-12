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
public class c {
    private PopupWindow dXA;
    private Runnable dXC = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.dXA != null && c.this.dXA.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.hkh.getActivity());
                int h = l.h(c.this.hkh.getActivity(), e.C0200e.ds252);
                c.this.dXA.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.dXA, fragmentTabWidget, (aO - l.h(c.this.hkh.getActivity(), e.C0200e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.hki);
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.dXD, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 1));
            }
        }
    };
    private Runnable dXD = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aFO();
        }
    };
    private View.OnClickListener dXE = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aFN();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.hkh, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").x("obj_locate", 1));
        }
    };
    private TextView evU;
    private MainTabActivity hkh;
    private long hki;
    private View hkj;
    private TextView hkk;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.hkh = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hkh.findViewById(e.g.tab_host);
    }

    public void d(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hki = j;
            if (this.hkj == null) {
                this.hkj = LayoutInflater.from(this.hkh.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.evU = (TextView) this.hkj.findViewById(e.g.tips);
                this.hkk = (TextView) this.hkj.findViewById(e.g.tips_content);
                this.hkj.setOnClickListener(this.dXE);
            }
            this.evU.setText(ao.f(str, 24, "..."));
            this.hkk.setText(e.j.topic_join);
            if (this.dXA == null) {
                this.dXA = new PopupWindow(this.hkj, -2, -2);
                this.dXA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, c.this.hkh.getActivity()));
                    }
                });
            } else {
                aFN();
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.dXC, 100L);
        }
    }

    public void aFN() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXC);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXD);
        aFO();
    }

    public void aFO() {
        g.a(this.dXA);
    }

    public void onDestroy() {
        aFN();
    }
}
