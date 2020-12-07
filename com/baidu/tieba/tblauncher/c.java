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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c {
    private PopupWindow jyB;
    private Runnable jyD = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jyB != null && c.this.jyB.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nsz.getActivity());
                int dimens = l.getDimens(c.this.nsz.getActivity(), R.dimen.ds278);
                c.this.jyB.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jyB, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nsz.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.jyE, 5000L);
                TiebaStatic.log(new ar("c13016").al("obj_locate", 1));
            }
        }
    };
    private Runnable jyE = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cLw();
        }
    };
    private View.OnClickListener jyF = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cLv();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.nsz, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new ar("c13017").al("obj_locate", 1));
        }
    };
    private TextView keQ;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private View nsA;
    private TextView nsB;
    private MainTabActivity nsz;

    public c(MainTabActivity mainTabActivity) {
        this.nsz = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nsz.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.nsA == null) {
                this.nsA = LayoutInflater.from(this.nsz.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.keQ = (TextView) this.nsA.findViewById(R.id.tips);
                this.nsB = (TextView) this.nsA.findViewById(R.id.tips_content);
                this.nsA.setOnClickListener(this.jyF);
            }
            this.keQ.setText(au.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nsB.setText(R.string.topic_join);
            if (this.jyB == null) {
                this.jyB = new PopupWindow(this.nsA, -2, -2);
            } else {
                cLv();
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyD);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jyD, 100L);
        }
    }

    public void cLv() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyD);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jyE);
        cLw();
    }

    public void cLw() {
        g.dismissPopupWindow(this.jyB);
    }

    public void onDestroy() {
        cLv();
    }
}
