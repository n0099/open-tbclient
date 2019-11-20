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
    private PopupWindow fTw;
    private long gnr;
    private TextView gtA;
    private MainTabActivity jnU;
    private View jnV;
    private TextView jnW;
    private FragmentTabHost mTabHost;
    private String mTopicName;
    private Runnable fTy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.fTw != null && c.this.fTw.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.jnU.getActivity());
                int dimens = l.getDimens(c.this.jnU.getActivity(), R.dimen.ds278);
                c.this.fTw.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.fTw, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.jnU.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.alP().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.gnr);
                e.fZ().postDelayed(c.this.fTz, 5000L);
                TiebaStatic.log(new an("c13016").O("obj_locate", 1));
            }
        }
    };
    private Runnable fTz = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bra();
        }
    };
    private View.OnClickListener fTA = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bqZ();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.jnU, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").O("obj_locate", 1));
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.jnU = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.jnU.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.gnr = j;
            if (this.jnV == null) {
                this.jnV = LayoutInflater.from(this.jnU.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.gtA = (TextView) this.jnV.findViewById(R.id.tips);
                this.jnW = (TextView) this.jnV.findViewById(R.id.tips_content);
                this.jnV.setOnClickListener(this.fTA);
            }
            this.gtA.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.jnW.setText(R.string.topic_join);
            if (this.fTw == null) {
                this.fTw = new PopupWindow(this.jnV, -2, -2);
            } else {
                bqZ();
            }
            e.fZ().removeCallbacks(this.fTy);
            e.fZ().postDelayed(this.fTy, 100L);
        }
    }

    public void bqZ() {
        e.fZ().removeCallbacks(this.fTy);
        e.fZ().removeCallbacks(this.fTz);
        bra();
    }

    public void bra() {
        g.dismissPopupWindow(this.fTw);
    }

    public void onDestroy() {
        bqZ();
    }
}
