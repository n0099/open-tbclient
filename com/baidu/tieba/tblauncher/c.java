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
    private TextView eFE;
    private PopupWindow egV;
    private Runnable egX = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.egV != null && c.this.egV.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(c.this.huF.getActivity());
                int h = l.h(c.this.huF.getActivity(), e.C0210e.ds252);
                c.this.egV.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.egV, fragmentTabWidget, (aO - l.h(c.this.huF.getActivity(), e.C0210e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", c.this.huG);
                com.baidu.adp.lib.g.e.jG().postDelayed(c.this.egY, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 1));
            }
        }
    };
    private Runnable egY = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.aIp();
        }
    };
    private View.OnClickListener egZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.aIo();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.huF, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").x("obj_locate", 1));
        }
    };
    private MainTabActivity huF;
    private long huG;
    private View huH;
    private TextView huI;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.huF = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.huF.findViewById(e.g.tab_host);
    }

    public void d(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.huG = j;
            if (this.huH == null) {
                this.huH = LayoutInflater.from(this.huF.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.eFE = (TextView) this.huH.findViewById(e.g.tips);
                this.huI = (TextView) this.huH.findViewById(e.g.tips_content);
                this.huH.setOnClickListener(this.egZ);
            }
            this.eFE.setText(ao.f(str, 24, "..."));
            this.huI.setText(e.j.topic_join);
            if (this.egV == null) {
                this.egV = new PopupWindow(this.huH, -2, -2);
                this.egV.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.c.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, c.this.huF.getActivity()));
                    }
                });
            } else {
                aIo();
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.egX, 100L);
        }
    }

    public void aIo() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egX);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.egY);
        aIp();
    }

    public void aIp() {
        g.a(this.egV);
    }

    public void onDestroy() {
        aIo();
    }
}
