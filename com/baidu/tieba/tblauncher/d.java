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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private TextView efp;
    private Runnable fJX = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.gSC != null && d.this.gSC.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int ah = l.ah(d.this.gTr.getActivity());
                int f = l.f(d.this.gTr.getActivity(), d.e.ds252);
                d.this.gSC.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gSC, fragmentTabWidget, (ah - l.f(d.this.gTr.getActivity(), d.e.ds430)) / 2, -f);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gTs);
                com.baidu.adp.lib.g.e.in().postDelayed(d.this.fJY, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable fJY = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfn();
        }
    };
    private View.OnClickListener fJZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bxT();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gTr, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").r("obj_locate", 1));
        }
    };
    private PopupWindow gSC;
    private MainTabActivity gTr;
    private long gTs;
    private View gTt;
    private TextView gTu;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gTr = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.gTr.findViewById(d.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gTs = j;
            if (this.gTt == null) {
                this.gTt = LayoutInflater.from(this.gTr.getActivity()).inflate(d.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.efp = (TextView) this.gTt.findViewById(d.g.tips);
                this.gTu = (TextView) this.gTt.findViewById(d.g.tips_content);
                this.gTt.setOnClickListener(this.fJZ);
            }
            this.efp.setText(ap.g(str, 24, "..."));
            this.gTu.setText(d.j.topic_join);
            if (this.gSC == null) {
                this.gSC = new PopupWindow(this.gTt, -2, -2);
                this.gSC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gTr.getActivity()));
                    }
                });
            } else {
                bxT();
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJX);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fJX, 100L);
        }
    }

    public void bxT() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJX);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJY);
        bfn();
    }

    public void bfn() {
        g.a(this.gSC);
    }

    public void onDestroy() {
        bxT();
    }
}
