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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c {
    private TextView jRm;
    private PopupWindow jkY;
    private Runnable jla = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.jkY != null && c.this.jkY.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.nex.getActivity());
                int dimens = l.getDimens(c.this.nex.getActivity(), R.dimen.ds278);
                c.this.jkY.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.jkY, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.nex.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.bpu().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                com.baidu.adp.lib.f.e.mY().postDelayed(c.this.jlb, 5000L);
                TiebaStatic.log(new ar("c13016").ak("obj_locate", 1));
            }
        }
    };
    private Runnable jlb = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.cGh();
        }
    };
    private View.OnClickListener jlc = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.cGg();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.nex, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new ar("c13017").ak("obj_locate", 1));
        }
    };
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;
    private MainTabActivity nex;
    private View ney;
    private TextView nez;

    public c(MainTabActivity mainTabActivity) {
        this.nex = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.nex.findViewById(R.id.tab_host);
    }

    public void k(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.ney == null) {
                this.ney = LayoutInflater.from(this.nex.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.jRm = (TextView) this.ney.findViewById(R.id.tips);
                this.nez = (TextView) this.ney.findViewById(R.id.tips_content);
                this.ney.setOnClickListener(this.jlc);
            }
            this.jRm.setText(au.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.nez.setText(R.string.topic_join);
            if (this.jkY == null) {
                this.jkY = new PopupWindow(this.ney, -2, -2);
            } else {
                cGg();
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jla);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.jla, 100L);
        }
    }

    public void cGg() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jla);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jlb);
        cGh();
    }

    public void cGh() {
        g.dismissPopupWindow(this.jkY);
    }

    public void onDestroy() {
        cGg();
    }
}
