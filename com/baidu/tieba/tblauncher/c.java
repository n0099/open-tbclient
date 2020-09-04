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
    private PopupWindow ivI;
    private Runnable ivK = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.ivI != null && c.this.ivI.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.mlI.getActivity());
                int dimens = l.getDimens(c.this.mlI.getActivity(), R.dimen.ds278);
                c.this.ivI.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.ivI, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.mlI.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mS().postDelayed(c.this.ivL, 5000L);
                TiebaStatic.log(new aq("c13016").ai("obj_locate", 1));
            }
        }
    };
    private Runnable ivL = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cue();
        }
    };
    private View.OnClickListener ivM = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cud();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mlI, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").ai("obj_locate", 1));
        }
    };
    private TextView jaB;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity mlI;
    private View mlJ;
    private TextView mlK;

    public c(MainTabActivity mainTabActivity) {
        this.mlI = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.mlI.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.mlJ == null) {
                this.mlJ = LayoutInflater.from(this.mlI.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jaB = (TextView) this.mlJ.findViewById(R.id.tips);
                this.mlK = (TextView) this.mlJ.findViewById(R.id.tips_content);
                this.mlJ.setOnClickListener(this.ivM);
            }
            this.jaB.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.mlK.setText(R.string.topic_join);
            if (this.ivI == null) {
                this.ivI = new PopupWindow(this.mlJ, -2, -2);
            } else {
                cud();
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivK);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.ivK, 100L);
        }
    }

    public void cud() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivK);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.ivL);
        cue();
    }

    public void cue() {
        g.dismissPopupWindow(this.ivI);
    }

    public void onDestroy() {
        cud();
    }
}
