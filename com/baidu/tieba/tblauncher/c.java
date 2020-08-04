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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c {
    private TextView iLx;
    private PopupWindow ihx;
    private MainTabActivity lTE;
    private View lTF;
    private TextView lTG;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private Runnable ihz = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.ihx != null && c.this.ihx.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.lTE.getActivity());
                int dimens = l.getDimens(c.this.lTE.getActivity(), R.dimen.ds278);
                c.this.ihx.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.ihx, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.lTE.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.ihA, 5000L);
                TiebaStatic.log(new ap("c13016").ah("obj_locate", 1));
            }
        }
    };
    private Runnable ihA = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cjz();
        }
    };
    private View.OnClickListener ihB = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cjy();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.lTE, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new ap("c13017").ah("obj_locate", 1));
        }
    };

    public c(MainTabActivity mainTabActivity) {
        this.lTE = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.lTE.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.lTF == null) {
                this.lTF = LayoutInflater.from(this.lTE.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.iLx = (TextView) this.lTF.findViewById(R.id.tips);
                this.lTG = (TextView) this.lTF.findViewById(R.id.tips_content);
                this.lTF.setOnClickListener(this.ihB);
            }
            this.iLx.setText(as.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.lTG.setText(R.string.topic_join);
            if (this.ihx == null) {
                this.ihx = new PopupWindow(this.lTF, -2, -2);
            } else {
                cjy();
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihz);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ihz, 100L);
        }
    }

    public void cjy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihz);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ihA);
        cjz();
    }

    public void cjz() {
        g.dismissPopupWindow(this.ihx);
    }

    public void onDestroy() {
        cjy();
    }
}
