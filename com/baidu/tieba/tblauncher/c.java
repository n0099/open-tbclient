package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.g.g;
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
/* loaded from: classes4.dex */
public class c {
    private PopupWindow fUn;
    private Runnable fUp = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fUn != null && c.this.fUn.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.joL.getActivity());
                int dimens = l.getDimens(c.this.joL.getActivity(), R.dimen.ds278);
                c.this.fUn.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fUn, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.joL.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.alR().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.goi);
                e.fZ().postDelayed(c.this.fUq, 5000L);
                TiebaStatic.log(new an("c13016").O("obj_locate", 1));
            }
        }
    };
    private Runnable fUq = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.brc();
        }
    };
    private View.OnClickListener fUr = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.brb();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.joL, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").O("obj_locate", 1));
        }
    };
    private long goi;
    private TextView gur;
    private MainTabActivity joL;
    private View joM;
    private TextView joN;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.joL = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.joL.findViewById(R.id.tab_host);
    }

    public void i(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.alR().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.goi = j;
            if (this.joM == null) {
                this.joM = LayoutInflater.from(this.joL.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gur = (TextView) this.joM.findViewById(R.id.tips);
                this.joN = (TextView) this.joM.findViewById(R.id.tips_content);
                this.joM.setOnClickListener(this.fUr);
            }
            this.gur.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.joN.setText(R.string.topic_join);
            if (this.fUn == null) {
                this.fUn = new PopupWindow(this.joM, -2, -2);
            } else {
                brb();
            }
            e.fZ().removeCallbacks(this.fUp);
            e.fZ().postDelayed(this.fUp, 100L);
        }
    }

    public void brb() {
        e.fZ().removeCallbacks(this.fUp);
        e.fZ().removeCallbacks(this.fUq);
        brc();
    }

    public void brc() {
        g.dismissPopupWindow(this.fUn);
    }

    public void onDestroy() {
        brb();
    }
}
