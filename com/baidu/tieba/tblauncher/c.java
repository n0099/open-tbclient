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
/* loaded from: classes16.dex */
public class c {
    private PopupWindow ivC;
    private Runnable ivE = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.ivC != null && c.this.ivC.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.mlq.getActivity());
                int dimens = l.getDimens(c.this.mlq.getActivity(), R.dimen.ds278);
                c.this.ivC.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.ivC, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.mlq.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.ivF, 5000L);
                TiebaStatic.log(new aq("c13016").ai("obj_locate", 1));
            }
        }
    };
    private Runnable ivF = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cud();
        }
    };
    private View.OnClickListener ivG = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cuc();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mlq, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").ai("obj_locate", 1));
        }
    };
    private TextView jav;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity mlq;
    private View mlr;
    private TextView mls;

    public c(MainTabActivity mainTabActivity) {
        this.mlq = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.mlq.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.mlr == null) {
                this.mlr = LayoutInflater.from(this.mlq.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jav = (TextView) this.mlr.findViewById(R.id.tips);
                this.mls = (TextView) this.mlr.findViewById(R.id.tips_content);
                this.mlr.setOnClickListener(this.ivG);
            }
            this.jav.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.mls.setText(R.string.topic_join);
            if (this.ivC == null) {
                this.ivC = new PopupWindow(this.mlr, -2, -2);
            } else {
                cuc();
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivE);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.ivE, 100L);
        }
    }

    public void cuc() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivE);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivF);
        cud();
    }

    public void cud() {
        g.dismissPopupWindow(this.ivC);
    }

    public void onDestroy() {
        cuc();
    }
}
