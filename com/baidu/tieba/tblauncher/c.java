package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.f.e;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c {
    private PopupWindow gLi;
    private Runnable gLk = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.gLi != null && c.this.gLi.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.klO.getActivity());
                int dimens = l.getDimens(c.this.klO.getActivity(), R.dimen.ds278);
                c.this.gLi.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.gLi, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.klO.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.hev);
                e.gx().postDelayed(c.this.gLl, 5000L);
                TiebaStatic.log(new an("c13016").Z("obj_locate", 1));
            }
        }
    };
    private Runnable gLl = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bJD();
        }
    };
    private View.OnClickListener gLm = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bJC();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.klO, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").Z("obj_locate", 1));
        }
    };
    private long hev;
    private TextView hlj;
    private MainTabActivity klO;
    private View klP;
    private TextView klQ;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.klO = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.klO.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.hev = j;
            if (this.klP == null) {
                this.klP = LayoutInflater.from(this.klO.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hlj = (TextView) this.klP.findViewById(R.id.tips);
                this.klQ = (TextView) this.klP.findViewById(R.id.tips_content);
                this.klP.setOnClickListener(this.gLm);
            }
            this.hlj.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.klQ.setText(R.string.topic_join);
            if (this.gLi == null) {
                this.gLi = new PopupWindow(this.klP, -2, -2);
            } else {
                bJC();
            }
            e.gx().removeCallbacks(this.gLk);
            e.gx().postDelayed(this.gLk, 100L);
        }
    }

    public void bJC() {
        e.gx().removeCallbacks(this.gLk);
        e.gx().removeCallbacks(this.gLl);
        bJD();
    }

    public void bJD() {
        g.dismissPopupWindow(this.gLi);
    }

    public void onDestroy() {
        bJC();
    }
}
