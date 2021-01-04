package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private PopupWindow jLc;
    private Runnable jLe = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jLc != null && c.this.jLc.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nyA.getActivity());
                int dimens = l.getDimens(c.this.nyA.getActivity(), R.dimen.ds278);
                c.this.jLc.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jLc, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nyA.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.jLf, 5000L);
                TiebaStatic.log(new aq("c13016").an("obj_locate", 1));
            }
        }
    };
    private Runnable jLf = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cOA();
        }
    };
    private View.OnClickListener jLg = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cOz();
            if (!WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(c.this.nyA).setType(9).setTitle(c.this.mTopicName).setForumId("0").send();
                TiebaStatic.log(new aq("c13017").an("obj_locate", 1));
            }
        }
    };
    private TextView kse;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity nyA;
    private View nyB;
    private TextView nyC;

    public c(MainTabActivity mainTabActivity) {
        this.nyA = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nyA.findViewById(R.id.tab_host);
    }

    public void l(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.nyB == null) {
                this.nyB = LayoutInflater.from(this.nyA.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.kse = (TextView) this.nyB.findViewById(R.id.tips);
                this.nyC = (TextView) this.nyB.findViewById(R.id.tips_content);
                this.nyB.setOnClickListener(this.jLg);
            }
            this.kse.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nyC.setText(R.string.topic_join);
            if (this.jLc == null) {
                this.jLc = new PopupWindow(this.nyB, -2, -2);
            } else {
                cOz();
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLe);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jLe, 100L);
        }
    }

    public void cOz() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLe);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jLf);
        cOA();
    }

    public void cOA() {
        g.dismissPopupWindow(this.jLc);
    }

    public void onDestroy() {
        cOz();
    }
}
