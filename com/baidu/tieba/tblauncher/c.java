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
    private PopupWindow jNX;
    private Runnable jNZ = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jNX != null && c.this.jNX.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nGl.getActivity());
                int dimens = l.getDimens(c.this.nGl.getActivity(), R.dimen.ds278);
                c.this.jNX.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jNX, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nGl.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.jOa, 5000L);
                TiebaStatic.log(new ar("c13016").aq("obj_locate", 1));
            }
        }
    };
    private Runnable jOa = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMk();
        }
    };
    private View.OnClickListener jOb = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cMj();
            if (!WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(c.this.nGl).setType(9).setTitle(c.this.mTopicName).setForumId("0").send();
                TiebaStatic.log(new ar("c13017").aq("obj_locate", 1));
            }
        }
    };
    private TextView kxW;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity nGl;
    private View nGm;
    private TextView nGn;

    public c(MainTabActivity mainTabActivity) {
        this.nGl = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nGl.findViewById(R.id.tab_host);
    }

    public void m(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.nGm == null) {
                this.nGm = LayoutInflater.from(this.nGl.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.kxW = (TextView) this.nGm.findViewById(R.id.tips);
                this.nGn = (TextView) this.nGm.findViewById(R.id.tips_content);
                this.nGm.setOnClickListener(this.jOb);
            }
            this.kxW.setText(au.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nGn.setText(R.string.topic_join);
            if (this.jNX == null) {
                this.jNX = new PopupWindow(this.nGm, -2, -2);
            } else {
                cMj();
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNZ);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jNZ, 100L);
        }
    }

    public void cMj() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jNZ);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jOa);
        cMk();
    }

    public void cMk() {
        g.dismissPopupWindow(this.jNX);
    }

    public void onDestroy() {
        cMj();
    }
}
