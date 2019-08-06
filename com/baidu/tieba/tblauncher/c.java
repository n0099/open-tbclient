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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private PopupWindow fTc;
    private Runnable fTe = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fTc != null && c.this.fTc.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.jmx.getActivity());
                int g = l.g(c.this.jmx.getActivity(), R.dimen.ds278);
                c.this.fTc.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fTc, fragmentTabWidget, (af - l.g(c.this.jmx.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putLong("home_tip", c.this.gmS);
                e.iK().postDelayed(c.this.fTf, 5000L);
                TiebaStatic.log(new an("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fTf = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.btl();
        }
    };
    private View.OnClickListener fTg = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.btk();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jmx, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").P("obj_locate", 1));
        }
    };
    private long gmS;
    private TextView guD;
    private MainTabActivity jmx;
    private View jmy;
    private TextView jmz;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.jmx = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jmx.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gmS = j;
            if (this.jmy == null) {
                this.jmy = LayoutInflater.from(this.jmx.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.guD = (TextView) this.jmy.findViewById(R.id.tips);
                this.jmz = (TextView) this.jmy.findViewById(R.id.tips_content);
                this.jmy.setOnClickListener(this.fTg);
            }
            this.guD.setText(aq.l(str, 24, "..."));
            this.jmz.setText(R.string.topic_join);
            if (this.fTc == null) {
                this.fTc = new PopupWindow(this.jmy, -2, -2);
            } else {
                btk();
            }
            e.iK().removeCallbacks(this.fTe);
            e.iK().postDelayed(this.fTe, 100L);
        }
    }

    public void btk() {
        e.iK().removeCallbacks(this.fTe);
        e.iK().removeCallbacks(this.fTf);
        btl();
    }

    public void btl() {
        g.a(this.fTc);
    }

    public void onDestroy() {
        btk();
    }
}
