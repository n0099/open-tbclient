package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
    private TextView eGr;
    private PopupWindow ehC;
    private Runnable ehE = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.ehC != null && c.this.ehC.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.hvO.getActivity());
                int h = l.h(c.this.hvO.getActivity(), e.C0210e.ds252);
                c.this.ehC.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.ehC, fragmentTabWidget, (aO - l.h(c.this.hvO.getActivity(), e.C0210e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.hvP);
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.ehF, 5000L);
                TiebaStatic.log(new am("c13016").y("obj_locate", 1));
            }
        }
    };
    private Runnable ehF = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.aIM();
        }
    };
    private View.OnClickListener ehG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aIL();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.hvO, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").y("obj_locate", 1));
        }
    };
    private MainTabActivity hvO;
    private long hvP;
    private View hvQ;
    private TextView hvR;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.hvO = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hvO.findViewById(e.g.tab_host);
    }

    public void d(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hvP = j;
            if (this.hvQ == null) {
                this.hvQ = LayoutInflater.from(this.hvO.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.eGr = (TextView) this.hvQ.findViewById(e.g.tips);
                this.hvR = (TextView) this.hvQ.findViewById(e.g.tips_content);
                this.hvQ.setOnClickListener(this.ehG);
            }
            this.eGr.setText(ao.f(str, 24, "..."));
            this.hvR.setText(e.j.topic_join);
            if (this.ehC == null) {
                this.ehC = new PopupWindow(this.hvQ, -2, -2);
            } else {
                aIL();
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ehE, 100L);
        }
    }

    public void aIL() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehE);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ehF);
        aIM();
    }

    public void aIM() {
        g.a(this.ehC);
    }

    public void onDestroy() {
        aIL();
    }
}
