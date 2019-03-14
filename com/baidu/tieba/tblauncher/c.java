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
    private long fOO;
    private TextView fWu;
    private PopupWindow fwJ;
    private Runnable fwL = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fwJ != null && c.this.fwJ.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.iMs.getActivity());
                int h = l.h(c.this.iMs.getActivity(), d.e.ds278);
                c.this.fwJ.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fwJ, fragmentTabWidget, (aO - l.h(c.this.iMs.getActivity(), d.e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.fOO);
                e.jH().postDelayed(c.this.fwM, 5000L);
                TiebaStatic.log(new am("c13016").T("obj_locate", 1));
            }
        }
    };
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bjC();
        }
    };
    private View.OnClickListener fwN = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bjB();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.iMs, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").T("obj_locate", 1));
        }
    };
    private MainTabActivity iMs;
    private View iMt;
    private TextView iMu;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.iMs = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.iMs.findViewById(d.g.tab_host);
    }

    public void i(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.fOO = j;
            if (this.iMt == null) {
                this.iMt = LayoutInflater.from(this.iMs.getActivity()).inflate(d.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.fWu = (TextView) this.iMt.findViewById(d.g.tips);
                this.iMu = (TextView) this.iMt.findViewById(d.g.tips_content);
                this.iMt.setOnClickListener(this.fwN);
            }
            this.fWu.setText(ap.i(str, 24, "..."));
            this.iMu.setText(d.j.topic_join);
            if (this.fwJ == null) {
                this.fwJ = new PopupWindow(this.iMt, -2, -2);
            } else {
                bjB();
            }
            e.jH().removeCallbacks(this.fwL);
            e.jH().postDelayed(this.fwL, 100L);
        }
    }

    public void bjB() {
        e.jH().removeCallbacks(this.fwL);
        e.jH().removeCallbacks(this.fwM);
        bjC();
    }

    public void bjC() {
        g.a(this.fwJ);
    }

    public void onDestroy() {
        bjB();
    }
}
