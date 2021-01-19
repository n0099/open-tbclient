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
    private PopupWindow jGw;
    private TextView knz;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity ntU;
    private View ntV;
    private TextView ntW;
    private Runnable jGy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jGw != null && c.this.jGw.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.ntU.getActivity());
                int dimens = l.getDimens(c.this.ntU.getActivity(), R.dimen.ds278);
                c.this.jGw.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jGw, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.ntU.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mB().postDelayed(c.this.jGz, 5000L);
                TiebaStatic.log(new aq("c13016").an("obj_locate", 1));
            }
        }
    };
    private Runnable jGz = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cKJ();
        }
    };
    private View.OnClickListener jGA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cKI();
            if (!WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(c.this.ntU).setType(9).setTitle(c.this.mTopicName).setForumId("0").send();
                TiebaStatic.log(new aq("c13017").an("obj_locate", 1));
            }
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.ntU = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.ntU.findViewById(R.id.tab_host);
    }

    public void l(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.ntV == null) {
                this.ntV = LayoutInflater.from(this.ntU.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.knz = (TextView) this.ntV.findViewById(R.id.tips);
                this.ntW = (TextView) this.ntV.findViewById(R.id.tips_content);
                this.ntV.setOnClickListener(this.jGA);
            }
            this.knz.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.ntW.setText(R.string.topic_join);
            if (this.jGw == null) {
                this.jGw = new PopupWindow(this.ntV, -2, -2);
            } else {
                cKI();
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGy);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.jGy, 100L);
        }
    }

    public void cKI() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGy);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.jGz);
        cKJ();
    }

    public void cKJ() {
        g.dismissPopupWindow(this.jGw);
    }

    public void onDestroy() {
        cKI();
    }
}
