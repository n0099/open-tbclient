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
    private PopupWindow hNu;
    private Runnable hNw = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.hNu != null && c.this.hNu.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.lrv.getActivity());
                int dimens = l.getDimens(c.this.lrv.getActivity(), R.dimen.ds278);
                c.this.hNu.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.hNu, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.lrv.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.ld().postDelayed(c.this.hNx, 5000L);
                TiebaStatic.log(new an("c13016").ag("obj_locate", 1));
            }
        }
    };
    private Runnable hNx = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.ccy();
        }
    };
    private View.OnClickListener hNy = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.ccx();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.lrv, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").ag("obj_locate", 1));
        }
    };
    private TextView iny;
    private MainTabActivity lrv;
    private View lrw;
    private TextView lrx;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.lrv = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.lrv.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.lrw == null) {
                this.lrw = LayoutInflater.from(this.lrv.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.iny = (TextView) this.lrw.findViewById(R.id.tips);
                this.lrx = (TextView) this.lrw.findViewById(R.id.tips_content);
                this.lrw.setOnClickListener(this.hNy);
            }
            this.iny.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.lrx.setText(R.string.topic_join);
            if (this.hNu == null) {
                this.hNu = new PopupWindow(this.lrw, -2, -2);
            } else {
                ccx();
            }
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNw);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.hNw, 100L);
        }
    }

    public void ccx() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNw);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.hNx);
        ccy();
    }

    public void ccy() {
        g.dismissPopupWindow(this.hNu);
    }

    public void onDestroy() {
        ccx();
    }
}
