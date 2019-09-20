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
    private PopupWindow fUT;
    private Runnable fUV = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fUT != null && c.this.fUT.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.joS.getActivity());
                int g = l.g(c.this.joS.getActivity(), R.dimen.ds278);
                c.this.fUT.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fUT, fragmentTabWidget, (af - l.g(c.this.joS.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.ahU().putLong("home_tip", c.this.goJ);
                e.iK().postDelayed(c.this.fUW, 5000L);
                TiebaStatic.log(new an("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fUW = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.btZ();
        }
    };
    private View.OnClickListener fUX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.btY();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.joS, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").P("obj_locate", 1));
        }
    };
    private long goJ;
    private TextView gwu;
    private MainTabActivity joS;
    private View joT;
    private TextView joU;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.joS = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.joS.findViewById(R.id.tab_host);
    }

    public void i(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.goJ = j;
            if (this.joT == null) {
                this.joT = LayoutInflater.from(this.joS.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gwu = (TextView) this.joT.findViewById(R.id.tips);
                this.joU = (TextView) this.joT.findViewById(R.id.tips_content);
                this.joT.setOnClickListener(this.fUX);
            }
            this.gwu.setText(aq.l(str, 24, "..."));
            this.joU.setText(R.string.topic_join);
            if (this.fUT == null) {
                this.fUT = new PopupWindow(this.joT, -2, -2);
            } else {
                btY();
            }
            e.iK().removeCallbacks(this.fUV);
            e.iK().postDelayed(this.fUV, 100L);
        }
    }

    public void btY() {
        e.iK().removeCallbacks(this.fUV);
        e.iK().removeCallbacks(this.fUW);
        btZ();
    }

    public void btZ() {
        g.a(this.fUT);
    }

    public void onDestroy() {
        btY();
    }
}
