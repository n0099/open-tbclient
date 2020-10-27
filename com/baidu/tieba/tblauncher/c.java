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
    private TextView jKE;
    private PopupWindow jeq;
    private Runnable jes = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jeq != null && c.this.jeq.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.mXA.getActivity());
                int dimens = l.getDimens(c.this.mXA.getActivity(), R.dimen.ds278);
                c.this.jeq.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jeq, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.mXA.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bnH().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.jet, 5000L);
                TiebaStatic.log(new aq("c13016").aj("obj_locate", 1));
            }
        }
    };
    private Runnable jet = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cEb();
        }
    };
    private View.OnClickListener jeu = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cEa();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mXA, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").aj("obj_locate", 1));
        }
    };
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity mXA;
    private View mXB;
    private TextView mXC;

    public c(MainTabActivity mainTabActivity) {
        this.mXA = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.mXA.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.mXB == null) {
                this.mXB = LayoutInflater.from(this.mXA.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jKE = (TextView) this.mXB.findViewById(R.id.tips);
                this.mXC = (TextView) this.mXB.findViewById(R.id.tips_content);
                this.mXB.setOnClickListener(this.jeu);
            }
            this.jKE.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.mXC.setText(R.string.topic_join);
            if (this.jeq == null) {
                this.jeq = new PopupWindow(this.mXB, -2, -2);
            } else {
                cEa();
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jes);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jes, 100L);
        }
    }

    public void cEa() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jes);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jet);
        cEb();
    }

    public void cEb() {
        g.dismissPopupWindow(this.jeq);
    }

    public void onDestroy() {
        cEa();
    }
}
