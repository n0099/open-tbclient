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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private FragmentTabHost bgN;
    private TextView dLn;
    private Runnable ftk = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bgN != null && d.this.gAA != null && d.this.gAA.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.bgN.getFragmentTabWidget();
                int af = l.af(d.this.gBn.getActivity());
                int e = l.e(d.this.gBn.getActivity(), d.e.ds252);
                d.this.gAA.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gAA, fragmentTabWidget, (af - l.e(d.this.gBn.getActivity(), d.e.ds430)) / 2, -e);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gBo);
                com.baidu.adp.lib.g.e.fw().postDelayed(d.this.ftl, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new al("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable ftl = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bbn();
        }
    };
    private View.OnClickListener ftm = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d.this.btE();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gBn, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new al("c13017").r("obj_locate", 1));
        }
    };
    private PopupWindow gAA;
    private MainTabActivity gBn;
    private long gBo;
    private View gBp;
    private TextView gBq;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gBn = mainTabActivity;
        this.bgN = (FragmentTabHost) this.gBn.findViewById(d.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gBo = j;
            if (this.gBp == null) {
                this.gBp = LayoutInflater.from(this.gBn.getActivity()).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
                this.dLn = (TextView) this.gBp.findViewById(d.g.tips);
                this.gBq = (TextView) this.gBp.findViewById(d.g.tips_content);
                this.gBp.setOnClickListener(this.ftm);
            }
            this.dLn.setText(an.g(str, 24, "..."));
            this.gBq.setText(d.k.topic_join);
            if (this.gAA == null) {
                this.gAA = new PopupWindow(this.gBp, -2, -2);
                this.gAA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gBn.getActivity()));
                    }
                });
            } else {
                btE();
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ftk);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.ftk, 100L);
        }
    }

    public void btE() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ftk);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.ftl);
        bbn();
    }

    public void bbn() {
        g.a(this.gAA);
    }

    public void onDestroy() {
        btE();
    }
}
