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
/* loaded from: classes6.dex */
public class c {
    private PopupWindow gHV;
    private Runnable gHX = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.gHV != null && c.this.gHV.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.kig.getActivity());
                int dimens = l.getDimens(c.this.kig.getActivity(), R.dimen.ds278);
                c.this.gHV.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.gHV, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.kig.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aCY().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.haS);
                e.gy().postDelayed(c.this.gHY, 5000L);
                TiebaStatic.log(new an("c13016").Z("obj_locate", 1));
            }
        }
    };
    private Runnable gHY = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bIB();
        }
    };
    private View.OnClickListener gHZ = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bIA();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.kig, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").Z("obj_locate", 1));
        }
    };
    private long haS;
    private TextView hhF;
    private MainTabActivity kig;
    private View kih;
    private TextView kii;
    private FragmentTabHost mTabHost;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.kig = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.kig.findViewById(R.id.tab_host);
    }

    public void g(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.haS = j;
            if (this.kih == null) {
                this.kih = LayoutInflater.from(this.kig.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hhF = (TextView) this.kih.findViewById(R.id.tips);
                this.kii = (TextView) this.kih.findViewById(R.id.tips_content);
                this.kih.setOnClickListener(this.gHZ);
            }
            this.hhF.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.kii.setText(R.string.topic_join);
            if (this.gHV == null) {
                this.gHV = new PopupWindow(this.kih, -2, -2);
            } else {
                bIA();
            }
            e.gy().removeCallbacks(this.gHX);
            e.gy().postDelayed(this.gHX, 100L);
        }
    }

    public void bIA() {
        e.gy().removeCallbacks(this.gHX);
        e.gy().removeCallbacks(this.gHY);
        bIB();
    }

    public void bIB() {
        g.dismissPopupWindow(this.gHV);
    }

    public void onDestroy() {
        bIA();
    }
}
