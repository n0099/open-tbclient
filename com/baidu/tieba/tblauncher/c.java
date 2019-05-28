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
    private PopupWindow fNn;
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fNn != null && c.this.fNn.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.jfc.getActivity());
                int g = l.g(c.this.jfc.getActivity(), R.dimen.ds278);
                c.this.fNn.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fNn, fragmentTabWidget, (af - l.g(c.this.jfc.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("home_tip", c.this.gfK);
                e.iB().postDelayed(c.this.fNq, 5000L);
                TiebaStatic.log(new am("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fNq = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqV();
        }
    };
    private View.OnClickListener fNr = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bqU();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jfc, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").P("obj_locate", 1));
        }
    };
    private long gfK;
    private TextView gnx;
    private MainTabActivity jfc;
    private View jfd;
    private TextView jfe;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.jfc = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jfc.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gfK = j;
            if (this.jfd == null) {
                this.jfd = LayoutInflater.from(this.jfc.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gnx = (TextView) this.jfd.findViewById(R.id.tips);
                this.jfe = (TextView) this.jfd.findViewById(R.id.tips_content);
                this.jfd.setOnClickListener(this.fNr);
            }
            this.gnx.setText(ap.l(str, 24, "..."));
            this.jfe.setText(R.string.topic_join);
            if (this.fNn == null) {
                this.fNn = new PopupWindow(this.jfd, -2, -2);
            } else {
                bqU();
            }
            e.iB().removeCallbacks(this.fNp);
            e.iB().postDelayed(this.fNp, 100L);
        }
    }

    public void bqU() {
        e.iB().removeCallbacks(this.fNp);
        e.iB().removeCallbacks(this.fNq);
        bqV();
    }

    public void bqV() {
        g.a(this.fNn);
    }

    public void onDestroy() {
        bqU();
    }
}
