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
    private PopupWindow gNv;
    private Runnable gNx = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.mTabHost != null && c.this.gNv != null && c.this.gNv.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = c.this.mTabHost.getFragmentTabWidget();
                int equipmentWidth = l.getEquipmentWidth(c.this.kmY.getActivity());
                int dimens = l.getDimens(c.this.kmY.getActivity(), R.dimen.ds278);
                c.this.gNv.getContentView().measure(0, 0);
                g.showPopupWindowAsDropDown(c.this.gNv, fragmentTabWidget, (equipmentWidth - l.getDimens(c.this.kmY.getActivity(), R.dimen.ds430)) / 2, -dimens);
                com.baidu.tbadk.core.sharedPref.b.aFD().putLong(SharedPrefConfig.HOME_TOPIC_TIP, c.this.mTopicId);
                e.gx().postDelayed(c.this.gNy, 5000L);
                TiebaStatic.log(new an("c13016").X("obj_locate", 1));
            }
        }
    };
    private Runnable gNy = new Runnable() { // from class: com.baidu.tieba.tblauncher.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLh();
        }
    };
    private View.OnClickListener gNz = new View.OnClickListener() { // from class: com.baidu.tieba.tblauncher.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bLg();
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(c.this.kmY, 9, String.valueOf(0), "", null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
            if (!StringUtils.isNull(c.this.mTopicName)) {
                writeActivityConfig.setTitle(c.this.mTopicName, true);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            TiebaStatic.log(new an("c13017").X("obj_locate", 1));
        }
    };
    private TextView hnx;
    private MainTabActivity kmY;
    private View kmZ;
    private TextView kna;
    private FragmentTabHost mTabHost;
    private long mTopicId;
    private String mTopicName;

    public c(MainTabActivity mainTabActivity) {
        this.kmY = mainTabActivity;
        this.mTabHost = (FragmentTabHost) this.kmY.findViewById(R.id.tab_host);
    }

    public void h(String str, String str2, long j) {
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.HOME_TOPIC_TIP, 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.mTopicName = str2;
            this.mTopicId = j;
            if (this.kmZ == null) {
                this.kmZ = LayoutInflater.from(this.kmY.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.hnx = (TextView) this.kmZ.findViewById(R.id.tips);
                this.kna = (TextView) this.kmZ.findViewById(R.id.tips_content);
                this.kmZ.setOnClickListener(this.gNz);
            }
            this.hnx.setText(aq.cutHotTopicShow(str, 24, StringHelper.STRING_MORE));
            this.kna.setText(R.string.topic_join);
            if (this.gNv == null) {
                this.gNv = new PopupWindow(this.kmZ, -2, -2);
            } else {
                bLg();
            }
            e.gx().removeCallbacks(this.gNx);
            e.gx().postDelayed(this.gNx, 100L);
        }
    }

    public void bLg() {
        e.gx().removeCallbacks(this.gNx);
        e.gx().removeCallbacks(this.gNy);
        bLh();
    }

    public void bLh() {
        g.dismissPopupWindow(this.gNv);
    }

    public void onDestroy() {
        bLg();
    }
}
