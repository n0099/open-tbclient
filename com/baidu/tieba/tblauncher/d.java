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
public class d {
    private TextView euA;
    private Runnable fYV = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.hhH != null && d.this.hhH.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int aO = l.aO(d.this.hiw.getActivity());
                int h = l.h(d.this.hiw.getActivity(), e.C0175e.ds252);
                d.this.hhH.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.hhH, fragmentTabWidget, (aO - l.h(d.this.hiw.getActivity(), e.C0175e.ds430)) / 2, -h);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.hix);
                com.baidu.adp.lib.g.e.jI().postDelayed(d.this.fYW, 5000L);
                TiebaStatic.log(new am("c13016").x("obj_locate", 1));
            }
        }
    };
    private Runnable fYW = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bkY();
        }
    };
    private View.OnClickListener fYX = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bDQ();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.hiw, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new am("c13017").x("obj_locate", 1));
        }
    };
    private PopupWindow hhH;
    private MainTabActivity hiw;
    private long hix;
    private View hiy;
    private TextView hiz;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.hiw = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.hiw.findViewById(e.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hix = j;
            if (this.hiy == null) {
                this.hiy = LayoutInflater.from(this.hiw.getActivity()).inflate(e.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.euA = (TextView) this.hiy.findViewById(e.g.tips);
                this.hiz = (TextView) this.hiy.findViewById(e.g.tips_content);
                this.hiy.setOnClickListener(this.fYX);
            }
            this.euA.setText(ao.f(str, 24, "..."));
            this.hiz.setText(e.j.topic_join);
            if (this.hhH == null) {
                this.hhH = new PopupWindow(this.hiy, -2, -2);
                this.hhH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.hiw.getActivity()));
                    }
                });
            } else {
                bDQ();
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYV);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.fYV, 100L);
        }
    }

    public void bDQ() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYV);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fYW);
        bkY();
    }

    public void bkY() {
        g.a(this.hhH);
    }

    public void onDestroy() {
        bDQ();
    }
}
