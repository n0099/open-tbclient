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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private TextView iFr;
    private PopupWindow ibt;
    private Runnable ibv = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.ibt != null && c.this.ibt.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.lMm.getActivity());
                int dimens = l.getDimens(c.this.lMm.getActivity(), R.dimen.ds278);
                c.this.ibt.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.ibt, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.lMm.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.lt().postDelayed(c.this.ibw, 5000L);
                TiebaStatic.log(new ao("c13016").ag("obj_locate", 1));
            }
        }
    };
    private Runnable ibw = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cfZ();
        }
    };
    private View.OnClickListener ibx = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cfY();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.lMm, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new ao("c13017").ag("obj_locate", 1));
        }
    };
    private MainTabActivity lMm;
    private View lMn;
    private TextView lMo;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.lMm = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.lMm.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.lMn == null) {
                this.lMn = LayoutInflater.from(this.lMm.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.iFr = (TextView) this.lMn.findViewById(R.id.tips);
                this.lMo = (TextView) this.lMn.findViewById(R.id.tips_content);
                this.lMn.setOnClickListener(this.ibx);
            }
            this.iFr.setText(ar.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.lMo.setText(R.string.topic_join);
            if (this.ibt == null) {
                this.ibt = new PopupWindow(this.lMn, -2, -2);
            } else {
                cfY();
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibv);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ibv, 100L);
        }
    }

    public void cfY() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibv);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ibw);
        cfZ();
    }

    public void cfZ() {
        g.dismissPopupWindow(this.ibt);
    }

    public void onDestroy() {
        cfY();
    }
}
