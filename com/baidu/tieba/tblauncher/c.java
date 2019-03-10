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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c {
    private long fOP;
    private TextView fWv;
    private PopupWindow fwK;
    private Runnable fwM = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fwK != null && c.this.fwK.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.iMA.getActivity());
                int h = l.h(c.this.iMA.getActivity(), d.e.ds278);
                c.this.fwK.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fwK, fragmentTabWidget, (aO - l.h(c.this.iMA.getActivity(), d.e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.fOP);
                e.jH().postDelayed(c.this.fwN, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new am("c13016").T("obj_locate", 1));
            }
        }
    };
    private Runnable fwN = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bjD();
        }
    };
    private View.OnClickListener fwO = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bjC();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.iMA, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").T("obj_locate", 1));
        }
    };
    private MainTabActivity iMA;
    private View iMB;
    private TextView iMC;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.iMA = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.iMA.findViewById(d.g.tab_host);
    }

    public void i(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.fOP = j;
            if (this.iMB == null) {
                this.iMB = LayoutInflater.from(this.iMA.getActivity()).inflate(d.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.fWv = (TextView) this.iMB.findViewById(d.g.tips);
                this.iMC = (TextView) this.iMB.findViewById(d.g.tips_content);
                this.iMB.setOnClickListener(this.fwO);
            }
            this.fWv.setText(ap.i(str, 24, "..."));
            this.iMC.setText(d.j.topic_join);
            if (this.fwK == null) {
                this.fwK = new PopupWindow(this.iMB, -2, -2);
            } else {
                bjC();
            }
            e.jH().removeCallbacks(this.fwM);
            e.jH().postDelayed(this.fwM, 100L);
        }
    }

    public void bjC() {
        e.jH().removeCallbacks(this.fwM);
        e.jH().removeCallbacks(this.fwN);
        bjD();
    }

    public void bjD() {
        g.a(this.fwK);
    }

    public void onDestroy() {
        bjC();
    }
}
