package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c {
    private TextView jQC;
    private PopupWindow jko;
    private Runnable jkq = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jko != null && c.this.jko.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.ndv.getActivity());
                int dimens = l.getDimens(c.this.ndv.getActivity(), R.dimen.ds278);
                c.this.jko.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jko, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.ndv.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bqh().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.jkr, 5000L);
                TiebaStatic.log(new aq("c13016").al("obj_locate", 1));
            }
        }
    };
    private Runnable jkr = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cGC();
        }
    };
    private View.OnClickListener jks = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cGB();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.ndv, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").al("obj_locate", 1));
        }
    };
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity ndv;
    private View ndw;
    private TextView ndx;

    public c(MainTabActivity mainTabActivity) {
        this.ndv = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.ndv.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.ndw == null) {
                this.ndw = LayoutInflater.from(this.ndv.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jQC = (TextView) this.ndw.findViewById(R.id.tips);
                this.ndx = (TextView) this.ndw.findViewById(R.id.tips_content);
                this.ndw.setOnClickListener(this.jks);
            }
            this.jQC.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.ndx.setText(R.string.topic_join);
            if (this.jko == null) {
                this.jko = new PopupWindow(this.ndw, -2, -2);
            } else {
                cGB();
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkq);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jkq, 100L);
        }
    }

    public void cGB() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkq);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jkr);
        cGC();
    }

    public void cGC() {
        g.dismissPopupWindow(this.jko);
    }

    public void onDestroy() {
        cGB();
    }
}
