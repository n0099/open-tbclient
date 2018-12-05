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
    private TextView eCN;
    private PopupWindow eee;
    private Runnable eeg = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.eee != null && c.this.eee.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.hrt.getActivity());
                int h = l.h(c.this.hrt.getActivity(), e.C0210e.ds252);
                c.this.eee.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.eee, fragmentTabWidget, (aO - l.h(c.this.hrt.getActivity(), e.C0210e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.hru);
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.eeh, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 1));
            }
        }
    };
    private Runnable eeh = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aHA();
        }
    };
    private View.OnClickListener eei = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aHz();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.hrt, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").x("obj_locate", 1));
        }
    };
    private MainTabActivity hrt;
    private long hru;
    private View hrv;
    private TextView hrw;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.hrt = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hrt.findViewById(e.g.tab_host);
    }

    public void d(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hru = j;
            if (this.hrv == null) {
                this.hrv = LayoutInflater.from(this.hrt.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.eCN = (TextView) this.hrv.findViewById(e.g.tips);
                this.hrw = (TextView) this.hrv.findViewById(e.g.tips_content);
                this.hrv.setOnClickListener(this.eei);
            }
            this.eCN.setText(ao.f(str, 24, "..."));
            this.hrw.setText(e.j.topic_join);
            if (this.eee == null) {
                this.eee = new PopupWindow(this.hrv, -2, -2);
                this.eee.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, c.this.hrt.getActivity()));
                    }
                });
            } else {
                aHz();
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.eeg, 100L);
        }
    }

    public void aHz() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeg);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eeh);
        aHA();
    }

    public void aHA() {
        g.a(this.eee);
    }

    public void onDestroy() {
        aHz();
    }
}
