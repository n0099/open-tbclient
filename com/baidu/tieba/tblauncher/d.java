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
    private FragmentTabHost bgO;
    private TextView dMt;
    private Runnable fur = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.bgO != null && d.this.gBD != null && d.this.gBD.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.bgO.getFragmentTabWidget();
                int af = l.af(d.this.gCq.getActivity());
                int e = l.e(d.this.gCq.getActivity(), d.e.ds252);
                d.this.gBD.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gBD, fragmentTabWidget, (af - l.e(d.this.gCq.getActivity(), d.e.ds430)) / 2, -e);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gCr);
                com.baidu.adp.lib.g.e.fw().postDelayed(d.this.fus, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new al("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable fus = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bbn();
        }
    };
    private View.OnClickListener fut = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d.this.btC();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gCq, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new al("c13017").r("obj_locate", 1));
        }
    };
    private PopupWindow gBD;
    private MainTabActivity gCq;
    private long gCr;
    private View gCs;
    private TextView gCt;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gCq = mainTabActivity;
        this.bgO = (FragmentTabHost) this.gCq.findViewById(d.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gCr = j;
            if (this.gCs == null) {
                this.gCs = LayoutInflater.from(this.gCq.getActivity()).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
                this.dMt = (TextView) this.gCs.findViewById(d.g.tips);
                this.gCt = (TextView) this.gCs.findViewById(d.g.tips_content);
                this.gCs.setOnClickListener(this.fut);
            }
            this.dMt.setText(an.g(str, 24, "..."));
            this.gCt.setText(d.k.topic_join);
            if (this.gBD == null) {
                this.gBD = new PopupWindow(this.gCs, -2, -2);
                this.gBD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gCq.getActivity()));
                    }
                });
            } else {
                btC();
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fur);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fur, 100L);
        }
    }

    public void btC() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fur);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fus);
        bbn();
    }

    public void bbn() {
        g.a(this.gBD);
    }

    public void onDestroy() {
        btC();
    }
}
