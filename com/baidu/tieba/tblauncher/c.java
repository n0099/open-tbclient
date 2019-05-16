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
    private PopupWindow fNm;
    private Runnable fNo = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fNm != null && c.this.fNm.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.jfa.getActivity());
                int g = l.g(c.this.jfa.getActivity(), R.dimen.ds278);
                c.this.fNm.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fNm, fragmentTabWidget, (af - l.g(c.this.jfa.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.agM().putLong("home_tip", c.this.gfJ);
                e.iB().postDelayed(c.this.fNp, 5000L);
                TiebaStatic.log(new am("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fNp = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bqS();
        }
    };
    private View.OnClickListener fNq = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bqR();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jfa, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").P("obj_locate", 1));
        }
    };
    private long gfJ;
    private TextView gnw;
    private MainTabActivity jfa;
    private View jfb;
    private TextView jfc;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.jfa = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jfa.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.agM().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gfJ = j;
            if (this.jfb == null) {
                this.jfb = LayoutInflater.from(this.jfa.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gnw = (TextView) this.jfb.findViewById(R.id.tips);
                this.jfc = (TextView) this.jfb.findViewById(R.id.tips_content);
                this.jfb.setOnClickListener(this.fNq);
            }
            this.gnw.setText(ap.l(str, 24, "..."));
            this.jfc.setText(R.string.topic_join);
            if (this.fNm == null) {
                this.fNm = new PopupWindow(this.jfb, -2, -2);
            } else {
                bqR();
            }
            e.iB().removeCallbacks(this.fNo);
            e.iB().postDelayed(this.fNo, 100L);
        }
    }

    public void bqR() {
        e.iB().removeCallbacks(this.fNo);
        e.iB().removeCallbacks(this.fNp);
        bqS();
    }

    public void bqS() {
        g.a(this.fNm);
    }

    public void onDestroy() {
        bqR();
    }
}
