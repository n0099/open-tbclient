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
    private PopupWindow iRU;
    private Runnable iRW = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.iRU != null && c.this.iRU.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.mKR.getActivity());
                int dimens = l.getDimens(c.this.mKR.getActivity(), R.dimen.ds278);
                c.this.iRU.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.iRU, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.mKR.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.blO().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.iRX, 5000L);
                TiebaStatic.log(new aq("c13016").aj("obj_locate", 1));
            }
        }
    };
    private Runnable iRX = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cAU();
        }
    };
    private View.OnClickListener iRY = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cAT();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mKR, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").aj("obj_locate", 1));
        }
    };
    private TextView jyf;
    private MainTabActivity mKR;
    private View mKS;
    private TextView mKT;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.mKR = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.mKR.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.mKS == null) {
                this.mKS = LayoutInflater.from(this.mKR.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jyf = (TextView) this.mKS.findViewById(R.id.tips);
                this.mKT = (TextView) this.mKS.findViewById(R.id.tips_content);
                this.mKS.setOnClickListener(this.iRY);
            }
            this.jyf.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.mKT.setText(R.string.topic_join);
            if (this.iRU == null) {
                this.iRU = new PopupWindow(this.mKS, -2, -2);
            } else {
                cAT();
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRW);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.iRW, 100L);
        }
    }

    public void cAT() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRW);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.iRX);
        cAU();
    }

    public void cAU() {
        g.dismissPopupWindow(this.iRU);
    }

    public void onDestroy() {
        cAT();
    }
}
