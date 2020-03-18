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
/* loaded from: classes9.dex */
public class c {
    private PopupWindow gOC;
    private Runnable gOE = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.gOC != null && c.this.gOC.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.koB.getActivity());
                int dimens = l.getDimens(c.this.koB.getActivity(), R.dimen.ds278);
                c.this.gOC.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.gOC, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.koB.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aFH().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                e.gx().postDelayed(c.this.gOF, 5000L);
                TiebaStatic.log(new an("c13016").X("obj_locate", 1));
            }
        }
    };
    private Runnable gOF = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLv();
        }
    };
    private View.OnClickListener gOG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bLu();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.koB, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").X("obj_locate", 1));
        }
    };
    private TextView hoX;
    private MainTabActivity koB;
    private View koC;
    private TextView koD;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.koB = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.koB.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.koC == null) {
                this.koC = LayoutInflater.from(this.koB.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hoX = (TextView) this.koC.findViewById(R.id.tips);
                this.koD = (TextView) this.koC.findViewById(R.id.tips_content);
                this.koC.setOnClickListener(this.gOG);
            }
            this.hoX.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.koD.setText(R.string.topic_join);
            if (this.gOC == null) {
                this.gOC = new PopupWindow(this.koC, -2, -2);
            } else {
                bLu();
            }
            e.gx().removeCallbacks(this.gOE);
            e.gx().postDelayed(this.gOE, 100L);
        }
    }

    public void bLu() {
        e.gx().removeCallbacks(this.gOE);
        e.gx().removeCallbacks(this.gOF);
        bLv();
    }

    public void bLv() {
        g.dismissPopupWindow(this.gOC);
    }

    public void onDestroy() {
        bLu();
    }
}
