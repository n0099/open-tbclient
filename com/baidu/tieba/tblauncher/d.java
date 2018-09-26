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
/* loaded from: classes.dex */
public class d {
    private TextView emH;
    private Runnable fRv = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.hap != null && d.this.hap.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(d.this.hbf.getActivity());
                int h = l.h(d.this.hbf.getActivity(), e.C0141e.ds252);
                d.this.hap.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.hap, fragmentTabWidget, (aO - l.h(d.this.hbf.getActivity(), e.C0141e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.hbg);
                com.baidu.adp.lib.g.e.jt().postDelayed(d.this.fRw, 5000L);
                TiebaStatic.log(new am("c13016").w("obj_locate", 1));
            }
        }
    };
    private Runnable fRw = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bhM();
        }
    };
    private View.OnClickListener fRx = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bAC();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.hbf, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").w("obj_locate", 1));
        }
    };
    private PopupWindow hap;
    private MainTabActivity hbf;
    private long hbg;
    private View hbh;
    private TextView hbi;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.hbf = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hbf.findViewById(e.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hbg = j;
            if (this.hbh == null) {
                this.hbh = LayoutInflater.from(this.hbf.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.emH = (TextView) this.hbh.findViewById(e.g.tips);
                this.hbi = (TextView) this.hbh.findViewById(e.g.tips_content);
                this.hbh.setOnClickListener(this.fRx);
            }
            this.emH.setText(ao.f(str, 24, "..."));
            this.hbi.setText(e.j.topic_join);
            if (this.hap == null) {
                this.hap = new PopupWindow(this.hbh, -2, -2);
                this.hap.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.hbf.getActivity()));
                    }
                });
            } else {
                bAC();
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.fRv, 100L);
        }
    }

    public void bAC() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRv);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fRw);
        bhM();
    }

    public void bhM() {
        g.a(this.hap);
    }

    public void onDestroy() {
        bAC();
    }
}
