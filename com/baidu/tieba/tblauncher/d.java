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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class d {
    private TextView efm;
    private Runnable fJQ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.gSD != null && d.this.gSD.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int ah = l.ah(d.this.gTs.getActivity());
                int f = l.f(d.this.gTs.getActivity(), f.e.ds252);
                d.this.gSD.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gSD, fragmentTabWidget, (ah - l.f(d.this.gTs.getActivity(), f.e.ds430)) / 2, -f);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gTt);
                com.baidu.adp.lib.g.e.in().postDelayed(d.this.fJR, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable fJR = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfi();
        }
    };
    private View.OnClickListener fJS = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bxU();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gTs, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").r("obj_locate", 1));
        }
    };
    private PopupWindow gSD;
    private MainTabActivity gTs;
    private long gTt;
    private View gTu;
    private TextView gTv;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gTs = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.gTs.findViewById(f.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gTt = j;
            if (this.gTu == null) {
                this.gTu = LayoutInflater.from(this.gTs.getActivity()).inflate(f.h.tips_blue_twice_line_down, (ViewGroup) null);
                this.efm = (TextView) this.gTu.findViewById(f.g.tips);
                this.gTv = (TextView) this.gTu.findViewById(f.g.tips_content);
                this.gTu.setOnClickListener(this.fJS);
            }
            this.efm.setText(ap.f(str, 24, "..."));
            this.gTv.setText(f.j.topic_join);
            if (this.gSD == null) {
                this.gSD = new PopupWindow(this.gTu, -2, -2);
                this.gSD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gTs.getActivity()));
                    }
                });
            } else {
                bxU();
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJQ);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fJQ, 100L);
        }
    }

    public void bxU() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJQ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fJR);
        bfi();
    }

    public void bfi() {
        g.a(this.gSD);
    }

    public void onDestroy() {
        bxU();
    }
}
