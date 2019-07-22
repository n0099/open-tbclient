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
    private PopupWindow fSm;
    private Runnable fSo = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fSm != null && c.this.fSm.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int af = l.af(c.this.jlp.getActivity());
                int g = l.g(c.this.jlp.getActivity(), R.dimen.ds278);
                c.this.fSm.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fSm, fragmentTabWidget, (af - l.g(c.this.jlp.getActivity(), R.dimen.ds430)) / 2, -g);
                com.baidu.tbadk.core.sharedPref.b.ahO().putLong("home_tip", c.this.gma);
                e.iK().postDelayed(c.this.fSp, 5000L);
                TiebaStatic.log(new an("c13016").P("obj_locate", 1));
            }
        }
    };
    private Runnable fSp = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bsY();
        }
    };
    private View.OnClickListener fSq = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bsX();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jlp, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").P("obj_locate", 1));
        }
    };
    private long gma;
    private TextView gtL;
    private MainTabActivity jlp;
    private View jlq;
    private TextView jlr;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.jlp = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jlp.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gma = j;
            if (this.jlq == null) {
                this.jlq = LayoutInflater.from(this.jlp.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gtL = (TextView) this.jlq.findViewById(R.id.tips);
                this.jlr = (TextView) this.jlq.findViewById(R.id.tips_content);
                this.jlq.setOnClickListener(this.fSq);
            }
            this.gtL.setText(aq.l(str, 24, "..."));
            this.jlr.setText(R.string.topic_join);
            if (this.fSm == null) {
                this.fSm = new PopupWindow(this.jlq, -2, -2);
            } else {
                bsX();
            }
            e.iK().removeCallbacks(this.fSo);
            e.iK().postDelayed(this.fSo, 100L);
        }
    }

    public void bsX() {
        e.iK().removeCallbacks(this.fSo);
        e.iK().removeCallbacks(this.fSp);
        bsY();
    }

    public void bsY() {
        g.a(this.fSm);
    }

    public void onDestroy() {
        bsX();
    }
}
