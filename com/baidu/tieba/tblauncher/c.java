package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c {
    private long fOC;
    private TextView fWi;
    private PopupWindow fww;
    private MainTabActivity iMh;
    private View iMi;
    private TextView iMj;
    private FragmentTabHost mTabHost;
    private String mTopicName;
    private Runnable fwy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fww != null && c.this.fww.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.iMh.getActivity());
                int h = l.h(c.this.iMh.getActivity(), d.e.ds278);
                c.this.fww.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fww, fragmentTabWidget, (aO - l.h(c.this.iMh.getActivity(), d.e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.fOC);
                e.jH().postDelayed(c.this.fwz, 5000L);
                TiebaStatic.log(new am("c13016").T("obj_locate", 1));
            }
        }
    };
    private Runnable fwz = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bjA();
        }
    };
    private View.OnClickListener fwA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bjz();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.iMh, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").T("obj_locate", 1));
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.iMh = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.iMh.findViewById(d.g.tab_host);
    }

    public void i(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.fOC = j;
            if (this.iMi == null) {
                this.iMi = LayoutInflater.from(this.iMh.getActivity()).inflate(d.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.fWi = (TextView) this.iMi.findViewById(d.g.tips);
                this.iMj = (TextView) this.iMi.findViewById(d.g.tips_content);
                this.iMi.setOnClickListener(this.fwA);
            }
            this.fWi.setText(ap.i(str, 24, "..."));
            this.iMj.setText(d.j.topic_join);
            if (this.fww == null) {
                this.fww = new PopupWindow(this.iMi, -2, -2);
            } else {
                bjz();
            }
            e.jH().removeCallbacks(this.fwy);
            e.jH().postDelayed(this.fwy, 100L);
        }
    }

    public void bjz() {
        e.jH().removeCallbacks(this.fwy);
        e.jH().removeCallbacks(this.fwz);
        bjA();
    }

    public void bjA() {
        g.a(this.fww);
    }

    public void onDestroy() {
        bjz();
    }
}
