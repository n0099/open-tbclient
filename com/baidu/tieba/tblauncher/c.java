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
/* loaded from: classes21.dex */
public class c {
    private PopupWindow iDe;
    private Runnable iDg = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.iDe != null && c.this.iDe.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.mvh.getActivity());
                int dimens = l.getDimens(c.this.mvh.getActivity(), R.dimen.ds278);
                c.this.iDe.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.iDe, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.mvh.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mX().postDelayed(c.this.iDh, 5000L);
                TiebaStatic.log(new aq("c13016").ai("obj_locate", 1));
            }
        }
    };
    private Runnable iDh = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cxx();
        }
    };
    private View.OnClickListener iDi = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cxw();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.mvh, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new aq("c13017").ai("obj_locate", 1));
        }
    };
    private TextView jjh;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity mvh;
    private View mvi;
    private TextView mvj;

    public c(MainTabActivity mainTabActivity) {
        this.mvh = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.mvh.findViewById(R.id.tab_host);
    }

    public void j(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.mvi == null) {
                this.mvi = LayoutInflater.from(this.mvh.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jjh = (TextView) this.mvi.findViewById(R.id.tips);
                this.mvj = (TextView) this.mvi.findViewById(R.id.tips_content);
                this.mvi.setOnClickListener(this.iDi);
            }
            this.jjh.setText(at.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.mvj.setText(R.string.topic_join);
            if (this.iDe == null) {
                this.iDe = new PopupWindow(this.mvi, -2, -2);
            } else {
                cxw();
            }
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDg);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.iDg, 100L);
        }
    }

    public void cxw() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDg);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.iDh);
        cxx();
    }

    public void cxx() {
        g.dismissPopupWindow(this.iDe);
    }

    public void onDestroy() {
        cxw();
    }
}
