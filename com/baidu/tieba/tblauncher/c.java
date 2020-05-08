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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private TextView hYL;
    private PopupWindow hyH;
    private Runnable hyJ = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.hyH != null && c.this.hyH.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.kYL.getActivity());
                int dimens = l.getDimens(c.this.kYL.getActivity(), R.dimen.ds278);
                c.this.hyH.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.hyH, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.kYL.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aNT().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.lb().postDelayed(c.this.hyK, 5000L);
                TiebaStatic.log(new an("c13016").af("obj_locate", 1));
            }
        }
    };
    private Runnable hyK = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bVZ();
        }
    };
    private View.OnClickListener hyL = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bVY();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.kYL, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").af("obj_locate", 1));
        }
    };
    private MainTabActivity kYL;
    private View kYM;
    private TextView kYN;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.kYL = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.kYL.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.kYM == null) {
                this.kYM = LayoutInflater.from(this.kYL.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hYL = (TextView) this.kYM.findViewById(R.id.tips);
                this.kYN = (TextView) this.kYM.findViewById(R.id.tips_content);
                this.kYM.setOnClickListener(this.hyL);
            }
            this.hYL.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.kYN.setText(R.string.topic_join);
            if (this.hyH == null) {
                this.hyH = new PopupWindow(this.kYM, -2, -2);
            } else {
                bVY();
            }
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyJ);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.hyJ, 100L);
        }
    }

    public void bVY() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyJ);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.hyK);
        bVZ();
    }

    public void bVZ() {
        g.dismissPopupWindow(this.hyH);
    }

    public void onDestroy() {
        bVY();
    }
}
