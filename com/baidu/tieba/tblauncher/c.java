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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private PopupWindow fNp;
    private Runnable fNr = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fNp != null && c.this.fNp.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.jfg.getActivity());
                int g = l.g(c.this.jfg.getActivity(), R.dimen.ds278);
                c.this.fNp.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fNp, fragmentTabWidget, (af - l.g(c.this.jfg.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("home_tip", c.this.gfM);
                e.iB().postDelayed(c.this.fNs, 5000L);
                TiebaStatic.log(new am("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fNs = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqX();
        }
    };
    private View.OnClickListener fNt = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bqW();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jfg, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").P("obj_locate", 1));
        }
    };
    private long gfM;
    private TextView gnz;
    private MainTabActivity jfg;
    private View jfh;
    private TextView jfi;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.jfg = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jfg.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gfM = j;
            if (this.jfh == null) {
                this.jfh = LayoutInflater.from(this.jfg.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gnz = (TextView) this.jfh.findViewById(R.id.tips);
                this.jfi = (TextView) this.jfh.findViewById(R.id.tips_content);
                this.jfh.setOnClickListener(this.fNt);
            }
            this.gnz.setText(ap.l(str, 24, "..."));
            this.jfi.setText(R.string.topic_join);
            if (this.fNp == null) {
                this.fNp = new PopupWindow(this.jfh, -2, -2);
            } else {
                bqW();
            }
            e.iB().removeCallbacks(this.fNr);
            e.iB().postDelayed(this.fNr, 100L);
        }
    }

    public void bqW() {
        e.iB().removeCallbacks(this.fNr);
        e.iB().removeCallbacks(this.fNs);
        bqX();
    }

    public void bqX() {
        g.a(this.fNp);
    }

    public void onDestroy() {
        bqW();
    }
}
