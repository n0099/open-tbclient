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
    private TextView ebz;
    private Runnable fJJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.mTabHost != null && d.this.gRE != null && d.this.gRE.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = d.this.mTabHost.getFragmentTabWidget();
                int ah = l.ah(d.this.gSt.getActivity());
                int e = l.e(d.this.gSt.getActivity(), d.e.ds252);
                d.this.gRE.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(d.this.gRE, fragmentTabWidget, (ah - l.e(d.this.gSt.getActivity(), d.e.ds430)) / 2, -e);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("home_tip", d.this.gSu);
                com.baidu.adp.lib.g.e.im().postDelayed(d.this.fJK, TbConfig.NOTIFY_SOUND_INTERVAL);
                TiebaStatic.log(new an("c13016").r("obj_locate", 1));
            }
        }
    };
    private Runnable fJK = new Runnable() { // from class: com.baidu.tieba.tblauncher.d.3
        @Override // java.lang.Runnable
        public void run() {
            d.this.bgU();
        }
    };
    private View.OnClickListener fJL = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.d.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.bzq();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(d.this.gSt, 9, String.valueOf(0), "", null, null, 0, null, 13003, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(d.this.mTopicName)) {
                writeActivityConfig.setTitle(d.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            TiebaStatic.log(new an("c13017").r("obj_locate", 1));
        }
    };
    private PopupWindow gRE;
    private MainTabActivity gSt;
    private long gSu;
    private View gSv;
    private TextView gSw;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public d(MainTabActivity mainTabActivity) {
        this.gSt = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.gSt.findViewById(d.g.tab_host);
    }

    public void c(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gSu = j;
            if (this.gSv == null) {
                this.gSv = LayoutInflater.from(this.gSt.getActivity()).inflate(d.i.tips_blue_twice_line_down, (ViewGroup) null);
                this.ebz = (TextView) this.gSv.findViewById(d.g.tips);
                this.gSw = (TextView) this.gSv.findViewById(d.g.tips_content);
                this.gSv.setOnClickListener(this.fJL);
            }
            this.ebz.setText(ap.g(str, 24, "..."));
            this.gSw.setText(d.k.topic_join);
            if (this.gRE == null) {
                this.gRE = new PopupWindow(this.gSv, -2, -2);
                this.gRE.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.tblauncher.d.1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public void onDismiss() {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921341, d.this.gSt.getActivity()));
                    }
                });
            } else {
                bzq();
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJJ);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fJJ, 100L);
        }
    }

    public void bzq() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJJ);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fJK);
        bgU();
    }

    public void bgU() {
        g.a(this.gRE);
    }

    public void onDestroy() {
        bzq();
    }
}
