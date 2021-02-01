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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    private PopupWindow jMa;
    private Runnable jMc = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jMa != null && c.this.jMa.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nDF.getActivity());
                int dimens = l.getDimens(c.this.nDF.getActivity(), R.dimen.ds278);
                c.this.jMa.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jMa, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nDF.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.jMd, 5000L);
                TiebaStatic.log(new ar("c13016").ap("obj_locate", 1));
            }
        }
    };
    private Runnable jMd = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cLX();
        }
    };
    private View.OnClickListener jMe = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cLW();
            if (!WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(c.this.nDF).setType(9).setTitle(c.this.mTopicName).setForumId("0").send();
                TiebaStatic.log(new ar("c13017").ap("obj_locate", 1));
            }
        }
    };
    private TextView kvG;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity nDF;
    private View nDG;
    private TextView nDH;

    public c(MainTabActivity mainTabActivity) {
        this.nDF = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nDF.findViewById(R.id.tab_host);
    }

    public void m(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.nDG == null) {
                this.nDG = LayoutInflater.from(this.nDF.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.kvG = (TextView) this.nDG.findViewById(R.id.tips);
                this.nDH = (TextView) this.nDG.findViewById(R.id.tips_content);
                this.nDG.setOnClickListener(this.jMe);
            }
            this.kvG.setText(au.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nDH.setText(R.string.topic_join);
            if (this.jMa == null) {
                this.jMa = new PopupWindow(this.nDG, -2, -2);
            } else {
                cLW();
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMc);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMc, 100L);
        }
    }

    public void cLW() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMd);
        cLX();
    }

    public void cLX() {
        g.dismissPopupWindow(this.jMa);
    }

    public void onDestroy() {
        cLW();
    }
}
