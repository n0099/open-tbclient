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
    private PopupWindow gNh;
    private Runnable gNj = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.gNh != null && c.this.gNh.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.kmK.getActivity());
                int dimens = l.getDimens(c.this.kmK.getActivity(), R.dimen.ds278);
                c.this.gNh.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.gNh, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.kmK.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aFB().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                e.gx().postDelayed(c.this.gNk, 5000L);
                TiebaStatic.log(new an("c13016").X("obj_locate", 1));
            }
        }
    };
    private Runnable gNk = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLe();
        }
    };
    private View.OnClickListener gNl = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bLd();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.kmK, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").X("obj_locate", 1));
        }
    };
    private TextView hnj;
    private MainTabActivity kmK;
    private View kmL;
    private TextView kmM;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.kmK = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.kmK.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.kmL == null) {
                this.kmL = LayoutInflater.from(this.kmK.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hnj = (TextView) this.kmL.findViewById(R.id.tips);
                this.kmM = (TextView) this.kmL.findViewById(R.id.tips_content);
                this.kmL.setOnClickListener(this.gNl);
            }
            this.hnj.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.kmM.setText(R.string.topic_join);
            if (this.gNh == null) {
                this.gNh = new PopupWindow(this.kmL, -2, -2);
            } else {
                bLd();
            }
            e.gx().removeCallbacks(this.gNj);
            e.gx().postDelayed(this.gNj, 100L);
        }
    }

    public void bLd() {
        e.gx().removeCallbacks(this.gNj);
        e.gx().removeCallbacks(this.gNk);
        bLe();
    }

    public void bLe() {
        g.dismissPopupWindow(this.gNh);
    }

    public void onDestroy() {
        bLd();
    }
}
