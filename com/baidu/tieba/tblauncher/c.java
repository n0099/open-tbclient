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
    private PopupWindow jMo;
    private Runnable jMq = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jMo != null && c.this.jMo.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nEf.getActivity());
                int dimens = l.getDimens(c.this.nEf.getActivity(), R.dimen.ds278);
                c.this.jMo.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jMo, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nEf.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mA().postDelayed(c.this.jMr, 5000L);
                TiebaStatic.log(new ar("c13016").ap("obj_locate", 1));
            }
        }
    };
    private Runnable jMr = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cMe();
        }
    };
    private View.OnClickListener jMs = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cMd();
            if (!WriteActivityConfig.isAsyncWriting()) {
                WriteActivityConfig.newInstance(c.this.nEf).setType(9).setTitle(c.this.mTopicName).setForumId("0").send();
                TiebaStatic.log(new ar("c13017").ap("obj_locate", 1));
            }
        }
    };
    private TextView kvU;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity nEf;
    private View nEg;
    private TextView nEh;

    public c(MainTabActivity mainTabActivity) {
        this.nEf = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nEf.findViewById(R.id.tab_host);
    }

    public void m(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.nEg == null) {
                this.nEg = LayoutInflater.from(this.nEf.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.kvU = (TextView) this.nEg.findViewById(R.id.tips);
                this.nEh = (TextView) this.nEg.findViewById(R.id.tips_content);
                this.nEg.setOnClickListener(this.jMs);
            }
            this.kvU.setText(au.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nEh.setText(R.string.topic_join);
            if (this.jMo == null) {
                this.jMo = new PopupWindow(this.nEg, -2, -2);
            } else {
                cMd();
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMq);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.jMq, 100L);
        }
    }

    public void cMd() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMq);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.jMr);
        cMe();
    }

    public void cMe() {
        g.dismissPopupWindow(this.jMo);
    }

    public void onDestroy() {
        cMd();
    }
}
